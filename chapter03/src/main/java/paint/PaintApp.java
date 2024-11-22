package paint;

public class PaintApp {
	public static void main(String args[]) {
		Point point1 = new Point();
		point1.setX(10);
		point1.setY(20);
		draw(point1);
		// point1.show();

		Point point2 = new Point(100, 200);
		point2.show();
		// point2.show(true);
		draw(point2);
		// point2.disappear();
		point2.show(false);

		ColorPoint point3 = new ColorPoint(100,100,"black");
		draw(point3);
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		draw(new GraphicText("test"));
		
		
	}

	public static void draw(Drawable drawable) {
		drawable.draw();
	}
	
	
	/*
	 
	public static void drawShape(Shape shape) {
		shape.draw();
	}
	
	public static void drawTriangle(Triangle triangle) {
		triangle.draw();
	}
	
	public static void drawRectangle(Rectangle rectangle) {
		rectangle.draw();
	}
	
	*/
	// override를 통해 불필요한 메소드 만들 필요 없음 !!!!
	//public static void drawColorPoint(ColorPoint colorPoint) {
	//	colorPoint.show();
	//}

}
