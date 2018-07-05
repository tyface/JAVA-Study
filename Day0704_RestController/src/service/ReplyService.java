package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReplyDao;
import model.Reply;

@Service
public class ReplyService {
	@Autowired
	private ReplyDao replyDao;
	
	
	public boolean addReply(Reply reply) {
		if(replyDao.insertReply(reply)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Reply> getBoardReply(int boardNum){
		return replyDao.selectByBoardNum(boardNum);
	}
	
	
	
}
