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
--with-gmp-prefix=/usr/local/
#--with-int=imath-32
#--with-gmp=system \
#--with-gmp-prefix=$(PREFIX_BASE)
endif
