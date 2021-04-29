package exception;

public class MyStackException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyStackException() {
		super("MyException happens...");
	}
	
	public MyStackException(String message) {
		super(message);
	}
}
