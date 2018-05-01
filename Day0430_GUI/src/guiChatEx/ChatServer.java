package guiChatEx;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ChatServer {
	// 멀티 채팅 서버
	private ServerSocket severSocket; // 서버 소켓
	private Set<Socket> socketSet; // 접속자들의 소켓객체를 담을 SET변수
	private Socket socket; // 접속자들을 담을 소켓변수
	private int serverPort; // 서버 포트

	public ChatServer(int serverPort) { // 포트번호를 받아오는 생성자
		this.severSocket = null;
		this.socket = null;
		this.socketSet = new HashSet<Socket>();
		this.serverPort = serverPort;
	}

	public void runServer() { // 서버시작 메서드
		ObjectOutputStream out;
		Protocol ptc = null;
		Map<String, Object> dataMap;
		try {
			severSocket = new ServerSocket(serverPort); // 서버소켓 생성
			ptc = new Protocol();
			// 서버로의 접속을 계속 체크하면서 접속이 일어날경우 socketSet에 추가하고, 스레드를 만드는 반복문
			while (true) {
				socket = severSocket.accept(); // 대기 상태로 외부에서 서버로의 접속이 일어날때 실행된다
				System.out.println("연결 완료 : " + socket);
				out = new ObjectOutputStream(socket.getOutputStream());
				ptc.setType("#00");
				dataMap = new HashMap<String, Object>();
				dataMap.put("msg", "채팅서버에 접속 셨습니다.");
				ptc.setData(dataMap);


				out.writeObject(ptc);
				out.flush();

				socketSet.add(socket); // 소켓이 생성되면 socketSet에 추가
				System.out.println("현제 인원 : " + socketSet.size());

				Runnable run = () -> { // Runnable 선언
					sendAllMsg(socket); // sendAllMsg 메서드 실행
				};

				Thread t1 = new Thread(run);
				t1.start(); // 스레드 시작
			} // while end

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Protocol join(Account ac) {
		Protocol ptc = new Protocol();
		ObjectIOManagement io = new ObjectIOManagement();
		Map<String, String> acList = io.getList();
		Map<String, Object> data = new HashMap<String, Object>();

		if (acList.get(ac.getId()) == null) {
			acList.put(ac.getId(), ac.getPass());
			io.pushList(acList);
			data.put("msg", "< 회원가입 완료 >");
		} else {
			data.put("msg", "< 중복된 ID입니다. >");
		}
		ptc.setType("#00");
		ptc.setData(data);
		return ptc;
	}

	public Protocol sign(Account ac) {
		Protocol ptc = new Protocol();
		ObjectIOManagement io = new ObjectIOManagement();
		Map<String, String> acList = io.getList();
		Map<String, Object> data = new HashMap<String, Object>();

		if (acList.get(ac.getId()) == null) {
			data.put("msg", "< 해당 ID가 존재하지 안습니다. >");
		} else if (!acList.get(ac.getId()).equals(ac.getPass())) {
			data.put("msg", "< PASSWORD가 일치하지 않습니다. >");
		} else {
			data.put("signOK", "< 로그인 되었습니다. >");
		}
		ptc.setType("#00");
		ptc.setData(data);
		return ptc;
	}

	// 접속자의 소켓정보를 받고 현제 socketSet에 저장되어있는 모두에게 접속자의 메세지를 전달하는 메서드
	public void sendAllMsg(Socket socket) {
		ObjectInputStream in = null; // 리더
		ObjectOutputStream out = null; // 라이터
		ObjectOutputStream tmpOut = null;
		Protocol ptc;
		Socket temp; // 소켓을 담을 임시변수
		Iterator<Socket> it; // socketSet 모든 값에 접근하기위한 Iterator객체변수
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			while (true) {
				// 접속자의 메세지를 읽어오는 리더생성

				ptc = (Protocol) in.readObject();

				switch (ptc.getType()) {
				case "#01":
					System.out.println("#01");
					ptc = join((Account) ptc.getData("join"));

					out.writeObject(ptc);
					out.flush();
					break;
				case "#02":
					System.out.println("#02");
					ptc = sign((Account) ptc.getData("sign"));

					out.writeObject(ptc);
					out.flush();
					break;
				case "#03":
					System.out.println("#03");
					it = socketSet.iterator(); // socketSet을 Iterator로 변환

					// Iterator 객체를 사용하는동안 변동이 없게하기위한 synchronized
					synchronized (it) { // TODO 확실하게 필요한지 잘 모르겠음..
						while (it.hasNext()) {
							temp = it.next(); // 소켓 객체를 임시변수에 삽입
							if (temp == socket) { // 메세지를 보낼때 접속자 본인에게는 메세지를 보내지 않게하기위한 조건문
								continue;
							}

							// 메세지를 보내기위한 라이터 생성
							tmpOut = new ObjectOutputStream(temp.getOutputStream());

							// 메세지 보내기
							tmpOut.writeObject(ptc);
							tmpOut.flush();
						}
					}
					break;
				default:
					System.out.println("default");
					break;
				}

			}
		} catch (EOFException e) {
			sendAllMsg(socket);
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
