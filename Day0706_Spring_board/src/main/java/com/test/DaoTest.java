package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.BoardDao;
import com.model.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DaoTest {
	@Autowired
	private BoardDao boardDao;
	
	@Test
	public void boardDaoTest() {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("TITLE", "제목");
		params.put("type", 1);
		params.put("firstRow", 1);
		params.put("endRow", 10);
		
		List<Board> boardList
		 = boardDao.searchBoard(params);
		
		for(Board board:boardList) {
			System.out.println(board);
		}
		
		
		
		
		
	}
	
}










