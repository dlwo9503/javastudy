package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("두 정수와 연산자를 입력하시오 >> ");
		String expression = scanner.nextLine();

		String[] tokens = expression.split(" ");

		if (tokens.length != 3) {
			System.out.println("알 수 없는 식입니다.");
		}

		int lValue = Integer.parseInt(tokens[0]);
		int rValue = Integer.parseInt(tokens[1]);

		switch (tokens[2]) {
		case "+": {
			Add add = new Add();
			int result = add.calculate(lValue, rValue);
			System.out.println(result);

			break;
		}
		case "-": {
			Sub sub = new Sub();
			int result = sub.calculate(lValue, rValue);
			System.out.println(result);

			break;
		}
		case "*": {
			Mul mul = new Mul();
			int result = mul.calculate(lValue, rValue);
			System.out.println(result);

			break;
		}
		case "/": {
			Div div = new Div();
			int result = div.calculate(lValue, rValue);
			System.out.println(result);

			break;
		}
		default: {
			System.out.println(">> 알 수 없는 연산입니다.");
		}
		}

		scanner.close();

	}

}
