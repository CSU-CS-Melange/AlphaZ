#ST(spacetime) var stMap
ST	0	B	(t,i,j->t,t+i,t+j)
ST	0	temp_B	(t,i,j->t,t+i,t+j)

#M(memory) var space mapping modFactors
M	B	B	(t,i,j->i,j)
M	temp_B	temp_B	(t,i,j->t,i,j)	2,0,0

#SO(statement ordering) pred succ
SO	temp_B	B

#Tiling
TILE	0	0	2

#Vec Options	variable name 	register block size
VC	temp_B	1,3