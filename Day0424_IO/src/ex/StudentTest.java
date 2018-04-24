package ex;

import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		IOManager io = new IOManager();
		Student student = new Student();
		List<String> arrList =  io.getStr();
		
		student.setName(arrList.get(0));
		student.setGrade(Integer.parseInt(arrList.get(1)));
		student.setPoint(Integer.parseInt(arrList.get(2)));
		
		System.out.println(student.toString());
		
		student.setName("haha");
		student.setGrade(6);
		student.setPoint(125);

		System.out.println(student.toString());
		
		io.setStr(student.toString());
		
	}

}
