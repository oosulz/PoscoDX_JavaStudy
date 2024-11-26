package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
		v.addElement("마이콜");
		v.addElement("또치");
		
		
		// 순회
		for (int i = 0; i< v.size(); i++) {
			String s = v.elementAt(i);
			System.out.println(s);
		}
		
		System.out.println("==================");
		// 삭제
		// v.remove("또치"); // "또치" 삭제
		// v.removeElementAt(1); // 1번째 인덱스 삭제
		
		
		// 순회 2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
