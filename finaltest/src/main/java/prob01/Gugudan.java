package prob01;

import java.util.Random;
import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int n1 = rand.nextInt(9) + 1;
		int n2 = rand.nextInt(9) + 1;

		System.out.println(n1 + " * " + n2 + " = ?\n");

		int[] arr = new int[9];
		for (int i = 0; i < 8; i++) {
			arr[i] = (rand.nextInt(9) + 1) * (rand.nextInt(9) + 1);
		}
		arr[8] = n1 * n2;

		int swap = rand.nextInt(9);
		
		int temp = arr[swap];
		arr[swap] = arr[8];
		arr[8] = temp;

		for (int i = 0; i < 3; i++) {
			
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
			if ((i + 1) % 3 == 0) {
				System.out.println();
			}
		}
		System.out.print("\nanswer: ");
		int ans = sc.nextInt();
		if (ans == arr[swap]) {
			System.out.println("\n정답");
		} else {
			System.out.println("\n오답");
		}
	}

}
