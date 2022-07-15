package juanc.berkeley_juan_armijos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanc
 */
public class Cliente extends Thread {

    private int idCliente;
    private long tiempoCliente;
    private Salida salida;
    private final boolean tiempoDemora = true;

    public Cliente(int idCliente, Salida sda) {
        this.salida = sda;
        this.idCliente = idCliente;
        this.tiempoCliente = System.nanoTime();
    }

    public void run() {
        while (true) {
            this.tiempoCliente += (this.tiempoDemora) ? (this.idCliente + 1) * 2 : 0;
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
            System.out.println("Cliente: " + idCliente + " con un tiempo de: " + formatter.format(new Date(this.tiempoCliente)));
            this.salida.setDifTiempos(this.tiempoCliente, this.idCliente);
            this.tiempoCliente += this.salida.getConfTiempo(this.idCliente);
            System.out.println("Cliente: " + idCliente + " con un tiempo de: " + formatter.format(new Date(this.tiempoCliente)));
        }

    }

}
