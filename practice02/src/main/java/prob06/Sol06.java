package prob06;

import java.util.Random;
import java.util.Scanner;

public class Sol06 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			// 정답 랜덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt(100) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요:");
			
			int cnt = 1;
			int min = 1;
			int max = 100;

			while (true) {
				System.out.println(min + "-" + max);
				System.out.print(cnt + ">>");
				int num = scanner.nextInt();
				
				if (num != correctNumber) {
					if (num > correctNumber) {
						System.out.println("더 낮게");
						max = num;
					} else {
						System.out.println("더 높게");
						min = num;
					}
					cnt++;
				} else {
					System.out.println("맞췄습니다");
					break;
				}
			}

			// 새 게임 여부 확인하기
			System.out.print("다시 하겠습니까(y/n)>>");
			String answer = scanner.next();
			if ("y".equals(answer) == false) {
				break;
			}
		}

		scanner.close();
	}
}