package service;

import java.util.List;
import java.util.Map;

public interface IStudentService {

	public Map<String, Object> getStudent(int num);

	public List<Map<String, Object>> getStudentByGrade(int grade);

	public List<Map<String, Object>> getAllStudent();
	
	public boolean addStudent(String name, int grade);
}
