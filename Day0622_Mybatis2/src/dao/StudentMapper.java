package dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.Student;

public interface StudentMapper {

	@Insert("INSERT INTO student_ex "
			+ "VALUES (#{snum},#{sname},#{sgrade})")
	public int insertStudent(Student student);

	@Update("UPDATE student_ex "
			+ "SET sname = #{sname}, sgrade = #{sgrade} "
			+ "WHERE snum = #{snum}")
	public int updateStudent(Student student);

	@Delete("DELETE student_ex "
			+ "FROM snum = #{snum}")
	public int deleteStudent(int snum);

	@Select("SELECT * "
			+ "FROM  student_ex "
			+ "WHERE snum = #{snum}")
	public Student selectOne(int snum);

	@Select("SELECT * "
			+ "FROM student_ex")
	public List<Student> selectAll();
}
