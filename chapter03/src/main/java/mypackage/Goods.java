package mypackage;

public class Goods {
	private String name; // 모든 접근이 가능하다
	private int price; // 같은 패키지 + 자식
	private int countSold; // 클래스 내부에서만 접근이 가능
	private int countStock; // (default) 같은 패키지에서만
	

	public void m() {
		countSold = 10; // private라서 외부 클래스에서 접근 불가!
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountSold() {
		return countSold;
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	
	public void printInfo() {
		System.out.println("상품이름: " + name); // (this는 객체가 생성되고 자기 자신을 레퍼런스 하고싶을 때 사용 외부 인스턴스 생성 X시)
		System.out.println("가격: " + price);
		System.out.println("판매수량: " + countSold);
		System.out.println("재고수량: " + countStock);
	}

}
