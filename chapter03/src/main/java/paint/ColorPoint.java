package paint;

public class ColorPoint extends Point {
	private String color;

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
