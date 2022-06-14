
package tcp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
    
    private static ServerSocket server;
    private static int port = 9876;
    
    public static void main(String args[]) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        while(true){
            System.out.println("Esperando respuesta del cliente");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Mensaje recibido: " + message);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hola cliente "+message);
            ois.close();
            oos.close();
            socket.close();
            if(message.equalsIgnoreCase("Saliendo")) 
            	break;
        }
        System.out.println("Apagando el servidor!!");
        server.close();
    }
    
}
