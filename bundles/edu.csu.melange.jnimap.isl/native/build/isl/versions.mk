METHOD=#GIT
VERSION=0.20

# isl git repo name
GITREP=isl

### if METHOD = GIT, clone from GITADDR @head or @ CHECKOUT if specified
GITADDR=git://repo.or.cz/isl.git
#CHECKOUT=79fed64e9227b5c1814df23829901d32c1811ae1

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


