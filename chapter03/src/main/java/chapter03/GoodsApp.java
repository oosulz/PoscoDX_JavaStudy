package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
		goods.name = "nikon";
		goods.price = 40000;
		goods.countSold = 10;
		goods.countStock = 20;
		
		System.out.println("상품이름: " + goods.name);
		System.out.println("가격: " + goods.price);
		System.out.println("판매수량: " + goods.countSold);
		System.out.println("재고수량: " + goods.countStock + goods.getClass());

	}
}
