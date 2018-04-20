package map;

import java.util.HashMap;
import java.util.Map;

public class MapTest3 {

	public static void main(String[] args) {
		// 데이터 전달 할 때 많이 사용
		// 데이터의 올쥬가 매우 다양하기 때문에 모든 데이터를 한꺼번에 담아서 처리할 자료구조가 필요 >>>Map

		 Map<String, Object> map = new HashMap<String, Object>();
		
		 map.put("student", new Student());
		 map.put("phone", "010-5133-9855");
		 map.put("member_number", 5);
		
	}

}
