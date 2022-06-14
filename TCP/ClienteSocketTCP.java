package tcp;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteSocketTCP {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
	    	String host = "127.0.0.1";
	    	Socket socket = null;
	    	ObjectOutputStream oos = null;
	    	ObjectInputStream ois = null;
	    	for(int i=0; i<20;i++){
			socket = new Socket(host, 9876);
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("Envío de solicitud al Servidor de Socket");
			if(i==19)
				oos.writeObject("Salida");
			else 
				oos.writeObject(""+i);			
			ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println("Mensaje: " + message);
			ois.close();
			oos.close();
			Thread.sleep(1000);
	    	}
	}
}
