####################
##     CLOOG      ##
####################
ifeq ($(LIB),cloog)
CFG_OPTIONS= \
--host=$(HOST) \
--prefix=$(PREFIX_BASE)/cloog-test/ \
--with-pic \
--disable-static \
--with-isl=bundled\
--with-gmp-prefix=$(HOME)/complibs/usr/local/\
--with-osl=no
#--with-gmp=system
endif
