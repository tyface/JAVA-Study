package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext("dao/appContext.xml");

		BoardDao dao = context.getBean("boardDao", BoardDao.class);
		
		Board b = new Board();
		b.setNum(67);
		b.setTitle("제목");
		 System.out.println(dao.searchBoard(b));
//		 System.out.println(dao.updateBoard());

		// System.out.println(dao.selectOne(10));
		// System.out.println(dao.selectAll());
//		for (Board st : dao.selectAll()) {
//			System.out.println(st);
//		}
	}
}
