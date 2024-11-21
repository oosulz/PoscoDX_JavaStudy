package chapter03;

public class StaticMethod {
	
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		StaticMethod.m = 10;
		
		//같은 클래스의 static 변수 접근에서 클래스 이름 생략 가능
		m = 20;
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
	}
	
	
	
	static void s1() {

	}
	
	
	/*
	 * 에러 발생 : 어떤 n인지 모르기 때문 !!
	static void s2() {
		f1();
	}
	*/
	
	static void s3() {
		StaticMethod.m = 10;
		//같은 클래스의 static 메소드 호출에서 클래스 이름 생략 가능
		m = 20;
	}
	
	static void s4() {
		StaticMethod.s1();
		
		//같은 클래스의 static 메소드 호출에서 클래스 이름 생략 가능
		s1();
	}
	
	public static void main(String args[]) {
		StaticMethod smMethod = new StaticMethod();
		smMethod.f2();
		System.out.print(smMethod.m);
	}
}
