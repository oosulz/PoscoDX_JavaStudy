package chapter04;

public class WrapperClassTest01 {

	// 직접 생성하면 heap상에 객체가 존재하게 된다.
	// 리터럴(literal)을 사용하면 JBVM안의 Contsant Pool에서 관리하게 된다.
	public static void main(String[] args) {
		Integer integer = new Integer(10);
		Character character = new Character('c');
		Boolean boolean2 = new Boolean(true);

		
		//auto boxing
		Integer i1 = 10;
		Integer i2 = 20;
		System.out.println(i1 != i2);
		System.out.println(i1.equals(i2));
		
		//auto boxing
		int m1 = i1 + 10;
		int m2 = i1.intValue() + 20;
	
	}
}
