cc = gcc
obj = main.o p1.o p2.o

darren : $(obj)
	$(cc) -o darren $(obj)

main.o: main.c h1.h h2.h
	$(CC) -c main.c

p1.o: p1.c h1.h h2.h
	$(CC) -c p1.c

p2.o: p2.c h1.h h2.h
	$(CC) -c p2.c


clean : 
	-rm $(obj)