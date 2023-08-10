outSuffix = "3d"; 

prog = ReadAlphabets("multi_conv"+outSuffix+".ab");
initSys = "init";
convSys = "conv";

ForceCoB(prog, initSys, "kernel",           "(i,j,k->i+_K0,j+_K1,k+_K2)");
ForceCoB(prog, initSys, "padded_kernel",    "(i,j,k->i+_PK0,j+_PK1,k+_PK2)");
#ForceCoB(prog, initSys, "padded_kernel_cp", "(i,j,k->i+_PK0,j+_PK1,k+_PK2)");
ForceCoB(prog, initSys, "patch",            "(i,j,k->i+_PK0,j+_PK1,k+_PK2)");
#ForceCoB(prog, initSys, "patch_cp",         "(i,j,k->i+_PK0,j+_PK1,k+_PK2)");

ForceCoB(prog, convSys, "kernel", "(i,j,k->i+_K0,j+_K1,k+_K2)");

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
