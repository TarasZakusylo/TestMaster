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

public class ReectraciaTeacher extends JFrame {

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
	private Choice c_Specializacia;
	private JLabel l_Specializacia;

	public ReectraciaTeacher(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		label_NazvaVikna = new JLabel("Реєстрація");
		label_NazvaVikna.setForeground(Color.WHITE);
		label_NazvaVikna.setBounds(12, 30, 497, 88);
		label_NazvaVikna.setFont(new Font("Monotype Corsiva", Font.PLAIN, 55));
		label_NazvaVikna.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label_NazvaVikna);

		label_Password = new JLabel("Пароль");
		label_Password.setForeground(Color.WHITE);
		label_Password.setBounds(12, 145, 231, 29);
		label_Password.setHorizontalAlignment(SwingConstants.CENTER);
		label_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		getContentPane().add(label_Password);

		passwordField_Password = new JPasswordField();
		passwordField_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		passwordField_Password.setBounds(12, 198, 231, 33);
		passwordField_Password.setToolTipText("");
		passwordField_Password.setText("1");
		getContentPane().add(passwordField_Password);

		button_Nazad = new JButton("Назад");
		button_Nazad.setForeground(Color.BLACK);
		button_Nazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AvtorTeacher("TestMaster");
				setVisible(false);
			}
		});
		button_Nazad.setBounds(12, 446, 231, 36);
		button_Nazad.setFont(new Font("Palatino Linotype", Font.PLAIN, 30));
		getContentPane().add(button_Nazad);

		label_PIP = new JLabel("Ім'я та Прізвище");
		label_PIP.setForeground(Color.WHITE);
		label_PIP.setBounds(12, 263, 231, 29);
		label_PIP.setHorizontalAlignment(SwingConstants.CENTER);
		label_PIP.setFont(new Font("Palatino Linotype", Font.PLAIN, 26));
		getContentPane().add(label_PIP);

		textField_PIP = new JTextField();
		textField_PIP.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		textField_PIP.setBounds(12, 315, 231, 33);
		textField_PIP.setToolTipText("");
		textField_PIP.setText("1");
		textField_PIP.setColumns(10);
		getContentPane().add(textField_PIP);

		label_email = new JLabel("e-mail");
		label_email.setForeground(Color.WHITE);
		label_email.setBounds(298, 145, 231, 29);
		label_email.setHorizontalAlignment(SwingConstants.CENTER);
		label_email.setFont(new Font("Palatino Linotype", Font.PLAIN, 28));
		getContentPane().add(label_email);

		textField_mail = new JTextField();
		textField_mail.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		textField_mail.setBounds(298, 198, 231, 33);
		textField_mail.setToolTipText("");
		textField_mail.setText("1");
		getContentPane().add(textField_mail);

		button_Gotovo = new JButton("Готово");
		button_Gotovo.setForeground(Color.BLACK);
		button_Gotovo.setBounds(298, 446, 231, 36);
		button_Gotovo.addActionListener(new ActionListener() {

			private String s_Password;
			private String s_PIP;
			private String s_mail;
			String s_Specializacia;

			private Formatter formatter_reestracia;
			private String s_reestracia;

			private int i_korektnist = 0;
			private int i_korektnist1 = 0;

			@SuppressWarnings("deprecation")

			public void actionPerformed(ActionEvent arg0) {

				s_Password = passwordField_Password.getText();
				s_PIP = textField_PIP.getText();
				s_mail = textField_mail.getText();
				s_Specializacia = c_Specializacia.getSelectedItem();

				File file = new File("res/AvtoruzaciaTecher/" + s_mail + ".txt");

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
								formatter_reestracia = new Formatter("res/AvtoruzaciaTeacher/" + s_mail + ".txt");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "System Error");
							}

							s_reestracia = s_Password + " " + s_PIP + " " + s_Specializacia;

							formatter_reestracia.format(s_reestracia);
							formatter_reestracia.close();

							JOptionPane.showMessageDialog(null, "Зареєстровано");
							new AvtorTeacher("TestMaster");
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

		l_Specializacia = new JLabel("Основна спеціалізація");
		l_Specializacia.setHorizontalAlignment(SwingConstants.CENTER);
		l_Specializacia.setForeground(Color.WHITE);
		l_Specializacia.setFont(new Font("Palatino Linotype", Font.PLAIN, 26));
		l_Specializacia.setBounds(265, 263, 290, 29);
		getContentPane().add(l_Specializacia);

		c_Specializacia = new Choice();
		c_Specializacia.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
		c_Specializacia.setBounds(298, 315, 231, 36);
		getContentPane().add(c_Specializacia);
		c_Specializacia.add("УкраїнськаМова");
		c_Specializacia.add("УкраїнськаЛітература");
		c_Specializacia.add("ІноземнаМова");
		c_Specializacia.add("РосійськаМова");
		c_Specializacia.add("СвітоваЛітература");
		c_Specializacia.add("Історія");
		c_Specializacia.add("Економіка");
		c_Specializacia.add("Правознавство");
		c_Specializacia.add("МузичнеМистецтво");
		c_Specializacia.add("ОбразотворчеМистецтво");
		c_Specializacia.add("ХудожняКультура");
		c_Specializacia.add("Етика");
		c_Specializacia.add("Математика");
		c_Specializacia.add("Астрономія");
		c_Specializacia.add("Біологія");
		c_Specializacia.add("Географія");
		c_Specializacia.add("Природознавство");
		c_Specializacia.add("Фізика");
		c_Specializacia.add("Хімія");
		c_Specializacia.add("ТрудовеНавчання");
		c_Specializacia.add("Інформатика");
		c_Specializacia.add("ОсновиЗдоров’я");
		c_Specializacia.add("ФізичнаКультура");
		c_Specializacia.add("Технології");
		c_Specializacia.add("ЗахистВітчизни");
		c_Specializacia.add("Екологія");
		c_Specializacia.add("Філософія");
		c_Specializacia.add("Психологія");
		c_Specializacia.add("Адміністрація");
		c_Specializacia.add("Організатори");

		l_fon = new JLabel("");
		l_fon.setForeground(Color.WHITE);
		l_fon.setIcon(new ImageIcon("res/fon/ReectraciaTeacher.jpg"));
		l_fon.setBounds(-1, 0, 995, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
