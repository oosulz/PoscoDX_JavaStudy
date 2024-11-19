package prob02;

public class Sol02 {
	public static void main(String[] args) {
		int n = 10;
		for (int i = 0; i < 9; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(j + " ");
			}
			n++;
			System.out.print("\n");
		}
	}
}