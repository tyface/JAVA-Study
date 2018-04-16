
public class BreakEx1 {
	public static void main(String[] args) {
		/* 중첩 반복문에서 내가 원하는 반복문을 종료하고 싶을 때 반복문에 태그를 달아주면 된다.
		 * 사용예)
		 * 태그1:
		 * 반복문1
		 * 	태그2:
		 * 	반복문2
		 * 
		 * 		break 태그1; <<종료하고자 하는 반복문을 선택할 수 있다.
		 * 
		 * *반복문을 이름을 설정하지 않고, 바깥쪽 반복문을 종료하기 위해서는 바깥쪽 반복문의
		 * 상태를 결정할 수 있는 변수값을 바꿔주면 된다.
		 */
		int count = 0;
		
		outFor:
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 5; j++) {
				if(i ==3 && j ==3) {
					break outFor;
				}
				count++;
			}
		}
		
		System.out.println(count);
	}
}
