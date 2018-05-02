package chatProtocol;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TCPChatClient extends JFrame {
	// 클라이언트에서 할일
	// 화면그리기
	// 각 컴퍼넌트간에 이벤트 처리하기
	// 서버에서 들어오는 메시지 처리하기

	// 멤버변수
	// 서버와 통신을 유지하기 위해서 socket
	// 이벤트 처리 등을 위한 각종 컴퍼넌트
	// 데이터 송/수신을 Stream
	// 데이터 송신을 할 Protocol 객체

	////////// 프로그램 실행에 필요한 상수 선언
	// 클라이언트 별로 가져야 할 필요가 없고(static), 변경이 되면 안됨(final)
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	////////////////////////////////////
	private Socket socket; // 서버와 통신을 위한 socket
	private Protocol p; // 서버와 통신할 때 데이터를 담아서 보낼 객체
	private ObjectInputStream in;
	private ObjectOutputStream out;

	///////////////// 컴퍼넌트 멤버변수 선언
	private JScrollPane scrollPane;
	private JTextArea messageTextArea; // 채팅 내용이 표시 될 textArea
	private JTextField messageTextField;
	private JButton sendBtn;
	private JTextField nickTextField;
	private JButton nickBtn;
	private JLabel nickResultLabel;
	public static void main(String[] args) {
		TCPChatClient client = new TCPChatClient();
	}

	public TCPChatClient() {

		this.setSize(445, 418);

		getConnection();
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER); // Frame의 중앙에 panel 붙이기
		panel.setLayout(null); // panel의 layout 지정, 컴퍼넌트들을 자유롭게 배치가능

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 265, 314);
		panel.add(scrollPane);

		messageTextArea = new JTextArea();
		scrollPane.setViewportView(messageTextArea);

		messageTextField = new JTextField();
		messageTextField.setBounds(12, 334, 265, 36);
		panel.add(messageTextField);
		messageTextField.setColumns(10);

		sendBtn = new JButton("전 송");
		sendBtn.setBounds(305, 334, 112, 36);

		sendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// messageTextfield에 있는 메시지를
				// Protocol 객체에 담아서 전송
				try {

					p = new Protocol();
					p.setType(2100); // 내가 보내는 객체는 채팅내용이다.
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("message", messageTextField.getText());
					p.setData(data);
					out.writeObject(p);

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(sendBtn);

		nickTextField = new JTextField();
		nickTextField.setBounds(287, 12, 130, 21);
		panel.add(nickTextField);
		nickTextField.setColumns(10);

		nickBtn = new JButton("닉네임 변경");
		nickBtn.setBounds(289, 43, 128, 23);
		nickBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					p = new Protocol();
					p.setType(2200); // 내가 보내는 객체는 채팅내용이다.
					Map<String, Object> data = new HashMap<String, Object>();
					data.put("nick", nickTextField.getText());
					p.setData(data);
					out.writeObject(p);
					out.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(nickBtn);
		
		nickResultLabel = new JLabel("");
		nickResultLabel.setBounds(289, 76, 128, 15);
		panel.add(nickResultLabel);

		this.setVisible(true);
	}

	public void getConnection() {
		// 서버에 연결요청하는 메서드
		// 서버IP, Port가 필요함
		try {
			this.socket = new Socket(SERVER_IP, SERVER_PORT);

			// 연결 후, 서버로부터 들어오는 메시지를 처리하기 위한
			// 스레드를 생성해주어야 한다. >>스레드 선언

			out = new ObjectOutputStream(socket.getOutputStream());

			Thread t1 = new Thread(new ClientReceiveThread());
			t1.start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 고정값이니까... 상수로 고정

	}

	// 스레드 :ClientReceiveThread, 서버로 부터 들어오는 메시지를 확인하고,
	// 채팅 메시지이면 클라이언트가 가지고 있는 textArea에 추가 해주어야 한다.
	// >>> 스레드에서 클라이언트 멤버 변수에 접근 가능해야 한다.
	// >> 내부클래스로 선언하면 쉽게 작성할 수 있다.

	class ClientReceiveThread implements Runnable {
		Protocol inProtocol = null;

		ObjectInputStream in = null;

		public void run() {
			// 소켓으로 부터 들어오는 메시지를 확인하고 처리
			// 소켓으로 부터 들어오는 메시지는 객체일거니까...
			try {

				while (true) {
					in = new ObjectInputStream(socket.getInputStream());
					// System.out.println("메시지 수신대기..." );
					inProtocol = (Protocol) in.readObject();
					// System.out.println("메시지 수신 : " + inProtocol.getType());
					checkProtocol(inProtocol);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void checkProtocol(Protocol p) {
			if (p.getType() == 1100) {
				// 채팅 메시지가 수신된것
				// Map을 반환하는 getData()
				Map<String, Object> data = p.getData();
				messageTextArea.append(data.get("message") + "\n");

			} else if (p.getType() == 1200) {
				nickResultLabel.setText((String)p.getData().get("result"));
			}
		}
	}
}
