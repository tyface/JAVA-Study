package aop;

public class PersonProxy {
	//Boy나 Girl의 기능을 대신 호출햊 주는 클래스
	Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
		
	}
	
	public void callPerson() {
		System.out.println("지하철을 탄다");
		person.doSomething();
		System.out.println("계산을하고 집에 온다.");
		System.out.println("씻고 잠을 잔다.");
	}
}
