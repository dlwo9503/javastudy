package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void odd (int a) {
		int sum = 0;
		for (int i = 1; i <= a; i++) {
			if(i % 2 == 1) sum += i;
		}
		System.out.println("결과값 : " + sum);
	}

	public static void even (int a) {
		int sum = 0;
		for (int i = 2; i <= a; i++) {
			if(i % 2 == 0) sum += i;
		}
		System.out.println("결과값 : " + sum);
	}
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		int a = scanner.nextInt();
		if (a % 2 == 1) odd(a);
		else even(a);
		
		scanner.close();
	}
}