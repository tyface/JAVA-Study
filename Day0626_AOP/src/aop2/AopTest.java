package aop2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context
		 = new GenericXmlApplicationContext("aop2/appContext.xml");
		Person p = context.getBean("girl", Person.class); 
		try {
			p.doSomething();
		} catch (Exception e) {
			System.out.println("엄마 호출!!");
		}
	}
}
