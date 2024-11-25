package chapter04;

public class StringTest02 {
	// immutabaility(불변성)

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		s2 = s1.toUpperCase();
		
		String s4 = s2.concat("??");
		
		String s5 = ".".concat("s2").concat("@");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		System.out.println(equalsHello(null));
		
		
		
		String s6 = "     ab    cd  ";
		String s7 = "abc,def,ghi";
		
		String s8 = s6.concat(s7);
		System.out.println(s7);
		
		System.out.println("---"+s6.trim()+"---");
		System.out.println("---"+s6.replaceAll(" ","")+"---");
		
		String[] tokens = s7.split(",");
		
		for (String string : tokens) {
			System.out.println(string);
		}
		
		String[] tokens2 = s7.split(" ");
		
		for (String string : tokens2) {
			System.out.println(string);
		}
		
		
	}

	private static boolean equalsHello(String s) {
		return "hello".equals(s);
	}


	
	
	
	
}
