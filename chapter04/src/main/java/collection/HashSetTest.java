package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();

		String string = new String("마이콜");

		set.add("둘리");
		set.add("마이콜");
		set.add("도우너");
		//set.add(string); // 안들어감
		
		System.out.println(set.size());
		System.out.println(set.contains(string));
		
		//순회
		for(String s : set) {
			System.out.println(s);
		}

	}
}
