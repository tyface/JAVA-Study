package tcp;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public static void main(String[] args) {
		// 연결요청을 받는쪽
		// 1.요청을 기다리다가 요청이 들어오면 수락(Socket생성) : ServerSocket
		// 2.소켓이 생성되면 메시지 보내기

		int port = 5000;

		try {
			// 요청을 받을 서버소켓 생성
			ServerSocket severSocket = new ServerSocket(port);
			// 요청 기다리기 및 요청 수락
			System.out.println("연결 대기중...");
			Socket socket = severSocket.accept();

			//연결이 된 상태이므로 클라이언트에 인삿말 보내기
			OutputStream out = socket.getOutputStream();
			
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			writer.write("서버에 접속되셨습니다.");
			writer.newLine();
			writer.flush();
			while(true) {
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
