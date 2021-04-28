package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		// 상품 입력
		for (int i = 0; i < goods.length; i++) {
			String drink = scanner.next();
			int price = scanner.nextInt();
			int num = scanner.nextInt();
			goods[i] = new Goods(drink, price, num);
		}

		// 상품 출력
		for (int i = 0; i < goods.length; i++) {
			goods[i].show();
		}
		
		// 자원정리
		scanner.close();
	}
}
