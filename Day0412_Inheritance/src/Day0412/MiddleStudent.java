package Day0412;

public class MiddleStudent extends Student {
	boolean schoolUniform;

	public MiddleStudent() {
		schoolUniform = true;
	}

	@Override
	public String toString() {
		return "MiddleStudent [schoolUniform=" + schoolUniform + "]";
	}

	public boolean isSchoolUniform() {
		return schoolUniform;
	}

	public void setSchoolUniform(boolean schoolUniform) {
		this.schoolUniform = schoolUniform;
	}
	
	
}
