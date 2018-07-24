package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.EntDetailInfo;
import vo.EntInfo;

public class PublicDataDao {

	private static PublicDataDao instance;
	private SqlSessionFactory sqlSessionFactory;
	

	private PublicDataDao() {
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PublicDataDao getInstance() {
		if (instance == null) {
			instance = new PublicDataDao();
		}
		return instance;
	}

	public int regEntInfo(List<EntInfo> entList) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.insert("dao.mapper.publicdata-mapper.insertEntInfo", entList);
		} finally {
			session.close();
		}
	}
	
	public List<Map<String, String>> getEntList() {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.selectList("dao.mapper.publicdata-mapper.selectAll");
		} finally {
			session.close();
		}
	}
	
	public int modifyEnt(Map<String, String> map) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.update("dao.mapper.publicdata-mapper.updateResult", map);
		} finally {
			session.close();
		}
	}
	
	public int regEntDetailInfo(EntDetailInfo entDetailInfo) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.insert("dao.mapper.publicdata-mapper.insertEntDetailInfo", entDetailInfo);
		} finally {
			session.close();
		}
	}
	
	public int regPeriodInfo(Map<String, String> periodInfo) {

		SqlSession session = sqlSessionFactory.openSession();
		try {
			return session.insert("dao.mapper.publicdata-mapper.insertPeriodInfo", periodInfo);
		} finally {
			session.close();
		}
	}
}
