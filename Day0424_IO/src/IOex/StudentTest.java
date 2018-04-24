package IOex;

import java.util.List;

public class StudentTest {

	public static void main(String[] args) {
		IOManager io = new IOManager();
		Student student = new Student();
		
		List<String> arrList =  io.getInfo();
		
		student.setName(arrList.get(0));
		student.setGrade(Integer.parseInt(arrList.get(1)));
		student.setPoint(Integer.parseInt(arrList.get(2)));
		
		System.out.println(student.toString());
		
		student.setName("haha2");
		student.setGrade(66);
		student.setPoint(125);

		System.out.println(student.toString());
		
		io.setInfo(student.toString());
		
	}

}
