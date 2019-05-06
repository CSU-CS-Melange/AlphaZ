#ST(spacetime) var stMap
ST	H	(i,j->i,j)
ST	score	(i,j->i,j)


#M(memory) var memSpace memAlloc
M	H	H	(i,j->i-j+N)
M	score	score	(i,j->)


#Tiling
TILE	3

#Communication
COMMUNICATION	H	1,0
