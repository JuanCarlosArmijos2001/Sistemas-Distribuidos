package juanc.berkeley_juan_armijos;

/**
 *
 * @author juanc
 */
public class Simulacion {

    public static void main(String[] args) {
        System.out.println("Berkeley");
        System.out.println("Tiempo inicial de los 3 clientes");
        Salida simuTiempo = new Salida();
        Servidor serv = new Servidor(simuTiempo);

        serv.start();

        Cliente aux[] = new Cliente[3];
        for (int i = 0; i < 3; i++) {
            aux[i] = new Cliente(i, simuTiempo);
            aux[i].start();
        }
    }
}
