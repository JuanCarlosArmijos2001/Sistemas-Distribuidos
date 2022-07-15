package juanc.berkeley_juan_armijos;

/**
 *
 * @author juanc
 */
public class Salida {

    private long tiempoServidor;
    private long[] diferenciaTiempos;
    private long sumaDiferencias;
    private final int totalClientes = 3;
    private int auxCliente;

    public Salida() {
        this.tiempoServidor = 0;
        this.diferenciaTiempos = new long[totalClientes];
        this.sumaDiferencias = 0;
        this.auxCliente = this.totalClientes;
    }

    public synchronized void setTiempoServidor(long tiempoServidor) {
        this.tiempoServidor = tiempoServidor;
        try {
            notifyAll();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setDifTiempos(long tiempo, int n) {
        try {
            if (tiempoServidor == 0) {
                wait();
            }
            this.diferenciaTiempos[n] = (tiempo - tiempoServidor);
            this.sumaDiferencias += tiempo;
            auxCliente--;

            if (auxCliente == 0) {
                notify();
            }
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setCalPromedio() {
        long promedio = (this.sumaDiferencias / (this.totalClientes + 1));
        for (int i = 0; i < this.totalClientes; i++) {
            this.diferenciaTiempos[i] = ((-this.diferenciaTiempos[i]) + promedio);
            notifyAll();
        }
    }

    public synchronized long getConfTiempo(int n) {
        return this.diferenciaTiempos[n];
    }

    public synchronized long getPromedio() {
        return this.sumaDiferencias / (this.totalClientes + 1);
    }

    public synchronized void reinicioProceso() {
        this.tiempoServidor = 0;
        this.auxCliente = this.totalClientes;
        this.sumaDiferencias = 0;
    }
}
