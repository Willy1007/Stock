package controller.stock;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.StocksServiceImpl;
import util.cal;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Font;

public class SelectInfoUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static StocksServiceImpl ssi = new StocksServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectInfoUI frame = new SelectInfoUI();
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
	public SelectInfoUI() {
		setTitle("交易紀錄");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 500, 290);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("微軟正黑體", Font.BOLD, 11));
		scrollPane.setViewportView(textArea);
		
		
		Member m = (Member)cal.readData("member.txt");
		int Id = m.getId();
		String Name = m.getName();
		String Username = m.getUsername();
	
		textArea.setText(
			"會員編號 : " + Id + "\t\t會員帳號 : " + Username + "\t\t會員姓名 : " + Name +
			"\n-----------------------------------------------------------------------------------------" +
			"\n股票\t價格\t數量\t總額\t日期\n" + ssi.queryStockInfo(Username)
		);
		
		JButton print = new JButton("列印");
		print.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textArea.print();
				}catch(PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		print.setBounds(130, 315, 107, 35);
		contentPane.add(print);
		
		JButton print_1 = new JButton("取消");
		print_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockUI s = new StockUI();
				s.setVisible(true);
				dispose();
			}
		});
		print_1.setBounds(280, 315, 107, 35);
		contentPane.add(print_1);
	}
}
