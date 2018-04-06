
public class Student {
	// 학생 객체가 가질 기능
	// 평균 구하는 기능
	// 출력 기능
	// 가지는 데이터
	// 이름,수학,영어,국어

	String name;
	int math;
	int eng;
	int kor;
	double avg;

	public void getAvg() {
		avg = (double) (math + eng + kor) / 3;
	}
	
	public void printVeiw() {
		System.out.printf("%s 학생의 평균은 %.2f 입니다.\r\n",name,avg);
	}

}
