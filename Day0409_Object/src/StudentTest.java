
public class StudentTest {

	public static void main(String[] args) {
		// Student 클래스를 작성
		// 객체를 만들어서 객체의 멤버변수에 갑을 넣고, 조회하고
		// 메서드를 만들어서 객체 상태를 출력하는 기능 실행해보기
		// Stedent가 가져야할 상태값
		// 이름, 학년, 번호,
		// Student 객체가 할 수 있는 동작
		// 상태값 출력 : printStudent
		// 객체 2개 s1, s1 만들어서 각각 이름, 학년, 번호 값 넣어주고
		// printStudent 활용해서 상태값 출력해보기
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.name = "홍길동";
		s1.grade = 3;
		s1.num = 12;
		
		s2.name = "이순신";
		s2.grade = 2;
		s2.num = 10;
		
		s1.printStudent();
		s2.printStudent();
	}

}

class Student {
	String name;
	int grade;
	int num;
	
	public void printStudent() {
		System.out.println("이름 : " + name);
		System.out.println("학년 : " + grade);
		System.out.println("번호 : " + num);
	}
	
}