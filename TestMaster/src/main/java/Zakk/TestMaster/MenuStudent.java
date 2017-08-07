package Zakk.TestMaster;

import java.awt.Desktop;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuStudent extends JFrame {

	private static final long serialVersionUID = 1L;

	Desktop d = Desktop.getDesktop();

	private JLabel l_fon;
	private JLabel l_Nazva;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_5;

	public MenuStudent(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		l_Nazva = new JLabel("Меню Учня");
		l_Nazva.setHorizontalAlignment(SwingConstants.CENTER);
		l_Nazva.setFont(new Font("Monotype Corsiva", Font.PLAIN, 90));
		l_Nazva.setBounds(486, 13, 496, 137);
		getContentPane().add(l_Nazva);

		button = new JButton("Тести");
		button.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button.setBounds(596, 200, 315, 40);
		getContentPane().add(button);

		button_1 = new JButton("Рейтинги");
		button_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_1.setBounds(596, 241, 315, 40);
		getContentPane().add(button_1);

		button_2 = new JButton("Домашні завдання");
		button_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_2.setBounds(596, 323, 315, 40);
		getContentPane().add(button_2);

		button_3 = new JButton("Розклад");
		button_3.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_3.setBounds(596, 282, 315, 40);
		getContentPane().add(button_3);

		button_5 = new JButton("Заходи");
		button_5.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_5.setBounds(596, 364, 315, 40);
		getContentPane().add(button_5);

		l_fon = new JLabel("");
		l_fon.setVerticalAlignment(SwingConstants.TOP);
		l_fon.setIcon(new ImageIcon("res/fon/MenuStudent.jpg"));
		l_fon.setBounds(0, 0, 994, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
