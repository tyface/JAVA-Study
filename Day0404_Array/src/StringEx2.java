
public class StringEx2 {
	public static void main(String[] args) {
		// "no news is good news"
		// 에서 반복문을 사용하여 n의 개수를 출력하는 프로그램을 작성하시오.

		String str = "no news is good news"; //탐색할 문자열 저장
		final char search = 'n'; //검색할 문자 저장
		int count = 0; //찾은 문자열의 개수 저장
		
		
		//검색할 문자열 str에서 search문자를 찾을때마다 count를 1증가
		for (int i = 0; i < str.length(); i++) { 
			if (search == str.charAt(i)) {
				count++;
			}
		}
		
		System.out.printf("'%s'의 개수는 %d개 입니다.", search, count); //출력
		
	}
}
