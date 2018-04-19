
public class ExceptionTest4 {
	public static void main(String[] args) {
		
		Student s = new Student(300, 0);
		//예외발생
try {
	s.showAvg();
	
}catch (Exception e) {
	System.out.println(e);
}

	}
}
