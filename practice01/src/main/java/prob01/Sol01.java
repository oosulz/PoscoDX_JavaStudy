package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		if (n % 3 == 0) {
			System.out.println("3의 배수 입니다.");
		} else {
			System.out.println("3의 배수가 아닙니다.");
		}
		scanner.close();
	}

}