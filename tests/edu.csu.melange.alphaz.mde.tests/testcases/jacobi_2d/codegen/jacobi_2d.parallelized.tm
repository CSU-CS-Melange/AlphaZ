#ST(spacetime) var stMap
ST	0	B	(t,i,j->t,j,i)
ST	0	temp_B	(t,i,j->t,j,i)

#M(memory) var space mapping modFactors
M	B	B	(t,i,j->i,j)
M	temp_B	temp_B	(t,i,j->t,i,j)	2,0,0

#SO(statement ordering) varPred varSucc
SO	temp_B	B

#PAR(parallelization specification)	level 	prefix	dims
PAR	0	-1	1,2
