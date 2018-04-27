package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class EventFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JButton button;
	JToggleButton toggleButton;

	public EventFrame() {
		this.setTitle("이벤트처리");
		this.setSize(300, 400);
		JPanel panel = new JPanel();
		getContentPane().add(panel);

		button = new JButton("버튼");
		panel.add(button);

		toggleButton = new JToggleButton("토글버튼");
		panel.add(toggleButton);
		toggleButton.addActionListener(new MyActionListener());

		this.setVisible(true);
	}

	public static void main(String[] args) {
		EventFrame frame = new EventFrame();
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (toggleButton.isSelected()) {
				toggleButton.setText("눌림");
			} else {
				toggleButton.setText("안눌림");
			}

		}

	}

}
