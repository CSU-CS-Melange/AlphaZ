include Linux_32/user.mk
include Linux_32/libraries.mk

GECOS_PTRSIZE = (int)
ARCH = 32
JAVA_INC= -I$(JAVA_HOME)/include $(JAVA_EXTRA_INC)

OBJS=ISL_ISLFold_native.o\
	ISL_ISLDimType_native.o\
	ISL_ISLContext_native.o\
	ISL_ISLVal_native.o\
	ISL_ISLValList_native.o\
	ISL_ISLMultiVal_native.o\
	ISL_ISLIdentifier_native.o\
	ISL_ISLIdentifierList_native.o\
	ISL_ISLSpace_native.o\
	ISL_ISLLocalSpace_native.o\
	ISL_ISLOptions_native.o\
	ISL_ISLPrinter_native.o\
	ISL_ISLSet_native.o\
	ISL_ISLBasicSet_native.o\
	ISL_ISLUnionSet_native.o\
	ISL_ISLBasicSetList_native.o\
	ISL_ISLSetList_native.o\
	ISL_ISLMap_native.o\
	ISL_ISLBasicMap_native.o\
	ISL_ISLUnionMap_native.o\
	ISL_ISLAff_native.o\
	ISL_ISLAffList_native.o\
	ISL_ISLMultiAff_native.o\
	ISL_ISLPWAff_native.o\
	ISL_ISLPWAffList_native.o\
	ISL_ISLMultiPWAff_native.o\
	ISL_ISLUnionPWAff_native.o\
	ISL_ISLUnionPWAffList_native.o\
	ISL_ISLMultiUnionPWAff_native.o\
	ISL_ISLPWMultiAff_native.o\
	ISL_ISLUnionPWMultiAff_native.o\
	ISL_ISLPoint_native.o\
	ISL_ISLTerm_native.o\
	ISL_ISLConstraint_native.o\
	ISL_ISLConstraintList_native.o\
	ISL_ISLMatrix_native.o\
	ISL_ISLVector_native.o\
	ISL_ISLVertices_native.o\
	ISL_ISLCell_native.o\
	ISL_ISLVertex_native.o\
	ISL_ISLQPolynomial_native.o\
	ISL_ISLPWQPolynomial_native.o\
	ISL_ISLQPolynomialFold_native.o\
	ISL_ISLPWQPolynomialFold_native.o\
	ISL_ISLUnionPWQPolynomial_native.o\
	ISL_ISLUnionPWQPolynomialFold_native.o\
	ISL_ISLSchedule_native.o\
	ISL_ISLStandardIO_native.o\
	ISL_ISLQPolynomialPiece_native.o\
	ISL_ISLQPolynomialFoldPiece_native.o\
	ISL_ISLDataflowAnalysis_native.o\
	ISL_ISLPWMultiAffPiece_native.o\
	ISL_ISLAstNodeType_native.o\
	ISL_ISLAstExprType_native.o\
	ISL_ISLAstOpType_native.o\
	ISL_ISLASTBuild_native.o\
	ISL_ISLASTNode_native.o\
	ISL_ISLASTIfNode_native.o\
	ISL_ISLASTForNode_native.o\
	ISL_ISLASTBlockNode_native.o\
	ISL_ISLASTUserNode_native.o\
	ISL_ISLASTUnscannedNode_native.o\
	ISL_ISLASTExpression_native.o\
	ISL_ISLASTIdentifier_native.o\
	ISL_ISLASTLiteral_native.o\
	ISL_ISLASTOperation_native.o\
	ISL_ISLASTNodeList_native.o\
	ISL_ISLASTExpressionList_native.o\
	ISL_common_native.o \
	ISL_UserModules.o

#Extra objects to be linked
EXTRA_OBJS=ISLUser_vertices.o \
	ISLUser_ast.o \
	ISLUser_codegen.o \
	ISLUser_collections.o \
	ISLUser_scheduling.o \
	ISLUser_dataflow.o \
	ISLUser_tostring.o \
	ISLUser_lexnext.o \
	ISLUser_lexpred.o \
	ISLUser_misc.o \
	ISLUser_polynomial.o \
	ISLUser_stdio.o

