package collection;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;


public class VectorTest02 {
	public static void main(String[] args) {
		List<String> list = new Vector<>(); //list에  있는 메솓만 사용 가능
		
		list.add("둘리");
		list.add("마이콜");
		list.add("또치");
		
		
		// 순회
		for (int i = 0; i< list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		System.out.println("==================");
		// 삭제
		list.remove("또치"); // "또치" 삭제
		// v.removeElementAt(1); // 1번째 인덱스 삭제
		
		
		// 순회 2
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("==================");
		
		// 순회 3
		for (String s: list) {
			System.out.println(s);
		}
	}
}
