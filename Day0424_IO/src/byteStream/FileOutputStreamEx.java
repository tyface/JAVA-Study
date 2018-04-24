package byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
	public static void main(String[] args) {
		// 문장을 파일에 작성하기.
		String str = "Hello!! FileOutputStream!!";
		FileOutputStream fos = null;
		
		try {

			fos = new FileOutputStream("src/byteStream/data2.txt");

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
