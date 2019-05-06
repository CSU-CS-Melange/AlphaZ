# Load Program and store as 'prog'
prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
# Define a variable 'system' to store the system name
system = "matrix_product";
# Print out the program loaded in three different ways
Show(prog);
CheckProgram(prog);

#print("Hello");
#print(calc_IsEmpty(calc_ReadDomain("i,j,k|i==0")));

ForceCoB(prog, system, "A","(i,j->j,i+j)");
Show(prog);
ASave(prog);
generateWriteC(prog, system, "../../test-out/writeC/");  
generateScheduledCode(prog, system, "../../test-out/writeC/");