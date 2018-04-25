package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {
	// 데이터를 받기위해서 데이터가 등어오는 통로인 DatagramSocket과 port설정
	// 키보드로부터 입력을 계속해서 받다가 quit를 입력받으면 종료
	private DatagramSocket socket;
	private DatagramPacket packet;
	Set<String> list;
	byte[] buf;
	int port;

	public ChatServer(int port) {
		this.port = port;
	}

	public void runServer() {
		try {
			socket = new DatagramSocket(port);
			packet = null;
			list = new HashSet<String>();
			while (true) {
				receivePacket();
				sendPacket();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void receivePacket() throws IOException {

		// 패킷준비하고 , socket으로 부터 데이터 받아오기
		System.out.println("데이터 수신 대기중...");
		buf = new byte[512];
		packet = new DatagramPacket(buf, buf.length);
		socket.receive(packet);

		list.add(packet.getAddress().getHostAddress());// 리시브 받은 정보의 ip를 저장

		System.out.println(packet.getAddress() + " : " + new String(buf).trim());

	}

	public void sendPacket() throws IOException {
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String ip = it.next();
			InetAddress ia = InetAddress.getByName(ip);
			//메세지앞에 해당 사용자의 ip붙이기
			String msg = "[" + packet.getAddress().getHostAddress() + "] : " + new String(buf).trim();
			buf = msg.getBytes();
			packet = new DatagramPacket(buf, buf.length, ia, 5000);
			// 소캣을 통해서 전송
			socket.send(packet);
		}
	}
}
