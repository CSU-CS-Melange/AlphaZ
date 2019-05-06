prog = ReadAlphabets("../../testcases/matrix_product_withReduce/matrix_product_withReduce.ab");
system = "matrix_product_withReduce";

AShow(prog, system);
SerializeReduction(prog, system, "C", "(i,j,k->i,j,k)");
#SerializeReduction(prog, "1,0,0", "(i,j,k->i+j+k)");
AShow(prog, system);
Normalize(prog);
AShow(prog, system);
