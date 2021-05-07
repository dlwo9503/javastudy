package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	private List<PrintWriter> listPrintWriter;

	public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriter) {
		this.socket = socket;
		this.listPrintWriter = listPrintWriter;
	}

	@Override
	public void run() {
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			// 1. Remote Host Information
			InetSocketAddress remoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			ChatServer.log("connected by client[" + remoteSocketAddress.getAddress().getHostAddress() + ":"
					+ remoteSocketAddress.getPort() + "]");

			// 2. 스트림 얻기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

			// 3. 요청 처리
			while (true) {
				String message = br.readLine();
				if (message == null) {
					doQuit(pw);
					ChatServer.log("클라이언트로 부터 연결 끊김");
					break;
				}

				String[] tokens = message.split(":");
				if ("JOIN".equals(tokens[0])) {
					doJoin(tokens[1], pw);
				} else if ("MESSAGE".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("QUIT".equals(tokens[0])) {
					doQuit(pw);
					break;
				}

			}
		} catch (SocketException e) {
			doQuit(pw);
			ChatServer.log("error : " + e);
		} catch (IOException e) {
			doQuit(pw);
			ChatServer.log("error : " + e);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				ChatServer.log("error:" + e);
			}
		}
	}

	private void doJoin(String nickname, PrintWriter printWriter) {
		this.nickname = nickname;
		
		String message = nickname + "님이 입장 하였습니다.";
		broadcastMessage(message);
		
		addPrintWriter(printWriter);
		
		printWriter.println("JOIN:OK");
		printWriter.flush();
	}
	
	private void doMessage(String message) {
		broadcastMessage(nickname + ":" + message);
	}
	
	private void doQuit(PrintWriter printWriter) {
		deletePrintWriter(printWriter);
		if (nickname != null) {
			broadcastMessage(nickname + "님이 퇴장 하였습니다.");
		}
	}

	private void addPrintWriter(PrintWriter printWriter) {
		synchronized (listPrintWriter) {
			listPrintWriter.add(printWriter);
		}
	}

	private void deletePrintWriter(PrintWriter printWriter) {
		synchronized (listPrintWriter) {
			listPrintWriter.remove(printWriter);
		}
	}

	private void broadcastMessage(String message) {
		synchronized (listPrintWriter) {
			for (PrintWriter printWriter : listPrintWriter) {
				printWriter.println(message);
			}
		}
	}

}