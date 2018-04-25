package studentEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOManagement {
	private static final String FILE_PATH = "src/studentEx/StudentList.dat"; // 파일 경로
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public ObjectIOManagement() {
		this.in = null;
		this.out = null;
	}

	public MyList<Student> getList() { // 학생 리스트 객체를 불러와서 반환
		MyList<Student> list = null;

		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILE_PATH)));
			list = (MyList<Student>) in.readObject(); // 학생 리스트 객체를 불러와서 list변수에 삽입

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			list = new MyList<Student>();
		} catch (EOFException e) {
			list = new MyList<Student>();
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

		return list;
	}

	public void pushList(MyList<Student> students) { // 학생 리스트 객체를 지정 파일에 삽입

		try {
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILE_PATH)));

			out.writeObject(students); // 학생 리스트 객체를 지정 파일에 삽입
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
