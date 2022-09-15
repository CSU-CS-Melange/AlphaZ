prog = ReadAlphabets("../AlphabetsExamples/MatMult/MM.ab");
system = "MM";
#prog = ReadAlphabets("../AlphabetsExamples/MatMult/matrix_product.ab");
#system = "matrix_product";
outDir = "../test-out/ScheduleC/"+system;
CheckProgram(prog);

#set the spacetimeMap for system MM
setSpaceTimeMap(prog, system, "C", "(i,j->i,j)");
setParallel(prog, system, "", "0,1");

#set the spacetimeMap for the system matrix_product
#setSpaceTimeMap(prog, system, "temp_C", "(i,j,k->i,j,k)");
#setSpaceTimeMap(prog, system, "C", "(i,j,k->i,j,k)");

#setMemorySpace(prog, system, "CSpace", "C, temp_C");
#setMemoryMap(prog, system, "temp_C", "CSpace", "(i,j,k->i,j)");
#setMemoryMap(prog, system, "C", "CSpace", "(i,j,k->i,j)");
#setStatementOrdering(prog, system, "temp_C", "C");
##setOrderingDimensions(prog, system, 0);
#setParallel(prog, system, "", "0,1");

generateScheduledCode(prog, system, outDir);
generateWrapper(prog, system, outDir);
generateMakefile(prog, system, outDir);
