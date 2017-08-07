package Zakk.TestMaster;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AvtorTeacher extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField tF_Mail;
	private JPasswordField pF_Password;
	private JLabel l_Koment;
	private JLabel l_Hapka;
	private JLabel l_fon;
	private JLabel l_Uchen;
	private JLabel l_Reestrasia;
	private JButton b_Vhid;
	private JLabel l_Password;
	private JLabel l_Mail;

	public AvtorTeacher(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		l_Koment = new JLabel("Авторизуйтесь, будь ласка");
		l_Koment.setHorizontalAlignment(SwingConstants.CENTER);
		l_Koment.setFont(new Font("Palatino Linotype", Font.BOLD, 33));
		l_Koment.setForeground(Color.WHITE);
		l_Koment.setBounds(486, 216, 483, 52);
		getContentPane().add(l_Koment);

		l_Hapka = new JLabel("Ви увійшли як учитель / викладач");
		l_Hapka.setForeground(Color.WHITE);
		l_Hapka.setFont(new Font("Monotype Corsiva", Font.PLAIN, 53));
		l_Hapka.setHorizontalAlignment(SwingConstants.CENTER);
		l_Hapka.setBounds(288, 29, 694, 135);
		getContentPane().add(l_Hapka);

		tF_Mail = new JTextField();
		tF_Mail.setFont(new Font("Palatino Linotype", Font.PLAIN, 23));
		tF_Mail.setBounds(722, 291, 239, 31);
		getContentPane().add(tF_Mail);
		tF_Mail.setColumns(10);

		pF_Password = new JPasswordField();
		pF_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 23));
		pF_Password.setBounds(722, 335, 239, 31);
		getContentPane().add(pF_Password);

		l_Mail = new JLabel("Пошта / Mail");
		l_Mail.setHorizontalAlignment(SwingConstants.CENTER);
		l_Mail.setFont(new Font("Palatino Linotype", Font.PLAIN, 23));
		l_Mail.setForeground(Color.WHITE);
		l_Mail.setBounds(496, 291, 214, 31);
		getContentPane().add(l_Mail);

		l_Password = new JLabel("Пароль / Password");
		l_Password.setHorizontalAlignment(SwingConstants.CENTER);
		l_Password.setFont(new Font("Palatino Linotype", Font.PLAIN, 23));
		l_Password.setForeground(Color.WHITE);
		l_Password.setBounds(496, 335, 214, 31);
		getContentPane().add(l_Password);

		b_Vhid = new JButton("Вхід");
		b_Vhid.addActionListener(new ActionListener() {

			private String s_Mail ;
			private String s_Password;
		 
			private Scanner scanner_Avtoruzacia;
			private String s_Avtoruzacia;

			
			private String Reading_Password;
			private String Reading_Name;
			private String Reading_Prizvusko;
			private Formatter formatter_RobocuyProfil;

			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent arg0) {
				
				s_Mail = tF_Mail.getText();
				s_Password = pF_Password.getText();
				
				String[][] Reading = new String[1][4];

				try {				
					scanner_Avtoruzacia = new Scanner(new File("res/AvtoruzaciaTeacher/" + s_Mail + ".txt"));
					while (scanner_Avtoruzacia.hasNext()) {
						for (int row = 0; row < Reading.length; row++) {
							Reading_Password = " ";
							Reading_Name = " ";
							Reading_Prizvusko = " ";
							for (int col = 0; col < Reading[row].length; col++) {
								Reading[row][col] = scanner_Avtoruzacia.next();
								if (col == 0) {
									Reading_Password = Reading[row][col];
								}
								if (col == 1) {
									Reading_Name = Reading[row][col];
								}
								if (col == 2) {
									Reading_Prizvusko = Reading[row][col];
								}
							}
						}
					}	
					s_Avtoruzacia = Reading_Password;
					scanner_Avtoruzacia.close();

					if (s_Password.equals(s_Avtoruzacia)) {
						JOptionPane.showMessageDialog(null, "Вітаю, Ви в системі");
						
						String s_Korustuvac = Reading_Name + " " + Reading_Prizvusko;

						try {
							formatter_RobocuyProfil = new Formatter("res/TumcasoviFaylu/Korustuvac.txt");
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "System Error");
						}
						formatter_RobocuyProfil.format(s_Korustuvac);
						formatter_RobocuyProfil.close();

						new MenuTeacher("TestMaster");
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Помилка введення");
						pF_Password.setText("");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Помилка введення");
				}
			}
		});
		b_Vhid.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		b_Vhid.setBounds(486, 379, 475, 31);
		getContentPane().add(b_Vhid);

		l_Reestrasia = new JLabel("Реєстрація");
		l_Reestrasia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new ReectraciaTeacher("TestMaster");
				setVisible(false);
			}
		});
		l_Reestrasia.setForeground(Color.WHITE);
		l_Reestrasia.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
		l_Reestrasia.setHorizontalAlignment(SwingConstants.CENTER);
		l_Reestrasia.setBounds(486, 482, 483, 52);
		getContentPane().add(l_Reestrasia);

		l_Uchen = new JLabel("Увійти як учень / студент");
		l_Uchen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new AvtorStudent("TestMaster");
				setVisible(false);
			}
		});
		l_Uchen.setHorizontalAlignment(SwingConstants.CENTER);
		l_Uchen.setForeground(Color.WHITE);
		l_Uchen.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		l_Uchen.setBounds(486, 533, 483, 32);
		getContentPane().add(l_Uchen);

		l_fon = new JLabel("");
		l_fon.setVerticalAlignment(SwingConstants.TOP);
		l_fon.setHorizontalAlignment(SwingConstants.CENTER);
		l_fon.setIcon(new ImageIcon("res/fon/AvtorTeacher.jpg"));
		l_fon.setBounds(0, 0, 994, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
