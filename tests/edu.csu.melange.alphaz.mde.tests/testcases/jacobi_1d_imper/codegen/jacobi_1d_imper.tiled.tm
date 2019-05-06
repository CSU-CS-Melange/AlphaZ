#ST(spacetime) var stMap
ST	0	B	(t,i->t,1,t+i)
ST	0	temp_A	(t,i->t,1,t+i)
ST	0	temp_B	(t,i->t,0,t+i)

#OD(ordering) level dim
OD	0	1

#M(memory) var space mapping modFactors
M	B	B	(t,i->i)
M	temp_A	temp_A	(t,i->t,i)	2,0
M	temp_B	temp_B	(t,i->i)

#SO(statement ordering) varPred varSucc
SO	temp_B	B
SO	temp_B	temp_A

TILE	0	0	2