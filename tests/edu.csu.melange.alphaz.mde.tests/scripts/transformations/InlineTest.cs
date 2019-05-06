prog = ReadAlphabets("../../testcases/matrix_product/matrix_product.ab");
system = "matrix_product";
Show(prog, system);
InlineForce(prog, system, "C", "temp_C");
Show(prog, system);

program = ReadAlphabets("../../testcases/fibonacci/fibonacci.ab");
fib_system = "fibonacci";
Show(prog, system);
#InlineAllForce(program, fib_system, "V");
#Show(program, fib_system);

InlineForce(program, fib_system, "V", "V", 2);
Show(program, fib_system);

