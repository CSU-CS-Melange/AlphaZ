.PHONY: Linux_32 Linux_64 Cygwin_32 Mingw_32 Macosx_32 Macosx_64

AUTODETECT=0
SYSTEM=$(shell uname -s)
ifeq ($(SYSTEM),Darwin)
	HOST=Macosx
	ARCH=$(shell sysctl -a hw.optional.x86_64 | cut -d" " -f2)
	ifeq ($(ARCH),1)
		ARCH=64
		AUTODETECT=1
	else 
		ARCH=32
		AUTODETECT=1
	endif
else
	ifeq ($(SYSTEM),Linux)
		HOST=Linux
		ARCH=$(shell uname -m)
		ifeq ($(ARCH),x86_64)
			ARCH=64
			AUTODETECT=1
		else 
		ARCH=32
		AUTODETECT=1
		endif
	else
		AUTODETECT=0
	endif
endif

all:
ifeq ($(AUTODETECT),1)
	@echo ">> Autodetecting host machine : $(HOST)_$(ARCH)"
	@$(MAKE) -s -f $(HOST)_$(ARCH)/Makefile clean
	@$(MAKE) -s -f $(HOST)_$(ARCH)/Makefile lib
else
	@echo "Cannot detect host machine. Please use one of the following :"
	@echo "    - make Linux_32 "
	@echo "    - make Linux_64 "
	@echo "    - make Cygwin_32 "
	@echo "    - make Mingw_32 "
	@echo "    - make Macosx_32 "
	@echo "    - make Macosx_64 "
endif

clean:
ifeq ($(AUTODETECT),1)
	@echo ">> Autodetecting host machine : $(HOST)_$(ARCH)"
	@$(MAKE) -s -f $(HOST)_$(ARCH)/Makefile clean
else
	@echo "Cannot detect host machine. Please use one of the following :"
	@echo "    - make -s -f Linux_32/Makefile clean "
	@echo "    - make -s -f Linux_64/Makefile clean "
	@echo "    - make -s -f Cygwin_32/Makefile clean "
	@echo "    - make -s -f Mingw_32/Makefile clean "
	@echo "    - make -s -f Macosx_32/Makefile clean "
	@echo "    - make -s -f Macosx_64/Makefile clean "
endif

Linux_32 :
	@$(MAKE) -s -f ./Linux_32/Makefile clean
	@$(MAKE) -s -f ./Linux_32/Makefile lib
Linux_64 :
	@$(MAKE) -s -f ./Linux_64/Makefile clean
	@$(MAKE) -s -f ./Linux_64/Makefile lib
Cygwin_32 :
	@$(MAKE) -s -f ./Cygwin_32/Makefile clean
	@$(MAKE) -s -f ./Cygwin_32/Makefile lib
Mingw_32 :
	@$(MAKE) -s -f ./Mingw_32/Makefile clean
	@$(MAKE) -s -f ./Mingw_32/Makefile lib
Macosx_32 :
	@$(MAKE) -s -f ./Macosx_32/Makefile clean
	@$(MAKE) -s -f ./Macosx_32/Makefile lib
Macosx_64 :
	@$(MAKE) -s -f ./Macosx_64/Makefile clean
	@$(MAKE) -s -f ./Macosx_64/Makefile lib
