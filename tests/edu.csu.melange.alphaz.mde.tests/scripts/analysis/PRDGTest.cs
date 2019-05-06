# Load Program and store as 'prog'
prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
# Define a variable 'system' to store the system name
system = "matrix_product";

prdg = BuildPRDG(prog, system);
ExportPRDG(prdg, "../../test-out/test.dot");
