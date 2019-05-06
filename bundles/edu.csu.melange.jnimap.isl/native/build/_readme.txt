This version works with the "aff"-patched version of ISL. To get this version, first
checkout GIT repo, and apply the "aff" patch (provided in the build folder of this plugin) 
using patch -p1 < aff.patch. Here is a template of a script that do the job.

NOTE : since it does not work with the last GIT updates, ISL should be reverted to the 
version 200392aeeff82c3d5d5e82a6569fdcb98f766b39.

GITADDR=git://repo.or.cz/isl.git
DIR=isl
git clone $(GITADDR)
cd $(DIR) && git checkout 200392aeeff82c3d5d5e82a6569fdcb98f766b39
cd $(DIR) && patch -p1 < ../aff.patch
cd $(DIR) && ./autogen.sh
cd $(DIR) && ./configure --with-pic --enable-static --enable-portable-binary
cd $(DIR) && make
cd $(DIR) && make check
cd $(DIR) && sudo make uninstall

