package controller.bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Bank;
import service.impl.BankServiceImpl;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class BankUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField save;
	private JTextField extract;
	private static BankServiceImpl bsi = new BankServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankUI frame = new BankUI();
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
	public BankUI() {
		setTitle("網路銀行");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel account = new JLabel("銀行帳號 :");
		account.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		account.setBounds(80, 40, 382, 45);
		contentPane.add(account);
		
		JLabel balance = new JLabel("存款餘額 :");
		balance.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		balance.setBounds(80, 120, 382, 45);
		contentPane.add(balance);
		
		save = new JTextField();
		save.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		save.setBounds(80, 210, 118, 32);
		contentPane.add(save);
		save.setColumns(10);
		
		extract = new JTextField();
		extract.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		extract.setColumns(10);
		extract.setBounds(80, 290, 118, 32);
		contentPane.add(extract);
		
		
		Bank bk = (Bank)cal.readData("bank.txt");
		bk = bsi.queryByAC(bk.getBankaccount());
		DecimalFormat df = new DecimalFormat("#,###");
		account.setText("銀行帳號 : " + bk.getBankaccount());
		balance.setText("存款餘額 : $" + df.format(bk.getBalance()));
		
		JButton savebutton = new JButton("存款");
		savebutton.setForeground(new Color(255, 255, 255));
		savebutton.setFont(new Font("新細明體", Font.BOLD, 12));
		savebutton.setBackground(new Color(128, 64, 64));
		savebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bank bks = (Bank)cal.readData("bank.txt");
				bks = bsi.queryByAC(bks.getBankaccount());
				
				if(save.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入金額 !", null, JOptionPane.WARNING_MESSAGE);
				}else {
					try {
						int money = Integer.parseInt(save.getText());
						int blc = bks.getBalance();
						
						bsi.updateBLC(bks.getId(), money + blc);
						
						JOptionPane.showMessageDialog(null, "存款成功 !");
						BankUI b = new BankUI();
						b.setVisible(true);
						dispose();
					}catch(NumberFormatException ex1) {
						ex1.printStackTrace();
						JOptionPane.showMessageDialog(null, "請輸入數字 !", null, JOptionPane.ERROR_MESSAGE);
						save.setText("");
					}
				}
			}
		});
		savebutton.setBounds(220, 210, 110, 32);
		contentPane.add(savebutton);
		
		JButton extractbutton = new JButton("提款");
		extractbutton.setBackground(new Color(255, 128, 0));
		extractbutton.setFont(new Font("新細明體", Font.BOLD, 12));
		extractbutton.setForeground(new Color(255, 255, 255));
		extractbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Bank bks = (Bank)cal.readData("bank.txt");
				bks = bsi.queryByAC(bks.getBankaccount());
				
				if(extract.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "請輸入金額 !", null, JOptionPane.WARNING_MESSAGE);
				}else {
					try {
						int money = Integer.parseInt(extract.getText());
						int blc = bks.getBalance();
						
						if(money > bks.getBalance()) {
							JOptionPane.showMessageDialog(null, "餘額不足 !", null, JOptionPane.ERROR_MESSAGE);
						}else {
							bsi.updateBLC(bks.getId(), blc - money);
							
							JOptionPane.showMessageDialog(null, "提款成功 !");
							BankUI b = new BankUI();
							b.setVisible(true);
							dispose();
						}
					}catch(NumberFormatException ex2) {
						ex2.printStackTrace();
						JOptionPane.showMessageDialog(null, "請輸入數字 !", null, JOptionPane.ERROR_MESSAGE);
						extract.setText("");
					}
				}
			}
		});
		extractbutton.setBounds(220, 290, 110, 32);
		contentPane.add(extractbutton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(0, 0, 450, 185);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton logout = new JButton("登出");
		logout.setBounds(350, 10, 72, 30);
		panel.add(logout);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BankLoginUI b = new BankLoginUI();
				b.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 255, 128));
		panel2.setBounds(0, 185, 450, 80);
		contentPane.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(128, 255, 255));
		panel3.setBounds(0, 265, 450, 80);
		contentPane.add(panel3);
	}
}
