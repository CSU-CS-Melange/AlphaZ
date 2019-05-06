#ST(spacetime) var stMap
ST	0	H	(i,j->i,i+j)
ST	0	score	(i,j->i,i+j)

#M(memory) var space mapping modFactors
M	H	H	(i,j->i,j)	2,0
M	score	score	(i,j->)


#Tiling
TILE	0	0	1