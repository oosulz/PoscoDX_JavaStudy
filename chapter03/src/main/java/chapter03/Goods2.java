package chapter03;

public class Goods2 {
	public String name; // 모든 접근이 가능하다
	protected int price; // 같은 패키지 + 자식 
	private int countSold; // 클래스 내부에서만 접근이 가능
	int countStock; 	// (default) 같은 패키지에서만
	
	public void m() {
		countSold = 10; // private라서 외부 클래스에서 접근 불가!
	}
	
	public void p() {
		System.out.println(countSold);
	}

}
