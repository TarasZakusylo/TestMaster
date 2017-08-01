package Zakk.TestMaster;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Pruvitanna extends JFrame {

	private static final long serialVersionUID = 1L;

	Desktop d = Desktop.getDesktop();

	private JLabel l_fon;
	private JLabel l_Nazva;
	private JButton b_Student;
	private JButton b_Teacher;
	private JLabel l_Mail;
	private JLabel l_Name;

	public Pruvitanna(String s) {
		super(s);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		l_Name = new JLabel("@Zakk");
		l_Name.setFont(new Font("Times New Roman", Font.BOLD, 30));
		l_Name.setHorizontalAlignment(SwingConstants.RIGHT);
		l_Name.setBounds(812, 486, 170, 36);
		getContentPane().add(l_Name);

		l_Mail = new JLabel("tapac.zakusylo@gmail.com");
		l_Mail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					d.browse(new URI("mailto:tapac.zakusylo@gmail.com"));
				} catch (Exception e1) {
				}
			}
		});
		l_Mail.setHorizontalAlignment(SwingConstants.RIGHT);
		l_Mail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l_Mail.setBounds(691, 522, 291, 30);
		getContentPane().add(l_Mail);

		b_Teacher = new JButton("Увійти як учитель / викладач");
		b_Teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b_Teacher.setForeground(new Color(0, 0, 0));
		b_Teacher.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		b_Teacher.setBounds(48, 417, 900, 45);
		getContentPane().add(b_Teacher);

		b_Student = new JButton("Увійти як учень / студент");
		b_Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		b_Student.setForeground(new Color(0, 0, 0));
		b_Student.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		b_Student.setBounds(48, 374, 900, 45);
		getContentPane().add(b_Student);

		l_Nazva = new JLabel("TestMaster");
		l_Nazva.setHorizontalAlignment(SwingConstants.CENTER);
		l_Nazva.setFont(new Font("Monotype Corsiva", Font.BOLD, 100));
		l_Nazva.setBounds(228, 61, 520, 199);
		getContentPane().add(l_Nazva);

		l_fon = new JLabel("");
		l_fon.setIcon(new ImageIcon("C:\\Users\\ZakkZakk\\Desktop\\Sky-background-TEST.jpg"));
		l_fon.setBounds(0, 0, 994, 565);
		getContentPane().add(l_fon);

		setVisible(true);
	}
}
