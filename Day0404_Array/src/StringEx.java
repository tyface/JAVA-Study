
public class StringEx {

	public static void main(String[] args) {
		//
		String s2 = "aa";
		String s3 = "a";
		String s4;
		s4 = s2 + s3;

		System.out.println(s4 == s2 + s3);

		// [H][e][l][l][o] : a[0]
		String a = "Hello";

		char c = a.charAt(0); // 문자열에 0번 인덱스에 있는 char를 가져와라,
		System.out.println(c); 
		System.out.println(a.length()); //문자열의 길이를 가져옴
		
		String b = "  He  llo  ";
		System.out.println(b.trim()); //앞뒤 공백제거
		System.out.println(a.contains("He")); //해당문자열이 포함되어있는지 검사
	}

}
