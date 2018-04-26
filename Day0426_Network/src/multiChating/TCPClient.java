package multiChating;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {
	public static void main(String[] args) {

		Socket socket = null;
		String host = "192.168.0.87";
		int port = 5000;

		try {
			socket = new Socket(host, port);

			Thread receiver = new Thread(new TCPReceiverThread(socket));
			Thread sender = new Thread(new TCPSenderThread(socket));

			sender.start();
			receiver.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
