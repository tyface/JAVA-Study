package mouseEvent;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MouseFrame extends JFrame implements MouseListener, ActionListener {
	JTextArea taMouse;
	JButton btnExit;

	public MouseFrame() {
		this.setTitle("마우스 이벤트");
		this.setSize(512, 379);
		this.setVisible(true);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		taMouse = new JTextArea();
		taMouse.setBounds(37, 34, 427, 191);
		panel.add(taMouse);

		btnExit = new JButton("New button");
		btnExit.setBounds(208, 262, 105, 27);
		panel.add(btnExit);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 마우스 클릭
		taMouse.append("마우스 클릭\n");
		taMouse.append("좌표 : " + e.getX() + "," + e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 마우스 버튼을 누르는 이벤트
		taMouse.append("마우스 프레스\n");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// 마우스 버튼을 때는 이벤트
		taMouse.append("마우스 릴리스\n");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 마우스가 컴포넌트 영역에 들어가는 이벤트
		taMouse.append("마우스 엔터..\n");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 마우스가 컴포넌트 영역에 빠져나가는 이벤트
		taMouse.append("마우스 엑시트..\n");
	}

	public static void main(String[] args) {
		MouseFrame mf = new MouseFrame();
	}
}
