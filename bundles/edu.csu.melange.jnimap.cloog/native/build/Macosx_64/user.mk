#PROTECTED REGION ID(user_Macosx_64) ENABLED START#
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home
JAVA_EXTRA_INC= -I$(JAVA_HOME)/Headers -I$(JAVA_HOME)/include/darwin/

EXTRA_LIBS = -L/usr/local/lib/
EXTRA_INCDIR = -I/usr/local/include/

EXTRA_CFLAGS=-DCLOOG_INT_GMP

#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
