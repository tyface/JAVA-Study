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
	private Student[] students; // 학생을 답을 배열 객채
	private int maxStudent; // 학생 객체의 총개수를 저장

	private int menu; // 선택 메뉴의 번호
	private String[] menuArr; // 메뉴를 담을 배열
	private boolean isRun; // 종료키가 입력되기 전까지 true를 표출
	private Scanner sc; // 스캐너 객체를 담을 변수

	public StudentManagement() { // 기본 생성자_정보를 기본값으로 초기화
		this.student = new Student();
		this.students = new Student[maxStudent];
		this.maxStudent = 0;

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
		System.out.println("*****************  메뉴를 선택하세요   *********************");
		System.out.print("*  ");
		for (int i = 0; i < menuArr.length; i++) {
			System.out.printf("%d.%s   ", i + 1, menuArr[i]);
		}
		System.out.println("*\r\n******************************************************");
	}

	public void selectMenu() { // 인풋으로 입력받은 값대로 해당하는 메소드를 실행하는 컨트롤러
		sc = new Scanner(System.in);
		menu = sc.nextInt();

		switch (menu) {
		case 1:
			showAllStudeunt();
			break;
		case 2:
			addStudent(createStudent());
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

	public void showAllStudeunt() { //모든 학생의 정보를 출력하는 메소드
		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < this.students.length; i++) {

			System.out.printf("이름 : %s / 학년 : %d / 평균 : %.2f / 국어 : %d / 영어 : %d / 수학 : %d \r\n", students[i].getName(),
					students[i].getGrade(), students[i].getAverage(), students[i].getScore().getKor(),
					students[i].getScore().getEng(), students[i].getScore().getMath());
		}
		System.out.println("=============================================================================\r\n");
	}

	public Student createStudent() { //데이터를 입력받아 student객체를 만들고 반환하는 메소드

		student = new Student();
		sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		student.setName(sc.nextLine());
		System.out.println("학년을 입력해주세요.");
		student.setGrade(sc.nextInt());
		System.out.println("국어점수를 입력해주세요.");
		student.setKor(sc.nextInt());
		System.out.println("영어점수를 입력해주세요.");
		student.setEng(sc.nextInt());
		System.out.println("수학점수를 입력해주세요.");
		student.setMath(sc.nextInt());
		System.out.println("등록 되었습니다.");
		return student;
	}

	public void addStudent(Student student) { //student 객체를 받아서 현제 students 배열에 추가하는 메소드
		maxStudent += 1;
		Student[] temp = new Student[maxStudent];
		for (int i = 0; i < students.length; i++) {
			temp[i] = this.students[i];
		}
		temp[maxStudent - 1] = student;
		students = temp;
	}

	public void searchStudent() {  //학생의 이름을 입력받아 해당하는 학생을 출력하는 메소드
		System.out.println("검색하고싶은 학생의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();

		System.out.println("\r\n=============================================================================");
		for (int i = 0; i < students.length; i++) {
			if (students[i].getName().equals(inputName)) {
				System.out.printf("이름 : %s / 학년 : %d / 평균 : %.2f / 국어 : %d / 영어 : %d / 수학 : %d \r\n",
						students[i].getName(), students[i].getGrade(), students[i].getAverage(),
						students[i].getScore().getKor(), students[i].getScore().getEng(),
						students[i].getScore().getMath());
			}
		}
		System.out.println("=============================================================================\r\n");
	}

	public void deleteStudent() { // 학생의 이름을 입력받아 해당 학생을 제외하고 students 배열에 다시 저장하는 메소드
		System.out.println("삭제하고 싶은 학생의 이름을 입력해주세요.");
		sc = new Scanner(System.in);
		String inputName = sc.nextLine();
		int count = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i].getName().equals(inputName)) {
				count += 1;
			}
		}

		maxStudent -= count;
		Student[] temp = new Student[maxStudent];

		int tempIndex = 0;
		for (int i = 0; i < students.length; i++) {

			if (!students[i].getName().equals(inputName)) {
				temp[tempIndex] = students[i];
				tempIndex++;
			}
		}
		students = temp;

		System.out.println("삭제되었습니다.");
	}

	//아래로  getter , setter 메소드
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public int getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}

	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
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
