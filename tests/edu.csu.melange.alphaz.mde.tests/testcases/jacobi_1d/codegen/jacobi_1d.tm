#ST(spacetime) var stMap
ST	0	B	(t,i->t,i)
ST	0	temp_B	(t,i->t,i)

#M(memory) var space mapping modFactors
M	B	B	(t,i->t,i)
M	temp_B	temp_B	(t,i->t,i)

#SO(statement ordering) varPred varSucc
SO	temp_B	B
