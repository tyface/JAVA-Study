package byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStream {
	public static void main(String[] args) {
		// 데이터 처리 스트림 예제3
		// 객체 단위로 데이터를 쓸수 있게 만들어 놓은 스트림
		String file = "src/byteStream/student.dat";
		ObjectInputStream in = null;
		ObjectOutputStream out = null;

		try {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

			Student s = new Student();
			s.setName("유지상");
			s.setGrade(4);
			s.setPoint(1001);
			
			
			out.writeObject(s);
			out.flush();

			
			Student inputStudent = (Student)in.readObject();

			System.out.println(inputStudent);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
