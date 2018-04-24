package studentEx;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagement {
	// 학생관리 프로그램 만들기
	// 기능 : 학생정보보기, 학생정보추가, 검색 //삭제
	// 단, 학생의 최대 수는 50명이다. //최대수없이
	// StudentManagement 클래스를 만들어서 관리할 수 있는 프로그램을 작성하시오
	// StudentManagementTest 클래스 main에서 할 작업
	// StudentManagement 가 가지고 있는 start()를 호출만 한다.
	// 단, 데이터의 초기화(학생정보)가 필요한 경우 작성해서 넣어줘도 된다.
	//
	// 필요한 메서드, 필요한 변수는 마음대로 선언해서 사용하셔도 됩니다.

	private Student student; // 학생 객체
	private MyList<Student> students;

	private ObjectIOManagement oio;
	private String[] menuArr; // 메뉴를 담을 배열
	private boolean isRun; // 종료키가 입력되기 전까지 true를 표출
	private Scanner sc; // 스캐너 객체를 담을 변수

	public StudentManagement() { // 기본 생성자_정보를 기본값으로 초기화
		this.student = new Student();
		this.students = new MyList<Student>();

		this.oio = new ObjectIOManagement();
		this.menuArr = new String[] { "학생정보보기", "학생정보추가", "학생검색", "학생삭제", "종료" };
		this.isRun = true;
	}

	public void strat() { // 프로그램을 시작하는 메소드
		while (isRun) {
			showMenu(); // 메뉴 목록을 띄우는 메소드
			selectMenu(); // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		}
	}

	public void showMenu() { // 메뉴 목록을 띄우는 메소드
		System.out.println("┌─────────────────  메뉴를 선택하세요   ────────────────────┐");
		System.out.print("│  ");
		// 배열에 담긴 메뉴 목록을 출력하는 반복문
		for (int i = 0; i < menuArr.length; i++) {
			System.out.printf("%d.%s   ", i + 1, menuArr[i]);
		}

		System.out.println(" │\r\n└─────────────────────────────────────────────────────┘");
	}

	public void selectMenu() { // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		int menuNum; // 선택 메뉴의 번호
		sc = new Scanner(System.in);
		menuNum = sc.nextInt();

		switch (menuNum) {
		case 1:
			showAllStudeunt();
			break;
		case 2:
			createStudent();
			break;
		case 3:
			searchStudent();
			break;
		case 4:
			deleteStudent();
			break;
		case 5:
			isRun = false;
			System.out.println("프로그램이 종료되었습니다.");
			break;
		default:
			break;
		}
	}

	public void showAllStudeunt() { // 모든 학생의 정보를 출력하는 메소드
		students = oio.getList();
		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < students.size(); i++) {

			System.out.printf("이름 : %s / 학년 : %d / 평균 : %.2f / 국어 : %d / 영어 : %d / 수학 : %d \r\n",
					students.get(i).getName(), students.get(i).getGrade(), students.get(i).getAverage(),
					students.get(i).getScore().getKor(), students.get(i).getScore().getEng(),
					students.get(i).getScore().getMath());
		}
		System.out.println("=============================================================================\r\n");

	}

	public void createStudent() { // 데이터를 입력받아 student객체를 만들고 반환하는 메소드
		students = oio.getList();
		student = new Student();
		sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		student.setName(sc.nextLine());
		try {
			System.out.println("학년을 입력해주세요.");
			student.setGrade(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
			student.setGrade(1);
			sc.next();
		}
		try {
			System.out.println("국어점수를 입력해주세요.");
			student.setKor(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
			student.setKor(1);
			sc.next();
		}
		try {
			System.out.println("영어점수를 입력해주세요.");
			student.setEng(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
			student.setEng(1);
			sc.next();
		}
		try {
			System.out.println("수학점수를 입력해주세요.");
			student.setMath(sc.nextInt());
		} catch (InputMismatchException e) {
			System.out.println("잘못입력하셨습니다.");
			student.setMath(1);
			sc.next();
		}
		students.add(student);
		oio.pushList(students);
		System.out.println("등록 되었습니다.");

	}

	// public void addStudent(Student student) { // student 객체를 받아서 현제 students 배열에
	// 추가하는 메소드
	// maxStudent++; // 학생을 추가할때마다 전체학생수 증가
	// Student[] temp = new Student[maxStudent]; // 증가된 전체학생수 크기만큼의 임시 배열 생성
	//
	// // 크기가 증가된 임시배열에 기존 Students배열 에있는 정보들을 삽입하는 반복문
	// for (int i = 0; i < students.length; i++) {
	// temp[i] = this.students[i];
	// }
	// temp[maxStudent - 1] = student; // 임시배열 마지막 인덱스에 새로운 Student객체를 추가
	// students = temp; // 임시배열을 기존 Studentㄴ배열 변수에 삽입
	// }

	public void searchStudent() { // 학생의 이름을 입력받아 해당하는 학생을 출력하는 메소드
		System.out.println("검색하고싶은 학생의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		students = oio.getList();
		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getName().equals(inputName)) {
				System.out.printf("이름 : %s / 학년 : %d / 평균 : %.2f / 국어 : %d / 영어 : %d / 수학 : %d \r\n", students.get(i).getName(),
						students.get(i).getGrade(), students.get(i).getAverage(), students.get(i).getScore().getKor(), students.get(i).getScore().getEng(),
						students.get(i).getScore().getMath());
			}
		}
		System.out.println("=============================================================================\r\n");
	}

	public void deleteStudent() { // 학생의 이름을 입력받아 해당 학생을 제외하고 students 배열에 다시 저장하는 메소드
		System.out.println("삭제하고 싶은 학생의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		students = oio.getList();
		for (int i = 0 ; i < students.size(); i++) {
			if(students.get(i).getName().equals(inputName)) {
				students.remove(i);
			}
		}
		oio.pushList(students);
		System.out.println("삭제되었습니다.");
	}

	// 아래로 getter , setter 메소드
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public MyList<Student> getStudents() {
		return students;
	}

	public void setStudents(MyList<Student> students) {
		this.students = students;
	}

	public String[] getMenuArr() {
		return menuArr;
	}

	public void setMenuArr(String[] menuArr) {
		this.menuArr = menuArr;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

}
