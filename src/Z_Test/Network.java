package Z_Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network {

	public static void main(String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getByName("google.com"));
		System.out.println(InetAddress.getByName("cyr-community.vercel.app"));
	}
}
