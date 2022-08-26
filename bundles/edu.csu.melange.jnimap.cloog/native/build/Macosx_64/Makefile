include Macosx_64/user.mk
include Macosx_64/init.mk
include Macosx_64/libraries.mk

GECOS_PTRSIZE = (long)
JAVA_INC=-I$(JAVA_HOME)/include $(JAVA_EXTRA_INC)

OBJS=Cloog_ClastExprType_native.o\
	Cloog_ClastRedType_native.o\
	Cloog_ClastBinType_native.o\
	Cloog_ClastExpr_native.o\
	Cloog_ClastName_native.o\
	Cloog_ClastTerm_native.o\
	Cloog_ClastReduction_native.o\
	Cloog_ClastBinary_native.o\
	Cloog_ClatStmtOp_native.o\
	Cloog_ClastStmt_native.o\
	Cloog_ClastAssignment_native.o\
	Cloog_ClastRoot_native.o\
	Cloog_ClastBlock_native.o\
	Cloog_CloogStatement_native.o\
	Cloog_ClastUserStmt_native.o\
	Cloog_ClastFor_native.o\
	Cloog_ClastEquation_native.o\
	Cloog_ClastGuard_native.o\
	Cloog_CloogNames_native.o\
	Cloog_CloogOptions_native.o\
	Cloog_CloogInput_native.o\
	Cloog_CloogState_native.o\
	Cloog_common_native.o \
	Cloog_UserModules.o

#Extra objects to be linked
EXTRA_OBJS=CloogUser_addons.o

CFLAGS = -m$(ARCH) -fPIC -O3 -Wall -Wextra -Wno-unused-label -Wno-unused-parameter \
		$(JAVA_INC) -I./ -I../ $(EXTRA_CFLAGS) $(EXTRA_INCDIR) \
		-I$(ISL_INCDIR) -I$(GMP_INCDIR) \
		-I$(CLOOG_INCDIR)

LIBS = \
	-Wl,-rpath,./.jnimap.temp.macosx_64 \
	./.jnimap.temp.macosx_64/libisl.$(ISL_VERSION).dylib \
	./.jnimap.temp.macosx_64/libgmp.$(GMP_VERSION).dylib \
	./.jnimap.temp.macosx_64/libcloog-isl.4.dylib \
	$(EXTRA_LIBS)

# Path to the CloogNative class file
CLASSPATH=../../bin/

V=@
Q=

all: 
	@echo usage :
	@echo  - make lib : compile macosx_$(ARCH_TYPE)_libjnicloog.so
	@echo  - make clean

###############################
#			Rules
###############################

