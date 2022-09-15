####################
##     CLOOG      ##
####################
ifeq ($(LIB),cloog)
CFG_OPTIONS= \
--host=$(HOST) \
--prefix=$(PREFIX_BASE)/ \
--with-pic \
--disable-static \
--with-isl-prefix=$(PREFIX_BASE)/ \
--with-gmp-prefix=$(PREFIX_BASE)/ \
--with-osl=no
#--with-isl=bundled\
#--with-gmp=system
endif
