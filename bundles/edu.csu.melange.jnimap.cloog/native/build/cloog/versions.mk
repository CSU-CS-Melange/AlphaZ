METHOD=#GIT
VERSION=0.18.4

# barvinok git repo name
GITREP=cloog

### if METHOD = GIT, clone from GITADDR @head or @ CHECKOUT if specified
GITADDR=git://repo.or.cz/cloog.git
#CHECKOUT=d2f282cbf206f1c92aaea0ea7ccff1709220414c

### else, download archive (FILE) from URL and unzip  
DLDIR=$(GITREP)-$(VERSION)
FILE=$(DLDIR).tar.gz
URL=https://www.bastoul.net/cloog/pages/download/count.php3?url=./$(FILE)

ifeq ($(METHOD),GIT)
	FILE = 
	DIR=$(GITREP)
else
	DIR=$(DLDIR)
endif


