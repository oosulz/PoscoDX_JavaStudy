package prob05;

public abstract class Shape {
	private double width;
	private double height;
	
	public abstract double getPerimeter(); 
	public abstract double getArea();

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	} 
	
}
