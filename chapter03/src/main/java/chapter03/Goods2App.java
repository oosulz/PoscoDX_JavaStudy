package chapter03;

import mypackage.Goods2;

public class Goods2App {
	public static void main(String[] args) {
		Goods2 goods2 = new Goods2();
		
		goods2.setName("camera"); // public [접근 제한이 없다]
		goods2.setPrice(40000); // protected는 같은 패키지에서 접근 가능하다
		goods2.setCountSold(10); // 내부 메소드를 통해서만 접근이 가능하다!
		goods2.setCountStock(20);
		
		goods2.printInfo();

	}

}
