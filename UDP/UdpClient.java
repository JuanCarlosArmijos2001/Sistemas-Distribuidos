/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author juan
 */
public class UdpClient {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IPaddress = InetAddress.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Ingrese un dato:");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPaddress, 9876);
        clientSocket.send(sendPacket);    
        System.out.println("Mensaje enviado");
        //------------------------Recibir msj del server-------------        
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("Mensaje recibido del server: "+modifiedSentence);
        clientSocket.close();
        //-----------------------------------------------------------        
    }
}
