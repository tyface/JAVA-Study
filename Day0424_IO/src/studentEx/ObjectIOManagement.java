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
	private String filePath;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private FileInputStream fis;

	public ObjectIOManagement() {
		this.filePath = "src/studentEx/StudentList.dat";
		this.in = null;
		this.out = null;
		this.fis = null;
	}

	public MyList<Student> getList() {
		MyList<Student> list = null;

		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filePath)));
			list = (MyList<Student>) in.readObject();

		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} catch (EOFException e) {
			return new MyList<Student>();
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

	public void pushList(MyList<Student> students) {

		try {

			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));

			out.writeObject(students);
			out.flush();

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
