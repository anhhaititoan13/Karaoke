package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import connection.ConnectJDBC;
import model.TaiKhoan_Model;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DangNhap_View extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDN;
	private JPasswordField txt_MKDN;
	private JButton btnngK;
	private JTextField txt_TenDK;
	private JPasswordField txtMKDK;
	private JPasswordField txt_MKDK2;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhap_View frame = new DangNhap_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DangNhap_View() {
		setTitle("Karaoke VKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 384);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(282, 97, 115, 37);
		contentPane.add(lblNewLabel);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(407, 117, 146, 3);
		separator_1_2.hide();
		contentPane.add(separator_1_2);

		txt_TenDK = new JTextField();
		txt_TenDK.setOpaque(false);
		txt_TenDK.setForeground(Color.YELLOW);
		txt_TenDK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_TenDK.setColumns(10);
		txt_TenDK.setBorder(null);
		txt_TenDK.setBounds(407, 83, 146, 37);
		txt_TenDK.hide();
		contentPane.add(txt_TenDK);

		JLabel lblMtKhu_1 = new JLabel("Mật khẩu:");
		lblMtKhu_1.setForeground(Color.WHITE);
		lblMtKhu_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu_1.setBackground(Color.WHITE);
		lblMtKhu_1.setBounds(282, 131, 115, 37);
		lblMtKhu_1.hide();
		contentPane.add(lblMtKhu_1);

		txtMKDK = new JPasswordField();
		txtMKDK.setOpaque(false);
		txtMKDK.setForeground(Color.YELLOW);
		txtMKDK.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMKDK.setBorder(null);
		txtMKDK.setBounds(407, 131, 146, 31);
		txtMKDK.hide();
		contentPane.add(txtMKDK);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setBounds(407, 165, 146, 3);
		separator_1_1_1.hide();
		contentPane.add(separator_1_1_1);

		JLabel lblMtKhu_1_1 = new JLabel("Nhập lại mật khẩu:");
		lblMtKhu_1_1.setForeground(Color.WHITE);
		lblMtKhu_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu_1_1.setBackground(Color.WHITE);
		lblMtKhu_1_1.setBounds(282, 181, 115, 37);
		lblMtKhu_1_1.hide();
		contentPane.add(lblMtKhu_1_1);

		txt_MKDK2 = new JPasswordField();
		txt_MKDK2.setOpaque(false);
		txt_MKDK2.setForeground(Color.YELLOW);
		txt_MKDK2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_MKDK2.setBorder(null);
		txt_MKDK2.setBounds(407, 181, 146, 37);
		txt_MKDK2.hide();
		contentPane.add(txt_MKDK2);

		JSeparator separator_1_1_1_1 = new JSeparator();
		separator_1_1_1_1.setBounds(407, 215, 146, 3);
		separator_1_1_1_1.hide();
		contentPane.add(separator_1_1_1_1);

		JLabel lblNewLabel_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(282, 86, 115, 37);
		lblNewLabel_2.hide();
		contentPane.add(lblNewLabel_2);

		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u:");
		lblMtKhu.setForeground(Color.WHITE);
		lblMtKhu.setBackground(Color.WHITE);
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMtKhu.setBounds(282, 145, 115, 37);
		contentPane.add(lblMtKhu);

		JLabel lbBaoLoi_DK = new JLabel("");
		lbBaoLoi_DK.setHorizontalAlignment(SwingConstants.CENTER);
		lbBaoLoi_DK.setForeground(Color.RED);
		lbBaoLoi_DK.setBounds(327, 242, 188, 20);
		contentPane.add(lbBaoLoi_DK);

		JButton bt_DK = new JButton("Đăng ký");
		bt_DK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dem1 = 0, dem2 = 0;
				ConnectJDBC cn = new ConnectJDBC();
				try {
					Connection connection = cn.getConnection();
					TaiKhoan_Model tk = new TaiKhoan_Model();
					tk.setTenDangNhap(txt_TenDK.getText());
					tk.setMatKhau(txtMKDK.getText());
					Statement st = connection.createStatement();
					ResultSet rs = st.executeQuery("select * from TaiKhoan");
					if (txt_TenDK.getText().equals("") || txtMKDK.getText().equals("")) {
						lbBaoLoi_DK.setText("Không được để trống thông tin!");
					} else {
						if (txtMKDK.getText().equals(txt_MKDK2.getText())) {
							while (rs.next()) {
								dem1 = rs.getRow();
							}
							ConnectJDBC.themTK(tk);
							ResultSet rs2 = st.executeQuery("select * from TaiKhoan");
							while (rs2.next()) {
								dem2 = rs2.getRow();
							}
							if (dem1 == dem2) {
								lbBaoLoi_DK.setText("Tên đăng nhập đã tồn tại!");
							} else {
								JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
							}
						} else {
							lbBaoLoi_DK.setText("Mật khẩu không khớp!");
						}
					}
				} catch (Exception e2) {
				}
			}
		});
		bt_DK.setOpaque(false);
		bt_DK.setForeground(Color.WHITE);
		bt_DK.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_DK.setBackground(Color.WHITE);
		bt_DK.setBounds(327, 273, 188, 37);
		bt_DK.hide();
		contentPane.add(bt_DK);

		txtTenDN = new JTextField();
		txtTenDN.setForeground(Color.YELLOW);
		txtTenDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTenDN.setBounds(407, 97, 146, 37);
		txtTenDN.setOpaque(false);
		txtTenDN.setBorder(null);
		contentPane.add(txtTenDN);
		txtTenDN.setColumns(10);

		txt_MKDN = new JPasswordField();
		txt_MKDN.setForeground(Color.YELLOW);
		txt_MKDN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_MKDN.setBounds(407, 151, 146, 31);
		txt_MKDN.setOpaque(false);
		txt_MKDN.setBorder(null);
		contentPane.add(txt_MKDN);

		JLabel lbBaoLoi = new JLabel("");
		lbBaoLoi.setForeground(Color.RED);
		lbBaoLoi.setHorizontalAlignment(SwingConstants.CENTER);
		lbBaoLoi.setBounds(339, 198, 166, 20);
		contentPane.add(lbBaoLoi);

		JButton bt_DN = new JButton("\u0110\u0103ng nh\u1EADp");
		bt_DN.setForeground(Color.WHITE);
		bt_DN.setBackground(Color.WHITE);
		bt_DN.setOpaque(false);
		bt_DN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectJDBC cn = new ConnectJDBC();
				String query = "Select * from TaiKhoan where TenDangNhap=? and MatKhau=?";
				try {
					Connection connection = cn.getConnection();
					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, txtTenDN.getText());
					ps.setString(2, txt_MKDN.getText());
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						DanhSachBaiHat_View v = new DanhSachBaiHat_View();
						v.show();
						hide();
					} else {
						lbBaoLoi.setText("Vui lòng nhập đúng thông tin!");
					}
				} catch (Exception e2) {
				}
			}
		});
		bt_DN.setFont(new Font("Tahoma", Font.BOLD, 15));
		bt_DN.setBounds(327, 243, 188, 37);
		contentPane.add(bt_DN);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(407, 131, 146, 3);
		contentPane.add(separator_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(407, 179, 146, 3);
		contentPane.add(separator_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PhanQuyen_View view=new PhanQuyen_View();
				view.show();
				hide();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Ảnh\\left.png"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 42, 37);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("E:\\Ảnh\\v.png"));
		lblNewLabel_1_1_1.setBounds(99, 11, 29, 60);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("E:\\Ảnh\\letter-k (1).png"));
		lblNewLabel_1_1_1_1.setBounds(125, 11, 37, 60);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1_1.setIcon(new ImageIcon("E:\\Ảnh\\u.png"));
		lblNewLabel_1_1_1_1_1.setBounds(157, 11, 42, 60);
		contentPane.add(lblNewLabel_1_1_1_1_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Ảnh\\8.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 281, 345);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setIcon(new ImageIcon("E:\\Ảnh\\istockphoto-1216628493-612x612.jpg"));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(270, 0, 304, 345);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon("E:\\Ảnh\\10765266.jpg"));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 0, 273, 345);
		contentPane.add(lblNewLabel_1_2);

		btnNewButton_1 = new JButton("Đăng nhập");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(0, 0, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(302, 11, 125, 31);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				separator_1_2.hide();
				txt_TenDK.hide();
				lblMtKhu_1.hide();
				txtMKDK.hide();
				separator_1_1_1.hide();
				lblMtKhu_1_1.hide();
				txt_MKDK2.hide();
				separator_1_1_1_1.hide();
				lblNewLabel_2.hide();
				bt_DK.hide();
				lblNewLabel.show();
				txtTenDN.show();
				separator_1.show();
				lblMtKhu.show();
				separator_1_1.show();
				bt_DN.show();
				lbBaoLoi.show();
				lbBaoLoi_DK.hide();
				txt_MKDN.show();
				lbBaoLoi.setText("");
				txtTenDN.setText("");
				txt_MKDN.setText("");
				btnNewButton_1.setBackground(new Color(0, 0, 128));
				btnNewButton_1_1.setBackground(new Color(0, 0, 255));
			}
		});
		contentPane.add(btnNewButton_1);

		btnNewButton_1_1 = new JButton("Đăng ký");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(0, 0, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(427, 11, 115, 31);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				separator_1_2.show();
				txt_TenDK.show();
				lblMtKhu_1.show();
				separator_1_1_1.show();
				lblMtKhu_1_1.show();
				txt_MKDK2.show();
				separator_1_1_1_1.show();
				lblNewLabel_2.show();
				bt_DK.show();
				lblNewLabel.hide();
				txtTenDN.hide();
				separator_1.hide();
				lblMtKhu.hide();
				txtMKDK.show();
				txt_MKDN.hide();
				separator_1_1.hide();
				bt_DN.hide();
				lbBaoLoi.hide();
				lbBaoLoi_DK.show();
				lbBaoLoi_DK.setText("");
				txt_TenDK.setText("");
				txtMKDK.setText("");
				txt_MKDK2.setText("");
				btnNewButton_1_1.setBackground(new Color(0, 0, 128));
				btnNewButton_1.setBackground(new Color(0, 0, 255));
			}
		});
		contentPane.add(btnNewButton_1_1);

		setVisible(true);
	}
}
