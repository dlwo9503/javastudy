package chat.gui;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		// 입력을 받고 스캐너를 닫고,
		// 1. create socket
		// 2. connect to server
		// 3. create iostream // buffered로 만들
		// 4. join
//		String line = br.readLine();
		String line = "JOIN:OK"; // 받았다고 치고
		
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name).show(); // 이 때 채팅이 시작
		}
		new ChatWindow(name).show();
	}
}
