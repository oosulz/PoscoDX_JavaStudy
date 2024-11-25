package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		//Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
		//TimeZone tZone = TimeZone.getDefault();
		//Calendar cal = Calendar.getInstance();
		 Calendar calendar = Calendar.getInstance();
		 printDate(calendar);
		 
		 Calendar calendar2 = Calendar.getInstance();
		 calendar2.set(Calendar.YEAR,2024);
		 calendar2.set(Calendar.MONTH,11);
		 calendar2.set(Calendar.DATE,25);;
		 printDate(calendar2);
		 
		 calendar2.set(2024,12,31);
		 calendar2.add(Calendar.DATE, 100);
		 printDate(calendar2);
		 
	}
	public static void printDate(Calendar cal) {
		final String[] DAYS = {"일","월","화","수","목","금","토"};
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0-11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); //  1(일)~7(토)
		int hour = cal.get(Calendar.HOUR);
		int minutes = cal.get(Calendar.MINUTE);
		int seconds = cal.get(Calendar.SECOND);
		System.out.println(year+"-"+(month+1)+"-"+date+" "+DAYS[day]+"요일 "+hour+":"+minutes+":"+seconds);
	}


}
