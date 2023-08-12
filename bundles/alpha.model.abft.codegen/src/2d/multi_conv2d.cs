outSuffix = "2d"; 

prog = ReadAlphabets("multi_conv"+outSuffix+".ab");
initSys = "init";
convSys = "conv";

ForceCoB(prog, initSys, "kernel",           "(i,j->i+_K0,j+_K1)");
ForceCoB(prog, initSys, "padded_kernel",    "(i,j->i+_PK0,j+_PK1)");
#ForceCoB(prog, initSys, "padded_kernel_cp", "(i,j->i+_PK0,j+_PK1)");
ForceCoB(prog, initSys, "patch",            "(i,j->i+_PK0,j+_PK1)");
#ForceCoB(prog, initSys, "patch_cp",         "(i,j->i+_PK0,j+_PK1)");

ForceCoB(prog, convSys, "kernel", "(i,j->i+_K0,j+_K1)");

setSpaceTimeMap(prog, initSys, "padded_kernel", "(i,j->0,i,j)");
setSpaceTimeMap(prog, initSys, "patch",         "(i,j->1,i,j)");

generateScheduledCode(prog, initSys, "./");
generateScheduledCode(prog, convSys, "./");



# check init
#out = "codegen/"+convSys+outSuffix+"/test-init";
#generateScheduledCode(prog, initSys, out);
#generateWrapper(prog, initSys, out);
#generateMakefile(prog, initSys, out);

# check conv
#out = "codegen/"+convSys+outSuffix+"/test-conv";
#generateScheduledCode(prog, convSys, out);
#generateWrapper(prog, convSys, out);
#generateMakefile(prog, convSys, out);
