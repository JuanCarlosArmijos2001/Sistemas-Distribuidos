import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 *
 * @author juan
 */
public class Servidor {

    public static void main(String[] args) throws SocketException, IOException {
        MulticastSocket serverSocket = new MulticastSocket(55557);
        serverSocket.joinGroup(InetAddress.getByName("230.0.0.1"));
        byte[] receiveData = new byte[1024];
        System.out.println("Servidor activo");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Mensaje recibido");
            System.out.println(sentence);
        }

    }

}
