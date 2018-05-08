package student2;

import java.util.List;

public class StudentDaoTest {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		StudentVo vo = new StudentVo();
		vo.setSnum(8);
		vo.setSname("하하");
		vo.setSgrade(7);
//		System.out.println(dao.seleteOne(2));
		dao.insertStudent(vo);
		// List<StudentVo> list = dao.seleteAll();
		//
		// for (int i = 0; i < list.size(); i++) {
		//
		// System.out.println(list.get(i));
		// }
		System.out.println(dao.seleteOne(8));
		
		
	}
}
