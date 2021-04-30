package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// c:\temp
		System.out.println("c:\\temp");
		// "hello"
		System.out.println("\"hello\"");
		
		// \t : tab
		// \n : 개행
		// \r : carriage return
		// \b : beep(경고음)
		System.out.print("hello\tworld" + "\n");
		System.out.println("hello\tworld");
		
		// '
		char c = '\'';
		System.out.println(c);
	}

}
