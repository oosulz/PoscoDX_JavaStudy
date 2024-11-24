package prob05;

public class RectTriangle extends Shape {
	
	public RectTriangle(int width, int height) {
        setWidth(width); 
        setHeight(height);
	}

	public double getArea() {
		return getHeight() * getWidth() * 0.5;
	}
	
	public double getPerimeter() { 
		return getHeight() + getWidth() + Math.sqrt(Math.pow(getArea(),2) + Math.pow(getHeight(),2));
	}


}
