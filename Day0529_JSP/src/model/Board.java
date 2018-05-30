package model;

public class Board {
	private String title;
	private String name;
	private String email;
	private String pass;
	private String content;
	
	public Board() {
	}
	
	public Board(String title, String name, String email, String pass, String content) {
		this.title = title;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [title=" + title + ", name=" + name + ", email=" + email + ", pass=" + pass + ", content="
				+ content + "]";
	}
	
	
}
