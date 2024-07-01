package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import model.Member;
import service.impl.BankServiceImpl;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;
	private JTextField bankaccount;
	private static MemberServiceImpl msi = new MemberServiceImpl();
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setTitle("會員註冊");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 40, 65, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(100, 100, 65, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密碼");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(100, 160, 65, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("電話");
		lblNewLabel_2_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_1.setBounds(100, 220, 65, 32);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("銀行帳號");
		lblNewLabel_2_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(100, 280, 96, 32);
		contentPane.add(lblNewLabel_2_2);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		name.setBounds(190, 40, 118, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		username.setColumns(10);
		username.setBounds(190, 100, 118, 32);
		contentPane.add(username);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		password.setColumns(10);
		password.setBounds(190, 160, 118, 32);
		contentPane.add(password);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		phone.setColumns(10);
		phone.setBounds(190, 220, 118, 32);
		contentPane.add(phone);
		
		bankaccount = new JTextField();
		bankaccount.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		bankaccount.setColumns(10);
		bankaccount.setBounds(190, 280, 118, 32);
		contentPane.add(bankaccount);
		
		JButton btnNewButton = new JButton("註冊");
		btnNewButton.setBackground(new Color(255, 128, 0));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name = name.getText();
				String Username = username.getText();
				String Password = password.getText();
				String Phone = phone.getText().equals("") ? null : phone.getText();
				String Bankaccount = bankaccount.getText().equals("") ? null : bankaccount.getText();
				
				if(Name.equals("") || Username.equals("") || Password.equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入姓名、帳號、密碼 !", null, JOptionPane.WARNING_MESSAGE);
				}else {
					Member data = msi.queryByUN(Username);
					if(data == null) {
						if(bsi.queryByAC(Bankaccount) != null || Bankaccount == null) {
							msi.addMB(Name, Username, Password, Phone, Bankaccount);
							JOptionPane.showMessageDialog(null, "註冊成功，請重新登入 !");
							
							LoginUI l = new LoginUI();
							l.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "沒有此銀行帳號請註冊 !", null, JOptionPane.WARNING_MESSAGE);
						}
					}else {
						JOptionPane.showMessageDialog(null, "此帳號已被註冊過 !", null, JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(90, 345, 101, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBackground(new Color(255, 128, 0));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(250, 345, 101, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel imge = new JLabel("");
		imge.setIcon(new ImageIcon(AddMemberUI.class.getResource("/images/AddMemberUI_img.jpg")));
		imge.setBounds(-10, -28, 450, 450);
		contentPane.add(imge);
		

	}
}
