package guiChatEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectIOManagement {
	private static final String FILE_PATH = "src/guiChatEx/account.dat"; // 파일 경로
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public ObjectIOManagement() {
		this.in = null;
		this.out = null;
	}

	public Map<String, String> getList() { // 리스트 객체를 불러와서 반환
		Map<String, String> accountList = null;

		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)));
			accountList = (HashMap<String, String>) in.readObject(); //리스트 객체를 불러와서 list변수에 삽입

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			accountList = new HashMap<String, String>();
		} catch (EOFException e) {
			accountList = new HashMap<String, String>();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End

		return accountList;
	}

	public void pushList(Map<String, String> accountList) { // 학생 리스트 객체를 지정 파일에 삽입

		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)));

			out.writeObject(accountList); // 학생 리스트 객체를 지정 파일에 삽입
			out.flush(); // Output 초기화
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
