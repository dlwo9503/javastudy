package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

import chat.ChatClient;
import chat.ChatClientThread;
// awt가 gui에 대한 내용이 들어있음
// socket 때문에 수정해야 함
public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private PrintWriter pw;
	private BufferedReader br; 
	
	private Socket socket = null;
	private String name = null;

	public ChatWindow(String name, Socket socket) {
		frame = new Frame(name); // 윈도우 창
		pannel = new Panel(); // 밑에 감싸는 창 (채팅창 + 버튼)
		buttonSend = new Button("Send"); // 버튼
		textField = new TextField(); // 채팅창
		textArea = new TextArea(30, 80); // 위에 대화창
		this.socket = socket;
		this.name = name;
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */
		
		System.out.println(name +  "님 입장 하겠습니다." );
		updateTextArea(name + "님 입장 하였습니다. 즐거운 채팅되세요~!");
//		pw.println( "MESSAGE:" + name + "님 입장했습니다. 즐거운 채팅되세요~!" );
		
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();
		
		// 2. IOStream 생성
		try {
			pw = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(), "UTF-8" ), true );
			br = new BufferedReader( new InputStreamReader(socket.getInputStream(), "UTF-8" ));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 3. Chat Client Thread 생성(Receive Thread)
//		new ChatClientThread().start();
		new ChatClientThread( socket ).start(); //
	}
	
	private void finish() {
		System.out.println("소켓 닫기 or 방나가기 프로토콜 구현"); // 이 부분 구현해야 함
		if(socket!= null && socket.isClosed() == false) {
			try {
				socket.close();
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void sendMessage() { // 버튼을 눌렀을 때
		String message = textField.getText();
		System.out.println("MESSAGE : " + message);
		// 프로토콜 구현
//		updateTextArea(name + " : " + message);
		pw.println( "MESSAGE:" + message );
		textField.setText("");
		textField.requestFocus();
		System.out.println("click"); // 클릭하면 입력한 내용을 빼오는걸 해야함
	}
	
	
	// Thread를 내부에서 구현
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}
	private class ChatClientThread extends Thread {
		private Socket socket;//
		
		public ChatClientThread( Socket socket ) {// 소켓 받아오기
			this.socket = socket;//
		}//

		@Override
		public void run() {
			try{
				BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream(), "UTF-8" ) );
				
				while( true ) {
					String message = br.readLine();
					if( message == null ) {
						break;
					}
//					System.out.println( message );
					
					updateTextArea(message);
					// 여기서 리시브
				}
			}catch(SocketException ex){
				ChatClientApp.log( "error : " + ex );	
			} catch(IOException ex){
				ChatClientApp.log( "error : " + ex );	
			} finally {
				finish();
			}
		}
	}
}
