
public class NestedIf {

	public static void main(String[] args) {
		// 중첩 if문
		// if-else 쌍에 대해서 실습하기
		// 짝수이면서 5이하인 수를 중첩if를 이용해서 찾아보자
		
		int x = 3;
		
		if (x%2 ==0) {
			
			if(x <=5)
				System.out.printf("%d는 짝수이면서 5이하이다",x);
			else 
				System.out.printf("%d는 짝수이면서 5초과이다",x);
		} else {
			
			if(x <=5)
				System.out.printf("%d는 홀수이면서 5이하이다",x);
			else 
				System.out.printf("%d는 홀수이면서 5초과이다",x);
		}
		

	}

}
