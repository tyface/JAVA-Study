package ex1;

public class SportsCar extends Car {
	boolean isTurbo = true;

	public SportsCar() {
		System.out.println("자식클래스 생성자 호출");
	}
	public void turboOn() {
		
		if (isTurbo == true) {
			System.out.println("터보 상태입니다.");
		} else {
			System.out.println("터보 온!!");
			isTurbo = true;
		}
	}

	public void turboOff() {
		
		if (isTurbo == false) {
			System.out.println("터보가 꺼진상태 입니다.");
		} else {
			System.out.println("터보를 끕니다.");
			isTurbo = false;
		}
	}
}
