#PROTECTED REGION ID(user_Macosx_64) ENABLED START#

#JAVA_HOME=/Library/Java/JavaVirtualMachines/1.6.0_22-b04-307.jdk/Contents/
#JAVA_EXTRA_INC=-I/Library/Java/JavaVirtualMachines/1.6.0_22-b04-307.jdk/Contents/Headers

#JAVA_HOME = /System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home
#JAVA_EXTRA_INC= -I/Developer/SDKs/MacOSX10.5.sdk/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Headers
#EXTRA_LIBS = -L/usr/local/lib/
#EXTRA_INCDIR = -I/usr/local/include/

#JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk1.8.0_25.jdk/Contents/Home
#JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home
JAVA_HOME = /Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Contents/Home
JAVA_EXTRA_INC= -I$(JAVA_HOME)/Headers -I$(JAVA_HOME)/include/darwin/

#amorvan
#JAVA_HOME = /System/Library/Frameworks/JavaVM.framework/Versions/Current/
#JAVA_EXTRA_INC= -I$(JAVA_HOME)/Headers
#EXTRA_LIBS = -lisl -lgmp -L$(HOME)/complibs/usr/local/lib/

#JAVA_HOME=/Library/Java/JavaVirtualMachines/1.6.0_37-b06-434.jdk/Contents/
#JAVA_EXTRA_INC=-I/Library/Java/JavaVirtualMachines/1.6.0_37-b06-434.jdk/Contents/Headers



#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
