package prob01;

import java.util.Scanner;

public class Prob01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in  );

		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		System.out.print("금액 : ");
		int a = scanner.nextInt();
		for (int i : MONEYS) {
			int Ans = a / i;
			a -= Ans * i;
			System.out.println(i + "원 : " + Ans + "개");
		}
		scanner.close();
 	}
}