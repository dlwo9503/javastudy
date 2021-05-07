package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	public static final int PORT = 7002;
	public static final int BUFFER_SIZE = 1024;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			socket = new DatagramSocket(PORT);

			while (true) {
				String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
				
				// 데이터 수신
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE], BUFFER_SIZE);
				socket.receive(receivePacket);

				byte[] receiveData = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(receiveData, 0, length, "utf-8");

				System.out.println("[server] receive:" + message);

				// 데이터 송신
				if ("".equals(message)) {
					byte[] sendData = now.getBytes("utf-8");
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
							receivePacket.getPort());
					socket.send(sendPacket);
				} else {
					byte[] sendData = message.getBytes("utf-8");
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
							receivePacket.getPort());
					socket.send(sendPacket);
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}
}
