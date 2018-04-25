package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UDPSenderThread implements Runnable {

	public void run() {
		// UDP방식으로 데이터를 보내는 프로그램
		// 목적지의 ip주소와 port번호가 필요하고 데이터를 DategramPacket 준비
		// IP와 port정보를 저장하고 데이터를 전송(데이터가 나가는 통로 : DatagramSocket)

		try {
			// UDP 방식에서 소켓은 DatagramSocket
			DatagramSocket socket = new DatagramSocket();
			// 데이터를 보낼목적지의 ip주소를 저장할 객체
			InetAddress ia = InetAddress.getByName("192.168.0.70");
			DatagramPacket packet = null;
			byte[] buf;
			Scanner sc = new Scanner(System.in);

			while (true) {
				String msg = sc.nextLine();

				if (msg.equals("quit")) {
					break;
				}

				buf = msg.getBytes();
				// 패킷 생성
				packet = new DatagramPacket(buf, buf.length, ia, 5000);
				// 소캣을 통해서 전송
				socket.send(packet);
			}

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
