#ST(spacetime) var stMap
ST	B	(t,i,j->t,t+i,t+j)
ST	temp_B	(t,i,j->t,t+i,t+j)

#M(memory) var memSpace memAlloc
M	B	B	(t,i,j->i,j)
M	temp_B	temp_B	(t,i,j->t,i,j)
#M	temp_B	temp_B	(t,i,j->t-i+N+2,t-j+N+2)

#SO(statement ordering) varPred varSucc
SO	temp_B	B

#Tiling
TILE	3

#Communication
COMMUNICATION	temp_B	1,0,0