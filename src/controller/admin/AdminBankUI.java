package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Bank;
import service.impl.BankServiceImpl;

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

public class AdminBankUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField selectname;
	private JTextField password;
	private JTextField balance;
	private JTable table;
	DefaultTableModel model;
	private JTextField account;
	
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBankUI frame = new AdminBankUI();
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
	public AdminBankUI() {
		setTitle("銀行管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 435);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
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
		selectname.setBounds(140, 250, 109, 29);
		contentPane.add(selectname);
		selectname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_2.setBounds(380, 250, 53, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1.setBounds(380, 300, 53, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("餘額");
		lblNewLabel_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(380, 350, 53, 29);
		contentPane.add(lblNewLabel_1_1);
		
		account = new JTextField();
		account.setEnabled(false);
		account.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		account.setColumns(10);
		account.setBounds(440, 250, 109, 29);
		contentPane.add(account);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		password.setColumns(10);
		password.setBounds(440, 300, 109, 29);
		contentPane.add(password);
		
		balance = new JTextField();
		balance.setEnabled(false);
		balance.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		balance.setColumns(10);
		balance.setBounds(440, 350, 109, 29);
		contentPane.add(balance);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 538, 196);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				account.setText(model.getValueAt(i, 1).toString());
				password.setText(model.getValueAt(i, 2).toString());
				balance.setText(model.getValueAt(i, 3).toString());
			}
		});
		model = new DefaultTableModel();
		Object[] column = {"編號","銀行帳號","密碼","餘額"};
		Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(192, 192, 192));
		
		JButton btnNewButton = new JButton("依帳號查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Bank data = bsi.queryByAC(selectname.getText());
				
				if(data != null) {
					row[0] = data.getId();
					row[1] = data.getBankaccount();
					row[2] = data.getPassword();
					row[3] = data.getBalance();
					model.addRow(row);
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號 !", null, JOptionPane.WARNING_MESSAGE);
					selectname.setText("");
				}
			}
		});
		btnNewButton.setBounds(20, 250, 101, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				List<Bank> data = bsi.selectAll();
				for(Bank i : data) {
					row[0] = i.getId();
					row[1] = i.getBankaccount();
					row[2] = i.getPassword();
					row[3] = i.getBalance();
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(20, 300, 101, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("更新");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bank data = bsi.queryByAC(account.getText());
				bsi.updatePW(data.getId(), password.getText());
				JOptionPane.showMessageDialog(null, "更新成功 !");
				model.setRowCount(0);
				account.setText("");
				password.setText("");
				balance.setText("");
			}
		});
		btnNewButton_1_1.setBounds(20, 350, 101, 29);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("清空");
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				account.setText("");
				password.setText("");
				balance.setText("");
				selectname.setText("");
				model.setRowCount(0);
			}
		});
		btnNewButton_1_1_1_1.setBounds(260, 300, 101, 29);
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
		btnNewButton_1_1_1_1_1.setBounds(260, 350, 101, 29);
		contentPane.add(btnNewButton_1_1_1_1_1);
		
	}
}
