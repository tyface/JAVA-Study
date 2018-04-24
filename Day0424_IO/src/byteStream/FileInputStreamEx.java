package byteStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {
		// 표준입력스트림: 키보드로 부터 데이터를 읽어옴
		// FileInputStream : 파일로 부터 데이터를 읽어옴

		FileInputStream fis = null;

		try {
			
			fis = new FileInputStream("src/byteStream/data.txt");
			
			int data;
			
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // try-catch End

	}
}
