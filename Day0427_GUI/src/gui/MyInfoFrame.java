package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MyInfoFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2473040907380867035L;
	private JTextField textField;

	public MyInfoFrame() {
		this.setSize(600, 400);
		getContentPane().setLayout(null);

		JButton button1 = new JButton("실행");
		button1.setBounds(460, 27, 92, 62);
		getContentPane().add(button1);

		textField = new JTextField();
		textField.setBounds(27, 27, 410, 62);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("라벨");
		lblNewLabel.setBounds(30, 0, 35, 25);
		getContentPane().add(lblNewLabel);

		this.setVisible(true);
	}
}
