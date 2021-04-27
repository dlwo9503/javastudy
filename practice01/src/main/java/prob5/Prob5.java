package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 99; i++) {
			int cnt = 0;
			int a = i / 10;
			int b = i % 10;
			if (a != 0 && a % 3 == 0) cnt++;
			if (b % 3 == 0) cnt++;
			if (cnt != 0) {
				System.out.print(i);
				System.out.print(" ");
				for (int j = 0; j < cnt; j++) System.out.print("짝");
				System.out.println();				
			}
		}
	}
}
