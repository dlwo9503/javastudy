package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;

public class RequestHandler extends Thread {
//	private static final String DOCUMENTROOT = "./webapp"; // 로컬용으로 남겨
	private static String DOCUMENTROOT = "";
	private Socket socket;
	
	static {
		DOCUMENTROOT = RequestHandler.class.getClass().getResource("/webapp").getPath();
	}

	public RequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());

			String request = null;
			while (true) {
				String line = br.readLine();
				if (line == null)
					break; // 브라우저가 연결을 끊으면 break

				// Request Header만 읽음
				if ("".equals(line)) {
					break;
				}

				// 첫번째 라인만 처리
				if (request == null) {
					request = line;
					break;
				}
			}

			// 요청 처리
			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				consoleLog("request:" + tokens[1]);
				reponseStaticResource(os, tokens[1], tokens[2]);
			} else { // method : POST, PUT, DELETE, HEAD, CONNECT
				/* Simple Http Server에서는 무시 */
				response400Error(os, tokens[1], tokens[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			os.write("HTTP/1.1 200 OK\r\n".getBytes("UTF-8"));
//			os.write("Content-Type:text/html; charset=utf-8\r\n".getBytes("UTF-8"));
//			os.write("\r\n".getBytes());
//			os.write("<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes("UTF-8"));
		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close(); // 1요청 -> 1응답 -> 끊음
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void reponseStaticResource(OutputStream os, String url, String protocol) throws IOException {

		// welcome file set
		if ("/".equals(url)) {
			url = "/index.html";
		}

		File file = new File(DOCUMENTROOT + url);
		if (file.exists() == false) {
			url = "/error/404.html";
			response404Error(os, url, protocol);
			return;
		}

		// nio = new io
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);
	}

	private void response400Error(OutputStream os, String url, String protocol) throws IOException {

		url = "/error/400.html";

		File file = new File(DOCUMENTROOT + url);
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 400 File not found\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);

	}

	private void response404Error(OutputStream os, String url, String protocol) throws IOException {
		
		url = "/error/404.html";

		File file = new File(DOCUMENTROOT + url);
		if(file.exists() == false) {
			System.out.println("file not found:" + file.getAbsolutePath());
			return;
		}
		
		byte[] body = Files.readAllBytes(file.toPath());
		String contentType = Files.probeContentType(file.toPath());
		os.write((protocol + " 404 File not found\r\n").getBytes("UTF-8"));
		os.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		os.write("\r\n".getBytes());
		os.write(body);

	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
