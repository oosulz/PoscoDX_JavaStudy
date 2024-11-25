package chapter04;

import java.awt.print.Printable;

public class StringTest03 {
	public static void main(String[] args) {

		String s1 = new StringBuilder("Hello ").append("World ").append("JAVA").append(21).toString();

		String s2 = new StringBuffer("Hello ").append("World ").append("JAVA").append(21).toString();

		System.out.println(s1);

		String s3 = "";

		for (int i = 0; i < 1000000; i++) {
			
			s3 = s2 + "h";
			s3 = new StringBuffer(s3).append("h").toString();
			/*
			 * if (i % 10000 == 0) { System.out.println(i); }
			 */
		}

		StringBuffer sbBuffer = new StringBuffer("");
		for (int i = 0; i < 1000000; i++) {
			sbBuffer.append("h");
		}
		
		String s4 = sbBuffer.toString();
		
		String s5 = "abcABCabcAbc";
		System.out.println(s5.length());
		System.out.println(s5.charAt(2));
		System.out.println(s5.indexOf("abc"));
		System.out.println(s5.indexOf("abc",7));
		System.out.println(s5.substring(3));
		System.out.println(s5.substring(3,5));		
		
	}
}

