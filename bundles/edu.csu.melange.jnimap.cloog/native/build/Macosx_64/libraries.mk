#PROTECTED REGION ID(libraries_Macosx_64) ENABLED START#
CLOOG_INCDIR=$(HOME)/complibs/usr/local/cloog-test/include
CLOOG_LIBDIR=$(HOME)/complibs/usr/local/cloog-test/lib
#Location of external jnimap with shared library
ISL_LOCATION=../../../edu.csu.melange.jnimap.isl/

#Libraries used by other bindigs --- use the same includes
ISL_INCDIR=$(HOME)/complibs/usr/local/cloog-test/include
GMP_INCDIR=/opt/homebrew/Cellar/gmp/6.2.1_1/include
#PROTECTED REGION END#

ISL_LIBDIR=${ISL_LOCATION}/lib/ISL_macosx_$(ARCH_TYPE)/
GMP_LIBDIR=${ISL_LOCATION}/lib/ISL_macosx_$(ARCH_TYPE)/

ISL_VERSION = 15
GMP_VERSION = 10
