package guiChatEx;

import java.io.Serializable;

public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3274160372647840492L;
	private String id;
	private char[] pass;
	private boolean isLogin;

	public Account() {
		this.id = "이름없음";
		this.pass = null;
		this.isLogin = false;
	}

	public Account(String id, String pass) {
		this.id = id;
		this.pass = null;
		this.isLogin = false;
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
		String rs = null;
		for (char e : pass) {
			rs += e;
		}
		
		return rs;
	}

	public void setPass(char[] pass) {
		this.pass = pass;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}
 
}
