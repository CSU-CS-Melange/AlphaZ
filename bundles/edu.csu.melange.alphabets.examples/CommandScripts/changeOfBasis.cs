prog = ReadAlphabets("../AlphabetsExamples/Fibonacci/Fib.ab");
system = "Fib";

ForceCoB(prog, system, "fib","(i->-i)");
Show(prog);