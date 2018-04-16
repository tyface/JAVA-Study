import java.util.Scanner;

public class StudentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println("이름을 입력 해주세요.");
		s1.name = sc.nextLine();
		System.out.println("수학점수를 입력 해주세요.");
		s1.math = sc.nextInt();
		System.out.println("영어점수를 입력 해주세요.");
		s1.eng = sc.nextInt();
		System.out.println("국어점수를 입력 해주세요.");
		s1.kor = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("이름을 입력 해주세요.");
		s2.name = sc.nextLine();
		System.out.println("수학점수를 입력 해주세요.");
		s2.math = sc.nextInt();
		System.out.println("영어점수를 입력 해주세요.");
		s2.eng = sc.nextInt();
		System.out.println("국어점수를 입력 해주세요.");
		s2.kor = sc.nextInt();
		
		s1.getAvg();
		s1.printVeiw();
		s2.getAvg();
		s2.printVeiw();
		sc.close();
	}

}
