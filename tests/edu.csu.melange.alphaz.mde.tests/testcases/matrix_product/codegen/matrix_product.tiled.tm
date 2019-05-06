#ST(spacetime) var stMap

#M(memory map) var space mapping
M	C	C	(i,j,k->i,j)
M	temp_C	C	(i,j,k->i,j)

#SO(statement ordering) pred succ
SO	temp_C	C

#Tiling level orderingPrefix begin end
TILE	0	0	2
