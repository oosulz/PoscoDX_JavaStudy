package chapter03;

import mypackage.Goods;

public class DiscountGoods2 extends Goods {
	double l = 12345678903433456L;
	float discountRate = 0.5f;
	
	public float getDiscountPrice() {
		return discountRate * getPrice();
	}
	

}
