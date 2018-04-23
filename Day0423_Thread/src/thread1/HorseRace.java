package thread1;

public class HorseRace {
	public static void main(String[] args) {
		// 말경주하기:
		// 반복적으로(1~5) 숫자를 만들어내는 클래스를 만들고
		// 누적합이 50이상이면 레이스를 종료

		Thread t1 = new Horse("번개");
		Thread t2 = new Horse("적토마");
		Thread t3 = new Horse("슈팅스타");
		Thread t4 = new Horse("다크호스");
		Thread t5 = new Horse("유니콘");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
		System.out.println("레이스 종료");
	}
}
