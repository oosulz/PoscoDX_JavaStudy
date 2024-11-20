package prob02;

import java.util.Scanner;

public class Sol02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[5];
		double sum = 0;

		System.out.print("5개의 숫자를 입력하세요.\n");
		
		for (int i = 0; i < intArray.length; i++) {
			int num = scanner.nextInt();
			intArray[i] = num;
			sum += num;
		}
		
		
		System.out.print("평균은 "+(sum/5)+" 입니다.");
		
		
		scanner.close();
	}
}
