package guiChatEx;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3274160372647840492L;
	private String id;
	private char[] pass;

	public Account() {
		this.id = "이름없음";
		this.pass = null;
	}

	public Account(String id, String pass) {
		this.id = id;
		this.pass = null;
	}

	@Override
	public String toString() {
		return id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		String rs = "";
		for (char e : pass) {
			rs += e;
		}

		return rs;
	}

	public void setPass(String str) {
		pass = new char[str.length()];
		for (int i = 0; i < pass.length; i++) {
			pass[i] = str.charAt(i);

		}
	}

	public void setPass(char[] pass) {
		this.pass = pass;
	}

}
