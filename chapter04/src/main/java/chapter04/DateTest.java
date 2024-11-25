package chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		printDate01(now);
		printDate02(now);
	}

	private static void printDate01(Date now) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(now));
	}

	private static void printDate02(Date now) {
		int year = now.getYear();
		int month = now.getMonth();
		int date = now.getDate();
		int hour = now.getHours();

		System.out.println((year + 1900) + "-" + (month + 1) + "-" + date + " "

		);
	}

}
