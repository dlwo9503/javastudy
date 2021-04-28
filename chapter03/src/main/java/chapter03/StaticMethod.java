package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스의 클래스 변수 접근에서는 생략이 가능
		System.out.println(m);
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		s1();
//		같은 클래스의 클래스 메소드 접근에서는 생략이 가능
	}
	
	static void s1() {
		// 에러 : static method에서는 인스턴스 변수에 접근할 수 없다.
		// System.out.println(n); // 에러뜸
	}
	
	static void s2() {
		System.out.println(StaticMethod.m);
		// 같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략 가능
		System.out.println(m);
	}
	
	static void s3() {
		// 에러 : static method에서는 인스턴스 메소드에 접근 불가능
		// f1();
	}
	
	static void s4() {
		StaticMethod.s1();
//		같은 클래스의 클래스 메소드 접근에서는 클래스 이름 생략 가능 
		s1();
	}
}
