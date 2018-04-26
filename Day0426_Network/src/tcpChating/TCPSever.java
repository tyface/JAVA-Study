package tcpChating;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPSever {
	static Socket SOCKET1 = null;
	static Socket SOCKET2 = null;

	public static void main(String[] args) {

		// 서버는 메시지를 받아서 상대방에게주는 동작을 동시에 진행 해야한다.
		// 서버는 각 소켓으로부터 메시지를 받아서 처리하는 기능이 병렬적으로 수행되어야 한다.
		ServerSocket severSocket = null;// "192.168.0.17"; //유진35 광민26 성재41 39도희 성지17

		try {
			severSocket = new ServerSocket(5000);
			System.out.println("연결 대기중...");
			SOCKET1 = severSocket.accept();
			System.out.println("연결1 완료");
			SOCKET2 = severSocket.accept();
			System.out.println("연결2 완료");

			Runnable r1 = () -> {
				toss(SOCKET1, SOCKET2);
			};

			Runnable r2 = () -> {
				toss(SOCKET2, SOCKET1);
			};

			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);

			t1.start();
			t2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	static void toss(Socket socket1, Socket socket2) {
		while (true) {
			try {
				socket1.getOutputStream().write(socket2.getInputStream().read());
				socket1.getOutputStream().flush();
			} catch (SocketException e) {
				try {
					socket1.close();
					socket2.close();
					break;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
