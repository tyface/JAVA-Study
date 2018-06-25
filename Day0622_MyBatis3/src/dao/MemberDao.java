package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model.Member;

public class MemberDao implements IMemberDao{

	SqlSessionFactory sqlSessionFactory;

	public MemberDao() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Member member) {
		SqlSession session = sqlSessionFactory.openSession();
		// session.insert("dao.memberMapper.insertMember");
		// <<<인터페이스에 선언된 메서드를 실제로 사용할 수 있도록 만들어줌
		try {
			return session.getMapper(IMemberDao.class).insertMember(member);
		} finally {
			session.close();
		}
	}

	public int updateMember(Member member) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(IMemberDao.class).updateMember(member);
		} finally {
			session.close();
		}
	}

	public int deleteMember(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(IMemberDao.class).deleteMember(num);
		} finally {
			session.close();
		}
	}

	public Member selectOne(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(IMemberDao.class).selectOne(num);
		} finally {
			session.close();
		}
	}

	public List<Member> selectAll() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.getMapper(IMemberDao.class).selectAll();
		} finally {
			session.close();
		}
	}

}
