package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/appContext.xml");
		
		
		
		StudentDao dao = context.getBean("studentDao",StudentDao.class);
		

//		 System.out.println(dao.insertMember(s));
//		System.out.println(dao.updateMember(s));
		
//		System.out.println(dao.selectOne(10));
//		System.out.println(dao.selectAll());
			System.out.println(dao.selectOne(6));
	}
}
