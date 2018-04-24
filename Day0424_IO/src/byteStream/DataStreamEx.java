package byteStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx {
	public static void main(String[] args) {
		// 데이터 처리 스트림 예제2
		// DatInputStream/DatOutputStream
		// byte단위로 데이터를 쓰던 것을, 자바 기초자료형 단위로 데이터를 쓸 수 있게 구현해놓은 스트림
		String file = "src/byteStream/data.dat";
		DataInputStream in = null;
		DataOutputStream out = null;

		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

			out.writeInt(100);
			out.writeDouble(1.12);
			out.writeBoolean(true);
			out.writeUTF("사나");

			out.flush();

			int intNum = in.readInt();
			double doubleNum = in.readDouble();
			boolean bool = in.readBoolean();
			String str = in.readUTF();

			System.out.println(intNum);
			System.out.println(doubleNum);
			System.out.println(bool);
			System.out.println(str);

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
