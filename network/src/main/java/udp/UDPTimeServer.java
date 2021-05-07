package udp;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {

	public static void main(String[] args) {
		DatagramPacket receivePacket = new DatagramPacket(new byte[0], 0);
		socket.receive(receivePacket); // blocking
		
		// 데이터 송신
		String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	
	}

}
