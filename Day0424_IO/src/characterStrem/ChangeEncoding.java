package characterStrem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChangeEncoding {

	public static void main(String[] args) {
		// 문서 인코딩 바꾸기

		// 1. FileInputStream,FileOutputStream,
		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("src/characterStrem/text.txt"),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/characterStrem/text2.txt"),"MS949"));

			int readChar;
			while ((readChar = in.read()) != -1) {
				out.write(readChar);
			}
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
