package guiChatEx;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements KeyListener {

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
	private JTextField passField;
	private JLabel lblPass;
	private JButton btnSign;
	private JScrollPane scrollPane_1;
	private JLabel lblConnList;

	private Socket socket;
	private ObjectOutputStream out;
	private boolean isLogin;
	private JList<Account> onlineList;

	public ChatClient() {
		isLogin = false;
		this.setTitle("GUI 채팅");
		this.setSize(884, 582);
		new Vector<Account>();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnSend = new JButton("Send");
		btnSend.setBounds(765, 484, 75, 39);
		panel.add(btnSend);

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isLogin) {
					sendMsg();
				} else {
					textView.append("< 로그인후 이용해주세요 >\n");
				}
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

		lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(14, 12, 62, 18);
		panel.add(lblServerIp);

		btnConnect = new JButton("connect");
		btnConnect.setBounds(231, 8, 85, 27);
		panel.add(btnConnect);

		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeConnection();
			}
		});

		lblId = new JLabel("ID");
		lblId.setBounds(330, 12, 62, 18);
		panel.add(lblId);

		idField = new JTextField();
		idField.setBounds(354, 9, 116, 24);
		panel.add(idField);
		idField.setColumns(10);

		passField = new JTextField();
		passField.setBounds(539, 9, 116, 24);
		panel.add(passField);
		passField.setColumns(10);

		lblPass = new JLabel("pass");
		lblPass.setBounds(486, 12, 39, 18);
		panel.add(lblPass);

		btnJoin = new JButton("Join");
		btnJoin.setBounds(751, 8, 72, 27);
		panel.add(btnJoin);

		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				join();
			}
		});

		btnSign = new JButton("Sign");
		btnSign.setBounds(665, 8, 72, 26);
		panel.add(btnSign);

		btnSign.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isLogin) {
					textView.append("< 이미 로그인 되었습니다. >\n");
				} else {
					sign();
				}
			}
		});

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(630, 75, 210, 397);
		panel.add(scrollPane_1);

		onlineList = new JList<Account>();
		scrollPane_1.setViewportView(onlineList);

		lblConnList = new JLabel("접속자 리스트");
		lblConnList.setFont(new Font("굴림", Font.PLAIN, 17));
		lblConnList.setBounds(630, 48, 121, 24);
		panel.add(lblConnList);

		// ss
		this.setVisible(true);
	}

	private void makeConnection() {
		InetAddress ia = null;
		Protocol ptc = new Protocol();
		try {
			ia = InetAddress.getByName(textIP.getText());
			socket = new Socket(ia, 8000);
			out = new ObjectOutputStream(socket.getOutputStream());

			Thread receiver = new Thread(new TCPReceiverThread());
			receiver.start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendMsg() {
		try {
			String msg = textInput.getText();

			sendProtocol("#03", "msg", msg);

			textView.append("나 : " + msg + "\n");
			textInput.setText("");
		} catch (NullPointerException e) {
			if (socket == null) {
				System.out.println("채팅서버에 접속되어있지 않습니다.");
			} else {
				e.printStackTrace();
			}
		}

	}

	private void sendProtocol(String type, String key, Object data) {
		Protocol ptc;
		Map<String, Object> dataMap;
		try {
			ptc = new Protocol();
			ptc.setType(type);

			dataMap = new HashMap<String, Object>();
			dataMap.put(key, data);

			ptc.setData(dataMap);
			out.writeObject(ptc);
			out.flush();
		} catch (NullPointerException e) {
			if (socket == null) {
				System.out.println("채팅서버에 접속되어있지 않습니다.");
			} else {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void join() {
		Account account = null;
		try {
			String id = idField.getText();
			String pass = passField.getText();

			account = new Account();
			account.setId(id);
			account.setPass(pass);

			sendProtocol("#01", "join", account);

		} catch (NullPointerException e) {
			if (socket == null) {
				System.out.println("채팅서버에 접속되어있지 않습니다.");
			} else {
				e.printStackTrace();
			}
		}
	}

	public void sign() {
		Account account = null;
		try {
			String id = idField.getText();
			String pass = passField.getText();
			account = new Account();
			account.setId(id);
			account.setPass(pass);

			sendProtocol("#02", "sign", account);
		} catch (NullPointerException e) {
			if (socket == null) {
				System.out.println("채팅서버에 접속되어있지 않습니다.");
			} else {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMsg();
		}
	}

	class TCPReceiverThread implements Runnable {

		public void run() {
			// 소켓으로 부터 들어오는 데이터를 계속해서 출력
			ObjectInputStream in = null;
			String msg = null;
			Protocol ptc = null;

			try {
				in = new ObjectInputStream(socket.getInputStream());
				while (true) {
					System.out.println("**1");
					ptc = (Protocol) in.readObject();
					System.out.println("**2");
					if (ptc.getType().equals("#00")) {
						msg = (String) ptc.getData("signOK");
						isLogin = true;
						Vector<Account> onList = (Vector<Account>) ptc.getData("onList");
					} else {
						msg = (String) ptc.getData("msg");
					}
					textView.append(msg + "\n");
					
				}
			} catch (SocketException e) {
				System.out.println("채팅서버가 종료 되었습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
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
		ChatClient chatClient = new ChatClient();
	}
}
