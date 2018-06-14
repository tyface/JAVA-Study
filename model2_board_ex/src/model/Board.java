package model;

import java.sql.Date;

public class Board {

	private int boardIdx;
	private String content;
	private String title;
	private int readCount;
	private Date regDate;
	private int userIdx;
	private String userId;

	public int getBoardIdx() {
		return boardIdx;
	}

	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Board [boardIdx=" + boardIdx + ", content=" + content + ", title=" + title +", readCount=" + readCount + ", regDate=" + regDate + ", userIdx=" + userIdx + ", userId=" + userId
				+ "]";
	}

}
