package prob05;

public class Sol05 {
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			String number = String.valueOf(i);
			String zzak = "";	
			
			for (int j = 0; j < number.length(); j++) {
				int tmp = Integer.parseInt(number.substring(j, j + 1));
					
				if (tmp == 3 || tmp == 6 || tmp == 9) {
					zzak += "짝";
					
				}
			}
			
			if (zzak.length() > 0) {
				System.out.print(i + " " + zzak);
				System.out.print("\n");
			}
		}
	}
}
