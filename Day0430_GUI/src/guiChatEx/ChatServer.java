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
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class ChatServer {
	// 멀티 채팅 서버
	private ServerSocket severSocket; // 서버 소켓
	private int serverPort; // 서버 포트
	private Socket socket; // 접속자의 소켓을 담을 변수
	private Set<Socket> socketSet; // 소켓객체를 담을 SET변수

	private Map<ObjectOutputStream, Account> onlineUserMap; // 온라인중인 유저의 스트림과 계정정보를 저장할 Map

	public ChatServer(int serverPort) { // 포트번호를 받아오는 생성자
		this.severSocket = null;
		this.serverPort = serverPort;
		this.socket = null;
		this.socketSet = new HashSet<Socket>();
		this.onlineUserMap = new HashMap<ObjectOutputStream, Account>();
	}

	public void runServer() { // 서버시작 메서드

		try {
			severSocket = new ServerSocket(serverPort); // 서버소켓 생성

			// 서버로의 접속을 계속 체크하면서 접속이 일어날경우 socketSet에 추가하고, 스레드를 만드는 반복문
			while (true) {
				socket = severSocket.accept(); // 대기 상태로 외부에서 서버로의 접속이 일어날때 실행된다
				System.out.println("log : #Connenction  - " + socket);
				socketSet.add(socket); // 생성된 소켓을 socketSet에 추가
				System.out.println("log : #ConnTotalSize  - " + socketSet.size());

				Runnable run = () -> {
					serverTread(socket); // serverTread 메서드 실행
				};

				Thread t1 = new Thread(run);
				t1.start(); // 스레드 시작
			} // while end

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Account searchId(List<Account> accountList, String id) { // 계정리스트에서 해당 ID를 찾아서 계정을 반환하는 메서드
		Account result = null;

		for (int i = 0; i < accountList.size(); i++) {
			if (accountList.get(i).getId().equals(id)) { // 리스트에서 해당 인덱스의 ID가 파라미터 ID와 같을경우 결과값에 계정을 삽입
				result = accountList.get(i);
			}
		}

		return result;
	}

	public boolean onlineCheck(String id) { // ID를 받아 현제 접속자리스트중(onlineUserMap) 해당아이디가 있는지 검사 후 논리값 반환
		boolean result = false;

		for (Account accounts : onlineUserMap.values()) {
			if (accounts.getId().equals(id)) // 온라인유저맵에서 파라미터로 받아온 ID 있을경우 결과값에 ture삽입
				result = true;
		}

		return result;
	}

	public Protocol join(Account ac) { // 회원가입 메서드
		AccountDao dao = new AccountDao(); // 파일 입출력 매니져
		Protocol proc = new Protocol(); // 클라이언트에 보낼 프로토콜
		Map<String, Object> data = new HashMap<String, Object>(); // 프로토콜에 들어갈 데이터맵

		if (dao.seleteOne(ac.getId()) == null) { // ID가 존재하지 않을때 회원가입 진행
			dao.insertaccount(ac); // 리스트를 파일에 입력
			data.put("msg", "< 회원가입 완료 >");
		} else { // ID가 존재할 경우 메세지 전송
			data.put("msg", "< 중복된 ID입니다. >");
		}

		// 프로토콜 셋팅후 반환
		proc.setType("#join");
		proc.setData(data);
		return proc;

	}

	public Protocol sign(Account ac, ObjectOutputStream out) { // 로그인 메서드
		AccountDao dao= new AccountDao(); // 파일 입출력 매니져
		Protocol proc = new Protocol(); // 클라이언트에 보낼 프로토콜
		Map<String, Object> data = new HashMap<String, Object>(); // 프로토콜에 들어갈 데이터맵

		Account searchAccount = dao.seleteOne(ac.getId()); // 해당 ID를 찾아 searchAccount에 삽입, 없다면 null을 삽입

		if (searchAccount == null) { // 회원가입하기전 유효성 검사
			proc.setType("#signNot");
			data.put("msg", "< 해당 ID가 존재하지 안습니다. >");
		} else if (!searchAccount.getPass().equals(ac.getPass())) {
			proc.setType("#signNot");
			data.put("msg", "< PASSWORD가 일치하지 않습니다. >");
		} else if (onlineCheck(ac.getId())) {
			proc.setType("#signNot");
			data.put("msg", "< 현제 로그인중인 계정입니다. >");
		} else { // 유효성 검사가 이상없다면 회원가입 진행
			onlineUserMap.put(out, searchAccount); // 온라인유저맵에 현제 로그인 시도중인 계정과 스트림 저장
			proc.setType("#signOK");
			data.put("msg", "< 로그인 되었습니다. >");
		}

		proc.setData(data); // 데이터를 프로토콜에 삽입후 반환
		return proc;
	}

	public void sendOnlineUserList() throws IOException { // 접속중인 유저리스트를 접속중인 클라이언트에 보내는 메서드
		Protocol proc = new Protocol(); // 클라이언트에 보낼 프로토콜
		Map<String, Object> data = new HashMap<String, Object>(); // 프로토콜에 들어갈 데이터맵
		List<String> onlineUserList = new Vector<String>(); // 클라이언트에 보낼 유저리스트

		// onlineUserMap에서 접속중인 계정의 ID값만 뽑아 onlineUserList에 추가하는 반복문
		for (Account accounts : onlineUserMap.values()) {
			onlineUserList.add(accounts.getId());
		}

		// 클라이언트에 보낼 프로토콜 셋팅
		proc.setType("#onList");
		data.put("onList", onlineUserList);
		proc.setData(data);
		// onlineUserMap에서 스트림값만 뽑아와 iterator리스트 객체 생성
		Iterator<ObjectOutputStream> it = onlineUserMap.keySet().iterator();
		ObjectOutputStream out = null;

		while (it.hasNext()) { // 현제 접속중인 모든 클라이언트에 프로토콜 타입으로 유저리스트를 출력
			out = it.next();

			out.writeObject(proc);
			out.flush();
			out.reset();
		}

	}

	// 접속한 클라이언트의 소켓을 파라미터로 받아오는 서버 스레드 메소드
	public void serverTread(Socket socket) {
		ObjectOutputStream out = null; // 받아온 소켓의 아웃풋스트림
		ObjectInputStream in = null; // 받아온 소켓의 인풋스트림
		Protocol proc; // 클라이언트에 보낼 프로토콜
		Map<String, Object> dataMap; // 프로토콜에 들어갈 데이터맵

		try {

			// 접속한 클라이언트의 인풋아웃풋 스트림
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			// 접속 완료 메세지를 보낼 프로토콜 셋팅
			proc = new Protocol();
			proc.setType("#conn");
			dataMap = new HashMap<String, Object>();
			dataMap.put("msg", "< 채팅서버에 접속 하셨습니다 >");
			proc.setData(dataMap);

			// 접속 완료 메세지 전송
			out.writeObject(proc);
			out.flush();

			while (true) { // 클라이언트로부터 들어오는 프로토콜을 반복적으로 읽어내고 처리하는 반복문

				proc = (Protocol) in.readObject();

				switch (proc.getType()) { // 받아온 프로토콜 타입별로 내용을 처리하여 클라이언트에 결과 보내기
				case "#join": // 회원가입
					System.out.println("log : #join - " + socket);
					proc = join((Account) proc.getData("account"));

					out.writeObject(proc);
					out.flush();
					out.reset();
					break;
				case "#sign": // 로그인
					System.out.println("log : #sign - " + socket);
					proc = sign((Account) proc.getData("account"), out);

					out.writeObject(proc);
					out.flush();
					out.reset();

					// 로그인이 정상 처리되었을때만 온라인리스트를 접속중인 모든 클라이언트에 전송
					if (proc.getType().equals("#signOK")) {
						sendOnlineUserList();
					}
					break;
				case "#msg": // 메세지
					// 접속중인 모든 클라이언트의 스트림에 접속하기위한 Iterator 생성
					Iterator<ObjectOutputStream> it = onlineUserMap.keySet().iterator();

					synchronized (it) { // Iterator 객체를 사용하는동안 변동이 없게하기위한 synchronized
						ObjectOutputStream tmpOut = null;
						while (it.hasNext()) {
							tmpOut = it.next(); // it의 아웃풋 스트림은 임시변수에 삽입

							if (tmpOut == out) { // 메세지를 보낼때 접속자 본인에게는 메세지를 보내지 않게하기위한 조건문
								continue;
							}

							Protocol proc2 = new Protocol();// 클라이언트에 보낼 프로토콜 셋팅
							proc2.setType("#msg");
							dataMap = new HashMap<String, Object>();
							dataMap.put("msg", onlineUserMap.get(out) + " : " + proc.getData("msg"));
							proc2.setData(dataMap);

							tmpOut.writeObject(proc2);
							tmpOut.flush();
							tmpOut.reset();
						}
					}
					break;
				case "#exit": // 종료
					break;
				default: // 예외
					System.out.println("log : #Not Type");
					break;
				}

			}
		} catch (SocketException e) {
			System.out.println("log : #close socket - " + socket);
		} catch (EOFException e) {
			System.out.println("log : #Exception - 오브젝트 리드,라이트 오류");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("log : #Exception - 입출력 오류");
			e.printStackTrace();
		} catch (ConcurrentModificationException e) {
			System.out.println("log : #Exception - 리스트 변경 오류");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("log : #Exception - 형변환 오류");
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					onlineUserMap.remove(out);
					socketSet.remove(socket); // socketSet에서 소켓 삭제
					System.out.println("log : #ConnTotalSize - " + onlineUserMap.size());
					socket.close();
					sendOnlineUserList();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
