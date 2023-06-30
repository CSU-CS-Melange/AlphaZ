###############
##    GMP    ##
###############
ifeq ($(LIB),gmp)
CFG_OPTIONS= \
--host=$(HOST) \
--prefix=$(PREFIX_BASE) \
--with-pic \
--disable-static \
--enable-shared \
--enable-portable-binary
endif
