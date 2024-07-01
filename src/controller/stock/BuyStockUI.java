package controller.stock;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.StocksInfo;
import service.impl.StocksServiceImpl;
import util.cal;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class BuyStockUI extends JFrame {

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
					BuyStockUI frame = new BuyStockUI();
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
	public BuyStockUI() {
		setTitle("下單確認");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("台雞店=>");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setBounds(35, 50, 110, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("大粒胱=>");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(35, 105, 110, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("蓮發顆=>");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(35, 160, 110, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("價格");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(170, 20, 65, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("數量");
		lblNewLabel_3_1.setForeground(Color.BLACK);
		lblNewLabel_3_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(280, 20, 65, 33);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel price1 = new JLabel("");
		price1.setForeground(Color.BLACK);
		price1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		price1.setBounds(170, 50, 65, 33);
		contentPane.add(price1);
		
		JLabel price2 = new JLabel("");
		price2.setForeground(Color.BLACK);
		price2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		price2.setBounds(170, 105, 65, 33);
		contentPane.add(price2);
		
		JLabel price3 = new JLabel("");
		price3.setForeground(Color.BLACK);
		price3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		price3.setBounds(170, 160, 65, 33);
		contentPane.add(price3);
		
		JLabel amount1 = new JLabel("");
		amount1.setForeground(Color.BLACK);
		amount1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		amount1.setBounds(280, 50, 65, 33);
		contentPane.add(amount1);
		
		JLabel amount2 = new JLabel("");
		amount2.setForeground(Color.BLACK);
		amount2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		amount2.setBounds(280, 105, 65, 33);
		contentPane.add(amount2);
		
		JLabel amount3 = new JLabel("");
		amount3.setForeground(Color.BLACK);
		amount3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		amount3.setBounds(280, 160, 65, 33);
		contentPane.add(amount3);
		
		JLabel total = new JLabel("0");
		total.setForeground(Color.BLACK);
		total.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		total.setBounds(100, 205, 318, 33);
		contentPane.add(total);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("總額$");
		lblNewLabel_3_1_1.setForeground(Color.BLACK);
		lblNewLabel_3_1_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(35, 205, 65, 33);
		contentPane.add(lblNewLabel_3_1_1);
		
		// 讀取購買資訊
		StocksInfo st = (StocksInfo)cal.readData("stock.txt");
		double Price1 = st.getStock1_price();
		double Price2 = st.getStock2_price();
		double Price3 = st.getStock3_price();
		int Amount1 = st.getStock1();
		int Amount2 = st.getStock2();
		int Amount3 = st.getStock3();
		
		DecimalFormat df = new DecimalFormat("#,###");
		String Price_total = df.format(st.getTotal());
		
		price1.setText(Double.toString(Price1));
		price2.setText(Double.toString(Price2));
		price3.setText(Double.toString(Price3));
		amount1.setText(Integer.toString(Amount1));
		amount2.setText(Integer.toString(Amount2));
		amount3.setText(Integer.toString(Amount3));
		total.setText(Price_total);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ssi.addSK(st);
				JOptionPane.showMessageDialog(null, "交易成功 !");
				StockUI s = new StockUI();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(100, 270, 87, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockUI s = new StockUI();
				s.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(250, 270, 87, 33);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(18, 0, 400, 200);
		contentPane.add(panel);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(128, 255, 128));
		panel2.setBounds(18, 200, 400, 48);
		contentPane.add(panel2);
		
	}
}
