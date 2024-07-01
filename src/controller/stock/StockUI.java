package controller.stock;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import controller.member.UpdateUseMemberUI;
import model.Member;
import model.NumberRandom;
import model.StocksInfo;
import service.impl.MemberServiceImpl;
import service.impl.StocksServiceImpl;
import util.cal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;


public class StockUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static MemberServiceImpl msi = new MemberServiceImpl();
	private static StocksServiceImpl ssi = new StocksServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockUI frame = new StockUI();
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
	public StockUI() {
		setTitle("STOCK");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("台雞店=>");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(230, 30, 110, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("大粒胱=>");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(230, 85, 110, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("蓮發顆=>");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(230, 140, 110, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel stock1 = new JLabel("0");
		stock1.setForeground(Color.WHITE);
		stock1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock1.setBounds(330, 30, 100, 33);
		contentPane.add(stock1);
		
		JLabel stock2 = new JLabel("0");
		stock2.setForeground(Color.WHITE);
		stock2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock2.setBounds(330, 85, 100, 33);
		contentPane.add(stock2);
		
		JLabel stock3 = new JLabel("0");
		stock3.setForeground(Color.WHITE);
		stock3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock3.setBounds(330, 140, 100, 33);
		contentPane.add(stock3);
		
		JLabel stock1a = new JLabel("()");
		stock1a.setForeground(Color.WHITE);
		stock1a.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock1a.setBounds(400, 30, 100, 33);
		contentPane.add(stock1a);
		
		JLabel stock2a = new JLabel("()");
		stock2a.setForeground(Color.WHITE);
		stock2a.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock2a.setBounds(400, 85, 100, 33);
		contentPane.add(stock2a);
		
		JLabel stock3a = new JLabel("()");
		stock3a.setForeground(Color.WHITE);
		stock3a.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		stock3a.setBounds(400, 140, 100, 33);
		contentPane.add(stock3a);
		
		JLabel times = new JLabel("");
		times.setForeground(new Color(255, 255, 0));
		times.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		times.setBounds(10, 270, 223, 35);
		contentPane.add(times);	
		
		JLabel lblNewLabel_3 = new JLabel("單位(1000股)");
		lblNewLabel_3.setForeground(new Color(255, 128, 64));
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(500, 0, 110, 33);
		contentPane.add(lblNewLabel_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		spinner_1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_1.setBounds(500, 35, 42, 26);
		contentPane.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_2.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		spinner_2.setBounds(500, 90, 42, 26);
		contentPane.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		spinner_3.setBounds(500, 145, 42, 26);
		contentPane.add(spinner_3);
		
		JLabel welname = new JLabel("歡迎 : Name");
		welname.setForeground(Color.YELLOW);
		welname.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		welname.setBounds(10, 10, 149, 35);
		contentPane.add(welname);
		
		JLabel idno = new JLabel("會員編號 : 00");
		idno.setForeground(Color.YELLOW);
		idno.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		idno.setBounds(10, 35, 149, 35);
		contentPane.add(idno);
		
		JLabel username = new JLabel("帳號 : Username");
		username.setForeground(Color.YELLOW);
		username.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		username.setBounds(10, 60, 149, 35);
		contentPane.add(username);
		
		JLabel bankaccount = new JLabel("扣款帳號 : 0");
		bankaccount.setForeground(Color.YELLOW);
		bankaccount.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		bankaccount.setBounds(10, 85, 149, 35);
		contentPane.add(bankaccount);
		
		JButton logout = new JButton("登出");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		logout.setBounds(470, 265, 110, 33);
		contentPane.add(logout);
		
		
		// 時間
		Timer timer = new Timer(1000, e -> times.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())));
		timer.start();
		
		// 載入會員資料
		Member memberInfo = (Member)cal.readData("member.txt");
		Member mb = msi.queryByUN(memberInfo.getUsername());
		welname.setText("歡迎 : " + mb.getName());
		idno.setText("會員編號 : " + mb.getId());
		username.setText("帳號 : " + mb.getUsername());
		bankaccount.setText("扣款帳號 : " + mb.getBankaccount());
		
		JButton buy = new JButton("下單");
		buy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = memberInfo.getUsername();
				int stock1_amount = (Integer)spinner_1.getValue();
				int stock2_amount =(Integer)spinner_2.getValue();
				int stock3_amount =(Integer)spinner_3.getValue();
				double stock1_price = Double.parseDouble(stock1.getText());
				double stock2_price = Double.parseDouble(stock2.getText());
				double stock3_price = Double.parseDouble(stock3.getText());
				
				if(stock1_amount > 0 || stock2_amount > 0 || stock3_amount > 0) {
					if(mb.getBankaccount() != null) {
						StocksInfo si = ssi.addSk(username, stock1_amount, stock2_amount, stock3_amount,
							stock1_price, stock2_price, stock3_price);
						
						cal.saveData("stock.txt", si);
						
						BuyStockUI b = new BuyStockUI();
						b.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "請新增扣款帳號 !", null, JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "請輸入下單張數 !", null, JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		buy.setBounds(330, 205, 110, 33);
		contentPane.add(buy);
		
		JButton select = new JButton("查詢交易紀錄");
		select.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SelectInfoUI s = new SelectInfoUI();
				s.setVisible(true);
				dispose();
			}
		});
		select.setBounds(330, 265, 110, 33);
		contentPane.add(select);
		
		JButton updateMember = new JButton("修改會員資料");
		updateMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateUseMemberUI u = new UpdateUseMemberUI();
				u.setVisible(true);
				dispose();
			}
		});
		updateMember.setBounds(470, 205, 110, 33);
		contentPane.add(updateMember);
		
		
				
		new Thread(new Runnable() {
			@Override
			public void run() {
				double start1 = 600.0;
				double start2 = 820.0;
				double start3 = 750.0;
				
				NumberRandom s = new NumberRandom(start1, start2, start3);
				stock1.setText(Double.toString(s.getStock1()));
				stock2.setText(Double.toString(s.getStock2()));
				stock3.setText(Double.toString(s.getStock3()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				while(true) {				
					s.RDNumber();
					stock1.setText(Double.toString(s.getStock1()));
					stock2.setText(Double.toString(s.getStock2()));
					stock3.setText(Double.toString(s.getStock3()));
					
					stock1a.setText("(" + Double.toString(s.getStock1() - start1) + ")");
					stock2a.setText("(" + Double.toString(s.getStock2() - start2) + ")");
					stock3a.setText("(" + Double.toString(s.getStock3() - start3) + ")");
					
					if(s.getStock1() > start1) {
						stock1.setForeground(Color.RED);
						stock1a.setForeground(Color.RED);
					}else if(s.getStock1() < start1) {
						stock1.setForeground(Color.GREEN);
						stock1a.setForeground(Color.GREEN);
					}else if(s.getStock1() == start1) {
						stock1.setForeground(Color.WHITE);
						stock1a.setForeground(Color.WHITE);
					}
					
					if(s.getStock2() > start2) {
						stock2.setForeground(Color.RED);
						stock2a.setForeground(Color.RED);
					}else if(s.getStock2() < start2) {
						stock2.setForeground(Color.GREEN);
						stock2a.setForeground(Color.GREEN);
					}else if(s.getStock2() == start2) {
						stock2.setForeground(Color.WHITE);
						stock2a.setForeground(Color.WHITE);
					}
					
					if(s.getStock3() > start3) {
						stock3.setForeground(Color.RED);
						stock3a.setForeground(Color.RED);
					}else if(s.getStock3() < start3) {
						stock3.setForeground(Color.GREEN);
						stock3a.setForeground(Color.GREEN);
					}else if(s.getStock3() == start3) {
						stock3.setForeground(Color.WHITE);
						stock3a.setForeground(Color.WHITE);
					}
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
