

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MultiplyEcho {
	private DatagramSocket dgSocket;

	MultiplyEcho(int pSrv) throws IOException {
		dgSocket = new DatagramSocket(pSrv);
	}

	void go() throws IOException {
		byte[] dataPacket = new byte[4096];
		byte[] sendData = new byte[4096];
		while (true) {
			DatagramPacket dgPacket = new DatagramPacket(dataPacket, dataPacket.length);
			String str;
			String result;

			dgSocket.receive(dgPacket);
			System.out.println("Datagram received from " + dgPacket.getSocketAddress());
			dgPacket.setSocketAddress(dgPacket.getSocketAddress());
			Integer multiplicateur;
			str = new String(dgPacket.getData());
			try {
				multiplicateur = Integer.parseInt(""+str.charAt(0));
				str = str.substring(1);
			} catch(Exception e) {
				multiplicateur = null;
			}
			String[] chaine = str.split("\\s");
		
			if(multiplicateur == null) {
				String tmp="";
				result = "Erreur : \"";
				for (int i=0;i<chaine.length;i++) {
					result += chaine[i] + " ";
					tmp += chaine[i] + " ";
				}
				result += "\" n'est pas valide !";
				System.out.println("Multiplicateur : aucun \n Phrase : " + tmp) ;
			} else {
				String tmp="";
				result = "Résultat : \"";
				for (int i=0;i<chaine.length;i++) {
					int j=1;
					while(j<= multiplicateur) {
						result += chaine[i] + " ";
						j++;			
					}
					tmp += chaine[i] + " ";
				}
				result += "\" ";
				System.out.println("Multiplicateur : "+multiplicateur+" \n Phrase : " + tmp) ;
			}

			sendData = result.getBytes();
			dgPacket.setData(sendData, 0, sendData.length);

			dgSocket.send(dgPacket);
		}

	}

	public static void main(String[] args) throws IOException {
		final int DEFAULT_PORT = 8100;
		System.out.println("Serveur démarré");
		new MultiplyEcho( args.length == 0 ? DEFAULT_PORT : Integer.parseInt(args[0]) ).go();

	}
}