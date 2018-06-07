package dao;

import java.util.List;

public interface IFileDao {

	public int insert(String fileName);

//	public int update(String fileName);
//
//	public int delete(String fileName);

	public List<String> selectAll();

}
