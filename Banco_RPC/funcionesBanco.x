struct depositar{
    int opcion;
    int monto;
    int saldo;
};
struct retirar{
    int opcion;
    int monto;
    int saldo;
};

program SERVIDOR_BANCARIO{
    version VERSION_ACTUALIZAR {
        int actualizarDepositar(depositar) = 1;
        int actualizarRetirar(retirar) = 2;
    } = 1;
} = 0x20000001;
