package chapter03;

import mypackage.Goods2;

public class DiscountGoods2 extends Goods2 {
	double l = 12345678903433456L;
	float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		return discountRate * getPrice();
	}
	

}
