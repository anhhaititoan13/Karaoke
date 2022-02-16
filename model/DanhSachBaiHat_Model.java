package model;

public class DanhSachBaiHat_Model {
	private String maSo, tenBaiHat, tenCaSi, theLoai;

	public DanhSachBaiHat_Model() {
	}

	public DanhSachBaiHat_Model(String maSo, String tenBaiHat, String tenCaSi, String theLoai) {
		this.maSo = maSo;
		this.tenBaiHat = tenBaiHat;
		this.tenCaSi = tenCaSi;
		this.theLoai = theLoai;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getTenBaiHat() {
		return tenBaiHat;
	}

	public void setTenBaiHat(String tenBaiHat) {
		this.tenBaiHat = tenBaiHat;
	}

	public String getTenCaSi() {
		return tenCaSi;
	}

	public void setTenCaSi(String tenCaSi) {
		this.tenCaSi = tenCaSi;
	}
}
