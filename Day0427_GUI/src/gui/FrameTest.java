package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest {
	// 예제 : 기본창 생성해보기
	// Swing의 컴포넌트들은 J~~~~~라는 이름을 가진다
	public static void main(String[] args) {
		// 전부 객체이기 때문에 생성자를 호출하면 요소를 만들 수 있음
		JFrame frame = new JFrame("Hello GUI");
		frame.setSize(600, 600);
		frame.setLayout(new GridLayout(2, 2));

		JButton button = new JButton("버튼1");
		JButton button2 = new JButton("버튼2");
		JButton button3 = new JButton("버튼3");
		JButton button4 = new JButton("버튼4");

		frame.add(button);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.setVisible(true); // 화면에 출력
		frame.setAlwaysOnTop(true); // 항상위로
		frame.setResizable(false); // 창크기 변경여부
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버튼을 눌렀을때의 기능

	}

}
