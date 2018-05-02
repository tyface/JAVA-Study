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

public class ServerTread extends Thread{
	// 멀티 채팅 서버
	private ServerSocket severSocket; // 서버 소켓
	private Set<Socket> socketSet; // 접속자들의 소켓객체를 담을 SET변수
	private int serverPort; // 서버 포트
	private Socket socket;
	private Map<ObjectOutputStream, Account> onlineUserList;

	public ServerTread(int serverPort) { // 포트번호를 받아오는 생성자
		this.severSocket = null;
		this.socketSet = new HashSet<Socket>();
		this.serverPort = serverPort;
		this.onlineUserList = new HashMap<ObjectOutputStream, Account>();
	}

	public void run() { // 서버시작 메서드

		try {
			severSocket = new ServerSocket(serverPort); // 서버소켓 생성
			socket = null;
			// 서버로의 접속을 계속 체크하면서 접속이 일어날경우 socketSet에 추가하고, 스레드를 만드는 반복문
			while (true) {
				socket = severSocket.accept(); // 대기 상태로 외부에서 서버로의 접속이 일어날때 실행된다
				System.out.println("연결 완료 : " + socket);
				socketSet.add(socket); // 소켓이 생성되면 socketSet에 추가

				System.out.println("현제 인원 : " + socketSet.size());

				Runnable run = () -> { // Runnable 선언
					serverTread(socket); // sendAllMsg 메서드 실행
				};

				Thread t1 = new Thread(run);
				t1.start(); // 스레드 시작
			} // while end

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Account searchId(List<Account> acList, String id) {
		for (int i = 0; i < acList.size(); i++) {
			if (acList.get(i).getId().equals(id)) {
				return acList.get(i);
			}
		}
		return null;
	}

	public Protocol join(Account ac) {
		Protocol ptc = new Protocol();
		ObjectIOManagement io = new ObjectIOManagement();
		List<Account> acList = io.getList();
		Map<String, Object> data = new HashMap<String, Object>();

		if (searchId(acList, ac.getId()) == null) {
			acList.add(ac);
			io.pushList(acList);
			data.put("msg", "< 회원가입 완료 >");
		} else {
			data.put("msg", "< 중복된 ID입니다. >");
		}
		ptc.setType("#03");
		ptc.setData(data);
		return ptc;

	}

	public Protocol sign(Account ac, ObjectOutputStream out) {
		Protocol ptc = new Protocol();
		ObjectIOManagement io = new ObjectIOManagement();
		List<Account> acList = io.getList();
		Map<String, Object> data = new HashMap<String, Object>();

		Account searchAccount = searchId(acList, ac.getId());
		if (searchAccount == null) {
			ptc.setType("#03");
			data.put("msg", "< 해당 ID가 존재하지 안습니다. >");
		} else if (!searchAccount.getPass().equals(ac.getPass())) {
			ptc.setType("#03");
			data.put("msg", "< PASSWORD가 일치하지 않습니다. >");
		} else if (onlineCheck(ac.getId())) {
			ptc.setType("#03");
			data.put("msg", "< 현제 로그인중인 계정입니다. >");
		} else {
			ptc.setType("#00");
			data.put("signOK", "< 로그인 되었습니다. >");
			onlineUserList.put(out, searchAccount);
			List<String> onlineIdList = new Vector<String>();
			for (Account accounts : onlineUserList.values()) {
				onlineIdList.add(accounts.getId());
			}

			data.put("onList", onlineIdList);
		}
		ptc.setData(data);
		return ptc;
	}

	public void sendOnlineList() throws IOException {
		Protocol ptc = new Protocol();
		Map<String, Object> data = new HashMap<String, Object>();
		List<String> onlineIdList = new Vector<String>();
		Iterator<ObjectOutputStream> it = null;
		ObjectOutputStream out = null;

		for (Account accounts : onlineUserList.values()) {
			onlineIdList.add(accounts.getId());
		}

		ptc.setType("#05");
		data.put("onList", onlineIdList);
		ptc.setData(data);
		it = onlineUserList.keySet().iterator(); // socketSet을 Iterator로 변환

		synchronized (it) { // TODO 확실하게 필요한지 잘 모르겠음..

			while (it.hasNext()) {
				out = it.next(); // 소켓 객체를 임시변수에 삽입

				out.writeObject(ptc);
				out.flush();
				out.reset();
			}
		}

	}

	public boolean onlineCheck(String id) {
		for (Account accounts : onlineUserList.values()) {
			if (accounts.getId().equals(id))
				return true;
		}
		return false;
	}

	// 접속자의 소켓정보를 받고 현제 socketSet에 저장되어있는 모두에게 접속자의 메세지를 전달하는 메서드
	public void serverTread(Socket socket) {
		ObjectOutputStream out = null;
		ObjectOutputStream tmpOut = null;
		ObjectInputStream in = null; // 리더
		Map<String, Object> dataMap;
		Protocol ptc;
		Iterator<ObjectOutputStream> it; // socketSet 모든 값에 접근하기위한 Iterator객체변수
		try {

			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());

			ptc = new Protocol();
			ptc.setType("#conn");

			dataMap = new HashMap<String, Object>();
			dataMap.put("msg", "채팅서버에 접속 셨습니다.");
			ptc.setData(dataMap);
			dataMap.clear(); //TODO
			
			out.writeObject(ptc);
			out.flush();
			
			while (true) {
				// 접속자의 메세지를 읽어오는 리더생성

				ptc = (Protocol) in.readObject();

				switch (ptc.getType()) {
				case "#01":
					ptc = join((Account) ptc.getData("join"));

					out.writeObject(ptc);
					out.flush();
					break;
				case "#02":
					ptc = sign((Account) ptc.getData("sign"), out);
					sendOnlineList();
					out.writeObject(ptc);
					out.flush();
					break;
				case "#03":
					Protocol outPtc = new Protocol();
					it = onlineUserList.keySet().iterator(); // socketSet을 Iterator로 변환
					// Iterator 객체를 사용하는동안 변동이 없게하기위한 synchronized
					synchronized (it) { // TODO 확실하게 필요한지 잘 모르겠음..

						while (it.hasNext()) {
							tmpOut = it.next(); // 소켓 객체를 임시변수에 삽입
							if (tmpOut == out) { // 메세지를 보낼때 접속자 본인에게는 메세지를 보내지 않게하기위한 조건문
								continue;
							}
							dataMap.clear();
							dataMap.put("msg", onlineUserList.get(out) + " : " + ptc.getData("msg"));
							outPtc.setType("#03");
							outPtc.setData(dataMap);

							tmpOut.writeObject(outPtc);
							tmpOut.flush();
							tmpOut.reset();
						}
					}
					break;
				case "#06":
					System.out.println("#06");
					onlineUserList.remove(out);
					System.out.println("소켓 종료 : " + socket);
					socketSet.remove(socket); // socketSet에서 소켓 삭제
					System.out.println("현제 인원 : " + onlineUserList.size());
					socket.close();
					sendOnlineList();
					break;
				default:
					System.out.println("default");
					break;
				}

			}
		} catch (SocketException e) {
		} catch (EOFException e) {
			e.printStackTrace();
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
					System.out.println("finally");
					onlineUserList.remove(out);
					System.out.println("소켓 종료 : " + socket);
					socketSet.remove(socket); // socketSet에서 소켓 삭제
					System.out.println("현제 인원 : " + onlineUserList.size());
					socket.close();
					sendOnlineList();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
