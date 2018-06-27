package dao3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Board;


public class DaoTest {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context
		 = new GenericXmlApplicationContext("dao3/appContext.xml");
		
		BoardDao dao = context.getBean("boardDao",BoardDao.class);
		
		Board board = new Board();
		board.setNum(64);
		board.setTitle("22spring test update ");
		board.setName("22유지상");;
		board.setPass("22");;
		board.setEmail("zxasd");;
		board.setContent("22스프링 내용입니다.");
		
//		dao.insertBoard(board);
		dao.updateBoard(board);
		
//		System.out.println(dao.selectOne(64));
//		System.out.println(dao.selectAll());
		System.out.println("종료 ");
		
		
		
		
	}
}
