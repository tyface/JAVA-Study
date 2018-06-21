package dao2;

import java.util.List;
import java.util.Map;

public interface MessageDao {
	
	public int insertMessage(Map<String, Object> param);

	public int updateMessage(Map<String, Object> param);

	public int deleteMessage(int id);

	public Map<String, Object> selectOne(int id);

	public List<Map<String, Object>> selectAll();
}
