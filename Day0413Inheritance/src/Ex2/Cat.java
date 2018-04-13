package Ex2;

public class Cat extends Animal {

	public Cat() {
		this.name = "야옹이";
		this.numOfLegs = 4;
	}

	public Cat(String name, int numOfLegs) {
		this.name = name;
		this.numOfLegs = numOfLegs;
	}

	public void meow() {
		System.out.println("야옹");
	}

	@Override
	public void sound() {
		System.out.println("야옹");
	}
}
