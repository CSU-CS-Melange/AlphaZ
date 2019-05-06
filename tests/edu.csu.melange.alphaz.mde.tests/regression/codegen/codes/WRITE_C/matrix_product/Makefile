CFLAGS=-fopenmp -O3  -std=c99 -W  -I/usr/include/malloc/ -lm
CC?=gcc
OBJS = $(ALPHAZ_MAKE_DIR)/matrix_product.o 
all: plain check

debug: CFLAGS =-DDEBUG -g  -std=c99 -W -lm  -I/usr/include/malloc/
debug: all

ifndef ALPHAZ_MAKE_DIR
	ALPHAZ_MAKE_DIR=.
endif

plain: $(OBJS)
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product $(OBJS) $(CFLAGS) -lm

check: $(OBJS)
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.check $(OBJS) $(CFLAGS) -lm -DCHECKING
	
check-noprompt: $(OBJS)
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.check $(OBJS) $(CFLAGS) -lm -DCHECKING -DNO_PROMPT

verify: $(OBJS) $(ALPHAZ_MAKE_DIR)/matrix_product_verify.o
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.verify $(OBJS) $(ALPHAZ_MAKE_DIR)/matrix_product_verify.o $(CFLAGS) -lm -DVERIFY
	
verify-noprompt: $(OBJS) $(ALPHAZ_MAKE_DIR)/matrix_product_verify.o
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.verify $(OBJS) $(ALPHAZ_MAKE_DIR)/matrix_product_verify.o $(CFLAGS) -lm -DVERIFY -DNO_PROMPT

verify-rand: $(OBJS)
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product-wrapper.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.verify-rand $(OBJS) matrix_product_verify.o $(CFLAGS) -lm -DVERIFY -DRANDOM

$(ALPHAZ_MAKE_DIR)/matrix_product.o : $(ALPHAZ_MAKE_DIR)/matrix_product.c
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product.c -o $(ALPHAZ_MAKE_DIR)/matrix_product.o $(CFLAGS) -c

$(ALPHAZ_MAKE_DIR)/matrix_product_verify.o : $(ALPHAZ_MAKE_DIR)/matrix_product_verify.c
	$(CC) $(ALPHAZ_MAKE_DIR)/matrix_product_verify.c -o $(ALPHAZ_MAKE_DIR)/matrix_product_verify.o $(CFLAGS) -c

clean:
	rm -f $(ALPHAZ_MAKE_DIR)/*.o $(ALPHAZ_MAKE_DIR)/matrix_product $(ALPHAZ_MAKE_DIR)/matrix_product.check $(ALPHAZ_MAKE_DIR)/matrix_product.verify $(ALPHAZ_MAKE_DIR)/matrix_product.verify-rand		
