package test2;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TCPChatServer {
	// 클라이언트로 부터 들어오는 요청을 받아들여서
	// 소켓생성하고, 각 소켓별로 스레드 하나씩 생성하기
	// 소켓리스트를 하나가지면서 각 클라이언트들에게 메시지를 전달

	public static void main(String[] args) {
		// 서버 소켓 열어놓고, 기다리다가 연결요청들어오면, 소켓 리스트에 추가
		ServerSocket serverSocket = null;
		TCPChatManager manager = new TCPChatManager();

		try {
			serverSocket = new ServerSocket(5000);

			while (true) {
				Socket socket = serverSocket.accept();

				manager.addSocket(socket);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class TCPChatManager {

	public TCPChatManager() {
		socketList = new ArrayList<Socket>();
	}

	private List<Socket> socketList; // 연결된 클라이언트의 소켓 리스트
	
	ObjectOutputStream out = null;
	// 연결요청이 들어오면, 소켓을 생성해서 socketList에 추가하고
	// 각 소켓별로 스레드 생성하기
	// - 각 클라이언트로 부터 들어오는 메시지를 수신하는 스레드 :
	// 각 소켓별로 하나씩 생성, 소켓이 생성될 때..

	public void addSocket(Socket socket) {
		socketList.add(socket);

		Thread t = new Thread(new ServerReceiveThread(socket));
		t.start();
	}

	class ServerReceiveThread implements Runnable {
		private Socket socket;
		private String clientId = "anonymous";
		
		
		public ServerReceiveThread(Socket socket) {
			this.socket = socket;
			
		}

		public void checkProtocol(Protocol p) throws IOException {
			
			if (p.getType() == 2100) {
				// 채팅 메시지 모든 소켓 리스트에 메시지 전달
				// 프로토콜 만들어서 모든 소켓 리스트에 전달

				Protocol outProtocol = new Protocol();

				outProtocol.setType(1100);
				
				String msg = clientId+":"+(String)(p.getData().get("message"));
				
				//Map<String, Object> data = p.getData();				
				outProtocol.getData().put("message", msg);
				//outProtocol.setData(data);

				for (Socket tmpSocket : socketList) {
					if (tmpSocket == socket) {
						continue;
					}
					
					out = new ObjectOutputStream(tmpSocket.getOutputStream());
					out.writeObject(outProtocol);
					out.flush();
				}
			}else if(p.getType() == 2200) {
				//닉네임 변경
				clientId = (String)p.getData().get("nick");
				
				Protocol outProtocol = new Protocol();
				outProtocol.setType(1200);
				//Map<String, Object> data = p.getData();				
				outProtocol.getData().put("result", "변경 성공하였습니다.");
//				out = new ObjectOutputStream(socket.getOutputStream());
				out.writeObject(outProtocol);
				out.flush();
			}
		}

		public void run() {
			// 반복하면서, 클라이언트로 부터 메시지가 들어오면
			// 메시지가 무엇인지 확인하고, 메시지 타입에 맞게 기능 실행
			// 메시지는 ObjectStream으로 들어올거기 때문에...

			try {
				ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
				Protocol p = null;
				while (true) {
					p = (Protocol) in.readObject();
					// System.out.println("p type : " + p.getType());
					// System.out.println("data :" + p.getData());
					checkProtocol(p);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