clean: 
	rm -rf ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so *.o ../*.o fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h ../../lib/Cloog_macosx_$(ARCH_TYPE)/*
	
lib: ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so

#Final file to be created.
../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so : $(OBJS) $(EXTRA_OBJS) libs_macosx_64
	$(V)mkdir -p ../../lib/
	$(Q)@echo "  [LINK] $@"
	$(V)$(CC) $(CFLAGS) -o ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so -shared $(OBJS) $(EXTRA_OBJS) $(LIBS)
	$(V)cd ../../lib/ && \
	mkdir -p Cloog_macosx_$(ARCH_TYPE)/ && \
	mv ../native/build/.jnimap.temp.macosx_64/* ./Cloog_macosx_$(ARCH_TYPE)/
	$(V)$(MAKE) -f Macosx_64/Makefile fixInstallNames
	$(V)rm -rf ./.jnimap.temp.macosx_64/

libs_macosx_64:
	$(V)mkdir -p ./.jnimap.temp.macosx_64
	$(V)cp $(ISL_LIBDIR)/libisl.$(ISL_VERSION).dylib .jnimap.temp.macosx_64/libisl.$(ISL_VERSION).dylib
	$(V)cp $(GMP_LIBDIR)/libgmp.$(GMP_VERSION).dylib .jnimap.temp.macosx_64/libgmp.$(GMP_VERSION).dylib
	$(V)cp $(CLOOG_LIBDIR)/libcloog-isl.4.dylib .jnimap.temp.macosx_64/libcloog-isl.4.dylib

fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h : fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h
fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h : $(CLASSPATH)/fr/irisa/cairn/jnimap/cloog/jni/CloogNative.class
	$(Q)@echo "  [JAVAH] $@"
	$(V)$(JAVA_H) -classpath $(CLASSPATH)/ fr.irisa.cairn.jnimap.cloog.jni.CloogNative
	@echo "#define GECOS_PTRSIZE $(GECOS_PTRSIZE)" >> $@
Cloog_ClastExprType_native.o : ../Cloog_ClastExprType_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastExprType_native.c
	
Cloog_ClastRedType_native.o : ../Cloog_ClastRedType_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastRedType_native.c
	
Cloog_ClastBinType_native.o : ../Cloog_ClastBinType_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastBinType_native.c
	
Cloog_ClastExpr_native.o : ../Cloog_ClastExpr_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastExpr_native.c
	
Cloog_ClastName_native.o : ../Cloog_ClastName_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastName_native.c
	
Cloog_ClastTerm_native.o : ../Cloog_ClastTerm_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastTerm_native.c
	
Cloog_ClastReduction_native.o : ../Cloog_ClastReduction_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastReduction_native.c
	
Cloog_ClastBinary_native.o : ../Cloog_ClastBinary_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastBinary_native.c
	
Cloog_ClatStmtOp_native.o : ../Cloog_ClatStmtOp_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClatStmtOp_native.c
	
Cloog_ClastStmt_native.o : ../Cloog_ClastStmt_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastStmt_native.c
	
Cloog_ClastAssignment_native.o : ../Cloog_ClastAssignment_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastAssignment_native.c
	
Cloog_ClastRoot_native.o : ../Cloog_ClastRoot_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastRoot_native.c
	
Cloog_ClastBlock_native.o : ../Cloog_ClastBlock_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastBlock_native.c
	
Cloog_CloogStatement_native.o : ../Cloog_CloogStatement_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_CloogStatement_native.c
	
Cloog_ClastUserStmt_native.o : ../Cloog_ClastUserStmt_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastUserStmt_native.c
	
Cloog_ClastFor_native.o : ../Cloog_ClastFor_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastFor_native.c
	
Cloog_ClastEquation_native.o : ../Cloog_ClastEquation_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastEquation_native.c
	
Cloog_ClastGuard_native.o : ../Cloog_ClastGuard_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_ClastGuard_native.c
	
Cloog_CloogNames_native.o : ../Cloog_CloogNames_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_CloogNames_native.c
	
Cloog_CloogOptions_native.o : ../Cloog_CloogOptions_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_CloogOptions_native.c
	
Cloog_CloogInput_native.o : ../Cloog_CloogInput_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_CloogInput_native.c
	
Cloog_CloogState_native.o : ../Cloog_CloogState_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_CloogState_native.c
	

Cloog_common_native.o : ../Cloog_common_native.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_common_native.c

Cloog_UserModules.o : ../Cloog_UserModules.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../Cloog_UserModules.c

#PROTECTED REGION ID(make_Macosx_64_CloogUser_addons) DISABLED START#
CloogUser_addons.o : ../CloogUser_addons.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../CloogUser_addons.c
#PROTECTED REGION END#

fixInstallNames:
	@echo "  [RPATH FIX] ISL"
	@A=`otool -L ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so | grep libisl.$(ISL_VERSION).dylib | colrm 1 8 | cut -d" " -f1`; \
		if [ "$$A" != "" ]; then \
			(if [ "$$A" != "@rpath/libisl.$(ISL_VERSION).dylib" ]; then \
				install_name_tool -change "$$A" "@rpath/libisl.$(ISL_VERSION).dylib" "../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so"; \
			fi); fi
	@A=`otool -L ../../lib/Cloog_macosx_$(ARCH_TYPE)/libcloog-isl.4.dylib | grep libisl.$(ISL_VERSION).dylib | colrm 1 8 | cut -d" " -f1`; \
		if [ "$$A" != "" ]; then \
			(if [ "$$A" != "@rpath/libisl.$(ISL_VERSION).dylib" ]; then \
				install_name_tool -change "$$A" "@rpath/libisl.$(ISL_VERSION).dylib" "../../lib/Cloog_macosx_$(ARCH_TYPE)/libcloog-isl.4.dylib"; \
			fi); fi
	@echo "  [RPATH FIX] GMP"
	@A=`otool -L ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so | grep libgmp.$(GMP_VERSION).dylib | colrm 1 8 | cut -d" " -f1`; \
		if [ "$$A" != "" ]; then \
			(if [ "$$A" != "@rpath/libgmp.$(GMP_VERSION).dylib" ]; then \
				install_name_tool -change "$$A" "@rpath/libgmp.$(GMP_VERSION).dylib" "../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so"; \
			fi); fi
	@A=`otool -L ../../lib/Cloog_macosx_$(ARCH_TYPE)/libcloog-isl.4.dylib | grep libgmp.$(GMP_VERSION).dylib | colrm 1 8 | cut -d" " -f1`; \
		if [ "$$A" != "" ]; then \
			(if [ "$$A" != "@rpath/libgmp.$(GMP_VERSION).dylib" ]; then \
				install_name_tool -change "$$A" "@rpath/libgmp.$(GMP_VERSION).dylib" "../../lib/Cloog_macosx_$(ARCH_TYPE)/libcloog-isl.4.dylib"; \
			fi); fi
	@echo "  [RPATH FIX] CLOOG"
	@A=`otool -L ../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so | grep libcloog-isl.4.dylib | colrm 1 8 | cut -d" " -f1`; \
		if [ "$$A" != "" ]; then \
			(if [ "$$A" != "@rpath/libcloog-isl.4.dylib" ]; then \
				install_name_tool -change "$$A" "@rpath/libcloog-isl.4.dylib" "../../lib/macosx_$(ARCH_TYPE)_libjnicloog.so"; \
			fi); fi
