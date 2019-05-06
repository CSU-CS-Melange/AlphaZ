# mpic TM2
# uses identity allocation

#ST(spacetime) var stMap
ST	B	(t,i->t,1,t+i)
ST	temp_A	(t,i->t,1,t+i)
ST	temp_B	(t,i->t,0,t+i)

#dim type
DIM_TYPE	B	1	ORDERING
DIM_TYPE	temp_A	1	ORDERING
DIM_TYPE	temp_B	1	ORDERING

#M(memory) var memSpace memAlloc
M	B	B	(t,i->t,i)
M	temp_A	temp_A	(t,i->t+1,i+1)
M	temp_B	temp_B	(t,i->t+1,i+1)

#SO(statement ordering) varPred varSucc
SO	temp_B	B
SO	temp_B	temp_A

TILE	2

#Communication
COMMUNICATION	temp_A	1,0
COMMUNICATION	temp_B	1,0