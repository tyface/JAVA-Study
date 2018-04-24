package byteStream;

import java.io.Serializable;

public class Student implements Serializable{
	//클래스의 버전정보를 저장하는 변수를 둬서 객체가 업데이트 되었는지 확인
	private static final long serialVersionUID = 5213444470558484388L;
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
