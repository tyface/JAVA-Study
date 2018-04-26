package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClientEx2 {
	public static void main(String[] args) {
		// 연결요청을 하는쪽
		// 프로그램이 시작되면 server에 연결 요청 > 연결이 되면 데이터 준비 및 전송

		Socket socket = null;
		String host = "192.168.0.41";
		int port = 5001;
		Scanner sc = new Scanner(System.in);
		try {
			// 소켓 객체를 ip와 port를 이용해서 생성하면 연결 요청하는것이다.
			socket = new Socket(host, port);

			// 요청이 수락되면 소켓을 통해서 데이터를 전송 : 소켓 내부의 스트림을 이용해서 전송
			// BufferedReader 데이터를 받겠다.
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

			while (true) {
				String msg = sc.nextLine();

				writer.write(msg);
				writer.newLine();
				writer.flush();

				if (msg.equals("quit")) {
					break;
				}
				// 스트림을 통해서 등어오는 문자열 읽기
				msg = reader.readLine();
				System.out.println("서버메세지 : " + msg);
			}

			System.out.println("클라이언트 종료");
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();

	}
}
