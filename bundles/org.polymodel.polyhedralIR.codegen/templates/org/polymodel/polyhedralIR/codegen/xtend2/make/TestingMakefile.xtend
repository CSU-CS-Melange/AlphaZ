package org.polymodel.polyhedralIR.codegen.xtend2.make

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import java.util.List

/**
 * Makefile to allow compiling from other directories. Used for regression tests.
 */
class TestingMakefile extends BaseMakefile {
	
	override cflagsOthers() {
		'''«super.cflagsOthers» -W'''
	}
	
	override CharSequence objects(List<CharSequence> names) {
		var objs = ''''''
		for(CharSequence s: names){
			objs = '''«objs»$(ALPHAZ_MAKE_DIR)/«s».o '''
		}
		return '''«objs»'''
	}
	
	override CharSequence makeObjs(List<CharSequence> names){
		var objs = ''''''
		for(CharSequence name : names){
			objs = '''
			«objs»$(ALPHAZ_MAKE_DIR)/«name».o : $(ALPHAZ_MAKE_DIR)/«name».c
				$(CC) $(ALPHAZ_MAKE_DIR)/«name».c -o $(ALPHAZ_MAKE_DIR)/«name».o $(CFLAGS) -c
			
			'''
		}
		
		return '''«objs»'''
	}
	
	override makefile(CharSequence name, List<CharSequence> names, CharSequence verifyName, boolean omp) '''
		«val path = '''$(ALPHAZ_MAKE_DIR)/«name»'''»
		«val verifyPath = '''$(ALPHAZ_MAKE_DIR)/«verifyName»'''»
		CFLAGS=«ompflag» «cflagsOptimization» «cflagsOthers» «includes» «libraries»
		CC?=«cc»
		OBJS = «objects(names)»
		all: plain check

		debug: CFLAGS =-DDEBUG -g «cflagsOthers» «libraries» «includes»
		debug: all
		
		ifndef ALPHAZ_MAKE_DIR
			ALPHAZ_MAKE_DIR=.
		endif
		
		plain: $(OBJS)
			$(CC) «path»-wrapper.c -o «path» $(OBJS) $(CFLAGS) -lm
		
		check: $(OBJS)
			$(CC) «path»-wrapper.c -o «path».check $(OBJS) $(CFLAGS) -lm -D«CHECKING_FLAG»
			
		check-noprompt: $(OBJS)
			$(CC) «path»-wrapper.c -o «path».check $(OBJS) $(CFLAGS) -lm -D«CHECKING_FLAG» -D«NO_PROMT_FLAG»
		
		verify: $(OBJS) «verifyPath».o
			$(CC) «path»-wrapper.c -o «path».verify $(OBJS) «verifyPath».o $(CFLAGS) -lm -D«VERIFY_FLAG»
			
		verify-noprompt: $(OBJS) «verifyPath».o
			$(CC) «path»-wrapper.c -o «path».verify $(OBJS) «verifyPath».o $(CFLAGS) -lm -D«VERIFY_FLAG» -D«NO_PROMT_FLAG»
		
		verify-rand: $(OBJS)
			$(CC) «path»-wrapper.c -o «path».verify-rand $(OBJS) «verifyName».o $(CFLAGS) -lm -D«VERIFY_FLAG» -D«RANDOM_FLAG»
		
		«makeObjs(names)»	
		«verifyPath».o : «verifyPath».c
			$(CC) «verifyPath».c -o «verifyPath».o $(CFLAGS) -c
		
		clean:
			rm -f $(ALPHAZ_MAKE_DIR)/*.o «path» «path».check «path».verify «path».verify-rand		
	'''

}