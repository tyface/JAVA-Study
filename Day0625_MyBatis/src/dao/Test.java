package dao;

import model.Member;

public class Test {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImp();
		Member s = new Member();
		s.setId("마이바티스");
		s.setPw("123");
		s.setName("이름음");
		s.setEmail("www2");
		

//		 System.out.println(dao.insertMember(s));
//		System.out.println(dao.updateMember(s));
		
//		System.out.println(dao.selectOne(10));
//		System.out.println(dao.selectAll());
		for (Member st : dao.selectAll()) {
			System.out.println(st);
		}
	}
}
