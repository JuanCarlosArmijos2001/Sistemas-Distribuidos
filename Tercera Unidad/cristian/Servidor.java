package cristian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author juanc
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        int portNumber = 30000;
        System.out.println("Algoritmo de Cristian");
        System.out.println("Ingresar el nombre del host: ");
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter escribir = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader leer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            System.out.println("Servidor Iniciado");
            while (true) {
                inputLine = leer.readLine();
                if (inputLine.equalsIgnoreCase("Salir")) {
                    System.out.println("Saliendo del servidor");
                    break;
                }
                escribir.println(System.currentTimeMillis() + 5000);
            }
        } catch (Exception e) {
            System.out.println("Fin del servidor");
        }

    }
}
