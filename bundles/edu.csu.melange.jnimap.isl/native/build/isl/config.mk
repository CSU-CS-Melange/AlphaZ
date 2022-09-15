###############
##    ISL    ##
###############
ifeq ($(LIB),isl)
CFG_OPTIONS= \
--host=$(HOST) \
--prefix=$(PREFIX_BASE) \
--with-pic \
--disable-static \
--enable-shared \
--enable-portable-binary \
--with-clang=no \
#--with-gmp-prefix=/opt/homebrew/Cellar/gmp/6.2.1_1/
#--with-int=imath-32
--with-gmp=system \
#--with-gmp-prefix=$(PREFIX_BASE)
endif
