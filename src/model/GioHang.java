package model;

public class GioHang {
	
	private String MaSP;
	private String TenSP;
	private double donGia;
	private int soLuong;
	
	public GioHang() {
		
	}
	
	public GioHang(String maSP, String tenSP, double donGia, int soLuong) {
		this.MaSP = maSP;
		this.TenSP = tenSP;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "GioHang [MaSP=" + MaSP + ", TenSP=" + TenSP + ", donGia=" + donGia + ", soLuong=" + soLuong + "]";
	}

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public double tongTien() {
		return getDonGia() * getSoLuong();
	}

}
