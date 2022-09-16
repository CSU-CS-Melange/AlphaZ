METHOD=#GIT
VERSION=6.2.1

# gmp git repo name
GITREP=gmp

### if METHOD = GIT, clone from GITADDR @head or @ CHECKOUT if specified
GITADDR=https://gmplib.org/repo/gmp/
#CHECKOUT=79fed64e9227b5c1814df23829901d32c1811ae1

### else, download archive (FILE) from URL and unzip  
DLDIR=$(GITREP)-$(VERSION)
FILE=$(DLDIR).tar.xz
URL=https://gmplib.org/download/gmp/$(FILE)

ifeq ($(METHOD),GIT)
	FILE = 
	DIR=$(GITREP)
else
	DIR=$(DLDIR)
endif


