
public class Student {
	// 이름, 학년, 점수
	// 생성자: 기본생성자, (이름,학년,Score), (이름,학년,국어,영어,수학)
	// 메서드: 평균점수를 반환하는 메서드 getAverage()
	// get/set/to
	private String name;
	private int grade;
	private Score score;

	public Student() {
		score = new Score();
		name = "이름없음";
	}

	public Student(String name, int grade, Score score) {
		this.name = name;
		this.grade = grade;
		this.score = score;
	}

	public Student(String name, int grade, int kor, int eng, int math) {
		this.name = name;
		this.grade = grade;
		this.score = new Score(kor, eng, math);
	}

	public double getAverage() {

		return (double) (score.getEng() + score.getKor() + score.getMath()) / 3;
	}


	public void setKor(int kor) {
		this.score.setKor(kor);
	}


	public void setEng(int eng) {
		this.score.setEng(eng);
	}


	public void setMath(int math) {
		this.score.setMath(math);
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", grade=" + grade + ", score=" + score + ", average=" +getAverage() + "]";
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

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

}
