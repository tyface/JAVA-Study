
public class StudentList {
	private Student[] students;

	public StudentList() {
		this.students = new Student[0];
	}

	public StudentList(Student[] students) {
		this.students = students;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void add(Student student) {
		size(); // 학생을 추가할때마다 전체학생수 증가
		Student[] temp = new Student[size()]; // 증가된 전체학생수 크기만큼의 임시 배열 생성

		// 크기가 증가된 임시배열에 기존 Students배열 에있는 정보들을 삽입하는 반복문
		for (int i = 0; i < students.length; i++) {
			temp[i] = this.students[i];
		}
		temp[size() - 1] = student; // 임시배열 마지막 인덱스에 새로운 Student객체를 추가
		students = temp; // 임시배열을 기존 Studentㄴ배열 변수에 삽입
	}

	public void delete(String name) {// 학생의 이름을 입력받아 해당 학생을 제외하고 students 배열에 다시 저장하는 메소드

		int count = 0;
		for (int i = 0; i < size(); i++) {
			if (students[i].getName().equals(name)) {
				count += 1;
			}
		}

		Student[] temp = new Student[size() - count];

		int tempIndex = 0;
		for (int i = 0; i < size(); i++) {

			if (!students[i].getName().equals(name)) {
				temp[tempIndex] = students[i];
				tempIndex++;
			}
		}
		students = temp;

	}

	public int size() {
		return this.students.length;
	}

}
