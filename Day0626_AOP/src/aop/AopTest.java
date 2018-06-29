package aop;

public class AopTest {
	public static void main(String[] args) {
//		Person b = new Boy();
//		Person g = new Girl();
//		b.doSomething();
//		g.doSomething();
		
		PersonProxy pp = new PersonProxy(new Boy());
		
		pp.callPerson();
	}
}
