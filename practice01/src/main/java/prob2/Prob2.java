package prob2;

import java.util.Iterator;

public class Prob2 {
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			for (int j = i; j < 10 + i; j++) {
				System.out.print(j + 1 + " ");
			}
			System.out.println();
		}
		
	}
}