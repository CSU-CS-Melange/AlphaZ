#ST(spacetime) var stMap
ST	new	(t,i->t,0,t+i)
ST	A	(t,i->t,1,t+i)
ST	Final	(t,i->t,1,t+i)

#dimension types
DIM_TYPE	new	1	ORDERING
DIM_TYPE	A	1	ORDERING
DIM_TYPE	Final	1	ORDERING

#M(memory) var memSpace memAlloc
M	new	new	(t,i->i)
M	A	A	(t,i->i)
M	Final	Final	(t,i->i)

#SO(statement ordering) varPred varSucc
SO	new	A
SO	new	Final
SO	A	Final
