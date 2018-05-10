package mamber;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVo {
	private int num;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Timestamp regDate;

	public MemberVo() {

	}

	public MemberVo(String id, String pw, String name, String email) {
		this.num = 0;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regDate = null;
	}
	

	public MemberVo(int num, String id, String pw, String name, String email, Timestamp regDate) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
//		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		String str = afterFormat.format(afterFormat);
		return "MamberVo [num=" + num + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
