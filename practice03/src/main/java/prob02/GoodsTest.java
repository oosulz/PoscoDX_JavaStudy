package prob02;


import java.util.Scanner;

public class GoodsTest {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];

		for (int i = 0; i < goods.length; i++) {
			String[] str = scanner.nextLine().split(" ");
			goods[i] = new Goods(str[0], Integer.parseInt(str[1]), Integer.parseInt(str[2]));
		}

		System.out.println();

		for (int i = 0; i < goods.length; i++) {
			goods[i].printInfo();
		}

		scanner.close();
	}
}