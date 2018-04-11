
public class Time {
	// 시,분,초를 저장할 수 있는 변수
	// 외부에서 접근X

	// 생성자 : 기본생성자, 시,분,초를 매개변수로 받는 생성자
	// 매서드 : setTiem()
	// showTime()

	private int hour;
	private int minute;
	private int second;

	public Time() {

	}

	public Time(int hour, int minute, int second) {
		// this.hour = hour;
		// this.minute = minute;
		// this.second = second;
		setTime(hour, minute, second);
	}

	public void setTime(int hour, int minute, int second) {

		if (hour < 0 || hour > 23) {
			hour = 0;
		}

		this.hour = hour;

		if (minute < 0 || minute > 59) {
			minute = 0;
		}

		this.minute = minute;

		if (second < 0 || second > 59) {
			second = 0;
		}

		this.second = second;
	}

	public void showTime() {
		System.out.printf("%02d시 %02d분 %02d초 입니다.\r\n", hour, minute, second);
	}

	public String toString() {
		String str = hour + "시 " + minute + "분 " + second + "초 입니다.";
		return str;
	}
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
