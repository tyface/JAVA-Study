package dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Member;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext("dao/appContext.xml");

		MemberDao dao = context.getBean("memberDao3", MemberDao.class);

		// System.out.println(dao.insertMember(s));
		// System.out.println(dao.updateMember(s));

		// System.out.println(dao.selectOne(10));
		// System.out.println(dao.selectAll());
		for (Member st : dao.selectAll()) {
			System.out.println(st);
		}
	}
}
