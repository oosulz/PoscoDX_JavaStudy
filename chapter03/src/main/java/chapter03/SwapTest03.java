package chapter03;

import chapter03.Value;

public class SwapTest03 {
	public static void main(String[] args) {
		
		Value i = new Value(10);
		Value j = new Value(20);
		System.out.println(i.val+ "," + j.val);
		
		swap(i,j);
		
		System.out.println(i.val+ "," + j.val);
	}

	private static void swap(Value i, Value j) {
		
		int tmp = i.val;
		i.val = j.val;
		i.val = tmp;
		
	}

}
