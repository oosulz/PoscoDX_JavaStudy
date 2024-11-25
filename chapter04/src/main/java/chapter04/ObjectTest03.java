package chapter04;

public class ObjectTest03 {
	
	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + ":"+s2.hashCode()); //내용기반
		System.out.println(System.identityHashCode(s1)+ ":" + System.identityHashCode(s2));
		
		System.out.println("===============================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3 == s4); // 이 부분이 다르게 나옴
		System.out.println(s3.equals(s4));
		System.out.println(s3.hashCode() + ":"+s4.hashCode()); //내용기반
		System.out.println(System.identityHashCode(s3)+ ":" + System.identityHashCode(s4));
		//출력이 다른 이유?
		// String Pool에 String 생성 과 힙에 String 객체 생성 다르기 때문 !!
		
	}

}
