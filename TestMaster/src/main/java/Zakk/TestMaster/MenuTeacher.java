package Zakk.TestMaster;

import java.awt.Desktop;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuTeacher extends JFrame {

	private static final long serialVersionUID = 1L;

	Desktop d = Desktop.getDesktop();

	private JLabel l_fon;
	private JLabel l_Nazva;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;

	public MenuTeacher(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		l_Nazva = new JLabel("Меню Учителя");
		l_Nazva.setHorizontalAlignment(SwingConstants.CENTER);
		l_Nazva.setFont(new Font("Monotype Corsiva", Font.PLAIN, 90));
		l_Nazva.setBounds(12, 0, 970, 137);
		getContentPane().add(l_Nazva);

		button = new JButton("Створення тестів");
		button.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button.setBounds(362, 150, 315, 40);
		getContentPane().add(button);

		button_1 = new JButton("Перегляд тестів");
		button_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_1.setBounds(362, 191, 315, 40);
		getContentPane().add(button_1);

		button_2 = new JButton("Рейтинги");
		button_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_2.setBounds(362, 273, 315, 40);
		getContentPane().add(button_2);

		button_3 = new JButton("Результати");
		button_3.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_3.setBounds(362, 232, 315, 40);
		getContentPane().add(button_3);

		button_4 = new JButton("Заходи");
		button_4.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_4.setBounds(362, 355, 315, 40);
		getContentPane().add(button_4);

		button_5 = new JButton("Розклад");
		button_5.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		button_5.setBounds(362, 314, 315, 40);
		getContentPane().add(button_5);

		l_fon = new JLabel("");
		l_fon.setIcon(new ImageIcon("res/fon/MenuTeacher.jpg"));
		l_fon.setBounds(0, 0, 994, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
