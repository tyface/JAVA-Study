package characterStrem;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderWriter {
	public static void main(String[] args) {
		// 문자스트림 예제 - 파일복사
		// 파일로 부터 데이터를 읽어와서 처리
		// FileReader, FileWriter

		FileReader fr = null;
		FileWriter fw = null;

		int readChar;
		try {
			fr = new FileReader("src/characterStrem/text.txt");
			fw = new FileWriter("src/characterStrem/text_copy.txt");

			while ((readChar = fr.read()) != -1) {
				fw.write((char)readChar);
			}
			fw.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(fr != null)fr.close();
				if(fw != null)fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
