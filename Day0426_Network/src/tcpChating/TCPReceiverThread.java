package tcpChating;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class TCPReceiverThread implements Runnable {

	private Socket socket;

	public TCPReceiverThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// 소켓으로 부터 들어오는 데이터를 계속해서 출력
		BufferedReader reader = null;
		String msg = null;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				msg = reader.readLine();
				
				if (msg == null) {
					break;
				}
				System.out.println("상대방 : " + msg);
			}
		} catch (SocketException e) {
			System.out.println("상대방이 연결을 종료 하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					System.out.println("Receiver End");
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
