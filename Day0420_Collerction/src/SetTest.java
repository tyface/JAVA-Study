import java.util.HashSet;
import java.util.Iterator;

public class SetTest {
	public static void main(String[] args) {

		// Set은 중복을 허용하지 않는 자료구조
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();

		set1.add("A");
		set1.add("B");
		set1.add("C");
		set1.add("D");

		set2.add("D");
		set2.add("F");
		set2.add("A");
		set2.add("G");

		

		// 집합 합집합, 차집합, 교집합 구현해보기
		HashSet<String> union = new HashSet<String>(set1); // 합집합
		HashSet<String> diffence = new HashSet<String>(set1); // 차집합
		HashSet<String> intersection = new HashSet<String>(set1); // 교집합

		union.addAll(set2);
		diffence.removeAll(set2);
		intersection.retainAll(set2);
		
		Iterator<String> it = intersection.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
