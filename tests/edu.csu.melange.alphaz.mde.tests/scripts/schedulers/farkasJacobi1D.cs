# Load Program and store as 'prog'
prog = ReadAlphabets("../../testcases/jacobi_1d/jacobi_1d.ab");
# Define a variable 'system' to store the system name
system = "jacobi_1d";

prdg = BuildPRDG(prog, system, 1);
schedules = FarkasMDScheduler(prdg);
setSchedule(prog, system, schedules);
listSpaceTimeMaps(prog, system);

