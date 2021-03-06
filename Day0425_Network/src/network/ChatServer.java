package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServer implements Runnable {
	// 채팅서버
	private DatagramSocket socket; // 소켓
	private DatagramPacket packet; // 페킷
	private Set<InetAddress> ipSet; // 접속자들의 ip저장할 리스트
	private byte[] buf; // 버퍼
	private int serverPort; // 채팅서버의 리스브 포트
	private int sendPort; // send 받을곳의 포트
	private String myAdress;

	public ChatServer(int serverPort, int sendPort) {
		this.serverPort = serverPort;
		this.sendPort = sendPort;
	}

	public void run() {
		try {
			myAdress = InetAddress.getLocalHost().getHostAddress();
			socket = new DatagramSocket(serverPort); // 소켓생성(포트번호)
			packet = null; // 패킷 준비
			ipSet = new HashSet<InetAddress>(); // ip주소를 저장한 HashSet생성

			while (true) { // 서버무한 구동
				receive(); // 리시브
				send(); // 샌드
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			socket.close();
		}
	}

	public void receive() throws IOException { // 리시브 기능
		// 패킷준비하고 , socket으로 부터 데이터 받아오기
		System.out.println("데이터 수신 대기중...");
		buf = new byte[512]; // 버퍼 만들기
		packet = new DatagramPacket(buf, buf.length); // 버퍼 크기만큼의 데이터를 전송할 packet 생성
		socket.receive(packet); // 만들어둔 소켓에 packet틀??로 데이터를 받아옴

		ipSet.add(packet.getAddress());// packet에 있는정보중 inetAdress 정보를 ipSet에 저장

		System.out.println(packet.getAddress() + " : " + new String(buf).trim()); // 출력
	}

	public void send() throws IOException { // 센드 기능
		Iterator<InetAddress> it = ipSet.iterator(); // list가 set이기때문에 모든값에 접속하기 위해 Iterator 사용
		InetAddress ia;
		
		while (it.hasNext()) {
			ia = it.next(); // ia변수에 ia객체를 삽입

			if (!ia.getHostAddress().equals(myAdress)) { //보내는 IP가 자신의 IP가 아닐때만 send
				// 메세지앞에 해당 사용자의 ip붙이기
				String msg = "[" + packet.getAddress().getHostAddress() + "] : " + new String(buf).trim();
				buf = msg.getBytes(); // ip를 붙인 메세지를 다시 byte타입으로 변환
				packet = new DatagramPacket(buf, buf.length, ia, sendPort); // packet에 InetAddress객체를 넘겨주고 받을사람의 포트를 입력
				socket.send(packet);// 소캣을 통해서 전송
			}
		}
	}
}
