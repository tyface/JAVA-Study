package IOex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class IOManager {
	String filePath;
	FileInputStream in;
	FileOutputStream out;
	StringBuilder sb;
	Student student;

	public IOManager() {
		this.filePath = "src/IOex/Student.txt";
		this.in = null;
		this.out = null;
		this.sb = new StringBuilder();
		this.student = new Student();
	}

	public List<String> getInfo() {
		List<String> result = new ArrayList<>();

		try {

			in = new FileInputStream(filePath);

			int data;

			while ((data = in.read()) != -1) {
				sb.append((char) data);
			}

			StringTokenizer st = new StringTokenizer(sb.toString(), "/");
			
			int countTokens = st.countTokens();
			for (int i = 0; i < countTokens; i++) {
				result.add(st.nextToken());
			}

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End

		return result;
	}

	public void setInfo(String str) {

		try {

			out = new FileOutputStream(filePath);

			byte[] bytes = str.getBytes();

			out.write(bytes);

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End
	}

}
