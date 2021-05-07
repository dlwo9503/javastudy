package chat.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatServer.PORT;

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = null;
		Socket socket = null;

		try {
			// 입력
			scanner = new Scanner(System.in);
			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false) {
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}
			
			//1. 소켓 생성
			socket = new Socket();
			
			//2. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

			//3. iostream 생성
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			//4. join
			pw.println("JOIN:" + name);
			String line = br.readLine();
			if ("JOIN:OK".equals(line)) {
				new ChatWindow(name, socket).show();
			}
		} catch (ConnectException ex) {
			log("error : " + ex);
		} catch (Exception ex) {
			log("error : " + ex);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
	}

	public static void log( String message ) {
		System.out.println( "\n[chat client]" + message );
	}
}
