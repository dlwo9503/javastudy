package prob04;

public class Person {
	private int berOfPerson;
	private int age;
	String name;
	
	public Person() {
		age = 12;
		name = "";
	}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public void selfIntroduce() {
		System.out.println("내 이름은 " + name + "이며, 나이는 " + age + "살 입니다.");
	}
	public int getPopulation() {
		return berOfPerson;
	}
}