package interface2;

public class HomeNetwork {
	public static void main(String[] args) {
		//무선으로 조종할 수 있는 기능을 가진 가전 제품을 조종
		//무선으로 켜고, 끄기 : 무선으로 조작가능한 객체여야 한다.
		//turnOn, turnOff
		
		RemoteController[] rc = new RemoteController[2];
		
		rc[0] = new Television();
		rc[1] = new Aircondition();
		
		for(RemoteController e : rc) {
			e.turnOn();
			e.turnOff();
		}
	}
}
