package prob05;

public class Sol05 {
	public static void main(String[] arg) {

		int array[] = { 5, 9, 3, 8, 60, 20, 1 };
		int count = array.length;

		System.out.println("Before Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}

		for (int i = 0; i < count; i++) {
			for (int j = i + 1; j < count; j++) {
				if (array[i] < array[j]) {
					int tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}

		System.out.println("\nAfter Sort.");

		for (int i = 0; i < count; i++) {
			System.out.print(array[i] + " ");
		}
	}
}