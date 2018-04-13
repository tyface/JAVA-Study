package Ex2;

import java.util.Random;

public class AnimalTest {

	public static void main(String[] args) {
		Animal[] animals = new Animal[5];
		Random ran = new Random();

		for (int i = 0; i < animals.length; i++) {

			switch (ran.nextInt(2)) {
			case 0:
				animals[i] = new Dog();
				break;
			case 1:
				animals[i] = new Cat();
				break;
			}
			animals[i].sound();
			// if(animals[i] instanceof Dog) {
			// Dog dog= (Dog)animals[i];
			// dog.bark();
			// } else if (animals[i] instanceof Cat) {
			// Cat cat= (Cat)animals[i];
			// cat.meow();
			// }
		}
	}
}
