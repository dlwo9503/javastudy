package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		point1.show();
		
		Point point2 = new Point(100, 200);
		point2.show();
		
//		point1.show(false);
		
		Point point3 = new ColorPoint();
		point3.setX(50);
		point3.setY(100);
		((ColorPoint)point3).setColor("red"); // 다운캐스팅
		// 부모 리모컨으로 자식 설계도 사용시에 사용
		point3.show(true); // 이렇게 해도 재사용하기 때문에 color나옴
		point3.show();
	}
}
