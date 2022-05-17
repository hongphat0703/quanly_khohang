import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Username;
	private JTextField txt_Gmail;
	private JPasswordField txt_Pwd;
	private JPasswordField txt_ConfirmPwd;
	static RLDTO tk = new RLDTO();		
	MySQLConnect connect = new MySQLConnect();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void defaultSet()
	{
		txt_Username.setText("");
		txt_Gmail.setText("");
		txt_Pwd.setText("");
		txt_ConfirmPwd.setText("");
	}
	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Username = new JLabel("Username:");
		lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Username.setBounds(10, 63, 95, 29);
		contentPane.add(lbl_Username);
		
		JLabel lbl_Gmail = new JLabel("Gmail:");
		lbl_Gmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Gmail.setBounds(10, 95, 95, 20);
		contentPane.add(lbl_Gmail);
		
		txt_Username = new JTextField();
		txt_Username.setBounds(145, 69, 186, 20);
		contentPane.add(txt_Username);
		txt_Username.setColumns(10);
		
		txt_Gmail = new JTextField();
		txt_Gmail.setColumns(10);
		txt_Gmail.setBounds(145, 96, 186, 20);
		contentPane.add(txt_Gmail);
		
		JLabel lbl_Pwd = new JLabel("Password:");
		lbl_Pwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Pwd.setBounds(10, 126, 95, 20);
		contentPane.add(lbl_Pwd);
		
		JLabel lbl_ConfirmPwd = new JLabel("Confirm:");
		lbl_ConfirmPwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ConfirmPwd.setBounds(10, 160, 95, 20);
		contentPane.add(lbl_ConfirmPwd);
		
		JButton btn_Login = new JButton("Login");
		btn_Login.setBackground(new Color(245, 245, 220));
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Icon/Login1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconLogin = new ImageIcon(dimg);
		btn_Login.setIcon(IconLogin);
		btn_Login.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();
				login.setVisible(true);
				
			}
		});
		btn_Login.setBounds(84, 207, 136, 33);
		contentPane.add(btn_Login);

		JButton btn_Reg = new JButton("Register");
		img = null;
		try {
			img = ImageIO.read(new File("Icon/Register1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconRegister = new ImageIcon(dimg);
		btn_Reg.setIcon(IconRegister);
		btn_Reg.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn_Reg.setBackground(new Color(245, 245, 220));
		btn_Reg.addActionListener(new ActionListener() {	
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	
				RLBUS abc = new RLBUS();
				tk = new RLDTO();
				if (txt_Username.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Chưa nhập Username");
				else {
					if (txt_Gmail.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Chưa nhập Gmail");
					else {
						if (txt_Pwd.getText().isEmpty())
							JOptionPane.showMessageDialog(null, "Chưa nhập Password");
						else {
							if (txt_ConfirmPwd.getText().isEmpty())
								JOptionPane.showMessageDialog(null, "Chưa nhập Confirm Password");
							else {
								if(txt_Pwd.getText().equalsIgnoreCase(txt_ConfirmPwd.getText())!=true)
									JOptionPane.showMessageDialog(null, "Password và Confirm Password không trùng");
							else {
								tk.setUsername(txt_Username.getText());
								tk.setPwd(txt_Pwd.getText());
								tk.setConfirm_pwd(txt_ConfirmPwd.getText());
								tk.setGmail(txt_Gmail.getText());
								abc.dangki();
							}
						}
					}
				}
			}
				defaultSet();
			}
		});
		btn_Reg.setBounds(267, 207, 136, 33);
		contentPane.add(btn_Reg);
		
		txt_Pwd = new JPasswordField();
		txt_Pwd.setBounds(145, 127, 186, 20);
		contentPane.add(txt_Pwd);
		
		txt_ConfirmPwd = new JPasswordField();
		txt_ConfirmPwd.setBounds(145, 162, 186, 20);
		contentPane.add(txt_ConfirmPwd);
		
		JLabel lbl_Reg = new JLabel("Register");
		lbl_Reg.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbl_Reg.setBounds(201, 19, 89, 29);
		contentPane.add(lbl_Reg);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBackground(new Color(0, 255, 255));
		lblNewLabel.setForeground(new Color(0, 255, 255));
		lblNewLabel.setIcon(new ImageIcon("Icon/Register.png"));
		lblNewLabel.setBounds(155, 0, 43, 58);
		contentPane.add(lblNewLabel);
		
		txt_Username.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txt_Gmail.requestFocus();
			}
		});
		txt_Gmail.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txt_Pwd.requestFocus();
			}
		});
		txt_Pwd.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txt_ConfirmPwd.requestFocus();
			}
		});
		
		setLocationRelativeTo(null);
	}
}
