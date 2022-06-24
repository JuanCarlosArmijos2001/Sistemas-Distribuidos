import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Juan
 */
public class ImplementationRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementationRMI() throws RemoteException{
        super();
    }

    // @Override
    public double depositar(double cantTransaccion, double cantCuenta) throws RemoteException{
        cantCuenta = cantCuenta + cantTransaccion;
        return cantCuenta;
    }
    
    // @Override
    public double retirar(double cantTransaccion, double cantCuenta) throws RemoteException{
        cantCuenta = cantCuenta - cantTransaccion;
        return cantCuenta;
    }
}

