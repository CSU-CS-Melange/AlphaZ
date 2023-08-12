outSuffix = "1d"; 

prog = ReadAlphabets("multi_conv"+outSuffix+".ab");
initSys = "init";
convSys = "conv";

ForceCoB(prog, initSys, "kernel",           "(i->i+_K0)");
ForceCoB(prog, initSys, "padded_kernel",    "(i->i+_PK0)");
#ForceCoB(prog, initSys, "padded_kernel_cp", "(i->i+_PK0)");
ForceCoB(prog, initSys, "patch",            "(i->i+_PK0)");
#ForceCoB(prog, initSys, "patch_cp",         "(i->i+_PK0)");

ForceCoB(prog, convSys, "kernel", "(i->i+_K0)");

setSpaceTimeMap(prog, initSys, "padded_kernel", "(i->0,i)");
setSpaceTimeMap(prog, initSys, "patch",         "(i->1,i)");

generateScheduledCode(prog, initSys, "./");
generateScheduledCode(prog, convSys, "./");



# check init
out = "codegen/"+convSys+outSuffix+"/test-init";
generateScheduledCode(prog, initSys, out);
generateWrapper(prog, initSys, out);
generateMakefile(prog, initSys, out);

# check conv
out = "codegen/"+convSys+outSuffix+"/test-conv";
generateScheduledCode(prog, convSys, out);
generateWrapper(prog, convSys, out);
generateMakefile(prog, convSys, out);
