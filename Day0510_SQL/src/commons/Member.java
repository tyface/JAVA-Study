package commons;

public enum Member {
	NUM("NUM"), 
	ID("ID"), 
	NAME("NAME"), 
	PW("PW"), 
	EMAIL("EMAIL"), 
	REG_DATE("REGDATE");

	private String col;

	private Member(String col) {
		this.col = col;

	}

	public String getCol() {
		return col;
	}
}
