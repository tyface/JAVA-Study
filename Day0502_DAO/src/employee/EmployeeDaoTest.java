package employee;

import java.util.List;

public class EmployeeDaoTest {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		EmployeeVo vo = new EmployeeVo(1, "유지상", 2, 3000);

		// dao.insertEmployee(vo);
		// dao.deleteEmployee(1);
		// System.out.println(dao.selectOne(1));
		dao.updateEmployee(vo);
		List<EmployeeVo> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
