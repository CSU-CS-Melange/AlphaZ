METHOD=GIT
VERSION=0.20.0

# barvinok git repo name
GITREP=cloog

### if METHOD = GIT, clone from GITADDR @head or @ CHECKOUT if specified
GITADDR=git@github.com:periscop/cloog.git
CHECKOUT=cloog-0.20.0

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


