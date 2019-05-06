#ST(spacetime) var stMap
ST	0	B	(t,i->t,i)
ST	0	temp_A	(t,i->t,i+1)
ST	0	temp_B	(t,i->t,i)

#M(memory) var space mapping modFactors
M	B	B	(t,i->i)
M	temp_B	temp_B	(t,i->i)
M	temp_A	temp_A	(t,i->i)

#SO(statement ordering) varPred varSucc
SO	temp_B	B
SO	temp_B	temp_A
