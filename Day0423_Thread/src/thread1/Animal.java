package thread1;


public class Animal {
	protected String name;
	protected int numOfLegs;

	public Animal () {
		name = "없음";
		numOfLegs = 0;
	}
	
	public void sound(){
		System.out.println("동물이 웁니다.");
	}

}
