package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	private Socket socket = null;

	ChatClientThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {

		/* reader를 통해 읽은 데이터 콘솔에 출력하기 (message 처리) */
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			while (true) {
				System.out.println(br.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
