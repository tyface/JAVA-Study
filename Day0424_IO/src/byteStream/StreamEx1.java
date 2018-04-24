package byteStream;
import java.io.IOException;

public class StreamEx1 {

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		System.out.println("문자를 입력하세요");
		int read;
		while ((read = System.in.read()) != -1) {
			// 읽어온 값이 없을때 read() >> -1 반환
			
			if(read == '\n'|| read == '\r') {
				continue;
			}
			if(read == 'q' || read == 'Q') {
				break;
			}
			char c = (char)read;
			
			System.out.println("[" + c + "] = " + read);

		}

	}
}
