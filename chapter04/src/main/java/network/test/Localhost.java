package network.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost { // 자기 자신

	public static void main(String[] args) {
		
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAdress = inetAddress.getHostAddress();
			System.out.println(hostName);
			System.out.println(hostAdress);
			
			byte[] addresses = inetAddress.getAddress();
			for (byte address : addresses) {
				System.out.print(address & 0x000000ff); // 0x000000ff == 127 -> & 연산을 해줘서 변환해
				System.out.print(".");
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		

	}

}
