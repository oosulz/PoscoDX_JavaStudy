package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		
		String string = "12345";
		int i = Integer.parseInt(string);
		String string2 = string.valueOf(i);
		
		String s3 = "" + i;
		
		System.out.println(string+":"+string2+":"+s3);
		
		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		char c = 'A';
		System.out.println((int)c);

		System.out.println(Integer.toBinaryString(15));
		
	}

}


