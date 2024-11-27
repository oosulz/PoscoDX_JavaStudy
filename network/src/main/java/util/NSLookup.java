package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.imageio.plugins.tiff.ExifGPSTagSet;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		InetAddress inetAddress = null;

		try {
			inetAddress = InetAddress.getLocalHost();
			String hostIPAddress = inetAddress.getHostAddress();
			byte[] IPAddresses = inetAddress.getAddress();

			String string = "";

			while (true) {
				System.out.print("> ");
				string = scanner.nextLine();

				if (string.trim().equals("exit")) {
					System.exit(0);
				}
				
				InetAddress[] IP = inetAddress.getAllByName(string);
				for (InetAddress i : IP) {
					System.out.println(string + " : " + i.getHostAddress());
				}
			}
		} catch (UnknownHostException e) {
			System.out.println(e);
		} finally {
			scanner.close();
		}
	}

}
