#SYS( the system whose targetMapping is specified)
SYS	matrix_product_SubSyst

#ST(spacetime) level var stMap
ST	0	UseEquation_C	(ip,jp->1,ip,jp,2)

#USE(optimizatin specification for useEquation) label	isInput	num	stMapForMemoryAllocation	stMapForValueCopy	stMapForMmeoryFree
USE_ST	UseEquation_C	0	0	(ip,jp->0,0,0,0)	(ip,jp->1,ip,jp,0)	(ip,jp->2,0,0,0)
USE_ST	UseEquation_C	0	1	(ip,jp->0,0,0,1)	(ip,jp->1,ip,jp,1)	(ip,jp->2,0,0,1)
USE_ST	UseEquation_C	1	0	(ip,jp->0,0,0,2)	(ip,jp->1,ip,jp,3)	(ip,jp->2,0,0,2)

#OD(ordering dimension) level dim
OD	0	0
OD	0	3

#SYS( the system whose targetMapping is specified
SYS	dot_product

#ST(spacetime) level var stMap
ST	0	temp	(i->i)
ST	0 	Res	(->N)
