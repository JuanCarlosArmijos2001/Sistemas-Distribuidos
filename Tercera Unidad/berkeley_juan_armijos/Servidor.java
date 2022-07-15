package juanc.berkeley_juan_armijos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanc
 */
public class Servidor extends Thread {

    private Salida salida;
    private final int espera;
    private long tiempoServidor;

    public Servidor(Salida salida) {
        this.salida = salida;
        this.espera = 3000;
        this.tiempoServidor = System.nanoTime();
    }
    public void run(){
        while (true) {
            try {
                Thread.sleep(this.espera);
                DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
                System.out.println("Tiempo servidor: "+formatter.format(new Date(this.tiempoServidor)));
                this.salida.setTiempoServidor(this.tiempoServidor);
                this.salida.setCalPromedio();
                this.tiempoServidor += this.salida.getPromedio();
                System.out.println("Tiempo esperado: "+formatter.format(new Date(this.tiempoServidor)));
                this.salida.reinicioProceso();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
