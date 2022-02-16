package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ConnectJDBC;
import model.DanhSachBaiHat_Model;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class DanhSachBaiHat_View extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField txt_MaSo;
	private JTextField txt_TenBH;
	private JTextField txt_TenCS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DanhSachBaiHat_View frame = new DanhSachBaiHat_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DanhSachBaiHat_View() {
		setTitle("Danh sách bài hát");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 495);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 75, 552, 272);
		contentPane.add(scrollPane);

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.PINK);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBounds(125, 264, 154, 41);
		comboBox.addItem("");
		comboBox.addItem("Nhạc trẻ");
		comboBox.addItem("Bolero");
		comboBox.addItem("Nhạc rap");
		comboBox.addItem("Nhạc rock");
		comboBox.addItem("Nhạc cách mạng");
		comboBox.addItem("Nhạc thiếu nhi");
		comboBox.addItem("Nhạc đồng quê");
		contentPane.add(comboBox);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String maSo = table.getValueAt(row, 0).toString();
				String tenBaiHat = table.getValueAt(row, 1).toString();
				String tenTacGia = table.getValueAt(row, 2).toString();
				String theLoai = table.getValueAt(row, 3).toString();

				txt_MaSo.setText(maSo);
				txt_TenBH.setText(tenBaiHat);
				txt_TenCS.setText(tenTacGia);
				comboBox.setSelectedItem(theLoai);
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 S\u1ED0", "T\u00CAN B\u00C0I H\u00C1T", "CA S\u0128 TH\u1EC2 HI\u1EC6N", "TH\u1EC2 LO\u1EA0I"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(228);
		table.getColumnModel().getColumn(2).setPreferredWidth(230);
		table.getColumnModel().getColumn(3).setPreferredWidth(221);
		table.setForeground(Color.BLACK);
		table.setBackground(Color.PINK);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("M\u00E3 S\u1ED1");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 123, 105, 36);
		contentPane.add(lblNewLabel);

		JLabel labBH = new JLabel("T\u00EAn B\u00E0i H\u00E1t");
		labBH.setFont(new Font("Tahoma", Font.BOLD, 16));
		labBH.setBounds(10, 170, 105, 33);
		contentPane.add(labBH);

		JLabel labCS = new JLabel("Tên Ca Sĩ");
		labCS.setFont(new Font("Tahoma", Font.BOLD, 16));
		labCS.setBounds(10, 218, 105, 36);
		contentPane.add(labCS);

		txt_MaSo = new JTextField();
		txt_MaSo.setBackground(Color.PINK);
		txt_MaSo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_MaSo.setBounds(125, 123, 154, 36);
		contentPane.add(txt_MaSo);
		txt_MaSo.setColumns(10);

		txt_TenBH = new JTextField();
		txt_TenBH.setBackground(Color.PINK);
		txt_TenBH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_TenBH.setColumns(10);
		txt_TenBH.setBounds(125, 170, 154, 36);
		contentPane.add(txt_TenBH);

		txt_TenCS = new JTextField();
		txt_TenCS.setBackground(Color.PINK);
		txt_TenCS.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_TenCS.setColumns(10);
		txt_TenCS.setBounds(125, 217, 154, 36);
		contentPane.add(txt_TenCS);

		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setIcon(new ImageIcon("E:\\Ảnh\\Refresh-icon.png"));
		btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachBaiHat_Model ds = new DanhSachBaiHat_Model();
				ds.setMaSo(txt_MaSo.getText());
				ds.setTenBaiHat(txt_TenBH.getText());
				ds.setTenCaSi(txt_TenCS.getText());
				ds.setTheLoai(comboBox.getSelectedItem().toString());
				ConnectJDBC.suaBH(ds);
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!");
				showData(ConnectJDBC.findAll());
				txt_MaSo.setText("");
				txt_TenBH.setText("");
				txt_TenCS.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		btnCpNht.setBounds(379, 380, 154, 53);
		contentPane.add(btnCpNht);

		JButton btnThm = new JButton("Thêm");
		btnThm.setIcon(new ImageIcon("E:\\Ảnh\\math-add-icon.png"));
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachBaiHat_Model ds = new DanhSachBaiHat_Model();
				ds.setMaSo(txt_MaSo.getText());
				ds.setTenBaiHat(txt_TenBH.getText());
				ds.setTenCaSi(txt_TenCS.getText());
				ds.setTheLoai(comboBox.getSelectedItem().toString());
				if (txt_MaSo.getText().equals("") || txt_TenBH.getText().equals("") || txt_TenCS.getText().equals("")
						|| comboBox.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Thêm không thành công!");
				} else {
					int dem1 = table.getRowCount();
					ConnectJDBC.themBH(ds);
					showData(ConnectJDBC.findAll());
					int dem2 = table.getRowCount();
					if (dem1 == dem2) {
						JOptionPane.showMessageDialog(null, "Thêm không thành công!");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thành công!");
						txt_MaSo.setText("");
						txt_TenBH.setText("");
						txt_TenCS.setText("");
						comboBox.setSelectedIndex(0);
					}
				}
			}
		});
		btnThm.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThm.setBounds(206, 380, 127, 53);
		contentPane.add(btnThm);

		JButton btnXa = new JButton("Xóa");
		btnXa.setIcon(new ImageIcon("E:\\Ảnh\\symbol-delete-icon.png"));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachBaiHat_Model ds = new DanhSachBaiHat_Model();
				ds.setMaSo(txt_MaSo.getText());
				ConnectJDBC.xoaBH(ds);
				JOptionPane.showMessageDialog(null, "Xóa thành công!");
				showData(ConnectJDBC.findAll());
				txt_MaSo.setText("");
				txt_TenBH.setText("");
				txt_TenCS.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXa.setBounds(572, 380, 120, 53);
		contentPane.add(btnXa);

		JLabel lblNewLabel_1 = new JLabel("Danh Sách Bài Hát");
		lblNewLabel_1.setFont(new Font("Ink Free", Font.BOLD, 55));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(192, 11, 481, 53);
		contentPane.add(lblNewLabel_1);

		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setIcon(new ImageIcon("E:\\Ảnh\\search-icon.png"));
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachBaiHat_Model bh = new DanhSachBaiHat_Model();
				bh.setTenBaiHat(txt_TenBH.getText());
				bh.setTheLoai(comboBox.getSelectedItem().toString());
				showData(ConnectJDBC.timBangTenVaTheLoaiBH(bh));
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBounds(10, 380, 148, 53);
		contentPane.add(btnTimKiem);

		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon("E:\\Ảnh\\arrow-refresh-4-icon (1).png"));
		btnLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_MaSo.setText("");
				txt_TenBH.setText("");
				txt_TenCS.setText("");
				comboBox.setSelectedIndex(0);
				showData(ConnectJDBC.findAll());
			}
		});
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLamMoi.setBounds(733, 380, 139, 53);
		contentPane.add(btnLamMoi);

		JLabel lblThLoi = new JLabel("Thể Loại");
		lblThLoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThLoi.setBounds(10, 264, 105, 39);
		contentPane.add(lblThLoi);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhap_View v = new DangNhap_View();
				v.show();
				hide();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon("E:\\Ảnh\\left.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 44, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Ảnh\\1732235.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 882, 456);
		contentPane.add(lblNewLabel_3);

		showData(ConnectJDBC.findAll());

		setVisible(true);
	}

	public static void showData(List<DanhSachBaiHat_Model> baiHatL) {
		List<DanhSachBaiHat_Model> baiHatList = new ArrayList<>();
		baiHatList = baiHatL;
		DefaultTableModel tableModel;
		tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for (DanhSachBaiHat_Model bh : baiHatList) {
			tableModel.addRow(new Object[] { bh.getMaSo(), bh.getTenBaiHat(), bh.getTenCaSi(), bh.getTheLoai() });
		}
	}
}
