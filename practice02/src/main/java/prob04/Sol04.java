package prob04;

public class Sol04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray(c1);

		char[] c2 = reverse("Java Programming!");
		printCharArray(c2);
	}

	public static char[] reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		char[] reverse = sb.reverse().toString().toCharArray();
		return reverse;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}