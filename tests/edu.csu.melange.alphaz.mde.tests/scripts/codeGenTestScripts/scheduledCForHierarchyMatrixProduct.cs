prog = ReadAlphabets("../../alphabets/SubSystemExamples/HierarchMatProduct_SubSyst.ab");
rootSystem = "mat_product";
subSystem1 = "mat_vect_product";
subSystem2 = "vector_product";
outDir = "../../test-out/"+ rootSystem + "_hierarchy";
CheckProgram(prog);

#set the spacetimeMap for the vector_product first
setSpaceTimeMap(prog, subSystem2, "temp", "(i->i)");
setSpaceTimeMap(prog, subSystem2, "Res", "(->N)");

#set space time map for the mat_vect_product
label_res = "UseEquation_res";
setSpaceTimeMap(prog, subSystem1, label_res, "(ip->ip,3)");
setSpaceTimeMapForUseEquationOptimization(prog, subSystem1, label_res, 0, 0, "(ip->ip,0)", "(ip->ip,2)", "(ip->ip,5)");
setSpaceTimeMapForUseEquationOptimization(prog, subSystem1, label_res, 1, 0, "(ip->ip,1)", "(ip->ip,4)", "(ip->ip,6)");
setMemorySpaceForUseEquationOptimization(prog, subSystem1, label_res, 0, 1, "vect");

label = "UseEquation_C";
#set the spacetimeMap for the rootSystem
setSpaceTimeMap(prog, rootSystem, label, "(ip->ip,3)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 0, 1, "(ip->ip,0)", "(ip->ip,2)", "(ip->ip,5)");
setSpaceTimeMapForUseEquationOptimization(prog, rootSystem, label, 1, 0, "(ip->ip,1)", "(ip->ip,4)", "(ip->ip,6)");
setMemorySpaceForUseEquationOptimization(prog, rootSystem, label, 0, 0, "A");

generateScheduledCode(prog, rootSystem, outDir);
generateWrapper(prog, rootSystem, outDir);
generateMakefile(prog, rootSystem, outDir);
