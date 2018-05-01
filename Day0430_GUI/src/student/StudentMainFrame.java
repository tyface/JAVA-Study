package student;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StudentMainFrame extends JFrame {
	private JTextField tfName;
	private JTextField tfTotal;
	private JTextField tfAvg;
	private JButton btnDetail;
	private JButton btnSelect;
	private JList<Student> studentJList;

	private Vector<Student> sList;
	// 학생리스트 보여주고 선택하여 기본정보를 보여주는 화면
	// 데이터: 학생리스트,

	public StudentMainFrame() {
		this.setTitle("학생정보");
		this.setSize(578, 465);

		setDefaultData();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		studentJList = new JList<Student>(sList);
		studentJList.setBounds(24, 32, 232, 343);
		studentJList.setSelectedIndex(0);
		panel.add(studentJList);
		
		btnDetail = new JButton("상세보기");
		btnDetail.setBounds(310, 325, 105, 27);
		panel.add(btnDetail);

		btnSelect = new JButton("점수보기");
		btnSelect.setBounds(429, 325, 105, 27);
		panel.add(btnSelect);

		btnSelect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = studentJList.getSelectedValue();

				tfName.setText(student.getName());
				tfTotal.setText(student.getTotal() + "");
				tfAvg.setText(student.getAverage() + "");

			}
		});

		tfName = new JTextField();
		tfName.setBounds(363, 30, 116, 24);
		panel.add(tfName);
		tfName.setColumns(10);

		tfTotal = new JTextField();
		tfTotal.setBounds(363, 66, 116, 24);
		panel.add(tfTotal);
		tfTotal.setColumns(10);

		tfAvg = new JTextField();
		tfAvg.setBounds(363, 102, 116, 24);
		panel.add(tfAvg);
		tfAvg.setColumns(10);

		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(298, 33, 51, 18);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("총점");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(298, 69, 51, 18);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("평균");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(298, 105, 51, 18);
		panel.add(lblNewLabel_2);

		this.setVisible(true);

	}

	public void setDefaultData() {
		sList = new Vector<Student>();
		sList.add(new Student("홍길동", 3, 90, 80, 70));
		sList.add(new Student("홍길동1", 4, 11, 22, 33));
		sList.add(new Student("홍길동2", 5, 44, 55, 66));
		sList.add(new Student("홍길동3", 6, 77, 88, 99));
	}

	public static void main(String[] args) {
		StudentMainFrame main = new StudentMainFrame();
	}

}
