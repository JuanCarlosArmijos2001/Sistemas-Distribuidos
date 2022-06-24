import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author juan
 */
public class Cliente {

    public static void main(String[] args) throws SocketException, IOException {

        MulticastSocket clienteSocket = new MulticastSocket();
        byte[] sendData = new byte[1024];
        System.out.println("El cliente esta activo");
        int contador = 0;
        while (true) {
            contador++;
            System.out.println("Mensaje: "+contador);
            String sentence = contador+"";
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("230.0.0.1"), 55557);
            clienteSocket.send(sendPacket);
        }

    }

}