#include "ISLUser_stdio.h"

/* PROTECTED REGION ID(ISLUser_stdio_local) ENABLED START */
#define BUFFSIZE 2048
static int stdout_copy = -1;
static char buff_stdout[BUFFSIZE];

static int stderr_copy = -1;
static char buff_stderr[BUFFSIZE];

/* PROTECTED REGION END */

void record_stdout_start() {
	/* PROTECTED REGION ID(ISLUser_stdio_record_stdout_start) ENABLED START */
	if (stdout_copy != -1)
		record_stdout_end();

	fflush(stdout);
    stdout_copy = dup(fileno(stdout));

	if (stdout_copy == -1)
		err(-1, "dup");
		
	if (freopen("/dev/null", "a", stdout) == NULL)
		err(-2, "freopen");

	memset(buff_stdout, 0, BUFFSIZE);
	setbuffer(stdout, buff_stdout, BUFFSIZE);
	/* PROTECTED REGION END */
}
char * record_stdout_end() {
	/* PROTECTED REGION ID(ISLUser_stdio_record_stdout_end) ENABLED START */
	if (stdout_copy == -1)
		return "";

	if (freopen("/dev/null", "a", stdout) == NULL)
		err(-3, "freopen");

    if (dup2(stdout_copy,fileno(stdout)) == -1)
		err(-4, "dup2");

	setbuf(stdout, NULL);

	close(stdout_copy);
	stdout_copy = -1;

	return buff_stdout;
	/* PROTECTED REGION END */
}
void record_stderr_start() {
	/* PROTECTED REGION ID(ISLUser_stdio_record_stderr_start) ENABLED START */
	if (stderr_copy != -1)
		record_stderr_end();

	fflush(stderr);
    stderr_copy = dup(fileno(stderr));

	if (stderr_copy == -1)
		err(-1, "dup");
		
	if (freopen("/dev/null", "a", stderr) == NULL)
		err(-2, "freopen");

	memset(buff_stderr, 0, BUFFSIZE);
	setbuffer(stderr, buff_stderr, BUFFSIZE);
	/* PROTECTED REGION END */
}
char * record_stderr_end() {
	/* PROTECTED REGION ID(ISLUser_stdio_record_stderr_end) ENABLED START */
	if (stderr_copy == -1)
		return "";

	if (freopen("/dev/null", "a", stderr) == NULL)
		err(-3, "freopen");

    if (dup2(stderr_copy,fileno(stderr)) == -1)
		err(-4, "dup2");

	setbuf(stderr, NULL);

	close(stderr_copy);
	stderr_copy = -1;

	return buff_stderr;
	/* PROTECTED REGION END */
}
