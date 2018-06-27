package dao2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class DaoTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context
		 = new GenericXmlApplicationContext("dao2/appContext.xml");
		
		MessageDao dao = context.getBean("messageDao",MessageDao.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "63");
		map.put("password", "63");
		map.put("name", "유지상");
		map.put("message", "63.");
		map.put("user_num", 1);
		
//		dao.insertMessage(map);
//		dao.updateMessage(map);
		
//		System.out.println(dao.selectOne(63));
		System.out.println(dao.selectAll());
		System.out.println("종료 ");
		
		
		
		
	}
}