CFLAGS = -m$(ARCH) -fPIC -O3 -Wall -Wextra -Wno-unused-label -Wno-unused-parameter \
		$(JAVA_INC) -I./ -I../ $(EXTRA_CFLAGS) $(EXTRA_INCDIR) \
		 \
		-I$(ISL_INCDIR) -I$(GMP_INCDIR)

LIBS = \
	-Wl,-rpath,./.jnimap.temp.linux_32 \
	 \
	./.jnimap.temp.linux_32/libisl.so.13 \
	./.jnimap.temp.linux_32/libgmp.so.10 \
	$(EXTRA_LIBS)

# Path to the ISLNative class file
CLASSPATH=../../bin/

V=@
Q=

all: 
	@echo usage :
	@echo  - make lib : compile linux_32_libjniisl.so
	@echo  - make clean

###############################
#			Rules
###############################

clean: 
	rm -rf ../../lib/linux_32_libjniisl.so *.o ../*.o fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h ../../lib/ISL_linux_32/*
	
lib: ../../lib/linux_32_libjniisl.so

#Final file to be created.
../../lib/linux_32_libjniisl.so : $(OBJS) $(EXTRA_OBJS) libs_linux_32
	$(V)mkdir -p ../../lib/
	$(Q)@echo "  [LINK] $@"
	$(V)$(CC) $(CFLAGS) -o ../../lib/linux_32_libjniisl.so -shared $(OBJS) $(EXTRA_OBJS) $(LIBS)
	$(V)cd ../../lib/ && \
	mkdir -p ISL_linux_32/ && \
	mv ../native/build/.jnimap.temp.linux_32/* ./ISL_linux_32/
	$(V)$(MAKE) -f Linux_32/Makefile fixInstallNames
	$(V)rm -rf ./.jnimap.temp.linux_32/

libs_linux_32:
	$(V)mkdir -p ./.jnimap.temp.linux_32
	$(V)cp $(ISL_LIBDIR)/libisl.so.13 .jnimap.temp.linux_32/libisl.so.13
	$(V)cp $(GMP_LIBDIR)/libgmp.so.10 .jnimap.temp.linux_32/libgmp.so.10

fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h : fr_irisa_cairn_jnimap_isl_jni_ISLNative.h
fr_irisa_cairn_jnimap_isl_jni_ISLNative.h : $(CLASSPATH)/fr/irisa/cairn/jnimap/isl/jni/ISLNative.class
	$(Q)@echo "  [JAVAH] $@"
	$(V)$(JAVA_H) -classpath $(CLASSPATH)/ fr.irisa.cairn.jnimap.isl.jni.ISLNative
	@echo "#define GECOS_PTRSIZE $(GECOS_PTRSIZE)" >> $@
ISL_ISLFold_native.o : ../ISL_ISLFold_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLFold_native.c
	
ISL_ISLDimType_native.o : ../ISL_ISLDimType_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLDimType_native.c
	
ISL_ISLContext_native.o : ../ISL_ISLContext_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLContext_native.c
	
ISL_ISLVal_native.o : ../ISL_ISLVal_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLVal_native.c
	
ISL_ISLValList_native.o : ../ISL_ISLValList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLValList_native.c
	
ISL_ISLMultiVal_native.o : ../ISL_ISLMultiVal_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMultiVal_native.c
	
ISL_ISLIdentifier_native.o : ../ISL_ISLIdentifier_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLIdentifier_native.c
	
ISL_ISLIdentifierList_native.o : ../ISL_ISLIdentifierList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLIdentifierList_native.c
	
ISL_ISLSpace_native.o : ../ISL_ISLSpace_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLSpace_native.c
	
ISL_ISLLocalSpace_native.o : ../ISL_ISLLocalSpace_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLLocalSpace_native.c
	
ISL_ISLOptions_native.o : ../ISL_ISLOptions_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLOptions_native.c
	
ISL_ISLPrinter_native.o : ../ISL_ISLPrinter_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPrinter_native.c
	
ISL_ISLSet_native.o : ../ISL_ISLSet_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLSet_native.c
	
ISL_ISLBasicSet_native.o : ../ISL_ISLBasicSet_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLBasicSet_native.c
	
ISL_ISLUnionSet_native.o : ../ISL_ISLUnionSet_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionSet_native.c
	
ISL_ISLBasicSetList_native.o : ../ISL_ISLBasicSetList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLBasicSetList_native.c
	
ISL_ISLSetList_native.o : ../ISL_ISLSetList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLSetList_native.c
	
ISL_ISLMap_native.o : ../ISL_ISLMap_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMap_native.c
	
ISL_ISLBasicMap_native.o : ../ISL_ISLBasicMap_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLBasicMap_native.c
	
ISL_ISLUnionMap_native.o : ../ISL_ISLUnionMap_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionMap_native.c
	
ISL_ISLAff_native.o : ../ISL_ISLAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLAff_native.c
	
ISL_ISLAffList_native.o : ../ISL_ISLAffList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLAffList_native.c
	
ISL_ISLMultiAff_native.o : ../ISL_ISLMultiAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMultiAff_native.c
	
ISL_ISLPWAff_native.o : ../ISL_ISLPWAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWAff_native.c
	
ISL_ISLPWAffList_native.o : ../ISL_ISLPWAffList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWAffList_native.c
	
ISL_ISLMultiPWAff_native.o : ../ISL_ISLMultiPWAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMultiPWAff_native.c
	
ISL_ISLUnionPWAff_native.o : ../ISL_ISLUnionPWAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionPWAff_native.c
	
ISL_ISLUnionPWAffList_native.o : ../ISL_ISLUnionPWAffList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionPWAffList_native.c
	
ISL_ISLMultiUnionPWAff_native.o : ../ISL_ISLMultiUnionPWAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMultiUnionPWAff_native.c
	
ISL_ISLPWMultiAff_native.o : ../ISL_ISLPWMultiAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWMultiAff_native.c
	
ISL_ISLUnionPWMultiAff_native.o : ../ISL_ISLUnionPWMultiAff_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionPWMultiAff_native.c
	
ISL_ISLPoint_native.o : ../ISL_ISLPoint_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPoint_native.c
	
ISL_ISLTerm_native.o : ../ISL_ISLTerm_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLTerm_native.c
	
ISL_ISLConstraint_native.o : ../ISL_ISLConstraint_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLConstraint_native.c
	
ISL_ISLConstraintList_native.o : ../ISL_ISLConstraintList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLConstraintList_native.c
	
ISL_ISLMatrix_native.o : ../ISL_ISLMatrix_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLMatrix_native.c
	
ISL_ISLVector_native.o : ../ISL_ISLVector_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLVector_native.c
	
ISL_ISLVertices_native.o : ../ISL_ISLVertices_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLVertices_native.c
	
ISL_ISLCell_native.o : ../ISL_ISLCell_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLCell_native.c
	
ISL_ISLVertex_native.o : ../ISL_ISLVertex_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLVertex_native.c
	
ISL_ISLQPolynomial_native.o : ../ISL_ISLQPolynomial_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLQPolynomial_native.c
	
ISL_ISLPWQPolynomial_native.o : ../ISL_ISLPWQPolynomial_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWQPolynomial_native.c
	
ISL_ISLQPolynomialFold_native.o : ../ISL_ISLQPolynomialFold_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLQPolynomialFold_native.c
	
ISL_ISLPWQPolynomialFold_native.o : ../ISL_ISLPWQPolynomialFold_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWQPolynomialFold_native.c
	
ISL_ISLUnionPWQPolynomial_native.o : ../ISL_ISLUnionPWQPolynomial_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionPWQPolynomial_native.c
	
ISL_ISLUnionPWQPolynomialFold_native.o : ../ISL_ISLUnionPWQPolynomialFold_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLUnionPWQPolynomialFold_native.c
	
ISL_ISLSchedule_native.o : ../ISL_ISLSchedule_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLSchedule_native.c
	
ISL_ISLStandardIO_native.o : ../ISL_ISLStandardIO_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLStandardIO_native.c
	
ISL_ISLQPolynomialPiece_native.o : ../ISL_ISLQPolynomialPiece_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLQPolynomialPiece_native.c
	
ISL_ISLQPolynomialFoldPiece_native.o : ../ISL_ISLQPolynomialFoldPiece_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLQPolynomialFoldPiece_native.c
	
ISL_ISLDataflowAnalysis_native.o : ../ISL_ISLDataflowAnalysis_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLDataflowAnalysis_native.c
	
ISL_ISLPWMultiAffPiece_native.o : ../ISL_ISLPWMultiAffPiece_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLPWMultiAffPiece_native.c
	
ISL_ISLAstNodeType_native.o : ../ISL_ISLAstNodeType_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLAstNodeType_native.c
	
ISL_ISLAstExprType_native.o : ../ISL_ISLAstExprType_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLAstExprType_native.c
	
ISL_ISLAstOpType_native.o : ../ISL_ISLAstOpType_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLAstOpType_native.c
	
ISL_ISLASTBuild_native.o : ../ISL_ISLASTBuild_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTBuild_native.c
	
ISL_ISLASTNode_native.o : ../ISL_ISLASTNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTNode_native.c
	
ISL_ISLASTIfNode_native.o : ../ISL_ISLASTIfNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTIfNode_native.c
	
ISL_ISLASTForNode_native.o : ../ISL_ISLASTForNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTForNode_native.c
	
ISL_ISLASTBlockNode_native.o : ../ISL_ISLASTBlockNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTBlockNode_native.c
	
ISL_ISLASTUserNode_native.o : ../ISL_ISLASTUserNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTUserNode_native.c
	
ISL_ISLASTUnscannedNode_native.o : ../ISL_ISLASTUnscannedNode_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTUnscannedNode_native.c
	
ISL_ISLASTExpression_native.o : ../ISL_ISLASTExpression_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTExpression_native.c
	
ISL_ISLASTIdentifier_native.o : ../ISL_ISLASTIdentifier_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTIdentifier_native.c
	
ISL_ISLASTLiteral_native.o : ../ISL_ISLASTLiteral_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTLiteral_native.c
	
ISL_ISLASTOperation_native.o : ../ISL_ISLASTOperation_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTOperation_native.c
	
ISL_ISLASTNodeList_native.o : ../ISL_ISLASTNodeList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTNodeList_native.c
	
ISL_ISLASTExpressionList_native.o : ../ISL_ISLASTExpressionList_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_ISLASTExpressionList_native.c
	

ISL_common_native.o : ../ISL_common_native.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_common_native.c

ISL_UserModules.o : ../ISL_UserModules.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISL_UserModules.c

#PROTECTED REGION ID(make_Linux_32_ISLUser_vertices) DISABLED START#
ISLUser_vertices.o : ../ISLUser_vertices.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_vertices.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_ast) DISABLED START#
ISLUser_ast.o : ../ISLUser_ast.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_ast.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_codegen) DISABLED START#
ISLUser_codegen.o : ../ISLUser_codegen.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_codegen.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_collections) DISABLED START#
ISLUser_collections.o : ../ISLUser_collections.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_collections.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_scheduling) DISABLED START#
ISLUser_scheduling.o : ../ISLUser_scheduling.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_scheduling.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_dataflow) DISABLED START#
ISLUser_dataflow.o : ../ISLUser_dataflow.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_dataflow.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_tostring) DISABLED START#
ISLUser_tostring.o : ../ISLUser_tostring.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_tostring.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_lexnext) DISABLED START#
ISLUser_lexnext.o : ../ISLUser_lexnext.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_lexnext.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_lexpred) DISABLED START#
ISLUser_lexpred.o : ../ISLUser_lexpred.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_lexpred.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_misc) DISABLED START#
ISLUser_misc.o : ../ISLUser_misc.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_misc.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_polynomial) DISABLED START#
ISLUser_polynomial.o : ../ISLUser_polynomial.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_polynomial.c
#PROTECTED REGION END#

#PROTECTED REGION ID(make_Linux_32_ISLUser_stdio) DISABLED START#
ISLUser_stdio.o : ../ISLUser_stdio.c fr_irisa_cairn_jnimap_isl_jni_ISLNative.h fr_irisa_cairn_jnimap_isl_jni_ISLNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../ISLUser_stdio.c
#PROTECTED REGION END#

fixInstallNames:
	@echo "  [RPATH FIX] ISL"
	patchelf --set-rpath ./.jnimap.temp.linux_32/ ../../lib/ISL_linux_32/libisl.so.13
	@echo "  [RPATH FIX] GMP"
	patchelf --set-rpath ./.jnimap.temp.linux_32/ ../../lib/ISL_linux_32/libgmp.so.10
