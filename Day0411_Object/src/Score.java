
public class Score {
	// 국어, 영어, 수학 점수를 저장할 수 있는 클래스
	// getter, setter 만들고, toString
	// 생성자: 기본생성자, 국,영,수, 점수를 매개변수로 받는 생성자
	
	private int kor;
	private int eng;
	private int math;
	
	public Score() {
		
	}

	public Score(int kor, int eng, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	@Override
	public String toString() {
		return "Score [kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
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
