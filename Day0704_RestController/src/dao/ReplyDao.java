package dao;

import java.util.List;

import model.Reply;

public interface ReplyDao {

	public int insertReply(Reply reply);

	public int updateReply(Reply reply);

	public int deleteReply(int replyNum);

	public Reply selectOne(int replyNum);

	public List<Reply> selectByBoardNum(int boardNum);
	
}
