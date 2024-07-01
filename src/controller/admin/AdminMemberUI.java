package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Member;
import service.impl.BankServiceImpl;
import service.impl.MemberServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AdminMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField selectname;
	private JTextField name;
	private JTextField password;
	private JTextField phone;
	private JTextField account;
	private JTable table;
	DefaultTableModel model;
	private JTextField username;
	
	public static MemberServiceImpl msi = new MemberServiceImpl();
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMemberUI frame = new AdminMemberUI();
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
	public AdminMemberUI() {
		setTitle("會員管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		selectname = new JTextField();
		selectname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectname.setText("");
			}
		});
		selectname.setText("請輸入帳號");
		selectname.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		selectname.setBounds(130, 240, 109, 29);
		contentPane.add(selectname);
		selectname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel.setBounds(390, 240, 53, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(390, 280, 53, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(390, 320, 53, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("電話");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(390, 360, 53, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("銀行帳號");
		lblNewLabel_1_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(390, 400, 77, 29);
		contentPane.add(lblNewLabel_1_2);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		name.setColumns(10);
		name.setBounds(460, 240, 109, 29);
		contentPane.add(name);
		
		username = new JTextField();
		username.setEnabled(false);
		username.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		username.setColumns(10);
		username.setBounds(460, 280, 109, 29);
		contentPane.add(username);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		password.setColumns(10);
		password.setBounds(460, 320, 109, 29);
		contentPane.add(password);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		phone.setColumns(10);
		phone.setBounds(460, 360, 109, 29);
		contentPane.add(phone);
		
		account = new JTextField();
		account.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		account.setColumns(10);
		account.setBounds(460, 400, 109, 29);
		contentPane.add(account);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 20, 538, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				name.setText(model.getValueAt(i, 1).toString());
				username.setText(model.getValueAt(i, 2).toString());
				password.setText(model.getValueAt(i, 3).toString());
				
				try {
					phone.setText(model.getValueAt(i, 4).toString());
				}catch(NullPointerException ex1) {
					ex1.printStackTrace();
					phone.setText("");
				}
				
				try {
					account.setText(model.getValueAt(i, 5).toString());
				}catch(NullPointerException ex1) {
					ex1.printStackTrace();
					account.setText("");
				}
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"會員編號","姓名","會員帳號","密碼","電話","銀行帳號"};
		Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(192, 192, 192));
		
		JButton btnNewButton = new JButton("依帳號查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Member data = msi.queryByUN(selectname.getText());
				if(data != null) {
					row[0] = data.getId();
					row[1] = data.getName();
					row[2] = data.getUsername();
					row[3] = data.getPassword();
					row[4] = data.getPhone();
					row[5] = data.getBankaccount();
					model.addRow(row);
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號 !", null, JOptionPane.WARNING_MESSAGE);
					selectname.setText("");
				}

			}
		});
		btnNewButton.setBounds(20, 240, 101, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				List<Member> data = msi.queryMember();
				for(Member i : data) {
					row[0] = i.getId();
					row[1] = i.getName();
					row[2] = i.getUsername();
					row[3] = i.getPassword();
					row[4] = i.getPhone();
					row[5] = i.getBankaccount();
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(20, 290, 101, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("更新");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nName = name.getText();
				String nPassword = password.getText();
				String nPhone = phone.getText();
				String nAccount = account.getText();
				Member mb = msi.queryByUN(username.getText());
				
				if(bsi.queryByAC(nAccount) != null || nAccount.equals("")) {
					msi.updateMB(mb, nName, nPassword, nPhone, nAccount);
					JOptionPane.showMessageDialog(null, "更新成功 !");
					model.setRowCount(0);
				}else {
					JOptionPane.showMessageDialog(null, "沒有此銀行帳號請註冊 !", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton_1_1.setBounds(20, 340, 101, 29);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("刪除");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Member mb = msi.queryByUN(username.getText());
				if(mb != null) {
					msi.deleteMB(mb.getId());
					JOptionPane.showMessageDialog(null, "刪除成功 !");
					model.setRowCount(0);
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號 !", null, JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnNewButton_1_1_1.setBounds(20, 390, 101, 29);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("清空");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
				username.setText("");
				password.setText("");
				phone.setText("");
				account.setText("");
				selectname.setText("");
				model.setRowCount(0);
			}
		});
		btnNewButton_1_1_1_1.setBounds(260, 340, 101, 29);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("返回");
		btnNewButton_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminUI a = new AdminUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(260, 390, 101, 29);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
	}
}
