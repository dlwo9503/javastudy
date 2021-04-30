package chapter04;

public class StringTest02 {

	public static void main(String[] args) {
		// immutability (불변성)
//		String s = "hello";
//		System.out.println(s.toUpperCase()); // 대문자로 변환
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??"); // 문자열 더해주는거
		String s5 = "!".concat(s2).concat("@"); // 이런식으로 여러개 더하는거 가능
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		// equals 주의할 점
		equalsHello(null);
		
		
	}
	
	private static boolean equalsHello(String s) {
		return "Hello".equals(s); // 이런식으로 앞에 문자를 두고 뒤에 변수를 두면 에러가 발생안함
	}

}
