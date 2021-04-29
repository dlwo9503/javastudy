package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("ABC");
		String s2 = new String("ABC");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2)); // 이건 주소기반이여서 다르게 나옴
		
		System.out.println("=========================");
		
		String s3 = "ABC";
		String s4 = "ABC";
		
		System.out.println(s3 == s4); // new로 생성안했기 때문에 true로 나옴
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4)); // 이 경우는 같게 나옴
		
		Integer i = 10; // int i = 10 이런형태 말고 Integer 생성자를 이용하면 리터럴 형태로 만들 수 있음
	}

}
// new로 하게되면 다르게 만들어짐
// 리터럴로 하게되면 동일하게 만들어짐
// "     "  <- 이런 애들을 리터럴이라고 함
// 리터럴 풀이라는 곳은 불변을 보장함