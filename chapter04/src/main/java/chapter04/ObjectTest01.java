package chapter04;

public class ObjectTest01 {
	
	public static void main(String[] args) {
		Point point = new Point();
		
		Class klassClass = point.getClass(); //reflection 
		
		System.out.println(klassClass);
		
		System.out.println(point.hashCode()); //address 기반의 hashing값
		// 타입이 다르면 동일한 해시값이 나올 수 있음 -> 객체의 성능을 위해 해시로 저장
		// address x
		// reference 값 x
		
		System.out.println(point.toString()); //getClass().toString() + "@" +hashCode()
		System.out.println(point);
		
		
	
	}
}
