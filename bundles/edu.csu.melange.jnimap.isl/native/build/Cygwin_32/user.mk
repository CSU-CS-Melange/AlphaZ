#PROTECTED REGION ID(user_Cygwin_32) ENABLED START#

# ./configure CFLAGS="-mno-cygwin -D ffs=__builtin_ffs" -prefix=/cygdrive/c/data/mingw32/ --with-gmp-prefix=/cygdrive/c/data/mingw32/
 
JAVA_HOME=/cygdrive/c/"Program Files"/Java/jdk1.6.0_22/
JAVA_INC=-I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/win32 -I$(JAVA_HOME)/include/linux

ARCH=32
EXTRA_CFLAGS= -mno-cygwin -Wl,--kill-at


EXTRA_INCDIR=\
	-I/cygdrive/c/data/mingw32/include/isl/ \
	-I/cygdrive/c/data/mingw32/include/ \
	-I../../../fr.irisa.cairn.jnimap.isl.native.extra/include
	 
EXTRA_LIBS=-L/cygdrive/c/data/mingw32/lib -L../../../fr.irisa.cairn.jnimap.isl.native.extra/lib -lisl-user -lisl -lgmp 

JAVAH=$(JAVA_HOME)/bin/javah
#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
