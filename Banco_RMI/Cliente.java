
import java.rmi.Naming;
import java.io.*;
import java.util.Scanner;

/**
 * @author Juan
 */
public class Cliente {

    public static void main(String[] args) {
        boolean salir = false;
        double cantTransaccion;
        double cantCuenta = 1000;
        Scanner cantidadActual;
        Scanner opcion;
        try {
            InterfazRMI interfaz = (InterfazRMI) Naming.lookup("rmi://localhost/bancoLoja");
            do {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("\t\t\t\tBANCO DE LOJA");
                System.out.println("Bienvenido al Banco de Loja");
                System.out.println("Su saldo actual es: " + cantCuenta);
                System.out.println("Seleccione una opción: ");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("Seleccione cualquier botón para salir");
                System.out.println("--------------------------------------------------------------------------------------------");
                opcion = new Scanner(new InputStreamReader(System.in));
                String aux = opcion.next();
                if (aux.equals("1")) {
                    System.out.println("Ingrese la cantidad a depositar: ");
                    cantidadActual = new Scanner(new InputStreamReader(System.in));
                    cantTransaccion = Double.parseDouble(cantidadActual.next());
                    while (cantTransaccion <= 0) {
                        System.out.println("El valor de depósito tiene que ser mayor de 0: ");
                        cantidadActual = new Scanner(new InputStreamReader(System.in));
                        cantTransaccion = Double.parseDouble(cantidadActual.next());
                    }
                    cantCuenta = interfaz.depositar(cantTransaccion, cantCuenta);
                    System.out.println("Depósito realizado, su saldo actual es: " + cantCuenta);
                    System.out.println("--------------------------------------------------------------------------------------------");
                    System.out.println();
                    System.out.println();

                } else if (aux.equals("2")) {
                    System.out.println("Retiro");
                        System.out.println("Ingrese la cantidad a retirar: ");
                        cantidadActual = new Scanner(new InputStreamReader(System.in));
                        cantTransaccion = Double.parseDouble(cantidadActual.next());
                        while (cantTransaccion <= 0 || cantTransaccion > cantCuenta) {
                            System.out.println("El valor de retiro no puede ser menor o igual a 0, ni mayor a la cantidad de dinero en su cuenta, ingrese otra cantidad: ");
                            cantidadActual = new Scanner(new InputStreamReader(System.in));
                            cantTransaccion = Double.parseDouble(cantidadActual.next());
                        }
                        cantCuenta = interfaz.retirar(cantTransaccion, cantCuenta);
                        System.out.println("Retiro realizado con éxito, el saldo en su cuenta es de: " + cantCuenta);
                        System.out.println("--------------------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.println();
                } else {
                    salir = true;
                }
            } while (!salir);
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
}
