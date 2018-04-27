package multiChating;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {

	ServerSocket severSocket = null;
	Set<Socket> socketSet = new HashSet<Socket>();
	Socket socket = null;

	public void runServer() {

		// 서버는 메시지를 받아서 상대방에게주는 동작을 동시에 진행 해야한다.
		// 서버는 각 소켓으로부터 메시지를 받아서 처리하는 기능이 병렬적으로 수행되어야 한다.
		// "192.168.0.17"; //유진35 광민26 성재41 39도희 성지17

		try {
			severSocket = new ServerSocket(5000);

			while (true) {
				socket = severSocket.accept();
				socketSet.add(socket);

				Runnable run = () -> {
					toss(socket);
				};

				Thread t1 = new Thread(run);
				t1.start();

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void toss(Socket socket) {

		while (true) {
			Iterator<Socket> it;
			Socket temp;
			BufferedReader reader = null;
			BufferedWriter writer = null;
			String msg;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				msg = reader.readLine();
				it = socketSet.iterator();
				synchronized (it) {
					while (it.hasNext()) {
						temp = it.next();
						if (temp == socket) {
							continue;
						}
						writer = new BufferedWriter(new OutputStreamWriter(temp.getOutputStream()));
						writer.write(msg);
						writer.newLine();
						writer.flush();
					}
				}
			} catch (SocketException e) {
				System.out.println("소켓 종료");
				try {
					socket.close();
					break;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ConcurrentModificationException e) {
				System.out.println("리스트 변경");
				continue;
			}
		}
	}

}
