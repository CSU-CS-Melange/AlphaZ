####################
##     CLOOG      ##
####################
ifeq ($(LIB),cloog)
CFG_OPTIONS= \
--host=$(HOST) \
--prefix=$(PREFIX_BASE)/cloog-test/ \
--with-pic \
--disable-static \
--with-isl-prefix=$(PREFIX_BASE)/cloog-test/ \
--with-gmp-prefix=/opt/homebrew/Cellar/gmp/6.2.1_1/ \
--with-osl=no
#--with-isl=bundled\
#--with-gmp=system
endif
