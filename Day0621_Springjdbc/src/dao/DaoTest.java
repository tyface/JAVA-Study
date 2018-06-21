package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;

public class DaoTest {
	public static void main(String[] args) {
		ApplicationContext context
		 = new GenericXmlApplicationContext("dao/appContext.xml");
		
		MemberDao dao = context.getBean("memberDao",MemberDao.class);
		
		Member member = new Member();
		member.setId("id1");
		member.setPw("1234");
		member.setName("홍길동");
		member.setEmail("hong1111@gmail.com");
//		dao.insertMember(member);
//		dao.updateMember(member);
		
//		System.out.println(dao.selectOne("id1"));
		System.out.println(dao.selectAll());
		System.out.println("종료 ");
		
		
		
		
	}
}
