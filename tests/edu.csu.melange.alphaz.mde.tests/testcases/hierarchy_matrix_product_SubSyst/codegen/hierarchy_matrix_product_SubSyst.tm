#SYS( the system whose targetMapping is specified)
SYS	hierarchy_matrix_product_SubSyst

#ST(spacetime) level var stMap
ST	0	UseEquation_C	(ip->0,ip,3)
ST	0	Cloc	(i,j->1,i,j)

#USE_ST(optimizatin specification for useEquation) label	isInput	num	stMapForMemoryAllocation	stMapForValueCopy	stMapForMmeoryFree
USE_ST	UseEquation_C	0	1	(ip->0,ip,0)	(ip->0,ip,2)	(ip->0,ip,5)
USE_ST	UseEquation_C	1	0	(ip->0,ip,1)	(ip->0,ip,4)	(ip->0,ip,6)

#USE_M (memory space speficication for useEquaiton)	label	isInput	num	spaceName
USE_M	UseEquation_C	0	0	A

#OD(ordering dimension) level dim
OD	0	0
OD	0	2

#SYS( the system whose targetMapping is specified
SYS	mat_vect_product

#ST(spacetime) level var stMap
ST	0	UseEquation_res	(ip->ip,3)

#USE_ST(optimizatin specification for useEquation) label	isInput	num	stMapForMemoryAllocation	stMapForValueCopy	stMapForMmeoryFree
USE_ST	UseEquation_res	0	0	(ip->ip,0)	(ip->ip,2)	(ip->ip,5)
USE_ST	UseEquation_res	1	0	(ip->ip,1)	(ip->ip,4)	(ip->ip,6)

#USE_M (memory space speficication for useEquaiton)	label	isInput	num	spaceName
USE_M	UseEquation_res	0	1	vect

#SYS( the system whose targetMapping is specified
SYS	vector_product

#ST(spacetime) level var stMap
ST	0	Res	(->N)


