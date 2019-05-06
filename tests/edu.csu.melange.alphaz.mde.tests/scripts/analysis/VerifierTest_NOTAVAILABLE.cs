# Load Program and store as 'prog'
prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
# Define a variable 'system' to store the system name
system = "matrix_product";


setSpaceTimeMap(prog, system, "C, temp_C", "(i,j,k->i,j,k)");
setSpaceTimeMap(prog, system, "C", "(i,j,k->i,j,k+1)");

setMemoryMap(prog, system, "C, temp_C", "C",  "(i,j,k->i,j)");

listSpaceTimeMaps(prog, system);
listMemoryMaps(prog, system);

#setStatementOrdering(prog, system, "temp_C", "C");

VerifyTargetMapping(prog, system , "MIN" );
