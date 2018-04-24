package ex;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		FileInputStreamEx fis = new FileInputStreamEx();
		FileOutputStreamEx fos = new FileOutputStreamEx();
		Student student = new Student();
		List<String> arrList =  fis.getStr();
		
		student.setName(arrList.get(0));
		student.setGrade(Integer.parseInt(arrList.get(1)));
		student.setPoint(Integer.parseInt(arrList.get(2)));
		
		System.out.println(student.toString());
		
		student.setName("haha");
		student.setGrade(6);
		student.setPoint(125);

		System.out.println(student.toString());
		
		fos.setStr(student.toString());
		
	}

}
