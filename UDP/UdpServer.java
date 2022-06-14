/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author juan
 */
public class UdpServer {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        System.out.println("Server activado");
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            //----------------------Envio de msjs desde el server---------------------------------
            InetAddress IPaddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            System.out.println("Mensaje enviado al cliente: "+capitalizedSentence);
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPaddress, port);
            serverSocket.send(sendPacket);
            //-------------------------------------------------------
            System.out.println("Mensaje recibido");
            System.out.println(sentence);            
            System.out.println("Server desactivado");
            
        }
        
    }
}
