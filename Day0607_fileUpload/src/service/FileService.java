package service;

import java.util.List;

import dao.FileDao;

public class FileService {
	private FileDao dao = null;
	private static FileService instance;
	
	private FileService() {
		dao = FileDao.getInstance();
	}

	public static FileService getInstance() {
		if(instance == null) {
			instance = new FileService();
		}
		return instance;
	}
	public boolean uploadFile(String fileName) {
		int result = dao.insert(fileName);

		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<String> getAllFileNames(){
		return dao.selectAll();
	}
}
