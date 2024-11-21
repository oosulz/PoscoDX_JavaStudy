package chapter03;

public class Goods2App {
	public static void main(String[] args) {
		Goods2 goods2 = new Goods2();
		
		goods2.setName("camera"); // public [접근 제한이 없다]
		goods2.setPrice(40000); // protected는 같은 패키지에서 접근 가능하다
		goods2.setCountSold(10); // 내부 메소드를 통해서만 접근이 가능하다!
		goods2.setCountStock(20);
		
		goods2.printInfo();
		
		//정보은닉(객체의 상태를 보호)
		goods2.setPrice(-1000);
		
		Goods2 goods2_1 = new Goods2();
		System.out.println(goods2_1.countOfGoods);
		Goods2 goods2_2 = new Goods2();
		System.out.println(goods2_2.countOfGoods);
		
		goods2.setPrice(400000);
		System.out.println(goods2.calcDiscountPrice(0.5f));

	}

}
