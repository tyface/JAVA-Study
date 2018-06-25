package dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Message;

public class MessageDao {
	SqlSessionFactory ssf;

	public MessageDao() {
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("congif.xml");
			ssf = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int inserMessage(Message message) {
		SqlSession session = ssf.openSession();
		try {
			return session.insert("dao.message_mapper.insertMessage", message);
		} finally {
			session.close();
		}
	}

	public int updateMessage(Message message) {
		SqlSession session = ssf.openSession();
		try {
			return session.update("dao.message_mapper.updateMessage", message);
		} finally {
			session.close();
		}
	}

	public int deleteMessage(int id) {
		SqlSession session = ssf.openSession();
		try {
			return session.delete("dao.message_mapper.deleteMessage", id);
		} finally {
			session.close();
		}
	}

	public Message selectOne(int id) {
		SqlSession session = ssf.openSession();
		try {
			return session.selectOne("dao.message_mapper.selecOne", id);
		} finally {
			session.close();
		}
	}

	public List<Message> selectAll() {
		SqlSession session = ssf.openSession();
		try {
			return session.selectList("dao.message_mapper.selectAll");
		} finally {
			session.close();
		}
	}

}
