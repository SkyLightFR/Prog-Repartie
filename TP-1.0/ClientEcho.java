

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientEcho {
private static DatagramSocket dgSocket;
	
	public static void main (String[] args) throws IOException {
		int port = 8100;
		InetAddress addr = InetAddress.getLocalHost();
		byte[] sendData = new byte[10000];
		byte[] receiveData = new byte[10000];
		String ch = "2Bonjour le monde";
		sendData = ch.getBytes();
		dgSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, addr, port);
		dgSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		dgSocket.receive(receivePacket);
		String msg = new String(receivePacket.getData());
		System.out.println(msg);
	}
}
