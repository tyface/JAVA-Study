package dao;

import java.util.List;

import model.Message;

public interface IMessageDao {

	public int insertMessage(Message message);

//	public int updateMessage(Message message);

	public int deleteMessage(int id);

	public Message selectOne(int id);

	public List<Message> selectAll();

}
