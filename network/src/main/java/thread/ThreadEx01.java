package thread;

public class ThreadEx01 {

	public static void main(String[] args) {
//		for (int i = 0; i < 10; i++) {
//			System.out.print(i);
//		}
		new DigitThread().start();
		
		for (char c = 'a'; c < 'z'; c++) { // for문이 스레드를 선점하기 힘듬
			System.out.print(c); // 부모 명령어와 섞여서 출력이 됨
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
