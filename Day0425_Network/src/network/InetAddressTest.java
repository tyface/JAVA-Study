package network;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) {
		InetAddress ia = null;
		
		try {
			ia = InetAddress.getLocalHost();
			System.out.println();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
