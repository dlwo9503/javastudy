package com.douzone.paint.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color) {
//		setX(x); // 상속받았기 때문에 this는 사용 불가
//		setY(y);
		super(x, y);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override // 재구현이라고 생각하면 됨
	public void show() {
		System.out.println("점[" + getX() + "," + getY() + "," + color + "]에 점을 그렸습니다.");
	} // 부모에 있는 show 가 아닌 새로운거 만
	
}
