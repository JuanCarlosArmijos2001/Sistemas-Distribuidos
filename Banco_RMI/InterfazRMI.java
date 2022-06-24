import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Juan
 */
public interface InterfazRMI extends Remote{
    public double depositar(double cantTransaccion, double cantCuenta)throws RemoteException;
    public double retirar(double cantTransaccion, double cantCuenta)throws RemoteException;    
}
