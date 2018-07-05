package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BoardDao;
import dao.MemberDao;
import model.Board;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDao dao;

	@Autowired
	BoardDao boardDao;
	
	@Override
	public boolean insertMember(Member member) {
		if (dao.insertMember(member) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateMember(Member member) {
		if (dao.updateMember(member) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	@Override
	public boolean join(Member member) {
		Board board = new Board();
		board.setTitle(member.getName() + "가입인사 입니다.");
		board.setName(member.getId());
//		board.setPass(member.getPw());
		board.setEmail(member.getEmail());
		board.setContent("반갑습니다. 오늘 가입했습니다." + member.getName());
		
	
		if (boardDao.insertBoard(board) > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Member getMemberById(String id) {
		return dao.selectById(id);
	}

	@Override
	public List<Member> getAllMember() {
		return dao.selectAll();
	}

}
