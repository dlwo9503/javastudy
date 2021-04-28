package prob02;

public class Goods {
	private String drink;
	private int price;
	private int num;
	
	public Goods() {
	}
	public Goods(String drink, int price, int num) {
		this.drink = drink;
		this.price = price;
		this.num = num;
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void show() {
		System.out.println(drink + "(가격:" + price + "원)이 " + num + "개 입고 되었습니다.");
	}
}
