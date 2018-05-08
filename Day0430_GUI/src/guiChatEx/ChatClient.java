package guiChatEx;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements KeyListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextArea textView;
	private JButton btnSend;
	private JTextField textInput;
	private JScrollPane scrollPane;
	private JTextField textIP;
	private JLabel lblServerIp;
	private JButton btnConnect;
	private JLabel lblId;
	private JTextField idField;
	private JButton btnJoin;
	private JLabel lblPass;
	private JButton btnSign;
	private JScrollPane scrollPane_1;
	private JLabel lblConnList;
	private JPasswordField passField;
	private JList<Account> onlineList;

	private Socket socket; // 클라이언트 소켓
	private ObjectOutputStream out; // 출력 스트림
	private boolean isLogin; // 로그인 여부
	private boolean isConn; // 채팅서버 연결 여부
	private Vector<Account> onList; // 접속자 리스트

	public ChatClient() {
		this.socket = null;
		this.out = null;
		this.isLogin = false;
		this.isConn = false;
		this.onList = new Vector<Account>();

		///////////////////////////////////////////////////
		///////////////////////////////////////////////////
		// GUI TODO
		this.setTitle("GUI 채팅");
		this.setSize(884, 582);
		this.addWindowListener(this);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnSend = new JButton("Send");
		btnSend.setBounds(765, 484, 75, 39);
		panel.add(btnSend);

		btnSend.addActionListener(new ActionListener() { // send
			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});

		btnConnect = new JButton("connect");
		btnConnect.setBounds(231, 8, 85, 27);
		panel.add(btnConnect);

		btnConnect.addActionListener(new ActionListener() { // conn
			@Override
			public void actionPerformed(ActionEvent e) {
				makeConnection();
			}
		});

		btnJoin = new JButton("Join");
		btnJoin.setBounds(751, 8, 72, 27);
		panel.add(btnJoin);

		btnJoin.addActionListener(new ActionListener() { // join
			@Override
			public void actionPerformed(ActionEvent e) {
				sendJoin();
			}
		});

		btnSign = new JButton("Sign");
		btnSign.setBounds(665, 8, 72, 26);
		panel.add(btnSign);

		btnSign.addActionListener(new ActionListener() { // sign
			@Override
			public void actionPerformed(ActionEvent e) {
				sendSign();
			}
		});

		textInput = new JTextField();
		textInput.setBounds(14, 484, 737, 39);
		panel.add(textInput);
		textInput.setColumns(10);
		textInput.addKeyListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 45, 602, 427);
		panel.add(scrollPane);

		textView = new JTextArea();
		scrollPane.setViewportView(textView);

		textIP = new JTextField();
		textIP.setText("192.168.0.87");
		textIP.setBounds(90, 9, 127, 24);
		panel.add(textIP);
		textIP.setColumns(10);
		textIP.addKeyListener(this);

		lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(14, 12, 62, 18);
		panel.add(lblServerIp);

		lblId = new JLabel("ID");
		lblId.setBounds(330, 12, 25, 18);
		panel.add(lblId);

		idField = new JTextField();
		idField.setBounds(354, 9, 116, 24);
		panel.add(idField);
		idField.setColumns(10);
		idField.addKeyListener(this);

		
		lblPass = new JLabel("pass");
		lblPass.setBounds(486, 12, 39, 18);
		panel.add(lblPass);
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(630, 75, 210, 397);
		panel.add(scrollPane_1);

		onlineList = new JList<Account>(onList);
		scrollPane_1.setViewportView(onlineList);

		lblConnList = new JLabel("접속자 리스트");
		lblConnList.setFont(new Font("굴림", Font.PLAIN, 17));
		lblConnList.setBounds(630, 48, 121, 24);
		panel.add(lblConnList);

		passField = new JPasswordField();
		passField.setBounds(539, 9, 112, 24);
		panel.add(passField);
		passField.addKeyListener(this);

		this.setVisible(true);
		// End Gui TODO
		//////////////////////////////////////////////
	}

	private void makeConnection() { // 서버 연결 메서드
		InetAddress ia = null;

		try {
			if (isConn) {
				textView.append("< 이미 채팅서버에 접속되어 있습니다 >\n");
			} else {
				ia = InetAddress.getByName(textIP.getText()); // InetAddress 객체 생성
				socket = new Socket(ia, 8000); // 서버 접속
				out = new ObjectOutputStream(socket.getOutputStream()); // 출력스트림 생성

				Thread receiver = new Thread(new TCPReceiverThread()); // 리시버스레드
				receiver.start();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 프로토콜에 필요한 정보를 파라미터로 받아 서버에 출력하는 메서드
	private void sendProtocol(String type, String key, Object data) {
		Protocol proc; // 서버에 보낼 프로토콜
		Map<String, Object> dataMap; // 프로토콜에 들어갈 데이터맵

		try {
			// 프로토콜 세팅
			proc = new Protocol();
			proc.setType(type);
			dataMap = new HashMap<String, Object>();
			dataMap.put(key, data);
			proc.setData(dataMap);

			// 서버에 출력
			out.writeObject(proc);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sendMsg() { // 서버에 나의 채팅내용을 출력하는 메서드
		if (!isConn) { // 서버에 연결이 되어있다면 재연결 허용하지않음
			textView.append("< 채팅서버에 연결되어있지 않습니다 >\n");
		} else if (!isLogin) {
			textView.append("< 로그인후 이용해주세요 >\n");
		} else {
			String msg = textInput.getText(); // 텍스트 필드에 있는 내용을 가져옴

			sendProtocol("#msg", "msg", msg);

			textView.append("나 : " + msg + "\n");
			textInput.setText("");
		}
	}

	private void sendJoin() { // 회원가입 메서드
		Account account = null;

		String id = idField.getText(); // ID필드에 있는 값을 가져옴
		char[] pass = passField.getPassword(); // PASS 필드에 있는 값을 가져옴

		if (!isConn) {
			textView.append("< 채팅서버에 연결되어있지 않습니다 >\n");
			return;
		} else if (id.equals("")) {
			textView.append("< 아이디를 입력해주세요 >\n");
		} else if (pass.length == 0) {
			textView.append("< 비밀번호를 입력해주세요 >\n");
		} else {
			// Account 객체 생성후 id,password 셋팅
			account = new Account();
			account.setId(id);
			account.setPass(pass);

			sendProtocol("#join", "account", account);
		}
	}

	public void sendSign() { // 로그인 메서드
		Account account = null;
		String id = idField.getText(); // ID필드에 있는 값을 가져옴
		char[] pass = passField.getPassword(); // PASS 필드에 있는 값을 가져옴

		if (!isConn) {
			textView.append("< 채팅서버에 연결되어있지 않습니다 >\n");
		} else if (isLogin) {
			textView.append("< 이미 로그인 되었습니다. >\n");
		} else {
			// Account 객체 생성후 id,password 셋팅
			account = new Account();
			account.setId(id);
			account.setPass(pass);

			sendProtocol("#sign", "account", account);
		}
	}

	class TCPReceiverThread implements Runnable { // 리시브 스레드

		@SuppressWarnings("unchecked")
		public void run() {// 소켓으로 부터 들어오는 데이터를 계속해서 출력
			ObjectInputStream in = null; // 출력 스트림
			Protocol proc = null; // 프로토콜
			String msg = null;

			try {
				in = new ObjectInputStream(socket.getInputStream()); // 입력 스트림 생성

				while (true) {
					proc = (Protocol) in.readObject(); // 서버에서 들어오는 입력정보를 proc 변수에 삽입

					switch (proc.getType()) { // 프로토콜의 타입별로 처리하는 분기점
					case "#conn":
						msg = (String) proc.getData("msg");
						isConn = true;
						break;
					case "#signOK":
						msg = (String) proc.getData("msg");
						isLogin = true;
						onList = (Vector<Account>) proc.getData("onList");
						break;
					case "#onList":
						onList = (Vector<Account>) proc.getData("onList");
						onlineList.setListData(onList);
						continue;
					case "#join":
					case "#signNot":
					case "#msg":
						msg = (String) proc.getData("msg");
						break;
					default:
						System.out.println("프로토콜 타입 : " + proc.getType());
						break;
					}

					textView.append(msg + "\n");
				}
			} catch (EOFException e) {
			} catch (SocketException e) {
				System.out.println("채팅서버가 종료 되었습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						System.out.println("Sender Exit");
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient(); // 클라이언트 실행
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (textInput.isFocusOwner()) {
				sendMsg();
			} else if (textIP.isFocusOwner()) {
				makeConnection();
			} else if (idField.isFocusOwner() || passField.isFocusOwner()) {
				sendSign();
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {

		sendProtocol("#exit", "exit", "클라이언트종료");
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}
