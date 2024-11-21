package prob04;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		String tmpString = "";
		
		for(int i = 0; i < strArr.length; i++) {
			tmpString += strArr[i];
		}
		return tmpString;
	}
}
