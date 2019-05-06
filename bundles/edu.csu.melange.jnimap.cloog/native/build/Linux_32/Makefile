include Linux_32/user.mk
include Linux_32/libraries.mk

GECOS_PTRSIZE = (int)
ARCH = 32
JAVA_INC= -I$(JAVA_HOME)/include $(JAVA_EXTRA_INC)

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
	-Wl,-rpath,./.jnimap.temp.linux_32 \
	./.jnimap.temp.linux_32/libisl.so.13 \
	./.jnimap.temp.linux_32/libgmp.so.10 \
	./.jnimap.temp.linux_32/libcloog-isl.so.4 \
	$(EXTRA_LIBS)

# Path to the CloogNative class file
CLASSPATH=../../bin/

V=@
Q=

all: 
	@echo usage :
	@echo  - make lib : compile linux_32_libjnicloog.so
	@echo  - make clean

###############################
#			Rules
###############################

clean: 
	rm -rf ../../lib/linux_32_libjnicloog.so *.o ../*.o fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h ../../lib/Cloog_linux_32/*
	
lib: ../../lib/linux_32_libjnicloog.so

#Final file to be created.
../../lib/linux_32_libjnicloog.so : $(OBJS) $(EXTRA_OBJS) libs_linux_32
	$(V)mkdir -p ../../lib/
	$(Q)@echo "  [LINK] $@"
	$(V)$(CC) $(CFLAGS) -o ../../lib/linux_32_libjnicloog.so -shared $(OBJS) $(EXTRA_OBJS) $(LIBS)
	$(V)cd ../../lib/ && \
	mkdir -p Cloog_linux_32/ && \
	mv ../native/build/.jnimap.temp.linux_32/* ./Cloog_linux_32/
	$(V)$(MAKE) -f Linux_32/Makefile fixInstallNames
	$(V)rm -rf ./.jnimap.temp.linux_32/

libs_linux_32:
	$(V)mkdir -p ./.jnimap.temp.linux_32
	$(V)cp $(ISL_LIBDIR)/libisl.so.13 .jnimap.temp.linux_32/libisl.so.13
	$(V)cp $(GMP_LIBDIR)/libgmp.so.10 .jnimap.temp.linux_32/libgmp.so.10
	$(V)cp $(CLOOG_LIBDIR)/libcloog-isl.so.4 .jnimap.temp.linux_32/libcloog-isl.so.4

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

#PROTECTED REGION ID(make_Linux_32_CloogUser_addons) DISABLED START#
CloogUser_addons.o : ../CloogUser_addons.c fr_irisa_cairn_jnimap_cloog_jni_CloogNative.h fr_irisa_cairn_jnimap_cloog_jni_CloogNative_UserModules.h
	$(Q)@echo "  [CC] $@"
	$(V)$(CC) $(CFLAGS) -c -o $@ ../CloogUser_addons.c
#PROTECTED REGION END#

fixInstallNames:
	@echo "  [RPATH FIX] ISL"
	patchelf --set-rpath ./.jnimap.temp.linux_32/ ../../lib/Cloog_linux_32/libisl.so.13
	@echo "  [RPATH FIX] GMP"
	patchelf --set-rpath ./.jnimap.temp.linux_32/ ../../lib/Cloog_linux_32/libgmp.so.10
	@echo "  [RPATH FIX] CLOOG"
	patchelf --set-rpath ./.jnimap.temp.linux_32/ ../../lib/Cloog_linux_32/libcloog-isl.so.4
