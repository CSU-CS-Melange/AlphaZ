package alpha.model.abft.codegen;

import alphaz.mde.Basic;
import alphaz.mde.CodeGen;
import alphaz.mde.TargetMapping;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.polymodel.algebra.Variable;
import org.polymodel.polyhedralIR.AffineSystem;
import org.polymodel.polyhedralIR.Program;
import org.polymodel.polyhedralIR.VariableDeclaration;
import org.polymodel.polyhedralIR.polyIRCG.generator.ABFTCodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.CodeGenOptions;
import org.polymodel.polyhedralIR.polyIRCG.generator.PolyIRCodeGen;

@SuppressWarnings("all")
public class Compile {
  public static void main(final String[] args) {
    try {
      int _size = ((List<String>)Conversions.doWrapArray(args)).size();
      boolean _lessThan = (_size < 4);
      if (_lessThan) {
        InputOutput.<String>println("usage: alphabets_file cT cJx codegen_file [output_directory]");
        return;
      }
      final String abFile = args[0];
      final String cTSize = args[1];
      final String cJxSize = args[2];
      final String abftOptionsFile = args[3];
      String outDir = ((String) null);
      int _size_1 = ((List<String>)Conversions.doWrapArray(args)).size();
      boolean _lessThan_1 = (_size_1 < 5);
      if (_lessThan_1) {
        outDir = "./";
      } else {
        outDir = args[4];
      }
      boolean _endsWith = outDir.endsWith("/");
      boolean _not = (!_endsWith);
      if (_not) {
        outDir = (outDir + "/");
      }
      final Program prog = Basic.ReadAlphabets(abFile);
      int _size_2 = prog.getSystems().size();
      boolean _greaterThan = (_size_2 > 1);
      if (_greaterThan) {
        throw new Exception("Expecting only a single system.");
      }
      final AffineSystem system = prog.getSystems().get(0);
      String patchSize = ((String) null);
      String kernel = ((String) null);
      try {
        FileReader _fileReader = new FileReader(abftOptionsFile);
        final BufferedReader reader = new BufferedReader(_fileReader);
        patchSize = reader.readLine();
        kernel = reader.readLine();
        reader.close();
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Function1<VariableDeclaration, Boolean> _function = (VariableDeclaration v) -> {
        boolean _startsWith = v.getVarID().getName().startsWith("Inv_");
        return Boolean.valueOf((!_startsWith));
      };
      final VariableDeclaration stencilVar = ((VariableDeclaration[])Conversions.unwrapArray(IterableExtensions.<VariableDeclaration>filter(system.getOutputs(), _function), VariableDeclaration.class))[0];
      final Function1<Variable, String> _function_1 = (Variable it) -> {
        return it.toString();
      };
      final List<String> indexNames = IterableExtensions.<String>toList(ListExtensions.<Variable, String>map(stencilVar.getDomain().getPMdomain().getDimensions().getIndices(), _function_1));
      int _size_3 = indexNames.size();
      final int D = (_size_3 - 1);
      final List<String> i3d = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("i", "j", "k"));
      String _name = system.getName();
      String _name_1 = stencilVar.getVarID().getName();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("(");
      String _join = IterableExtensions.join(indexNames, ",");
      _builder.append(_join);
      _builder.append("->1,t,0,");
      final Function1<Integer, String> _function_2 = (Integer it) -> {
        return i3d.get((it).intValue());
      };
      String _join_1 = IterableExtensions.join(IterableExtensions.<Integer, String>map(new ExclusiveRange(0, D, true), _function_2), ",");
      _builder.append(_join_1);
      _builder.append(",0)");
      TargetMapping.setSpaceTimeMap(prog, _name, _name_1, _builder.toString());
      ABFTCodeGenOptions options = ((ABFTCodeGenOptions) null);
      final Function1<VariableDeclaration, Boolean> _function_3 = (VariableDeclaration v) -> {
        return Boolean.valueOf(v.getVarID().getName().startsWith("Inv_"));
      };
      int _size_4 = IterableExtensions.<VariableDeclaration>toList(IterableExtensions.<VariableDeclaration>filter(system.getOutputs(), _function_3)).size();
      final boolean isBaseline = (_size_4 == 0);
      if ((!isBaseline)) {
        final Function1<VariableDeclaration, Boolean> _function_4 = (VariableDeclaration v) -> {
          return Boolean.valueOf(v.getVarID().getName().startsWith("Inv_"));
        };
        final VariableDeclaration invVar = ((VariableDeclaration[])Conversions.unwrapArray(IterableExtensions.<VariableDeclaration>filter(system.getOutputs(), _function_4), VariableDeclaration.class))[0];
        final Function1<VariableDeclaration, Boolean> _function_5 = (VariableDeclaration v) -> {
          return Boolean.valueOf(v.getVarID().getName().startsWith("Check_"));
        };
        final Function1<VariableDeclaration, String> _function_6 = (VariableDeclaration it) -> {
          return it.getVarID().getName();
        };
        final List<String> checkVarNames = IterableExtensions.<String>toList(IterableExtensions.<VariableDeclaration, String>map(IterableExtensions.<VariableDeclaration>filter(system.getLocals(), _function_5), _function_6));
        final Function1<String, String> _function_7 = (String it) -> {
          return ("t" + it);
        };
        final List<String> tileIndexNames = IterableExtensions.<String>toList(ListExtensions.<String, String>map(indexNames, _function_7));
        String _name_2 = system.getName();
        String _get = checkVarNames.get(0);
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("(");
        String _join_2 = IterableExtensions.join(tileIndexNames, ",");
        _builder_1.append(_join_2);
        _builder_1.append("->1,");
        _builder_1.append(cTSize);
        _builder_1.append("tt,1,");
        String _join_3 = IterableExtensions.join(tileIndexNames, ",");
        _builder_1.append(_join_3);
        _builder_1.append(")");
        TargetMapping.setSpaceTimeMap(prog, _name_2, _get, _builder_1.toString());
        String _name_3 = system.getName();
        String _get_1 = checkVarNames.get(1);
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("(");
        String _join_4 = IterableExtensions.join(tileIndexNames, ",");
        _builder_2.append(_join_4);
        _builder_2.append("->1,");
        _builder_2.append(cTSize);
        _builder_2.append("tt-");
        _builder_2.append(cTSize);
        _builder_2.append(",1,");
        String _join_5 = IterableExtensions.join(tileIndexNames, ",");
        _builder_2.append(_join_5);
        _builder_2.append(")");
        TargetMapping.setSpaceTimeMap(prog, _name_3, _get_1, _builder_2.toString());
        String _name_4 = system.getName();
        String _name_5 = invVar.getVarID().getName();
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("(");
        String _join_6 = IterableExtensions.join(tileIndexNames, ",");
        _builder_3.append(_join_6);
        _builder_3.append("->2,");
        String _join_7 = IterableExtensions.join(tileIndexNames, ",");
        _builder_3.append(_join_7);
        _builder_3.append(",0,0)");
        TargetMapping.setSpaceTimeMap(prog, _name_4, _name_5, _builder_3.toString());
        CodeGenOptions _createCGOptionForScheduledABFTC = CodeGen.createCGOptionForScheduledABFTC();
        options = ((ABFTCodeGenOptions) _createCGOptionForScheduledABFTC);
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("W_");
        String _name_6 = stencilVar.getVarID().getName();
        _builder_4.append(_name_6);
        _builder_4.append("_scc");
        options.weightsVar = _builder_4.toString();
        options.dataType = "double";
        options.patchVar = "patch";
        options.patchSize = patchSize;
        options.cT = cTSize;
        StringConcatenation _builder_5 = new StringConcatenation();
        final Function1<Integer, String> _function_8 = (Integer it) -> {
          return cJxSize;
        };
        String _join_8 = IterableExtensions.join(IterableExtensions.<Integer, String>map(new ExclusiveRange(0, D, true), _function_8), ",");
        _builder_5.append(_join_8);
        options.cJx = _builder_5.toString();
        options.kernel = kernel;
        options.numDims = D;
      }
      TargetMapping.setMemorySpace(prog, system.getName(), stencilVar.getVarID().getName(), stencilVar.getVarID().getName());
      String _name_7 = system.getName();
      String _name_8 = stencilVar.getVarID().getName();
      String _name_9 = stencilVar.getVarID().getName();
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("(");
      String _join_9 = IterableExtensions.join(indexNames, ",");
      _builder_6.append(_join_9);
      _builder_6.append("->");
      String _join_10 = IterableExtensions.join(indexNames, ",");
      _builder_6.append(_join_10);
      _builder_6.append(")");
      TargetMapping.setMemoryMap(prog, _name_7, _name_8, _name_9, _builder_6.toString(), 
        "2,");
      CodeGen.generateScheduledCode(prog, system.getName(), outDir);
      if ((options != null)) {
        CodeGen.generateABFTWrapper(prog, system.getName(), options, outDir);
      } else {
        CodeGen.generateWrapper(prog, system.getName(), outDir);
      }
      PolyIRCodeGen.generateABFTMakefile(system, outDir);
      if ((!isBaseline)) {
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("/");
        _builder_7.append(D);
        _builder_7.append("d/conv.c");
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append(outDir);
        _builder_8.append("conv.c");
        Compile.copyFile(_builder_7.toString(), _builder_8.toString());
        StringConcatenation _builder_9 = new StringConcatenation();
        _builder_9.append("/");
        _builder_9.append(D);
        _builder_9.append("d/init.c");
        StringConcatenation _builder_10 = new StringConcatenation();
        _builder_10.append(outDir);
        _builder_10.append("init.c");
        Compile.copyFile(_builder_9.toString(), _builder_10.toString());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static Long copyFile(final String srcPath, final String destPath) {
    long _xblockexpression = (long) 0;
    {
      final Path destinationPath = Paths.get(destPath);
      long _xtrycatchfinallyexpression = (long) 0;
      try {
        long _xblockexpression_1 = (long) 0;
        {
          final InputStream inputStream = Compile.class.getResourceAsStream(srcPath);
          long _xifexpression = (long) 0;
          if ((inputStream != null)) {
            _xifexpression = Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING);
          }
          _xblockexpression_1 = _xifexpression;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          e.printStackTrace();
          System.err.println(("An error occurred while loading " + srcPath));
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return Long.valueOf(_xblockexpression);
  }
}
