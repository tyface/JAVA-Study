package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest2 {
	public static void main(String[] args) {
		Map<String, Student> map  = new HashMap<String, Student> ();
		
		Student s1 = new Student("홍길동", 3, 100, 100, 100);
		Student s2 = new Student("신사임당", 2, 100, 100, 100);
		Student s3 = new Student("이순신", 1, 100, 100, 100);
		Student s4 = new Student("김장금", 5, 100, 100, 100);
		
		map.put("홍",s1);
		map.put("신",s2);
		map.put("이",s3);
		map.put("김",s4);
		
		Student s = map.get("김");
		
		System.out.println("찾은 학생: " + s);
		
		Set<String> keySet = map.keySet();
		
		for(String key:keySet){
			
			System.out.println(map.get(key));
		}
	}
}
