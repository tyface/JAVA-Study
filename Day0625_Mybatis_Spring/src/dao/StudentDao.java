package dao;

import java.util.List;

import model.Student;

public interface StudentDao {
	public int insertStudent(Student student);
	public int updateStudent(Student student);
	public int deleteStudent(int snum);
	public Student selectOne(int snum);
	public List<Student> selectAll();
}
