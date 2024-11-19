package prob03;

import java.util.Scanner;

public class Sol03 {

	public static void main(String[] args) {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("수를 입력 하세요 : ");
			int n = scanner.nextInt();
			int sum = 0;
			if (n % 2 == 0) {
				for (int i = 0; i <= n; i++) {
					if (i % 2 == 1) {
						continue;
					}
					sum += i;
				}
			} else {
				for (int i = 0; i <= n; i++) {
					if (i % 2 == 0) {
						continue;
					}
					sum += i;
				}
			}
			System.out.println("결과값 : " + sum);
			scanner.close();
		}

	}
}
