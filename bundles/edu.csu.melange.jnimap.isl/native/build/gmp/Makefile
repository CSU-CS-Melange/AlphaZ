#Makefile ISL
include ./init.mk
include ./versions.mk
include ./config.mk

all: install

#echo "skipping : isl is shipped with cloog" 
#install

dl:
ifeq ($(wildcard $(DIR)),)
ifeq ($(METHOD),GIT)
	rm -rf $(GITREP)
	git clone $(GITADDR)
ifeq ($(CHECKOUT),)
	@echo "using head"
else
	@echo "using commit $(CHECKOUT)"
	cd $(DIR) && git checkout $(CHECKOUT)
endif
	# inti 'imath' submodule
	cd $(DIR) && git submodule init
	cd $(DIR) && git submodule update
	#cd $(DIR) && git apply ../patch
	cd $(DIR) && ./autogen.sh 
else
ifeq ($(wildcard $(FILE)),)
	wget -O $(FILE) $(URL)
endif
	tar xvf $(FILE)
endif
else 
	-cd $(DIR) && make -s distclean
endif

configure: dl
	cd $(DIR) && ./configure $(CFG_OPTIONS)

compile: configure
	cd $(DIR) && make -j$(NBPROC)
ifeq ($(TARGET),win)
	cd $(DIR) && i586-mingw32msvc-gcc -shared .libs/*.o -o libisl.dll -L$(PREFIX_BASE)/lib -lgmp
endif

install: compile
	$(MAKE) f_install

check:
	cd $(DIR) && make check -j$(NBPROC)

f_install:
	cd $(DIR) && make install -j$(NBPROC)
ifeq ($(TARGET),win)
	cd $(DIR) && cp libisl.dll $(PREFIX_BASE)/lib/
endif

uninstall: 
	cd $(DIR) && make uninstall
ifeq ($(TARGET),win)
	rm $(PREFIX_BASE)/lib/libisl.dll
endif

clean:
	rm -rf $(GITREP) $(DLDIR)* *~
