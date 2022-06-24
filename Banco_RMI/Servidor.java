import java.rmi.Naming;

/**
 * @author Juan
 */
public class Servidor {
    public Servidor(){
        try {
            System.out.println("Banco de Loja le da la bienvenida a su servidor");
            InterfazRMI objetD = new ImplementationRMI();
            Naming.rebind("rmi://localhost/bancoLoja", objetD);
        } catch (Exception e) {
            System.out.println("Error en el servidor bancario: " + e);
        }
    }
    public static void main(String [] args){
        new Servidor();
    }
}
