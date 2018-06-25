package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("dao/appContext.xml");

		BoardDao dao = context.getBean("boardDao", BoardDao.class);
		
		Board b = new Board();
		b.setNum(65);
		b.setTitle("마이바티스");
		b.setName("마이마이");
		b.setPass("123");
		b.setEmail("이메일입니다.");
		b.setContent("내용앟하하");
		b.setReadCount(1);
		 System.out.println(dao.insertBoard(b));
		// System.out.println(dao.updateBoard());

		// System.out.println(dao.selectOne(10));
		// System.out.println(dao.selectAll());
		for (Board st : dao.selectAll()) {
			System.out.println(st);
		}
	}
}
