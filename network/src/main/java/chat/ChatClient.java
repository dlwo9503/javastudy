package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = ChatServer.PORT;

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		
		try {
			// 1. 키보드 연결
			scanner = new Scanner( System.in );
			
			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			
			// 4. reader/writer 생성
			PrintWriter pw = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(), "UTF-8" ), true );
			BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream(), "UTF-8" ) );
			
			// 5. join 프로토콜
			System.out.print( "닉네임을 입력해주세요 >> " );
			String nickname = scanner.nextLine();
			pw.println( "JOIN:" + nickname );
			String ack = br.readLine();
			if( "JOIN:OK".equals( ack ) ) {
				System.out.println(nickname +  "님 입장 하였습니다. 즐거운 채팅되세요~" );
			}
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread( socket ).start();
			
			//7. 키보드 입력 처리
			while( true ) {
				if( scanner.hasNextLine() == false ) {
					continue;
				}
				
				String message = scanner.nextLine();
				
				// quit 프로토콜 처리
				if( "quit".equals( message ) ) {
					pw.println( "QUIT" );
					break;
				} else if( "".equals( message ) == false ){ // 9. 메시지 처리
					pw.println( "MESSAGE:" + message );
				}
			}
		} catch (ConnectException ex) {
			log( "error : " + ex );	
		} catch (Exception ex) {
			log( "error : " + ex );	
		} finally {
			//10. 자원정리
			try {
				if( scanner != null ) {
					scanner.close();
				}
				if( socket != null && socket.isClosed() == false ){
					socket.close();
				}
			}catch( IOException ex ) {
				log( "error : " + ex );	
			}
		}
	}
	
	public static void log( String message ) {
		System.out.println( "\n[chat client]" + message );
	}
}