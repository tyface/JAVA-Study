
public class Student {
	int numOfSubject;
	int totalScore;

	public Student() {

	}

	public Student(int numOfSubject, int totalScore) {
		super();
		this.numOfSubject = numOfSubject;
		this.totalScore = totalScore;
	}

	public void showAvg() throws ArithmeticException {
			int result = numOfSubject / totalScore;
			System.out.println(result);
	}

}
