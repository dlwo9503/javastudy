package finaltest;

import java.util.Random;

public class prob01 {

	public static void main(String[] args) {
		
		Random rand = new Random();
		int n1 = rand.nextInt(9);
		int n2 = rand.nextInt(9);

		System.out.println(++n1 + " * " + ++n2 + " = ?");
		System.out.println();
		System.out.println();
		
	}

}
