package thread1;

public class HorseRace2 {
	public static void main(String[] args) {
		// 말경주하기:
		// 반복적으로(1~5) 숫자를 만들어내는 클래스를 만들고
		// 누적합이 50이상이면 레이스를 종료

		Horse2 h1 = new Horse2("번개");
		Horse2 h2 = new Horse2("적토마");
		Horse2 h3 = new Horse2("슈팅스타");
		Horse2 h4 = new Horse2("다크호스");
		Horse2 h5 = new Horse2("유니콘");
		
		Runnable r1 = h1;
		Runnable r2 = h2;
		Runnable r3 = h3;
		Runnable r4 = h4;
		Runnable r5 = h5;
		
		
		
		System.out.println("레이스 종료");
	}
}
