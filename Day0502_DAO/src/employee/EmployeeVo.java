package employee;

public class EmployeeVo {
	private int eNum;
	private String eName;
	private int deptno;
	private int salary;

	public EmployeeVo() {
	}

	public EmployeeVo(int eNum, String eName, int deptno, int salary) {
		super();
		this.eNum = eNum;
		this.eName = eName;
		this.deptno = deptno;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeeVo [eNum=" + eNum + ", eName=" + eName + ", deptno=" + deptno + ", salary=" + salary + "]";
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
