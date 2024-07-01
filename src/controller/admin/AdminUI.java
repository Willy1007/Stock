package controller.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AdminUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
		setTitle("系統管理員");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("會員管理");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMemberUI a = new AdminMemberUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(120, 40, 159, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("交易紀錄管理");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminStocksUI a = new AdminStocksUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(120, 100, 159, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("銀行管理");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminBankUI a = new AdminBankUI();
				a.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(120, 160, 159, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("登出");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUI l = new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(120, 220, 159, 39);
		contentPane.add(btnNewButton_2_1);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(AdminUI.class.getResource("/images/AdminUI_img.jpg")));
		image.setBounds(-10, 0, 420, 330);
		contentPane.add(image);
	}
}
