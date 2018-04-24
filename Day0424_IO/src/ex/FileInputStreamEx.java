package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FileInputStreamEx {
	FileInputStream fis = null;

	Student student = new Student();
	StringBuilder sb = new StringBuilder();
	List<String> strList;
	
	public List<String> getStr() {
		List<String> result = new ArrayList<>();

		try {

			fis = new FileInputStream("src/ex/Student.txt");

			int data;

			while ((data = fis.read()) != -1) {
				sb.append((char) data);
			}
			
			StringTokenizer str = new StringTokenizer(sb.toString(),"/");
			int countTokens = str.countTokens();
			
			for (int i = 0; i < countTokens; i++) {
				result.add(str.nextToken());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End

		return result;
	}
}
