package javaUtil;

import java.util.StringTokenizer;

public class JavaUtilTest2 {
	public static void main(String[] args) {
		//StringTokenaizer:ㅁ누자열을 특정한 문자 기준으로 잘라주는 역할을 하는 클래스
		String member = "홍길돌/123@/zxuz3/zxuz3@naver.com";
		StringTokenizer st = new StringTokenizer(member,"/");
		String name = st.nextToken();
		
		
		System.out.println(name);
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
	}
}
