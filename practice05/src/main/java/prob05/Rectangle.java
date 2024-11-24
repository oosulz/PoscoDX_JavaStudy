package prob05;

public class Rectangle extends Shape implements Resizable{
	
	public Rectangle(int width, int height) {
        setWidth(width); 
        setHeight(height);
	}

	public double getArea() {
		return getHeight() * getWidth();
	}
	
	public double getPerimeter() { 
		return (getHeight() + getWidth()) * 2;
	}

	public void resize(double rate) {
        setWidth(getWidth() * rate); 
        setHeight(getHeight() * rate); 
	}


}
