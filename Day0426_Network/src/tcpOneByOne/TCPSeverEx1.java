package tcpOneByOne;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSeverEx1 {
	public static void main(String[] args) {

		ServerSocket severSocket = null;// "192.168.0.17"; //35 광민26 성재41 39도희 성지17
		Socket socket = null;

		try {
			severSocket = new ServerSocket(5000);
			System.out.println("연결 대기중...");
			socket = severSocket.accept();
			System.out.println("연결 완료");
			
			Thread receiver = new Thread(new TCPReceiverThread(socket));
			Thread sender = new Thread(new TCPSenderThread(socket));
			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
