package dao;

import model.Student;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setSnum(10);
		s.setSname("마이파티스");
		s.setSgrade(6);

		// System.out.println(dao.insertStudent(s));
//		System.out.println(dao.updateStudent(s));
		
//		System.out.println(dao.selectOne(10));
//		System.out.println(dao.selectAll());
		for (Student st : dao.selectAll()) {
			System.out.println(st);
		}
	}
}
