package interface2;

public class Aircondition implements RemoteController {

	public void turnOn() {
		System.out.println("에어콘 On");
	}

	public void turnOff() {
		System.out.println("에어콘 Off");
	}
}
