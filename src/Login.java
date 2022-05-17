import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txt_Username;
	static RLDTO acc = new RLDTO();
	MySQLConnect connect = new MySQLConnect();
	private JPasswordField txt_Pwd;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(169, 11, 136, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_Username = new JLabel("Username:");
		lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Username.setBounds(23, 78, 124, 19);
		contentPane.add(lbl_Username);
		
		JLabel lbl_Pwd = new JLabel("Password:");
		lbl_Pwd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_Pwd.setBounds(23, 131, 124, 19);
		contentPane.add(lbl_Pwd);
		
		txt_Username = new JTextField();
		txt_Username.setBounds(157, 79, 164, 20);
		contentPane.add(txt_Username);
		txt_Username.setColumns(10);
		
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
		contentPane.add(btn_Login);
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_Username.getText().equals("") || txt_Pwd.getText().equals("")) JOptionPane.showMessageDialog(contentPane, "Vui lòng điền đầy đủ thông tin");
				else {
					acc = new RLDTO();
					acc.setUsername(txt_Username.getText());
					acc.setPwd(txt_Pwd.getText());
					try {
						Connection Conn = connect.getConnection();
						Statement stmt = connect.getStatement();
						String sql = "SELECT Username,Password FROM account";
						ResultSet rs = stmt.executeQuery(sql);
						while(rs.next()) {
							if(rs.getString(1).equals(acc.getUsername()) && rs.getString(2).equals(acc.getPwd())) acc.setStatus(1);
						}
						if(acc.getStatus() == 1 ) {
							JOptionPane.showInternalMessageDialog(contentPane, "Success");
							dispose();
							GUI.main(null);
						}
						else  JOptionPane.showInternalMessageDialog(contentPane, "No Success");
					} catch (Exception E) {
						E.printStackTrace();
					}
				}
			}
		});
		btn_Login.setBounds(89, 179, 136, 33);
		
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
		contentPane.add(btn_Login);
		btn_Reg.setBackground(new Color(245, 245, 220));
		btn_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Register register = new Register();
				register.setVisible(true);
			}
		});
		btn_Reg.setBounds(261, 179, 136, 33);
		contentPane.add(btn_Reg);
		
		txt_Pwd = new JPasswordField();
		txt_Pwd.setBounds(157, 132, 164, 20);
		contentPane.add(txt_Pwd);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("Icon/Login.png"));
		lblNewLabel_1.setBounds(116, 11, 53, 60);
		contentPane.add(lblNewLabel_1);
		
		txt_Username.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txt_Pwd.requestFocus();
			}
		});
		setLocationRelativeTo(null);
	}
}
