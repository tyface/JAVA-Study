package Ex2;

public class Dog extends Animal {

	public Dog() {
		this.name = "멍멍이";
		this.numOfLegs = 4;
	}

	public Dog(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}

	public void bark() {
		System.out.println("멍멍");
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}
