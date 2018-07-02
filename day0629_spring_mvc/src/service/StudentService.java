package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IStudentDao;

@Service
public class StudentService implements IStudentService {

	@Autowired
	IStudentDao dao;

	@Override
	public Map<String, Object> getStudent(int num) {
		return dao.selectOne(num);
	}

	@Override
	public List<Map<String, Object>> getStudentByGrade(int grade) {
		return dao.selectStudentByGrade(grade);
	}

	@Override
	public List<Map<String, Object>> getAllStudent() {
		return dao.selectAll();
	}

	@Override
	public boolean addStudent(String name, int grade) {
		Map<String, Object> student = new HashMap<String, Object>();

		student.put("SNAME", name);
		student.put("SGRADE", grade);
		
		if (dao.insertStudent(student) > 0) {
			return true;
		} else {
			return false;
		}
		
	}
}
