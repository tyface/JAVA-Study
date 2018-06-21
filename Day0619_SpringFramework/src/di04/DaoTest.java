package di04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		//스프링컨테이너 로딩
		//스프링 컨테이너에서 Dao 객체 꺼내와서 사용해보기 
		//Dao 스프링 컨테이너에 등록하고 사용해보기 
		//1. ConnectionProvider, StudentDao
		//객체 bean으로 등록하기
		//2. ConnectionProvider 객체를 
		// StudentDao에 의존성 주입하기 (setter든, 생성자든 아무거나)
		
		@SuppressWarnings("resource")
		ApplicationContext context
		 = new GenericXmlApplicationContext("di04/appContent.xml");
		
		StudentDao sDao = context.getBean("studentDao",StudentDao.class);
		System.out.println(sDao.selectOne(1));
		
		
		
		
		
	}
}
