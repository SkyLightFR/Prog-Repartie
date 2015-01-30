import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;


public class IP_Adress {
	
	static void displayInterfaceInformation(NetworkInterface netint) 
			  throws SocketException 
			{
				List<InterfaceAddress> addr = netint.getInterfaceAddresses();
			    System.out.println("Display name: " + netint.getDisplayName());
			    for (int i = 0; i<addr.size(); i++) {
			    	System.out.println("IP Addr: " + addr.get(i).toString());
			    }
			    System.out.println("MTU Size: " + netint.getMTU());
			}
	
	public static void main (String[] args) throws SocketException{
		Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
		for (NetworkInterface netint : Collections.list(nets))
			displayInterfaceInformation(netint);
	}
}