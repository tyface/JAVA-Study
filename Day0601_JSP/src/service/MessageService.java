package service;

import java.util.List;

import dao.MessageDao;
import model.Message;

public class MessageService {
	// Dao 객체를 멤버로 가지면서 사용
	MessageDao dao;

	public MessageService() {
		dao = new MessageDao();
	}

	public int regMessage(Message message) {
		return dao.insertMessage(message);
	}

	// public boolean modify(Message message) {
	//
	// if(dao.updateMessage(message)>0) {
	// return true;
	// }
	// return false;
	// }
	
	public int removeMessage(int id) {
		return dao.deleteMessage(id);
	}

	public Message getMessage(int id) {
		return dao.selectOne(id);
	}

	public List<Message> getAllMessage() {
		return dao.selectAll();
	}

}
