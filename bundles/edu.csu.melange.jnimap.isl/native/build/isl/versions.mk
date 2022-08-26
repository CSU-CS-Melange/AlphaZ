METHOD=GIT
VERSION=0.15

# isl git repo name
GITREP=isl

### if METHOD = GIT, clone from GITADDR @head or @ CHECKOUT if specified
GITADDR=git://repo.or.cz/isl.git
CHECKOUT=isl-0.15

### else, download archive (FILE) from URL and unzip  
DLDIR=$(GITREP)-$(VERSION)
FILE=$(DLDIR).tar.bz2
URL=http://isl.gforge.inria.fr/$(FILE)

ifeq ($(METHOD),GIT)
	FILE = 
	DIR=$(GITREP)
else
	DIR=$(DLDIR)
endif


