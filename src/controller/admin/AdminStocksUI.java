package controller.admin;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import model.StocksInfo;
import service.impl.StocksServiceImpl;

import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;

public class AdminStocksUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField selectname;
	private JTable table;
	DefaultTableModel model;
	
	public static StocksServiceImpl ssi = new StocksServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminStocksUI frame = new AdminStocksUI();
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
	public AdminStocksUI() {
		setTitle("交易紀錄管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
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
		selectname.setBounds(130, 295, 109, 29);
		contentPane.add(selectname);
		selectname.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 20, 750, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"會員帳號","台雞店","大粒胱","蓮發顆","台雞店_價格","大粒胱_價格","蓮發顆_價格","總額","交易日期"};
		Object[] row = new Object[9];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		table.setBackground(new Color(192, 192, 192));
		
		TableColumnModel cModel = table.getColumnModel();
		TableColumn date = cModel.getColumn(8);
		date.setPreferredWidth(130);
		
		JCalendar calendar1 = new JCalendar();
		calendar1.setBounds(250, 280, 250, 180);
		contentPane.add(calendar1);
		
		JCalendar calendar2 = new JCalendar();
		calendar2.setBounds(520, 280, 250, 180);
		contentPane.add(calendar2);
		
		JButton btnNewButton = new JButton("依帳號查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				List<StocksInfo> data = ssi.queryByUN(selectname.getText());
				if(data.size() != 0) {
					for(StocksInfo i : data) {
						row[0] = i.getUsername();
						row[1] = i.getStock1();
						row[2] = i.getStock2();
						row[3] = i.getStock3();
						row[4] = i.getStock1_price();
						row[5] = i.getStock2_price();
						row[6] = i.getStock3_price();
						row[7] = i.getTotal();
						row[8] = i.getDate();
						
						model.addRow(row);
					}
				}else {
					JOptionPane.showMessageDialog(null, "沒有此帳號 !", null, JOptionPane.WARNING_MESSAGE);
					selectname.setText("");
				}
			}
		});
		btnNewButton.setBounds(20, 295, 101, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("查詢全部");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				List<StocksInfo> data = ssi.queryAll();
				for(StocksInfo i : data) {
					row[0] = i.getUsername();
					row[1] = i.getStock1();
					row[2] = i.getStock2();
					row[3] = i.getStock3();
					row[4] = i.getStock1_price();
					row[5] = i.getStock2_price();
					row[6] = i.getStock3_price();
					row[7] = i.getTotal();
					row[8] = i.getDate();
					
					model.addRow(row);
				}
			}
		});
		btnNewButton_1.setBounds(20, 245, 101, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("返回");
		btnNewButton_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminUI a = new AdminUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(20, 445, 101, 29);
		contentPane.add(btnNewButton_1_1_1_1_1);
			
		JButton btnNewButton_2 = new JButton("依日期查詢");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Date start = calendar1.getDate();
				Date end = calendar2.getDate();
				List<StocksInfo> data = ssi.queryByDT(start, end);
				
				if(data.size() != 0) {
					for(StocksInfo i : data) {
						row[0] = i.getUsername();
						row[1] = i.getStock1();
						row[2] = i.getStock2();
						row[3] = i.getStock3();
						row[4] = i.getStock1_price();
						row[5] = i.getStock2_price();
						row[6] = i.getStock3_price();
						row[7] = i.getTotal();
						row[8] = i.getDate();
						
						model.addRow(row);
					}
				}else {
					JOptionPane.showMessageDialog(null, "查無資料 !", null, JOptionPane.WARNING_MESSAGE);
					selectname.setText("");
				}
			}
		});
		btnNewButton_2.setBounds(20, 395, 101, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("依帳號、日期查詢");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.setRowCount(0);
				Date start = calendar1.getDate();
				Date end = calendar2.getDate();
				List<StocksInfo> data = ssi.queryByDTAndUN(start, end, selectname.getText());
				
				if(data.size() != 0) {
					for(StocksInfo i : data) {
						row[0] = i.getUsername();
						row[1] = i.getStock1();
						row[2] = i.getStock2();
						row[3] = i.getStock3();
						row[4] = i.getStock1_price();
						row[5] = i.getStock2_price();
						row[6] = i.getStock3_price();
						row[7] = i.getTotal();
						row[8] = i.getDate();
						
						model.addRow(row);
					}
				}else {
					JOptionPane.showMessageDialog(null, "查無資料 !", null, JOptionPane.WARNING_MESSAGE);
					selectname.setText("");
				}
			}
		});
		btnNewButton_2_1.setBounds(20, 345, 138, 29);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel = new JLabel("查詢起始日期");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel.setBounds(250, 245, 161, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("查詢結束日期");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		lblNewLabel_1.setBounds(520, 245, 161, 34);
		contentPane.add(lblNewLabel_1);
		
	}
}
