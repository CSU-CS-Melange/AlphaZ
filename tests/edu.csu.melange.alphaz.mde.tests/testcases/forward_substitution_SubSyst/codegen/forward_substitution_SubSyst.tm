#SYS( the system whose targetMapping is specified)
SYS	forward_substitution_SubSyst

#ST(spacetime) level var stMap
ST	0	UseEquation_temp	(i->i,5)
ST	0	X	(i->i,7)

#USE(optimizatin specification for useEquation) label	isInput	num	stMapForMemoryAllocation	stMapForValueCopy	stMapForMmeoryFree
USE_ST	UseEquation_temp	0	0	(i->i,0)	(i->i,3)	(i->i,8)
USE_ST	UseEquation_temp	0	1	(i->i,1)	(i->i,4)	(i->i,9)
USE_ST	UseEquation_temp	1	0	(i->i,2)	(i->i,6)	(i->i,10)

#OD(ordering dimension) level dim
OD	0	1

#SYS( the system whose targetMapping is specified
SYS	dotProd
