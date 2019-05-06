CFLAGS=-O3 -std=c99 -fopenmp
LIBRARIES=-lm
CC?=gcc
OBJS = Jacobi1DTimeSkewed.o 
all: plain check

debug: CFLAGS =-DDEBUG -g -Wall -Wextra -std=c99 -fopenmp
debug: all
		
plain: $(OBJS)
	$(CC) Jacobi1DTimeSkewed-wrapper.c -o Jacobi1DTimeSkewed $(OBJS) $(CFLAGS) $(LIBRARIES)

check: $(OBJS)
	$(CC) Jacobi1DTimeSkewed-wrapper.c -o Jacobi1DTimeSkewed.check $(OBJS) $(CFLAGS) $(LIBRARIES) -DCHECKING

verify: $(OBJS) Jacobi1DTimeSkewed_verify.o
	$(CC) Jacobi1DTimeSkewed-wrapper.c -o Jacobi1DTimeSkewed.verify $(OBJS) Jacobi1DTimeSkewed_verify.o $(CFLAGS) $(LIBRARIES) -DVERIFY

verify-rand: $(OBJS) Jacobi1DTimeSkewed_verify.o
	$(CC) Jacobi1DTimeSkewed-wrapper.c -o Jacobi1DTimeSkewed.verify-rand $(OBJS) Jacobi1DTimeSkewed_verify.o $(CFLAGS) $(LIBRARIES) -DVERIFY -DRANDOM

Jacobi1DTimeSkewed.o : Jacobi1DTimeSkewed.c
	$(CC) Jacobi1DTimeSkewed.c -o Jacobi1DTimeSkewed.o $(CFLAGS) -c

Jacobi1DTimeSkewed_verify.o : Jacobi1DTimeSkewed_verify.c
	$(CC) Jacobi1DTimeSkewed_verify.c -o Jacobi1DTimeSkewed_verify.o $(CFLAGS) -c

clean:
	rm -f *.o Jacobi1DTimeSkewed Jacobi1DTimeSkewed.check Jacobi1DTimeSkewed.verify Jacobi1DTimeSkewed.verify-rand
