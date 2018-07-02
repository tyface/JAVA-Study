package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import model.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDao dao;

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

	@Override
	public Member getMemberById(String id) {
		return dao.selectById(id);
	}

	@Override
	public List<Member> getAllMember() {
		return dao.selectAll();
	}

}
