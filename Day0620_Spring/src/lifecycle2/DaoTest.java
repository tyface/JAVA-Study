package lifecycle2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		
		ApplicationContext context 
		 = new GenericXmlApplicationContext("lifecycle2/applicationContext.xml");
		
		StudentDao dao1 = context.getBean("studentDao",StudentDao.class); 
		StudentDao2 dao2 = context.getBean("studentDao2",StudentDao2.class);
		
//		if(dao1 == dao2) {
//			System.out.println("같음");
//		}else {
//			System.out.println("다름");
//		}
		((AbstractApplicationContext)context).close();
		System.out.println("종료합니다.");
		
	}
}
