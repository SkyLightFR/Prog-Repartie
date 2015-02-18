import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class ClientUDP {
	private static DatagramSocket dgSocket;
	
	public static void main (String[] args) throws IOException {
		int port = 8085;
		InetAddress addr = InetAddress.getLocalHost();
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String ch = "Hello World";
		sendData = ch.getBytes();
		dgSocket = new DatagramSocket();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, addr, port);
		dgSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		dgSocket.receive(receivePacket);
		String msg = new String(receivePacket.getData());
		System.out.println("Recu depuis le serveur : "+ msg);
	}
}
