#ST(spacetime) var stMap
ST	0	B	(t,i,j->t,1,t+i,t+j)
ST	0	temp_A	(t,i,j->t,1,t+i,t+j)
ST	0	temp_B	(t,i,j->t,0,t+i,t+j)

#OD(ordering)
OD	0	1

#M(memory) var space mapping modFactors
M	B	B	(t,i,j->i,j)
M	temp_A	temp_A	(t,i,j->t,i,j)	2,0,0
M	temp_B	temp_B	(t,i,j->i,j)

TILE	0	0	3