package model;

public class SanPham {
	
	private String maSP;
	private String tenSP;
	private double giaSp;
	private int soLuongTon;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPham(String maSP, String tenSP, double giaSp, int soLuongTon) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaSp = giaSp;
		this.soLuongTon = soLuongTon;
	}

	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", giaSp=" + giaSp + ", soLuongTon=" + soLuongTon + "]";
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public double getGiaSp() {
		return giaSp;
	}

	public void setGiaSp(double giaSp) {
		this.giaSp = giaSp;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	
}
