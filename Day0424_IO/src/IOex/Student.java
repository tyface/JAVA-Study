package IOex;

public class Student {
	private String name;
	private int grade;
	private int point;

	public Student() {
		this.name = null;
		this.grade = 0;
		this.point = 0;
	}

	public Student(String name, int grade, int point) {
		super();
		this.name = name;
		this.grade = grade;
		this.point = point;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return name + "/" + grade + "/" + point;
	}

}
