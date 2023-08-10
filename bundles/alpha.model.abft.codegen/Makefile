CFLAGS= -O3  -std=c99  -I/usr/include/malloc/
LIBRARIES=-lm
CC?=gcc
OBJS = star2d1r_double.o init.o conv.o
all: plain check

debug: CFLAGS =-DDEBUG -g -Wall -Wextra -std=c99 -I/usr/include/malloc/
debug: all

plain: $(OBJS)
	$(CC) star2d1r_double-wrapper.c -o star2d1r_double $(OBJS) $(CFLAGS) $(LIBRARIES)

check: $(OBJS)
	$(CC) star2d1r_double-wrapper.c -o star2d1r_double.check $(OBJS) $(CFLAGS) $(LIBRARIES) -DCHECKING -DRANDOM

init.o : init.c
	$(CC) init.c -o init.o $(CFLAGS) $(LIBRARIES) -c

conv.o : conv.c
	$(CC) conv.c -o conv.o $(CFLAGS) $(LIBRARIES) -c

star2d1r_double.o : star2d1r_double.c
	$(CC) star2d1r_double.c -o star2d1r_double.o $(CFLAGS) $(LIBRARIES) -c


clean:
	rm -f *.o star2d1r_double star2d1r_double.check
