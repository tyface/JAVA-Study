package guiChatEx;

import java.io.Serializable;
import java.util.Map;

public class Protocol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7802516905080527599L;
	private String type;
	private Map<String, Object> data;

	public Protocol() {
		this.type = null;
		this.data = null;
	}

	public Protocol(String type, Map<String, Object> data) {
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getData(String msg) {
		return (String) data.get(msg);
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
