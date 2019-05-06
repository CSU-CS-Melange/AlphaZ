# mpic TM2
# uses identity allocation

#ST(spacetime) var stMap
ST	B	(t,i->t,t+i)
ST	temp_B	(t,i->t,t+i)

#M(memory) var memSpace memAlloc
M	B	B	(t,i->t,i)
M	temp_B	temp_B	(t,i->t+1,i)

#SO(statement ordering) varPred varSucc
SO	temp_B	B

#Tiling
TILE	2

#Communication
COMMUNICATION	temp_B	1,0