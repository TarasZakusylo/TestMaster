package Zakk.TestMaster;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Formatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReectraciaStudent extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel label_NazvaVikna;
	private JLabel label_Password;
	private JPasswordField passwordField_Password;
	private JButton button_Nazad;
	private JLabel label_PIP;
	private JTextField textField_PIP;
	private JLabel label_email;
	private JTextField textField_mail;
	private JButton button_Gotovo;
	private JLabel l_fon;
	private JLabel l_RikVstupu;
	private Choice c_RikVstupu;
	private Choice c_Status;
	private JLabel l_Status;

	public ReectraciaStudent(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		label_NazvaVikna = new JLabel("Реєстрація");
		label_NazvaVikna.setForeground(new Color(0, 0, 0));
		label_NazvaVikna.setBounds(523, 13, 442, 88);
		label_NazvaVikna.setFont(new Font("Monotype Corsiva", Font.PLAIN, 55));
		label_NazvaVikna.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_NazvaVikna);

		label_Password = new JLabel("Пароль");
		label_Password.setForeground(new Color(0, 0, 0));
		label_Password.setBounds(533, 105, 208, 29);
		label_Password.setHorizontalAlignment(SwingConstants.CENTER);
		label_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		getContentPane().add(label_Password);

		passwordField_Password = new JPasswordField();
		passwordField_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		passwordField_Password.setBounds(533, 158, 208, 33);
		passwordField_Password.setToolTipText("");
		passwordField_Password.setText("1");
		getContentPane().add(passwordField_Password);

		button_Nazad = new JButton("Назад");
		button_Nazad.setForeground(Color.BLACK);
		button_Nazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AvtorStudent("TestMaster");
				setVisible(false);
			}
		});
		button_Nazad.setBounds(538, 442, 203, 36);
		button_Nazad.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		getContentPane().add(button_Nazad);

		label_PIP = new JLabel("Ім'я та Прізвище");
		label_PIP.setForeground(new Color(0, 0, 0));
		label_PIP.setBounds(533, 211, 208, 29);
		label_PIP.setHorizontalAlignment(SwingConstants.CENTER);
		label_PIP.setFont(new Font("Palatino Linotype", Font.PLAIN, 26));
		getContentPane().add(label_PIP);

		textField_PIP = new JTextField();
		textField_PIP.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		textField_PIP.setBounds(533, 263, 208, 33);
		textField_PIP.setToolTipText("");
		textField_PIP.setText("1");
		textField_PIP.setColumns(10);
		getContentPane().add(textField_PIP);

		label_email = new JLabel("e-mail");
		label_email.setForeground(new Color(0, 0, 0));
		label_email.setBounds(776, 105, 208, 29);
		label_email.setHorizontalAlignment(SwingConstants.CENTER);
		label_email.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		getContentPane().add(label_email);

		textField_mail = new JTextField();
		textField_mail.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		textField_mail.setBounds(776, 158, 208, 33);
		textField_mail.setToolTipText("");
		textField_mail.setText("1");
		getContentPane().add(textField_mail);

		button_Gotovo = new JButton("Готово");
		button_Gotovo.setForeground(Color.BLACK);
		button_Gotovo.setBounds(776, 442, 208, 36);
		button_Gotovo.addActionListener(new ActionListener() {

			private String s_Password;
			private String s_PIP;
			private String s_mail;
			private String s_RikVstupu;

			private Formatter formatter_reestracia;
			private String s_reestracia;

			private int i_korektnist = 0;
			private int i_korektnist1 = 0;
			private String s_Status;

			@SuppressWarnings("deprecation")

			public void actionPerformed(ActionEvent arg0) {

				s_Password = passwordField_Password.getText();
				s_PIP = textField_PIP.getText();
				s_mail = textField_mail.getText();
				s_RikVstupu = c_RikVstupu.getSelectedItem();
				s_Status = c_Status.getSelectedItem();

				File file = new File("res/AvtoruzaciaStudent/" + s_mail + ".txt");

				if (file.exists()) {
					JOptionPane.showMessageDialog(null, "Уже зареєстрований користувач під даним логіном");
				} else {

					int blockCount = s_PIP.split(" ").length;

					if (blockCount != 2) {
						JOptionPane.showMessageDialog(null, "Некоректне ім'я чи прізвище");
					} else {
						char[] chars = s_PIP.toCharArray();
						for (int i = 0; i < chars.length; i++) {
							try {
								if (chars[i] == '1' || chars[i] == '0' || chars[i] == '(' || chars[i] == ')'
										|| chars[i] == '+' || chars[i] == '=' || chars[i] == '/' || chars[i] == '.'
										|| chars[i] == ',') {
									i_korektnist++;
								}
							} catch (Exception e) {
							}
						}
						char[] chars1 = s_mail.toCharArray();
						for (int i = 0; i < chars1.length; i++) {
							try {
								if (chars1[i] == '@') {
									i_korektnist1 = 1;
								}
							} catch (Exception e) {
							}
						}
						if (i_korektnist == 0 && i_korektnist1 == 1) {

							try {
								formatter_reestracia = new Formatter("res/AvtoruzaciaStudent/" + s_mail + ".txt");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "System Error");
							}

							s_reestracia = s_Password + " " + s_PIP + " " + s_RikVstupu + " " +  s_Status;

							formatter_reestracia.format(s_reestracia);
							formatter_reestracia.close();

							JOptionPane.showMessageDialog(null, "Зареєстровано");
							new AvtorStudent("TestMaster");
							setVisible(false);

						} else {
							JOptionPane.showMessageDialog(null, "Перевірте введення");
						}
						i_korektnist = 0;

					}
				}

			}
		});
		button_Gotovo.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		getContentPane().add(button_Gotovo);

		l_Status = new JLabel("Статус");
		l_Status.setHorizontalAlignment(SwingConstants.CENTER);
		l_Status.setForeground(new Color(0, 0, 0));
		l_Status.setFont(new Font("Palatino Linotype", Font.PLAIN, 26));
		l_Status.setBounds(776, 211, 208, 29);
		getContentPane().add(l_Status);

		c_Status = new Choice();
		c_Status.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		c_Status.setBounds(776, 263, 208, 33);
		getContentPane().add(c_Status);
		c_Status.add("Учень");
		c_Status.add("Студент");

		l_RikVstupu = new JLabel("Рік вступу");
		l_RikVstupu.setHorizontalAlignment(SwingConstants.CENTER);
		l_RikVstupu.setForeground(new Color(0, 0, 0));
		l_RikVstupu.setFont(new Font("Palatino Linotype", Font.PLAIN, 26));
		l_RikVstupu.setBounds(615, 321, 290, 29);
		getContentPane().add(l_RikVstupu);

		c_RikVstupu = new Choice();
		c_RikVstupu.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		c_RikVstupu.setBounds(642, 373, 231, 33);
		getContentPane().add(c_RikVstupu);
		c_RikVstupu.add("2005");
		c_RikVstupu.add("2006");
		c_RikVstupu.add("2007");
		c_RikVstupu.add("2008");
		c_RikVstupu.add("2009");
		c_RikVstupu.add("2010");
		c_RikVstupu.add("2011");
		c_RikVstupu.add("2012");
		c_RikVstupu.add("2013");
		c_RikVstupu.add("2014");
		c_RikVstupu.add("2015");
		c_RikVstupu.add("2016");
		c_RikVstupu.add("2017");

		l_fon = new JLabel("");
		l_fon.setVerticalAlignment(SwingConstants.TOP);
		l_fon.setForeground(Color.WHITE);
		l_fon.setIcon(new ImageIcon("res/fon/ReectraciaStudent.jpg"));
		l_fon.setBounds(0, 0, 995, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
