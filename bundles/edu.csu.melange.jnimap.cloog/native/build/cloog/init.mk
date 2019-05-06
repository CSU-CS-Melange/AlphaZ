#Makefile
PREFIX_BASE=$(HOME)/complibs/usr/local/cloog/

SYSTEM=$(shell uname -s)
ifeq ($(SYSTEM),Linux)
	FINDOPT=.
else 
	FINDOPT=-d .
endif

#number of CPU (parallel compilation)
SYSTEM=$(shell uname -s)
ifeq ($(SYSTEM),Linux)
	N=$(shell more /proc/cpuinfo | grep processor | wc -l)
	#JOBS=$(shell echo "test(${N})" | bc -l compute.bc)
	#NBPROC=$(shell echo "${N}/${JOBS}" | bc)
	JOBS=1
	NBPROC=$(N)
else 
ifeq ($(SYSTEM),Darwin)
	NBPROC=$(shell sysctl -a hw.ncpu | cut -d" " -f2)
	JOBS=1
else
	NBPROC=1
	JOBS=1
endif
endif

#architecture
ifeq ($(SYSTEM),Darwin)
ARCH=$(shell sysctl -a hw.optional.x86_64 | cut -d" " -f2)
ifeq ($(ARCH),1)
	ARCH=64
	BUILDSYSTEM=x86_64-unkown-darwin
else 
	ARCH=32
	BUILDSYSTEM=i686-unkown-darwin
endif
else
ifeq ($(SYSTEM),Linux)
ARCH=$(shell uname -m)
ifeq ($(ARCH),x86_64)
	ARCH=64
	BUILDSYSTEM=x86_64-unkown-linux
else 
	ARCH=32
	BUILDSYSTEM=i686-unkown-linux
endif
else
	ARCH=32
	BUILDSYSTEM=i686-pc-none
endif
endif


#cross compile for win32
ifeq ($(TARGET),win)
	ARCH=32
	HOST=i586-mingw32msvc
	PREFIX_BASE=$(HOME)/complibs-win32/usr/local
else
	HOST=
endif

PREFIX_TOOLS=$(PREFIX_BASE)_tools
PREFIX_RETRO=$(PREFIX_BASE)_retro

BINPATH=$(PREFIX_TOOLS)/bin:$(PREFIX_BASE)/bin:$(PREFIX_RETRO)/bin
PATHUPDATE=export PATH=$$PATH:$(BINPATH) && 
FIND=/usr/bin/find
#LIB=$(notdir $(PWD))
LIB=$(shell basename "$(PWD)")
