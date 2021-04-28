package mypackage;

public class Goods {
	public static int countOfGoods; // static은 메소드 지역에 생성됨 
	
	public Goods() {
		Goods.countOfGoods++;
	}
	
	public String name;
	public int price;
	public int countStock; // 재고량
	private int countSold; // 판매량
	
	void m() {
		countSold = 100;
	}
}

// public : 모든 접근 가
// protected : 다른패키지는 안되는데 자식클래스는 접근가능
// default : 같은패키지에서만 접근 가능
// private : 클래스 내부에서만 접근 가