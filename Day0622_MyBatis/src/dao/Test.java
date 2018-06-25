package dao;

import model.Student;

public class Test {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		Student student = new Student();
		student.setSnum(6);
		student.setSname("테스트");
		student.setSgrade(34);
		
		
//		dao.insertStudent(student);
//		dao.updateStudent(student);
//		dao.delete
//		System.out.println(dao.selectOne(6));
//		System.out.println(dao.selectAll());
	}
}
