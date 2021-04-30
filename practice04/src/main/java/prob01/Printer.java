package prob01;

import java.util.Iterator;

public class Printer {
	private int a;
	private boolean b;
	private int c;
	private int name;
	
	public void println(int a) {
		System.out.println(a);
	}
	public void println(boolean b) {
		System.out.println(b);
	}
	public void println(double c) {
		 System.out.println(c);
	}
	public void println(String string) {
		System.out.println(string);
	}
	
	public <T> void println(T t) {
		System.out.println(t);
	}
	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.print(t);
			System.out.print(" ");
		}
		System.out.println("");
	}
	public int sum(Integer... nums) { // 가변 배열
		Integer sum = 0;
		for (Integer i : nums) {
			sum += i;
		}
		return sum;
	}
}
