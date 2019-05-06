prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
system = "matrix_product";
Show(prog, system);
Split(prog, system, "temp_C", "init_C", "{i,j,k|k==0}");
Show(prog, system);

