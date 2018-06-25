package model;

import java.util.Date;

public class Message {
	private String id;
	private String password;
	private String name;
	private String message;
	private Date user_num;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getUser_num() {
		return user_num;
	}

	public void setUser_num(Date user_num) {
		this.user_num = user_num;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", password=" + password + ", name=" + name + ", message=" + message
				+ ", user_num=" + user_num + "]";
	}

}
