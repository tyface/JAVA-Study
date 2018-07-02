package dao;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
	//학년별 학생 선택
	public int insertStudent(Map<String, Object> student);
	public int updateStudent(Map<String, Object> student);
	public int deleteStudent(int num);
	public Map<String, Object> selectOne(int unm);
	public List<Map<String, Object>> selectAll();
	public List<Map<String, Object>> selectStudentByGrade(int grade);
}
