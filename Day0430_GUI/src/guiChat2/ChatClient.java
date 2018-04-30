package guiChat2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel lblNick;
	private JTextField NickField;
	private JButton btnNickSave;

	private Socket socket;
	 private BufferedWriter writer;

	public ChatClient() {
		this.setTitle("GUI 채팅");
		this.setSize(512, 379);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnSend = new JButton("Send");
		btnSend.setBounds(405, 281, 75, 39);
		panel.add(btnSend);

		btnSend.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sendMsg();
			}
		});

		textInput = new JTextField();
		textInput.setBounds(14, 281, 377, 39);
		panel.add(textInput);
		textInput.setColumns(10);
		textInput.addKeyListener(this);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 12, 308, 257);
		panel.add(scrollPane);

		textView = new JTextArea();
		scrollPane.setViewportView(textView);

		textIP = new JTextField();
		textIP.setText("192.168.0.87");
		textIP.setBounds(336, 143, 144, 24);
		panel.add(textIP);
		textIP.setColumns(10);

		lblServerIp = new JLabel("Server IP");
		lblServerIp.setBounds(336, 113, 62, 18);
		panel.add(lblServerIp);

		btnConnect = new JButton("connect");
		btnConnect.setBounds(336, 179, 105, 27);
		panel.add(btnConnect);

		lblNick = new JLabel("닉네임");
		lblNick.setBounds(336, 15, 62, 18);
		panel.add(lblNick);

		NickField = new JTextField();
		NickField.setBounds(336, 39, 116, 24);
		panel.add(NickField);
		NickField.setColumns(10);

		btnNickSave = new JButton("닉네임 저장");
		btnNickSave.setBounds(336, 75, 116, 24);
		panel.add(btnNickSave);

		btnNickSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendNick();
			}
		});

		btnConnect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				makeConnection();
			}
		});

		// ss
		this.setVisible(true);
	}

	private void makeConnection() {
		InetAddress ia = null;
		try {
			ia = InetAddress.getByName(textIP.getText());
			socket = new Socket(ia, 8000);
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

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
			writer.write("02##" + msg);
			writer.newLine();
			writer.flush();

			textView.append("나 : " + msg + "\n");
			textInput.setText("");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			if (socket == null) {
				System.out.println("채팅서버에 접속되어있지 않습니다.");
			} else {
				e.printStackTrace();
			}
		}

	}

	private void sendNick() {

		try {
			String msg = NickField.getText();

			writer.write("01##" + msg);
			writer.newLine();
			writer.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			BufferedReader reader = null;
			String msg = null;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					msg = reader.readLine();

					textView.append(msg + "\n");
				}
			} catch (SocketException e) {
				System.out.println("상대방이 연결을 종료 하였습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null) {
						System.out.println("Sender Exit");
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		ChatClient mf = new ChatClient();
	}
}
