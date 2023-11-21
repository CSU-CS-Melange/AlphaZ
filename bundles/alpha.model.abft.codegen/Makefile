CFLAGS= -O3  -std=c99  -I/usr/include/malloc/
LIBRARIES=-lm
CC?=gcc
OBJS = star2d1r.o init.o conv.o
all: plain check

debug: CFLAGS =-DDEBUG -g -Wall -Wextra -std=c99 -I/usr/include/malloc/
debug: all

plain: $(OBJS)
	$(CC) star2d1r-wrapper.c -o star2d1r $(OBJS) $(CFLAGS) $(LIBRARIES)

check: $(OBJS)
	$(CC) star2d1r-wrapper.c -o star2d1r.check $(OBJS) $(CFLAGS) $(LIBRARIES) -DCHECKING -DRANDOM

init.o : init.c
	$(CC) init.c -o init.o $(CFLAGS) $(LIBRARIES) -c

conv.o : conv.c
	$(CC) conv.c -o conv.o $(CFLAGS) $(LIBRARIES) -c

star2d1r.o : star2d1r.c
	$(CC) star2d1r.c -o star2d1r.o $(CFLAGS) $(LIBRARIES) -c


clean:
	rm -f *.o star2d1r star2d1r.check
