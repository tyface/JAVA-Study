package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver {
	public static void main(String[] args) {
		// 데이터를 받기위해서 데이터가 등어오는 통로인 DatagramSocket과 port설정
		// 키보드로부터 입력을 계속해서 받다가 quit를 입력받으면 종료

		try {
			DatagramSocket socket = new DatagramSocket(5000);
			byte[] buf = null;
			DatagramPacket packet = null;

			// 5000포트로 들어오는 데이터를 계속 받으면 됨

			while (true) {
				// 패킷준비하고 , socket으로 부터 데이터 받아오기
				System.out.println("데이터 수신 대기중...");
				buf = new byte[512];
				packet = new DatagramPacket(buf, buf.length);

				socket.receive(packet);
				System.out.println(packet.getAddress() + " : " + new String(buf).trim());
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
