package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DanhSachBaiHat_Model;
import model.TaiKhoan_Model;

public class ConnectJDBC {
	static String connectionURL = "jdbc:sqlserver://CONGTOAN:1433;databaseName=Karaoke;integratedSecurity=true;";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(connectionURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static List<DanhSachBaiHat_Model> findAll() {
		List<DanhSachBaiHat_Model> listBaiHat = new ArrayList<>();
		String query = "select * from ThongTinBaiHat";
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				DanhSachBaiHat_Model bh = new DanhSachBaiHat_Model(rs.getString("MaSo"), rs.getString("TenBaiHat"),
						rs.getString("TenCaSi"), rs.getString("TheLoai"));
				listBaiHat.add(bh);
			}
		} catch (Exception e) {
		}
		return listBaiHat;
	}

	public static void themBH(DanhSachBaiHat_Model ds) {
		String query = "Insert into ThongTinBaiHat values (?,?,?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ds.getMaSo());
			ps.setString(2, ds.getTenBaiHat());
			ps.setString(3, ds.getTenCaSi());
			ps.setString(4, ds.getTheLoai());
			ps.execute();
		} catch (Exception e) {
		}
	}

	public static void xoaBH(DanhSachBaiHat_Model ds) {
		String query = "Delete from ThongTinBaiHat where MaSo='" + ds.getMaSo() + "'";
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public static void suaBH(DanhSachBaiHat_Model ds) {
		String query = "Update ThongTinBaiHat set MaSo=?,TenBaiHat=?,TenCaSi=?,TheLoai=? where MaSo='" + ds.getMaSo()
				+ "'";
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, ds.getMaSo());
			ps.setString(2, ds.getTenBaiHat());
			ps.setString(3, ds.getTenCaSi());
			ps.setString(4, ds.getTheLoai());
			ps.executeUpdate();
		} catch (Exception e) {
		}
	}

	public static List<DanhSachBaiHat_Model> timBangTenVaTheLoaiBH(DanhSachBaiHat_Model ds) {
		List<DanhSachBaiHat_Model> listBaiHat = new ArrayList<>();
		String query = "select * from ThongTinBaiHat where TenBaiHat=N'" + ds.getTenBaiHat() + "' or TheLoai=N'"
				+ ds.getTheLoai() + "'";
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				DanhSachBaiHat_Model bh = new DanhSachBaiHat_Model(rs.getString("MaSo"), rs.getString("TenBaiHat"),
						rs.getString("TenCaSi"), rs.getString("TheLoai"));
				listBaiHat.add(bh);
			}
		} catch (Exception e) {
		}
		return listBaiHat;
	}

	public static void themTK(TaiKhoan_Model tk) {
		String query = "Insert into TaiKhoan values (?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, tk.getTenDangNhap());
			ps.setString(2, tk.getMatKhau());
			ps.execute();
		} catch (Exception e) {
		}
	}
}
