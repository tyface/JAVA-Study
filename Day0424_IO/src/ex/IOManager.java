package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IOManager {
	String filePath;
	FileInputStream fis;
	FileOutputStream fos;
	StringBuilder sb;
	Student student;

	public IOManager() {
		this.filePath = "src/ex/Student.txt";
		this.fis = null;
		this.fos = null;
		this.sb = new StringBuilder();
		this.student = new Student();
	}

	public List<String> getStr() {
		List<String> result = new ArrayList<>();

		try {

			fis = new FileInputStream(filePath);

			int data;

			while ((data = fis.read()) != -1) {
				sb.append((char) data);
			}

			StringTokenizer str = new StringTokenizer(sb.toString(), "/");
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

	public void setStr(String str) {

		try {

			fos = new FileOutputStream(filePath);

			byte[] bytes = str.getBytes();

			fos.write(bytes);

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End
	}

}
