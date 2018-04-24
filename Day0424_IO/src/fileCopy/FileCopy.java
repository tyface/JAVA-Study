package fileCopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		byte[] bf = new byte[512];
		int readLength;

		try {
			in = new FileInputStream("src/fileCopy/cat.jpg");
			out = new FileOutputStream("src/fileCopy/cat_copy.jpg");

			while ((readLength = in.read(bf)) != -1) {
				out.write(bf, 0, readLength);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in.read() != -1)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
