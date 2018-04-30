package event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class MyFrame extends JFrame {
	// action : 요소에 일어나는 이벤트 처리 (처리, 글자바뀜, 포커스 발생/ 사라짐 등등)
	// KeyEvent : 키보드에서 일어나는 이벤트(키눌림, 올라옴 등등)
	// MouseEvent : 마우스에서 일어나는 이벤트(움직임, 클릭, 버튼 눔림, 버튼 떼짐 등등)
	private JButton btnEvent;
	private JTextField tfDollar;
	private JLabel lblResult;

	public MyFrame() {
		this.setTitle("이벤트 처리!!");
		this.setSize(512, 379);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		btnEvent = new JButton("이벤트 발생!!");
		btnEvent.setBounds(171, 241, 158, 53);
		panel.add(btnEvent);

		JLabel lblIntro = new JLabel("달러를 입력하세요");
		lblIntro.setFont(new Font("굴림", Font.PLAIN, 20));
		lblIntro.setBounds(14, 12, 191, 28);
		panel.add(lblIntro);

		tfDollar = new JTextField();
		tfDollar.setBounds(14, 52, 267, 39);
		panel.add(tfDollar);
		tfDollar.setColumns(10);

		lblResult = new JLabel("계산하세요.");
		lblResult.setFont(new Font("굴림", Font.PLAIN, 20));
		lblResult.setBounds(14, 103, 404, 28);
		panel.add(lblResult);
		this.setVisible(true);
		// 이벤트처리를 위해서는 컴포넌트에 Listener를 등록해 주어야 한다.
		// Action 이벤트를 처리하기 위해서는 ActionListener 를등록
		// Key 이벤트를 처리하기 위해서는 KeyListener 를등록
		// Mouse 이벤트를 처리하기 위해서는 MouseListener 를등록

		// 리스너 객체를 Listener 인터페이스의 구현클래스 객체를 넣어주면 된다.
		// 익명클래스로 Listener 인터페이스 구현해서 인자로 넘겨주기
		btnEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 여기에 btnEvent 버튼이 눌리면 동작할 코드를 작성
				// System.out.println("버튼 이벤트 발생");
				String dollar = tfDollar.getText();
				int dollarInt = Integer.parseInt(dollar);
				int result = dollarInt * 1067;

				lblResult.setText(result + "원 입니다.");

			}
		});

		tfDollar.addKeyListener(new MyKeyListener());

	}

	public static void main(String[] args) {
		MyFrame my = new MyFrame();

	}

	class MyKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// 키보드가 내려갔다가 올라왔을때 처리

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// 키보드가 눌렸을때 터리

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// 키보드가 올라왔을때 처리
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				String dollar = tfDollar.getText();
				int dollarInt = Integer.parseInt(dollar);
				int result = dollarInt * 1067;

				lblResult.setText(result + "원 입니다.");
			}
		}
	}

}
