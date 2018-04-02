
public class Operator1 {

	public static void main(String[] args) {
		//연산자 수업
		//증감연산자 ++,--
		
		char x = 'A';
		char y,z;
//		x++; //다른 연산을 모두 끝낸 후 x의 값을 1증가 시킨다. 후증가 
//		++x; //다른 연산을 하기 전 x의 값을 1증가 시킨다. 선증가
		
//		System.out.println(x);
		
		y = x++;
		z = ++x;
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		
	}
}
