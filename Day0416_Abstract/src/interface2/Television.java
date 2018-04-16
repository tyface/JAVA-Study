package interface2;

public class Television implements RemoteController{
	
	public void turnOn() {
		System.out.println("TV On");
	}

	public void turnOff() {
		System.out.println("TV Off");
	}
}
