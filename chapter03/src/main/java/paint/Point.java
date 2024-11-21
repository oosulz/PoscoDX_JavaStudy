package paint;

public class Point {
	private int x;
	private int y;
	
	public Point(int i, int j) {
		this.x = i;
		this.y = j;
	}

	public Point() {
		
	}

	public void show() {
		System.out.println("Point[x="+x+","+"y="+y+"]를 그렸습니다.");
		
	}
	
	public void show(boolean visible) {
		if(visible) {
			System.out.println("Point[x="+x+","+"y="+y+"]를 그렸습니다.");
		}
		else {
			System.out.println("Point[x="+x+","+"y="+y+"]를 지웠습니다.");
		}
		
		
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void disappear() {
		// TODO Auto-generated method stub
		
	}
	

	
}
