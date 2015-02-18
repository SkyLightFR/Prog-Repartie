/**
 * @author <a href="mailto:jean.carle@univ-lille1.fr">Jean Carle</a>, IUT-A, Universite de Lille 1
 * 
 */

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServeurUDP {
	private DatagramSocket dgSocket;

	ServeurUDP(int pSrv) throws IOException {
		dgSocket = new DatagramSocket(pSrv);
	}

	void go() throws IOException {
		
		byte[] receiveData = new byte[1024];

		while (true) {
			String str;
			DatagramPacket dgPacket = new DatagramPacket(receiveData, receiveData.length);
			dgSocket.receive(dgPacket);
			System.out.println("Datagram received from " + dgPacket.getSocketAddress());

			dgPacket.setSocketAddress(dgPacket.getSocketAddress());
			str = new String(dgPacket.getData());
			byte[] bufDate = str.getBytes();
			System.out.println(str);
			dgPacket.setData(bufDate, 0, bufDate.length);

			dgSocket.send(dgPacket);
		}
	}

	public static void main(String[] args) throws IOException {
		final int DEFAULT_PORT = 8085;
		new ServeurUDP( args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]) ).go();
	}
}