# Load Program and store as 'prog'
prog = ReadAlphabets("../../testcases/jacobi_2d/jacobi_2d.ab");
# Define a variable 'system' to store the system name
system = "jacobi_2d";

prdg = BuildPRDG(prog, system, 1);
schedules = PlutoScheduler(prdg);
setSchedule(prog, system, schedules);
listSpaceTimeMaps(prog, system);

