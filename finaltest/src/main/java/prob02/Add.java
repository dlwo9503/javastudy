package prob02;

public class Add implements Arithmetic {
	private int a;
	private int b;
	
	public int calculate( int a, int b ) {
		return a + b;
	}

	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
}