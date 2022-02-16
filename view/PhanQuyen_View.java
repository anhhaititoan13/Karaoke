package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PhanQuyen_View extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanQuyen_View frame = new PhanQuyen_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PhanQuyen_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ch\u00E0o m\u1EEBng b\u1EA1n \u0111\u00E3 \u0111\u1EBFn v\u1EDBi");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 11, 380, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblKaraokeVku = new JLabel("Karaoke VKU");
		lblKaraokeVku.setForeground(new Color(0, 255, 0));
		lblKaraokeVku.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaraokeVku.setFont(new Font("Monospaced", Font.BOLD | Font.ITALIC, 22));
		lblKaraokeVku.setBounds(46, 54, 336, 30);
		contentPane.add(lblKaraokeVku);
		
		JButton btnNewButton = new JButton("Ng\u01B0\u1EDDi d\u00F9ng");
		btnNewButton.setIcon(new ImageIcon("E:\\\u1EA2nh\\Person-Male-Light-icon (1).png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NguoiDung_View view=new NguoiDung_View();
				view.show();
				hide();
			}
		});
		btnNewButton.setBounds(36, 173, 166, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Qu\u1EA3n l\u00FD");
		btnNewButton_1.setIcon(new ImageIcon("E:\\\u1EA2nh\\Office-Customer-Male-Light-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap_View view=new DangNhap_View();
				view.show();
				hide();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(229, 173, 166, 62);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ti\u1EBFp t\u1EE5c v\u1EDBi vai tr\u00F2?");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(112, 128, 203, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("E:\\\u1EA2nh\\pngtree-dark-blue-technology-sense-main-picture-background-material-image_13038.jpg"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_2);
		
		setVisible(true);
	}
}
