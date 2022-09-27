package org.polymodel.polyhedralIR.codegen.xtend2.make

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import java.util.TreeMap
import java.util.Map
import org.polymodel.polyhedralIR.AffineSystem
import java.util.List
import java.util.LinkedList

class BaseMakefile {
	
    def Map<String,String> generate (AffineSystem system, List<AffineSystem> systems, boolean omp)  {
    	val files = new TreeMap<String,String>();
    	
    	val systemNames = new LinkedList<CharSequence>();
    	for(AffineSystem sys : systems){
    		systemNames.add(sys.name);
    	}
    	files.put("Makefile", makefile(system.name, systemNames, system.name+VERIFY_POSTFIX, omp).toString)
    	
		return files    	
	 }
	
	def CharSequence cflagsOptimization() {
		'''-O3'''
	}
	
	def CharSequence cflagsOthers() {
		''' -std=c99'''
	}
	
	def CharSequence includes() {
		''' -I/usr/include/malloc/'''
	}
	
	def CharSequence libraries() {
		'''-lm'''
	}
	
	def CharSequence ompflag(){
		'''-fopenmp'''
	}
	
	def CharSequence cc() {
		'''gcc'''
	}
	
	def CharSequence objects(List<CharSequence> names) {
		var objs = ''''''
		for(CharSequence s: names){
			objs = '''«objs»«s».o '''
		}
		return '''«objs»'''
	}
	
	def CharSequence makeObjs(List<CharSequence> names){
		var objs = ''''''
		for(CharSequence name : names){
			objs = '''
			«objs»«name».o : «name».c
				$(CC) «name».c -o «name».o $(CFLAGS) $(LIBRARIES) -c
			
			'''
		}
		
		return '''«objs»'''
	}

	def CharSequence makefile(CharSequence name, List<CharSequence> names, CharSequence verifyName, boolean omp) '''
		CFLAGS=«IF omp»«ompflag» «ENDIF» «cflagsOptimization» «cflagsOthers» «includes»
		LIBRARIES=«libraries»
		CC?=«cc»
		OBJS = «objects(names)»
		all: plain check

		debug: CFLAGS =-DDEBUG -g -Wall -Wextra«cflagsOthers»«includes»
		debug: all
				
		plain: $(OBJS)
			$(CC) «name»-wrapper.c -o «name» $(OBJS) $(CFLAGS) $(LIBRARIES)
		
		check: $(OBJS)
			$(CC) «name»-wrapper.c -o «name».check $(OBJS) $(CFLAGS) $(LIBRARIES) -D«CHECKING_FLAG» -D«RANDOM_FLAG»
		
		verify: $(OBJS) «verifyName».o
			$(CC) «name»-wrapper.c -o «name».verify $(OBJS) «verifyName».o $(CFLAGS) $(LIBRARIES) -D«VERIFY_FLAG»
		
		verify-rand: $(OBJS) «verifyName».o
			$(CC) «name»-wrapper.c -o «name».verify-rand $(OBJS) «verifyName».o $(CFLAGS) $(LIBRARIES) -D«VERIFY_FLAG» -D«RANDOM_FLAG»
		
		«makeObjs(names)»
		«verifyName».o : «verifyName».c
			$(CC) «verifyName».c -o «verifyName».o $(CFLAGS) $(LIBRARIES) -c
		
		clean:
			rm -f *.o «name» «name».check «name».verify «name».verify-rand
	'''
}