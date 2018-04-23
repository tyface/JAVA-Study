package thread2;

public class PrintThreadStatus {
	public static void main(String[] args) {
		// 스레드 진행에따른 상태값 출력해보기

		TargetThread talget = new TargetThread();
		PrintThread print = new PrintThread(talget);

		print.start();
	}
}
