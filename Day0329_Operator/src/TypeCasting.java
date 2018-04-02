
public class TypeCasting {

	public static void main(String[] args) {
		// 암시적 변환 : 컴파일러가 알아서 형변환을 해주는 경우
		// 특징: 데이터의 손실이 없음, 확대변환
		/* 예)
		 * double b = 2;
		 * b = 3.5 * 4;
		 */
		// 명시적 변환 : 개발자가 직접 형변환을 해주는 경우
		// 특징: 데이터의 손실이 일어남, 축소변환
		/* 예)
		 * int a = (int)123.5;
		 */
	}

}
