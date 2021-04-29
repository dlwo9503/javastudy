package chapter03;

public class Student extends Person {
	public Student() {
//		자식의 모든 생성자에서 부모의 특정 생성자를 명시(explicity)하지 않으면
//		암시적(implicity)으로 부모의 기본 생성자를 불러옴
//		위치는 자식생성자의 명령어보다 항상 앞에 위치해야 함
//		super(); // 이게 생략되어있음
//		부모꺼를 부를때는 this 말고 super을 사용
		System.out.println("Student() called");
	}
}
