package alpha.model.abft.codegen

import alphaz.mde.Basic
import alphaz.mde.TargetMapping
import alphaz.mde.CodeGen
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions
import java.io.BufferedReader
import java.io.FileReader
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen
import java.nio.file.Paths
import java.nio.file.Files
import java.io.IOException
import java.nio.file.StandardCopyOption

class Compile {
	
	def static void main(String[] args) {
		
		if (args.size < 4) {
			println("usage: alphabets_file H L codegen_file [output_directory]")
			return;
		}
		
		val abFile = args.get(0)
		val cTSize = args.get(1)
		val cJxSize = args.get(2)
		val abftOptionsFile = args.get(3)
		var outDir = null as String
		if (args.size < 5) {
			outDir = './'
		} else {
			outDir = args.get(4)
		}
		if (! outDir.endsWith('/'))
			outDir = outDir + '/'
		
		
		// run alphaz codegen 
		val prog = Basic.ReadAlphabets(abFile)

		// there must be a single system
		if (prog.systems.size > 1) {
			throw new Exception('Expecting only a single system.')
		}
		val system = prog.systems.get(0)
		
		// This information comes from the previous analysis
		var patchSize = null as String
		var kernel = null as String
        try {
            val reader = new BufferedReader(new FileReader(abftOptionsFile));
            patchSize = reader.readLine();
            kernel = reader.readLine();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		val stencilVar = system.outputs.filter(v|!v.varID.name.startsWith('Inv_')).get(0)
		val indexNames = stencilVar.domain.PMdomain.dimensions.indices.map[it.toString].toList
		
		val D = indexNames.size - 1
		val i3d = #["i", "j", "k"]
		
		TargetMapping.setSpaceTimeMap(prog, system.name, stencilVar.varID.name,
			'''(«indexNames.join(',')»->1,t,0,«(0..<D).map[i3d.get(it)].join(',')»,0)'''
		);
		
		var options = null as ABFTCodeGenOptions
		val isBaseline = system.outputs.filter(v|v.varID.name.startsWith('Inv_')).toList.size == 0
		if (!isBaseline) {
			val invVar = system.outputs.filter(v|v.varID.name.startsWith('Inv_')).get(0)
			val checkVarNames = system.locals.filter(v|v.varID.name.startsWith('Check_')).map[it.varID.name].toList
			val tileIndexNames = indexNames.map['t'+it].toList
			
			// Check_Y_scc_abft_a
			TargetMapping.setSpaceTimeMap(prog, system.name, checkVarNames.get(0),
			'''(«tileIndexNames.join(',')»->1,«cTSize»tt,1,«tileIndexNames.join(',')»)'''	
			)
			// Check_Y_scc_abft_b
			TargetMapping.setSpaceTimeMap(prog, system.name, checkVarNames.get(1),
			'''(«tileIndexNames.join(',')»->1,«cTSize»tt-«cTSize»,1,«tileIndexNames.join(',')»)'''	
			)
			// Inv_Y_scc_abft
			TargetMapping.setSpaceTimeMap(prog, system.name, invVar.varID.name,
			'''(«tileIndexNames.join(',')»->2,«tileIndexNames.join(',')»,0,0)'''	
			)
			
			options = CodeGen.createCGOptionForScheduledABFTC as ABFTCodeGenOptions
			options.weightsVar = '''W_«stencilVar.varID.name»_scc'''
			options.dataType = 'float'
			options.patchVar = 'patch'
			options.patchSize = patchSize
			options.cT = cTSize
			options.cJx = '''«(0..<D).map[cJxSize].join(',')»'''
			options.kernel = kernel
			options.numDims = D
		}
		
		// memory maps
		TargetMapping.setMemorySpace(prog, system.name, stencilVar.varID.name, stencilVar.varID.name);
		TargetMapping.setMemoryMap(prog, system.name, stencilVar.varID.name, stencilVar.varID.name, 
			'''(«indexNames.join(',')»->«indexNames.join(',')»)''',
			"2,"
		);
		
		CodeGen.generateScheduledCode(prog, system.name, outDir);
		if (options !== null) {
			CodeGen.generateABFTWrapper(prog, system.name, options, outDir);
		} else {
			CodeGen.generateWrapper(prog, system.name, outDir);
		}
		
		if (!isBaseline) {
			PolyIRCodeGen.generateABFTMakefile(system, outDir);
		} else {
			CodeGen.generateMakefile(prog, system.name, outDir)
		}
		
		if (!isBaseline) {
			// Output the pre-generated convolution code
			copyFile('''/«D»d/conv.c''', '''«outDir»conv.c''')
			copyFile('''/«D»d/init.c''', '''«outDir»init.c''')
		}
		
	}
	
	def static copyFile(String srcPath, String destPath) {
        val destinationPath = Paths.get(destPath);
        try {
            val inputStream = Compile.getResourceAsStream(srcPath);
            
            if (inputStream !== null) {
                Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while loading " + srcPath);
        }
	}
}