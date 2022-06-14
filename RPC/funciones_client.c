/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "funciones.h"


void
funcionesbasicas_1(char *host)
{
	CLIENT *clnt;
	int  *result_1;
	sumandos  suma_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, FUNCIONESBASICAS, VERSION_SUMA, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

	result_1 = suma_1(&suma_1_arg, clnt);
	if (result_1 == (int *) NULL) {
		clnt_perror (clnt, "call failed");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	printf ("Estoy en el cliente");
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	funcionesbasicas_1 (host);
exit (0);
}
