package controller.bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Bank;
import service.impl.BankServiceImpl;
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

public class BankLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private static BankServiceImpl bsi = new BankServiceImpl();
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankLoginUI frame = new BankLoginUI();
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
	public BankLoginUI() {
		setTitle("網路銀行登入");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("銀行帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(110, 60, 88, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("銀行密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 130, 88, 34);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		account.setBounds(210, 60, 139, 34);
		contentPane.add(account);
		account.setColumns(10);
		
		password = new JPasswordField();
		password.setEchoChar('*');
		password.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		password.setBounds(210, 130, 139, 34);
		contentPane.add(password);
		
		JButton login = new JButton("登入");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("新細明體", Font.BOLD, 12));
		login.setBackground(new Color(128, 128, 255));
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Account = account.getText();
				String Password = String.valueOf(password.getPassword());
				
				Bank bk = bsi.queryByAC(Account);
				if(bk != null) {
					if(Password.equals(bk.getPassword())) {
						cal.saveData("bank.txt", bk);
						BankUI b = new BankUI();
						b.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "密碼錯誤 !", null, JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號，請註冊 !", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		login.setBounds(110, 220, 107, 34);
		contentPane.add(login);
		
		JButton add = new JButton("註冊");
		add.setForeground(new Color(255, 255, 255));
		add.setFont(new Font("新細明體", Font.BOLD, 12));
		add.setBackground(new Color(128, 128, 255));
		add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddBankUI a = new AddBankUI();
				a.setVisible(true);
				dispose();
			}
		});
		add.setBounds(260, 220, 107, 34);
		contentPane.add(add);
		
		JButton back = new JButton("返回");
		back.setForeground(new Color(255, 255, 255));
		back.setBackground(new Color(128, 128, 255));
		back.setFont(new Font("新細明體", Font.BOLD, 12));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		back.setBounds(110, 285, 107, 34);
		contentPane.add(back);
		
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
		CheckBox.setBounds(355, 139, 97, 23);
		contentPane.add(CheckBox);
		
		JLabel image = new JLabel("");
		image.setFont(new Font("新細明體", Font.BOLD, 12));
		image.setIcon(new ImageIcon(BankLoginUI.class.getResource("/images/BankLoginUI_img.jpg")));
		image.setBounds(-10, -10, 500, 400);
		contentPane.add(image);
		
	}
}
