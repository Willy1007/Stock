package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.admin.AdminLoginUI;
import controller.bank.BankLoginUI;
import controller.member.AddMemberUI;
import controller.stock.StockUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Color;


public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private static MemberServiceImpl msi = new MemberServiceImpl();
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setTitle("症倦交易系統登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(116, 83, 62, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(116, 168, 62, 42);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		username.setBounds(176, 88, 134, 36);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		password.setBounds(176, 173, 134, 36);
		contentPane.add(password);
		
		JButton login = new JButton("登入");
		login.setFont(new Font("新細明體", Font.BOLD, 12));
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(128, 128, 128));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username = username.getText();
				String Password = String.valueOf(password.getPassword());
				Member data = msi.queryByUN(Username);
				
				if(data != null) {
					if(Password.equals(data.getPassword())){
						cal.saveData("member.txt", data);
						StockUI u = new StockUI();
						u.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "密碼錯誤 !", null, JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號，請註冊 !", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		login.setBounds(120, 250, 108, 30);
		contentPane.add(login);
		
		JButton add = new JButton("註冊");
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(128, 128, 128));
		add.setFont(new Font("新細明體", Font.BOLD, 12));
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI a = new AddMemberUI();
				a.setVisible(true);
				dispose();
			}
		});
		add.setBounds(280, 250, 108, 30);
		contentPane.add(add);
		
		JButton bank = new JButton("網路銀行");
		bank.setForeground(new Color(255, 255, 255));
		bank.setBackground(new Color(128, 128, 128));
		bank.setFont(new Font("新細明體", Font.BOLD, 12));
		bank.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BankLoginUI b = new BankLoginUI();
				b.setVisible(true);
				dispose();
			}
		});
		bank.setBounds(120, 315, 108, 30);
		contentPane.add(bank);
		
		JButton admin = new JButton("管理員");
		admin.setForeground(new Color(255, 255, 255));
		admin.setBackground(new Color(128, 128, 128));
		admin.setFont(new Font("新細明體", Font.BOLD, 12));
		admin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminLoginUI a = new AdminLoginUI();
				a.setVisible(true);
				dispose();
			}
		});
		admin.setBounds(280, 315, 108, 30);
		contentPane.add(admin);
		
		JCheckBox CheckBox = new JCheckBox("顯示密碼");
		CheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(CheckBox.isSelected()) {
					password.setEchoChar((char) 0);
				}else {
					password.setEchoChar('*');
				}
			}
		});
		CheckBox.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		CheckBox.setBounds(319, 183, 81, 23);
		contentPane.add(CheckBox);
		
		JLabel img = new JLabel("");
		img.setIcon(new ImageIcon(LoginUI.class.getResource("/images/LoginUI_img.jpg")));
		img.setBounds(0, 0, 500, 375);
		contentPane.add(img);
		
	}
}
