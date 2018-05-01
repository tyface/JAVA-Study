package student;

public class Student {
	// 이름 국,영,수
	private String name;
	private int grade;
	private int kor;
	private int eng;
	private int math;

	public Student() {

	}

	public Student(String name, int grade, int kor, int eng, int math) {
		this.name = name;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getTotal() {
		return kor + eng + math;

	}

	public int getAverage() {
		return getTotal() / 3;

	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

}
