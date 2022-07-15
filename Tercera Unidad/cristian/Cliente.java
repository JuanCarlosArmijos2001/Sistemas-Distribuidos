package cristian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author juanc
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        String hostname = "localhost";
        int puerto = 30000;
        try (
                Socket socketCliente = new Socket(hostname, puerto);
                PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));) {
            long T0;
            long Cs;
            long T1;
            long C;
            out.println(T0 = System.currentTimeMillis());
            Cs = Long.parseLong(in.readLine());
            T1 = System.currentTimeMillis();
            System.out.println("Formula: ");
            System.out.println("C = Cs+(T1-T0)/2");
            C = (Cs + (T1 - T0) / 2);
            DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
            System.out.println("T0 = " + formatter.format(new Date(T0)));
            System.out.println("T1 = " + formatter.format(new Date(T1)));
            System.out.println("Cs = " + formatter.format(new Date(Cs)));
            System.out.println("C = " + formatter.format(new Date(Cs)) + " + ( " + formatter.format(new Date(T1)) + " - " + formatter.format(new Date(T0))+" )" + "/2");
            System.out.println("C = " + formatter.format(new Date(C)));
            out.println("Salida");
        } catch (Exception e) {
            System.out.println("Tiempo agotado");
        }

    }
}
