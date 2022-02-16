package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ConnectJDBC;
import model.DanhSachBaiHat_Model;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class NguoiDung_View extends JFrame {

	private JPanel contentPane;
	private static JTable table;
	private JTextField textField;
	private JComboBox comboBox;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox_1;
	private JButton btnNewButton_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NguoiDung_View frame = new NguoiDung_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NguoiDung_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Người dùng");
		setBounds(100, 100, 462, 345);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 426, 144);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, },
				new String[] { "M\u00E3 B\u00E0i H\u00E1t", "T\u00EAn B\u00E0i H\u00E1t", "T\u00EAn Ca S\u0129",
						"Th\u1EC3 Lo\u1EA1i" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(105);
		table.getColumnModel().getColumn(1).setPreferredWidth(177);
		table.getColumnModel().getColumn(2).setPreferredWidth(180);
		table.getColumnModel().getColumn(3).setPreferredWidth(137);
		scrollPane.setViewportView(table);

		JLabel lblNewLabel = new JLabel("Tìm kiếm theo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 27, 116, 28);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Vui lòng nhập tên bài hát:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 66, 163, 26);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(173, 66, 191, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_2 = new JLabel("Vui lòng chọn thể loại:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 66, 163, 26);
		contentPane.add(lblNewLabel_2);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 68, 143, 26);
		comboBox_1.addItem("");
		comboBox_1.addItem("Nhạc trẻ");
		comboBox_1.addItem("Bolero");
		comboBox_1.addItem("Nhạc rap");
		comboBox_1.addItem("Nhạc rock");
		comboBox_1.addItem("Nhạc cách mạng");
		comboBox_1.addItem("Nhạc thiếu nhi");
		comboBox_1.addItem("Nhạc đồng quê");
		contentPane.add(comboBox_1);

		btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setIcon(new ImageIcon("E:\\Ảnh\\search-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DanhSachBaiHat_Model bh = new DanhSachBaiHat_Model();
				bh.setTenBaiHat(textField.getText());
				bh.setTheLoai(comboBox_1.getSelectedItem().toString());
				showData(ConnectJDBC.timBangTenVaTheLoaiBH(bh));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(138, 103, 143, 37);
		contentPane.add(btnNewButton);

		lblNewLabel_1.hide();
		textField.hide();
		btnNewButton.hide();
		lblNewLabel_2.hide();
		comboBox_1.hide();

		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(125, 27, 116, 28);
		comboBox.addItem("");
		comboBox.addItem("Tên bài hát");
		comboBox.addItem("Thể loại");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					lblNewLabel_1.show();
					textField.show();
					btnNewButton.show();
					lblNewLabel_2.hide();
					comboBox_1.hide();
					comboBox_1.setSelectedIndex(0);
					textField.setText("");
				}
				if (comboBox.getSelectedIndex() == 2) {
					lblNewLabel_1.hide();
					textField.hide();
					comboBox_1.show();
					lblNewLabel_2.show();
					btnNewButton.show();
					comboBox_1.setSelectedIndex(0);
					textField.setText("");
				}
			}
		});
		contentPane.add(comboBox);

		btnNewButton_1 = new JButton("Trở về");
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PhanQuyen_View view = new PhanQuyen_View();
				view.show();
				hide();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(363, 11, 73, 28);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\Ảnh\\hinh-nen-background-powerpoint-17.jpg"));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 446, 306);
		contentPane.add(lblNewLabel_3);

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
