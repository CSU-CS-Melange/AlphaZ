prog = ReadAlphabets("../AlphabetsExamples/MatMult/Matrix_product_SubSyst.ab");
rootSystem = "mat_product";
subSystem = "dot_product";
outDir = "../test-out/SubSystem/"+ rootSystem;
CheckProgram(prog);

#set the spacetimeMap for the subSystem dot product
setSpaceTimeMap(prog, subSystem, "temp", "(i->i)");
setSpaceTimeMap(prog, subSystem, "Res", "(->N)");

#set memory map for the variables in subSystem dot product
setMemorySpace(prog, subSystem, "RSpace", "temp, Res");
setMemoryMap(prog, subSystem, "temp", "RSpace", "(i->)");

label = "UseEquation_C";
##set the spacetimeMap for the rootSystem, including optimizations
##step one
#setSpaceTimeMap(prog, rootSystem, label, "(ip,jp->1,ip,jp,2)");
#setSpaceTimeMapForMemoryAllocation(prog, rootSystem, label, 0, 0, "(ip,jp->0,0,0,0)");
#setSpaceTimeMapForValueCopy(prog, rootSystem, label, 0, 0, "(ip,jp->1,ip,jp,0)");
#setSpaceTimeMapForMemoryFree(prog, rootSystem, label, 0, 0, "(ip,jp->2,0,0,0)");
#setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 1, "(ip,jp->0,0,0,1)", "(ip,jp->1,ip,jp,1)", "(ip,jp->2,0,0,1)");
#setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 1, 0, "(ip,jp->0,0,0,2)", "(ip,jp->1,ip,jp,3)", "(ip,jp->2,0,0,2)");
 
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 0, "(ip,jp->0,0,0,0,0)", "(ip,jp->1,ip,0,0,0)", "(ip,jp->2,0,0,0,0)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 1, "(ip,jp->0,0,0,0,0)", "(ip,jp->1,ip,1,jp,0)", "(ip,jp->2,0,0,0,0)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 1, 0, "(ip,jp->0,0,0,0,0)", "(ip,jp->1,ip,1,jp,2)", "(ip,jp->2,0,0,0,0)");
setSpaceTimeMap(prog, rootSystem, label, "(ip,jp->1,ip,1,jp,1)");

#setOrderingDimensions(prog, rootSystem, 0);
#setOrderingDimensions(prog, rootSystem, 3);

#step two, reuse input A and output C
#setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 0, 0, "A");
#setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 1, 0, "C");
#setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 1, "(ip,jp->0,0,0,0)", "(ip,jp->1,ip,jp,0)", "(ip,jp->2,0,0,0)");
#setSpaceTimeMap(prog, rootSystem, label, "(ip,jp->1,ip,jp,1)");

#setOrderingDimensions(prog, rootSystem, 0);
#setOrderingDimensions(prog, rootSystem, 3);

#set parallel dimension
#setParallel(prog, rootSystem, "1", "0,1");

#step three, reuse input A, B and C
#setMemoryMap(prog, rootSystem, "B",  "B", "(i,j->j,i)");
#setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 0, 0, "A");
#setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 0, 1, "B");
#setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 1, 0, "C");

#setSpaceTimeMap(prog, rootSystem, label, "(ip,jp->ip,jp)");

#setParallel(prog, rootSystem, "", "0,1");

generateScheduledCode(prog, rootSystem, outDir);
generateWrapper(prog, rootSystem, outDir);
generateMakefile(prog, rootSystem, outDir);
