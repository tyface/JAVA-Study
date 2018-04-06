import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		// 학생 두명의 정보(이름, 국어, 영어, 수학)를 입력받아서
		// 각 학생의 이름과 평균을 출력하는 프로그램을 작성하라
		// 입출력 예)

		Student1 s1 = new Student1();
		Student1 s2 = new Student1();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요.");
		s1.name = sc.nextLine();
		System.out.println("국어점수을 입력하세요.");
		s1.kor = sc.nextInt();
		System.out.println("수학점수을 입력하세요.");
		s1.math = sc.nextInt();
		System.out.println("영어점수을 입력하세요.");
		s1.eng = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("이름을 입력하세요.");
		s2.name = sc.nextLine();
		System.out.println("국어점수을 입력하세요.");
		s2.kor = sc.nextInt();
		System.out.println("수학점수을 입력하세요.");
		s2.math = sc.nextInt();
		System.out.println("영어점수을 입력하세요.");
		s2.eng = sc.nextInt();
	}

}
class Student1 {
	String name;
	int kor;
	int math;
	int eng;

}