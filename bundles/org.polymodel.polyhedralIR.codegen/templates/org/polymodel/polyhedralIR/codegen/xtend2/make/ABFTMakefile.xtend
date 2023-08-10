package org.polymodel.polyhedralIR.codegen.xtend2.make

import static org.polymodel.polyhedralIR.polyIRCG.generator.C.CodeGenConstantsForC.*
import java.util.List

class ABFTMakefile extends BaseMakefile {
	
	def override CharSequence makefile(CharSequence name, List<CharSequence> names, CharSequence verifyName, boolean omp, boolean withVerification) '''
		CFLAGS=«IF omp»«ompflag» «ENDIF» «cflagsOptimization» «cflagsOthers» «includes»
		LIBRARIES=«libraries»
		CC?=«cc»
		OBJS = «objects(names)»init.o conv.o
		all: plain check«IF withVerification» verify verify-rand«ENDIF»
		
		debug: CFLAGS =-DDEBUG -g -Wall -Wextra«cflagsOthers»«includes»
		debug: all
		
		plain: $(OBJS)
			$(CC) «name»-wrapper.c -o «name» $(OBJS) $(CFLAGS) $(LIBRARIES)
		
		check: $(OBJS)
			$(CC) «name»-wrapper.c -o «name».check $(OBJS) $(CFLAGS) $(LIBRARIES) -D«CHECKING_FLAG» -D«RANDOM_FLAG»
		
		init.o : init.c
			$(CC) init.c -o init.o $(CFLAGS) $(LIBRARIES) -c
		
		conv.o : conv.c
			$(CC) conv.c -o conv.o $(CFLAGS) $(LIBRARIES) -c
		
		«makeObjs(names)»
		
		clean:
			rm -f *.o «name» «name».check«IF withVerification» «name».verify «name».verify-rand«ENDIF»
	'''

}