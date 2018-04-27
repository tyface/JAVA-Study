package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class MyFrame2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	public MyFrame2() {
		this.setTitle("내가만든 프레임");
		this.setSize(607, 471);

		// 패널 : 다른컴퍼넌트들을 포함할 컴포넌트\
		JPanel panel = new JPanel();

		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(443, 24, 111, 41);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(29, 24, 402, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(29, 89, 525, 237);
		panel.add(textArea);
	}
}
