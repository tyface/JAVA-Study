
public class Structure {

	public static void main(String[] args) {
		// 구조체, structure
		// 다양한 데이터를 한꺼번에 처리하기 위해서 사용

		Student s1 = new Student();

		System.out.println(s1.name);

		s1.name = "유지상";
		s1.age = 29;
		s1.score = 99.9;
		s1.grade = 6;

		System.out.println(s1.name);
		
	}

}// class end

class Student { // 사용자 정의 데이터 타입
	// Student 클래스를 이용해서 여러 종류의 데이터를 한꺼번에 처리
	// 이름, 나이, 점수, 학년
	String name;
	int age;
	double score;
	int grade;

}
