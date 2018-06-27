package lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		
		ApplicationContext context 
		 = new GenericXmlApplicationContext("lifecycle/applicationContext.xml");
		
		System.out.println("컨테이너 준비완료");
		StudentDao dao1 = context.getBean("studentDao",StudentDao.class);
		StudentDao dao2 = context.getBean("studentDao",StudentDao.class);

		System.out.println("bean 객체 반환");
		
		//spring container에서 기본 설정은 sigleton
		
		if(dao1 == dao2) {
			System.out.println("같은 객체");
		}else {
			System.out.println("다른 객체");
		}
		//컨테이너 닫아주는 메서드, 실제로는 안씁니다.
		((AbstractApplicationContext)context).close();
		System.out.println("종료합니다.");
	}
}
