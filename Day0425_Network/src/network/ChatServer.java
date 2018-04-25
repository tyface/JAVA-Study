package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Iterator;

public class ChatServer {
	public static void main(String[] args) {
		// 데이터를 받기위해서 데이터가 등어오는 통로인 DatagramSocket과 port설정
		// 키보드로부터 입력을 계속해서 받다가 quit를 입력받으면 종료

		try {
			DatagramSocket socket = new DatagramSocket(5000);
			DatagramPacket packet = null;
			byte[] buf = null;

			HashSet<String> list = new HashSet<String>();
			// 5000포트로 들어오는 데이터를 계속 받으면 됨
			while (true) {
				// 패킷준비하고 , socket으로 부터 데이터 받아오기
				System.out.println("데이터 수신 대기중...");
				buf = new byte[512];
				packet = new DatagramPacket(buf, buf.length);

				socket.receive(packet);
				list.add(packet.getAddress().getHostAddress());// 리시브 받은 정보의 ip를 저장
				
				System.out.println(packet.getAddress() + " : " + new String(buf).trim());
				
				Iterator<String> it = list.iterator();
				while(it.hasNext()) {
					String ip = it.next();
					InetAddress ia = InetAddress.getByName(ip);
					// 패킷 생성
					packet = new DatagramPacket(buf, buf.length, ia, 5000);
					// 소캣을 통해서 전송
					socket.send(packet);
				}
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
