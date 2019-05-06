# mpic TM1
# uses OV allocation

#ST(spacetime) var stMap
ST	B	(t,i->t,t+i)
ST	temp_B	(t,i->t,t+i)

#M(memory) var memSpace memAlloc
M	B	B	(t,i->i)
M	temp_B	temp_B	(t,i->t-i+N+1)

#SO(statement ordering) varPred varSucc
SO	temp_B	B

#Tiling
TILE	2

#Communication
COMMUNICATION	temp_B	1,0