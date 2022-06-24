/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _FUNCIONESBANCO_H_RPCGEN
#define _FUNCIONESBANCO_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct depositar {
	int opcion;
	int monto;
	int saldo;
};
typedef struct depositar depositar;

struct retirar {
	int opcion;
	int monto;
	int saldo;
};
typedef struct retirar retirar;

#define SERVIDOR_BANCARIO 0x20000001
#define VERSION_ACTUALIZAR 1

#if defined(__STDC__) || defined(__cplusplus)
#define actualizarDepositar 1
extern  int * actualizardepositar_1(depositar *, CLIENT *);
extern  int * actualizardepositar_1_svc(depositar *, struct svc_req *);
#define actualizarRetirar 2
extern  int * actualizarretirar_1(retirar *, CLIENT *);
extern  int * actualizarretirar_1_svc(retirar *, struct svc_req *);
extern int servidor_bancario_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define actualizarDepositar 1
extern  int * actualizardepositar_1();
extern  int * actualizardepositar_1_svc();
#define actualizarRetirar 2
extern  int * actualizarretirar_1();
extern  int * actualizarretirar_1_svc();
extern int servidor_bancario_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_depositar (XDR *, depositar*);
extern  bool_t xdr_retirar (XDR *, retirar*);

#else /* K&R C */
extern bool_t xdr_depositar ();
extern bool_t xdr_retirar ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_FUNCIONESBANCO_H_RPCGEN */