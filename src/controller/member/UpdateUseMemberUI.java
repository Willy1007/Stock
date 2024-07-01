package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.stock.StockUI;
import model.Member;
import service.impl.BankServiceImpl;
import service.impl.MemberServiceImpl;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class UpdateUseMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newname;
	private JTextField newpassword;
	private JTextField newphone;
	private JTextField newbankaccount;
	private static MemberServiceImpl msi = new MemberServiceImpl();
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateUseMemberUI frame = new UpdateUseMemberUI();
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
	public UpdateUseMemberUI() {
		setTitle("會員資料修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usname = new JLabel("會員 : XXX 修改資料");
		usname.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		usname.setBounds(95, 20, 278, 62);
		contentPane.add(usname);
		
		JLabel lblNewLabel_1 = new JLabel("姓名 :");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(80, 90, 60, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼 :");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(80, 150, 60, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("電話 :");
		lblNewLabel_1_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(80, 210, 60, 31);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("銀行帳號 :");
		lblNewLabel_1_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(80, 270, 97, 31);
		contentPane.add(lblNewLabel_1_1_2);
		
		Member memberInfo = (Member)cal.readData("member.txt");
		Member mb = msi.queryByUN(memberInfo.getUsername());
		usname.setText("歡迎 : " + mb.getName() + "  修改會員資料");
		
		newname = new JTextField();
		newname.setText(mb.getName());
		newname.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		newname.setBounds(170, 90, 129, 31);
		contentPane.add(newname);
		newname.setColumns(10);
		
		newpassword = new JTextField();
		newpassword.setText(mb.getPassword());
		newpassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		newpassword.setColumns(10);
		newpassword.setBounds(170, 150, 129, 31);
		contentPane.add(newpassword);
		
		newphone = new JTextField();
		newphone.setText(mb.getPhone());
		newphone.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		newphone.setColumns(10);
		newphone.setBounds(170, 210, 129, 31);
		contentPane.add(newphone);
		
		newbankaccount = new JTextField();
		newbankaccount.setText(mb.getBankaccount());
		newbankaccount.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		newbankaccount.setColumns(10);
		newbankaccount.setBounds(170, 270, 129, 31);
		contentPane.add(newbankaccount);
			
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 192));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nName = newname.getText();
				String nPassword = newpassword.getText();
				String nPhone = newphone.getText();
				String nBankaccount = newbankaccount.getText();
				
				if(bsi.queryByAC(nBankaccount) != null || nBankaccount.equals("")) {
					msi.updateMB(mb, nName, nPassword, nPhone, nBankaccount);
					JOptionPane.showMessageDialog(null, "更新成功 !");
					
					StockUI s = new StockUI();
					s.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "沒有此銀行帳號請註冊 !", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(90, 340, 97, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(new Color(128, 128, 192));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockUI s = new StockUI();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(250, 340, 97, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(UpdateUseMemberUI.class.getResource("/images/AddMemberUI_img.jpg")));
		image.setBounds(-10, 0, 450, 450);
		contentPane.add(image);
		
	}
}
