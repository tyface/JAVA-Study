package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ServerManager {
	//소켓리스트 저장
	//소켓이 들어오면 thread 생성
	//Thread 가 어떤일을 하냐???
	//전달 받은 소켓으로 부터 메시지를 받아서 , 리스트에 있는 모든 소켓에 뿌리기 
	
	
	private List<Socket> socketList;
	
	public ServerManager() {
		socketList = new ArrayList<Socket>();
	}
	
	public void add(Socket socket) {
		socketList.add(socket);
		//thread 생성 및 실행
//		Thread t1 = new ServerThread(socket);
//		t1.start();
		new ServerThread(socket).start();
		
	}
	//스레드가 list를 계속 사용해야 되기 때문에 멤버클래스로 선언
	class ServerThread extends Thread{
		//특정 소켓으로 부터 메시지를 받아서 리스트의 모든 소켓에 전달
		//클라이언트당 닉네임이 하나씩 존재 하기 때문에 
		//클라이언트당 하나씩 존재하는 thread의 멤버 변수로 nick 을 가진다.  
		private String nick = "이름없음";
		private Socket socket;
		public ServerThread(Socket socket) {
			this.socket = socket;
		}
		
		public void run() {
//			BufferedReader reader = null;
			ObjectInputStream in = null;
			try {
				in = new ObjectInputStream(socket.getInputStream());
				
				//소켓으로 부터 메시지를 읽어오는 부분
				while(true) {
					String msg = null;
					String outMsg = null;
					//문자열을 읽어왔으니.... 리스트가 가지고 있는 소켓에다가 전달
					System.out.println("1");
					Protocol p = (Protocol)in.readObject();
					System.out.println("2");
					
					
					//읽어온 메시지가 닉네임 변경이면 닉을 변경하고
					//메시지 전송이면 이전과 같이 동작(모든 소켓에 메시지 전달)
					//01##메시지    : 닉네임변경
					//02##메시지  : 채팅
					
					String type = p.getType();
					
					Map<String, Object> data = p.getData();
					
					if(type.equals("#01")) {
						//닉네임 변경
						outMsg = (String)data.get("nick");
						nick = outMsg;
						
					}else if(type.equals("#02")) {
						//메시지 전달
						outMsg = (String)data.get("msg");
	
						for(Socket s:socketList) {
							if(s == socket) {
								continue;
							}
							BufferedWriter writer =
									new BufferedWriter(new OutputStreamWriter(
											s.getOutputStream()));
							
							writer.write(nick + " : " + outMsg);
							writer.newLine();
							writer.flush();
						}
					}
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
