
public class StudentArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] studentArr = new Student[3];

		studentArr[0] = new Student("홍길동", 3, new Score(100, 50, 50));
		studentArr[1] = new Student("신사임당", 2, new Score(50, 10, 40));
		studentArr[2] = new Student("김장금", 1, 100, 0, 100);
		
		for(Student s : studentArr) {
			System.out.println(s);
			
		}
		
		
		
	}

}
