package prob01;

public class Printer {
/*
	public void println(int i) {
		System.out.println(i);
		
	}
	public void println(double i) {
		System.out.println(i);
		
	}
	public void println(boolean i) {
		
		System.out.println(i);
	}
	public void println(String i) {
		System.out.println(i);
		
	}
*/
	// 위의 타입을 제네릭으로 표현시 하나의 함수로만 표현 가능
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	// ... -> 가변 파라미터
	public int sum(Integer ... nums) {
		int s = 0;
		for (Integer n: nums) {
			s += n;
		}
		return s;
	}
	
	// ... -> 가변 파라미터
	//제네릭과 가변 파라미터를 또 섞을 수도 있음
	public <T> void println(T... ts) {
		for (T t: ts) {
			System.out.print(t + " ");
		}
		System.out.print("\n");
	}
	
}
