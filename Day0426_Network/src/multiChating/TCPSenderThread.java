package multiChating;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPSenderThread implements Runnable {

	Socket socket;

	public TCPSenderThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		Scanner sc = new Scanner(System.in);
		BufferedWriter writer = null;
		String msg;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while (true) {
				// 키보드에서 입력받기
				msg = sc.nextLine();

				// 입력받은 문자열 writer 스트림으로 내보내기
				writer.write(msg);
				writer.newLine();
				writer.flush();
			}

		} catch (SocketException e) {
			System.out.println("상대방이 연결을 종료 하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					System.out.println("Sender Exit");
					writer.close();
					sc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
