package prob01;

import java.util.Scanner;

public class Sol01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int[] MONEYS = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int[] MONEYS_CNT = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		System.out.print("금액:");
		int money = scanner.nextInt();
		
		for (int i = 0; i < MONEYS.length; i++) {
			int tmp = money / MONEYS[i]; 
			MONEYS_CNT[i] = tmp;
			money = money % MONEYS[i];
		}
		
		for (int i = 0; i < MONEYS_CNT.length; i++) {
			System.out.print(MONEYS[i]+"원 : "+MONEYS_CNT[i]+"개\n");
		}
		
		scanner.close();
 	}
}