package controller.bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bank;
import service.impl.BankServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddBankUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBankUI frame = new AddBankUI();
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
	public AddBankUI() {
		setTitle("網路銀行註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("銀行帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel.setBounds(110, 60, 91, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("銀行密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(110, 130, 91, 36);
		contentPane.add(lblNewLabel_1);
		
		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		account.setBounds(210, 60, 141, 36);
		contentPane.add(account);
		account.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		password.setColumns(10);
		password.setBounds(210, 130, 141, 36);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(128, 128, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Account = account.getText();
				String Password = password.getText();
				
				if(Account.equals("") || Password.equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入帳號與密碼 !", null, JOptionPane.WARNING_MESSAGE);
				}else {
					Bank bk = bsi.queryByAC(Account);
					if(bk == null) {
						bk = new Bank();
						bk.setBankaccount(Account);
						bk.setPassword(Password);
						bsi.addBK(bk);
						
						JOptionPane.showMessageDialog(null, "註冊成功 !");
						
						BankLoginUI b = new BankLoginUI();
						b.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "此帳號已被註冊過 !", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(110, 235, 108, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(128, 128, 255));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BankLoginUI b = new BankLoginUI();
				b.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(270, 235, 108, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(AddBankUI.class.getResource("/images/BankLoginUI_img.jpg")));
		image.setBounds(-10, -10, 500, 400);
		contentPane.add(image);
	}

}
