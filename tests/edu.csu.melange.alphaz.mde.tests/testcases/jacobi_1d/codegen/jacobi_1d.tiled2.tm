#Using UOV allocation

#ST(spacetime) var stMap
ST	0	B	(t,i->t,t+i)
ST	0	temp_B	(t,i->t,t+i)

#M(memory) var space mapping modFactors
M	B	B	(t,i->i)
M	temp_B	temp_B	(t,i->t-i+N)

#SO(statement ordering) pred succ
SO	temp_B	B

#Tiling
TILE	0	0	1
