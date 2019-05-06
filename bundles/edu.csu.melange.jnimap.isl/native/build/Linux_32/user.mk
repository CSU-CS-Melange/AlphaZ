#PROTECTED REGION ID(user_Linux_32) ENABLED START#

CC = gcc
EXTRA_CFLAGS =

#JAVA_HOME = /usr/lib/jvm/java-6-openjdk
#JAVA_HOME = /usr/lib/jvm/java-6-sun
#JAVA_HOME = /usr/lib/jvm/default-java
#JAVA_HOME = /usr/lib/jvm/java-7-oracle/
JAVA_HOME = /usr/lib/jvm/java-1.7.0-openjdk-i386/
#JAVA_HOME = /usr/local/java
# Steven's machine
#JAVA_HOME = /usr/lib/jvm/java-6-sun-1.6.0.26

JAVA_EXTRA_INC=-I$(JAVA_HOME)/include/linux

#PROTECTED REGION END#

JAVA_H=$(JAVA_HOME)/bin/javah
