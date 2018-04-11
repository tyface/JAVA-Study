
public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Time time = new Time();
		
		time.setTime(20,5,59);
		time.showTime();
		
		Time time2 = new Time(12,11,15);
		time2.showTime();
		System.out.println(time2);
		
	}

}
