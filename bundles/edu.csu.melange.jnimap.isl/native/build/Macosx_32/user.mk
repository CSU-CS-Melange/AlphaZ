#PROTECTED REGION ID(user_Macosx_32) ENABLED START#

#JAVA_HOME = /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
#JAVA_EXTRA_INC= -I/Developer/SDKs/MacOSX10.5.sdk/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers
#EXTRA_LIBS = -L/usr/local/lib/ 
#EXTRA_INCDIR = -I/usr/local/include/

JAVA_HOME = /System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/
JAVA_EXTRA_INC= -I$(JAVA_HOME)/Headers

EXTRA_LIBS = -lisl -lgmp -L$(HOME)/complibs/usr/local/lib/
#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
