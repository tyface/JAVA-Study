package tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TcpServerEx2 {
	public static void main(String[] args) {
		// 연결요청을 받는쪽
		// 1.요청을 기다리다가 요청이 들어오면 수락(Socket생성) : ServerSocket
		// 2.소켓이 생성되면 메시지 보내기

		int port = 5000;
		Socket socket = null;
		try {
			// 요청을 받을 서버소켓 생성
			ServerSocket severSocket = new ServerSocket(port);
			// 요청 기다리기 및 요청 수락
			System.out.println("연결 대기중...");
			socket = severSocket.accept();
			System.out.println("연결 되었습니다.");

			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

			while (true) {
				String readMsg = reader.readLine();

				if (readMsg.equals("quit")) {
					break;
				}
				// 연결이 된 상태이므로 클라이언트에 인삿말 보내기
				writer.write(readMsg);
				writer.newLine();
				writer.flush();
			}

			System.out.println("서버가 종료 되었습니다.");
		} catch (SocketException e) {
			System.out.println("연결된 대상이 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
