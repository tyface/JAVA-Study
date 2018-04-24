package byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class bufferedStreamEx {
	public static void main(String[] args) {
		// 데이터 처리 스트림 BerfferedInput/OutputStream
		// 데이터 처리스트림 : 데이터 소스에서 값을 가져오거나 쓰는것이 아니라
		// 데이터를 받아서 쓰기 편하게 만들어주는 역할
		// 파일에 숫자 1~300 까지 작성 >> 반복문 >> 파일에 작성된 내용을 읽어와 보기

		String file = "src/byteStream/number.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {

			bos = new BufferedOutputStream(new FileOutputStream(file));

			for (int i = 1; i <= 300; i++) {
				bos.write(i);
			}
			bos.flush();

			bis = new BufferedInputStream(new FileInputStream(file));

			int data;
			while ((data = bis.read()) != -1) {
				System.out.println(data);
			}

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null)
					bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
