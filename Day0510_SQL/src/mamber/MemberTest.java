package mamber;

import java.sql.Timestamp;

public class MemberTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
//		dao.insertMember(new MemberVo("root","0000","관리자","zxuz3@"));		
//		dao.insertMember(new MemberVo("유지상","0000","관리자","zxuz4@"));
//		dao.insertMember(new MemberVo("root3","0000","관리자","zxuz5@"));
		
		
		
//		System.out.println(dao.selectOne(2));
		dao.updateMember(new MemberVo(3,"root2","0001","부관리자","zxuz5@naver.com",Timestamp.valueOf("2018-04-15 12:01:01")));
		
		for(MemberVo vo : dao.selectAll()) {
			System.out.println(vo);;
		}
		
	}
}
