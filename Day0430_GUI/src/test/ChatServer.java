package test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {
	// 멀티 채팅 서버
	private ServerSocket severSocket; // 서버 소켓
	private Set<Socket> socketSet; // 접속자들의 소켓객체를 담을 SET변수
	private Socket socket; // 접속자들을 담을 소켓변수
	private int serverPort; // 서버 포트
	private BufferedWriter out;

	public ChatServer(int serverPort) { // 포트번호를 받아오는 생성자
		this.severSocket = null;
		this.socket = null;
		this.socketSet = new HashSet<Socket>();
		this.serverPort = serverPort;
		this.out = null;
	}

	public void runServer() { // 서버시작 메서드

		try {
			severSocket = new ServerSocket(serverPort); // 서버소켓 생성

			// 서버로의 접속을 계속 체크하면서 접속이 일어날경우 socketSet에 추가하고, 스레드를 만드는 반복문
			while (true) {
				socket = severSocket.accept(); // 대기 상태로 외부에서 서버로의 접속이 일어날때 실행된다
				System.out.println("연결 완료 : " + socket);
				socketSet.add(socket); // 소켓이 생성되면 socketSet에 추가
				System.out.println("현제 인원 : " + socketSet.size());

				Runnable run = () -> { // Runnable 선언
					sendAllMsg(socket); // toss 메서드 실행
				};

				Thread t1 = new Thread(run);
				t1.start(); // 스레드 시작
			} // while end

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 접속자의 소켓정보를 받고 현제 socketSet에 저장되어있는 모두에게 접속자의 메세지를 전달하는 메서드
	public void sendAllMsg(Socket socket) {
		ObjectInputStream in = null; // 리더
		ObjectOutputStream out = null;
		// BufferedWriter writer = null; // 라이터
		Protocol ptc;
		Socket temp; // 소켓을 담을 임시변수
		String nick = "이름없음";
		Iterator<Socket> it; // socketSet 모든 값에 접근하기위한 Iterator객체변수
		String outMsg;
		try {
			int i = 0;
			in = new ObjectInputStream(socket.getInputStream());
			while (true) {
				// 접속자의 메세지를 읽어오는 리더생성
				System.out.println("**2");
				ptc = (Protocol) in.readObject(); // 접속자의 메세지 한줄을 읽어옴
				System.out.println("**3");
				System.out.println(ptc.getData("msg"));
				switch (ptc.getType()) {
				case "#01":
					nick = ptc.getData("nick");
					break;
				case "#02":
					it = socketSet.iterator(); // socketSet을 Iterator로 변환
					System.out.println("**4");
					// Iterator 객체를 사용하는동안 변동이 없게하기위한 synchronized
					synchronized (it) { // TODO 확실하게 필요한지 잘 모르겠음..
						while (it.hasNext()) {
							temp = it.next(); // 소켓 객체를 임시변수에 삽입
							if (temp == socket) { // 메세지를 보낼때 접속자 본인에게는 메세지를 보내지 않게하기위한 조건문
								continue;
							}

							// 메세지를 보내기위한 라이터 생성
							System.out.println("**5");
							out = new ObjectOutputStream(temp.getOutputStream());

							// 메세지 보내기
							out.writeObject(ptc);
							out.flush();
							
						}
					}
					break;
				default:
					break;
				}

			}
		} catch (SocketException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ConcurrentModificationException e) {
			System.out.println("리스트 변경 오류");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					System.out.println("소켓 종료 : " + socket);
					socketSet.remove(socket); // socketSet에서 소켓 삭제
					System.out.println("현제 인원 : " + socketSet.size());
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
