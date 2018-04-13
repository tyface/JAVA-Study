package Day0412;

public class HighStudent extends Student{
	String major;
	
	public HighStudent() {
		major = "없음";
	}

	@Override
	public String toString() {
		return "HighStudent [major=" + major + "]";
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
