package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class StudentDaoImp implements StudentDao{
	
	SqlSessionFactory sqlSessionFactory;

	public StudentDaoImp() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertStudent(Map<String, Object> params) {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(StudentDao.class).insertStudent(params);
		} finally {
			session.close();
		}
	}

	@Override
	public int updateStudent(Map<String, Object> params) {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(StudentDao.class).updateStudent(params);
		} finally {
			session.close();
		}
	}

	@Override
	public int deleteStudent(int snum) {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(StudentDao.class).deleteStudent(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public Map<String, Object> selectOne(int snum) {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(StudentDao.class).selectOne(snum);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Map<String, Object>> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(StudentDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
