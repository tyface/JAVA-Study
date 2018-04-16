
public class AnonymousTest2 {
	public static void main(String[] args) {
		//Animal을 상속 받는 익명클래스 작성
		
		Animal animal 
		 = new Animal() {
			public void move() {
				System.out.println("저벅저벅");
			}
		};
		
		animal.move();
		animal.name = "검은머리짐승";
		animal.numOfLegs = 2;
		
		
		
		
		
		
		
	}
}
