package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName();
			String hostIPAddress = inetAddress.getHostAddress();
			
			System.out.println(hostName);
			System.out.println(hostIPAddress);
			
			byte[] IPAddresses = inetAddress.getAddress();
			
			for(byte IPAddress : IPAddresses) {
				int unsignedByte = IPAddress & 0x000000FF;
				System.out.println(unsignedByte);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
