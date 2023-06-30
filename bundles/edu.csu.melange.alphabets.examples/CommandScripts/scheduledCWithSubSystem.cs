prog = ReadAlphabets("../AlphabetsExamples/MatMult/Matrix_product_SubSyst.ab");
rootSystem = "mat_product";
subSystem = "dot_product";
outDir = "../../test-out/"+ rootSystem;
CheckProgram(prog);

#set the spacetimeMap for the subSystem first
setSpaceTimeMap(prog, subSystem, "temp", "(i->i)");
setSpaceTimeMap(prog, subSystem, "Res", "(->N)");

label = "UseEquation_C";
#set the spacetimeMap for the rootSystem
setSpaceTimeMap(prog, rootSystem, label, "(ip,jp->1,ip,jp,2)");
setSpaceTimeMapForMemoryAllocation(prog, rootSystem, label, 0, 0, "(ip,jp->0,0,0,0)");
setSpaceTimeMapForValueCopy(prog, rootSystem, label, 0, 0, "(ip,jp->1,ip,jp,0)");
setSpaceTimeMapForMemoryFree(prog, rootSystem, label, 0, 0, "(ip,jp->2,0,0,0)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 1, "(ip,jp->0,0,0,1)", "(ip,jp->1,ip,jp,1)", "(ip,jp->2,0,0,1)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 1, 0, "(ip,jp->0,0,0,2)", "(ip,jp->1,ip,jp,3)", "(ip,jp->2,0,0,2)");

generateScheduledCode(prog, rootSystem, outDir);
generateWrapper(prog, rootSystem, outDir);
generateMakefile(prog, rootSystem, outDir);
