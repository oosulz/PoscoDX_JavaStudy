package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class HashMapTest {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("one", 1); //auto boxing
		map.put("two",2);
		map.put("three",3);
		
		int i = map.get("one"); //auto unboxing
		int j = map.get(new String("two"));
		System.out.println(i+":"+j);
	
		Set<String> set = map.keySet();
		
		//순회
		for(String key : set) {
			System.out.println(key);
		}
	
	}
}
