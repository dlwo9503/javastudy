package paint;

public class PaintApp {

	public static void main(String[] args) {
		Point point1 = new Point(10, 20);
//		point1.setX(10);
//		point1.setY(20);
		point1.show();
		point1.show(false);
		
		Point point2 = new Point(100, 200);
//		point2.show();
		drawPoint(point2);
		
//		point1.show(false);
		
		Point point3 = new ColorPoint(50, 100, "red");
//		point3.setX(50);
//		point3.setY(100);
//		((ColorPoint)point3).setColor("red"); // 다운캐스팅
//		// 부모 리모컨으로 자식 설계도 사용시에 사용
//		point3.show(true); // 이렇게 해도 재사용하기 때문에 color나옴
//		point3.show();
		drawPoint(point3);
		
		Rect rect = new Rect();
//		drawRect(rect);
//		drawShape(rect);
		draw(rect);
		
		Triangle triangle = new Triangle();
//		drawTriangle(triangle);
//		drawShape(triangle);
		draw(triangle);
		
		Circle circle = new Circle();
//		drawShape(circle);
		draw(circle);
		
	}
	
	public static void draw(Drawable drawable) {
		pt.show();
	}
	
//	public static void drawColorPoint(ColorPoint pt) {
//		pt.show();
//	}
	
//	public static void drawPoint(Point pt) {
//		pt.show();
//	}
//	
//	public static void drawShape(Shape shape) {
//		shape.draw();
//	}
	
//	public static void drawRect(Rect rect) {
//		rect.draw();
//	}
//	public static void drawTriangle(Triangle triangle) {
//		triangle.draw();
//	}
}
