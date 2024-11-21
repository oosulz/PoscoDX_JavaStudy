package chapter03;

import mypackage.Goods;

public class GoodsApp {
	public static void main(String[] args) {
		Goods goods = new Goods();
		
		goods.setName("camera"); // public [접근 제한이 없다]
		goods.setPrice(40000); // protected는 같은 패키지에서 접근 가능하다
		goods.setCountSold(10); // 내부 메소드를 통해서만 접근이 가능하다!
		goods.setCountStock(20);


	}

}
