#PROTECTED REGION ID(user_Linux_64) ENABLED START#


CC ?= gcc
EXTRA_CFLAGS =

JAVA_HOME = /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.342.b07-2.el8_6.x86_64
#JAVA_HOME = /usr/lib/jvm/java-7-openjdk-amd64
#JAVA_HOME = /udd/malle/soft/jdk1.7.0_51/
#JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-1.7.0.19.x86_64
#JAVA_HOME =/usr/lib/jvm/default-java/
#JAVA_HOME =  /usr/lib/jvm/java-6-sun/
#JAVA_EXTRA_INC= -I$(JAVA_HOME)/include/linux/ -I$(JAVA_HOME)/include/
#JAVA_HOME = /usr/local/java64/

JAVA_EXTRA_INC= -I$(JAVA_HOME)/include/linux/


#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
