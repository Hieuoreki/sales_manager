package model;

public class HoaDon {
	
	private int maHD;
	private double tongTien;
	private double thanhToan;
	private double tienKhachDua;
	private double tienThua;
	private String ngayTao;
	private String hinhThuc;
	private String nhanVienTao;
	private String khachHang;
	private String trangThai;
	private ThongKe thongke;
	
	public HoaDon() {
		
	}
	
	public HoaDon(ThongKe thongke) {
		this.thongke = thongke;
	}
	
	public HoaDon(int maHD, double tongTien, double thanhToan, double tienThua, String ngayTao, String hinhThuc,
			String nhanVienTao, String khachHang, String trangThai) {
		this.maHD = maHD;
		this.tongTien = tongTien;
		this.thanhToan = thanhToan;
		this.tienThua = tienThua;
		this.ngayTao = ngayTao;
		this.hinhThuc = hinhThuc;
		this.nhanVienTao = nhanVienTao;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
	}
	/*
	public HoaDon(int maHD, double tongTien, double thanhToan, double tienKhachDua, double tienThua, String ngayTao, String hinhThuc,
			String nhanVienTao, String khachHang, String trangThai) {
		this.maHD = maHD;
		this.tongTien = tongTien;
		this.thanhToan = thanhToan;
		this.tienKhachDua = tienKhachDua;
		this.tienThua = tienThua;
		this.ngayTao = ngayTao;
		this.hinhThuc = hinhThuc;
		this.nhanVienTao = nhanVienTao;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
	}*/

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", tongTien=" + tongTien + ", thanhToan=" + thanhToan + ", tienThua=" + tienThua
				+ ", ngayTao=" + ngayTao + ", hinhThuc=" + hinhThuc + ", nhanVienTao=" + nhanVienTao + ", khachHang="
				+ khachHang + ", trangThai=" + trangThai + "]";
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public double getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(double thanhToan) {
		this.thanhToan = thanhToan;
	}

	public double getTienKhachDua() {
		return tienKhachDua;
	}

	public void setTienKhachDua(double tienKhachDua) {
		this.tienKhachDua = tienKhachDua;
	}

	public double getTienThua() {
		return tienThua;
	}

	public void setTienThua(double tienThua) {
		this.tienThua = tienThua;
	}

	public String getNgayTao() {
		return ngayTao;
	}

	public void setNgayTao(String ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getHinhThuc() {
		return hinhThuc;
	}

	public void setHinhThuc(String hinhThuc) {
		this.hinhThuc = hinhThuc;
	}

	public String getNhanVienTao() {
		return nhanVienTao;
	}

	public void setNhanVienTao(String nhanVienTao) {
		this.nhanVienTao = nhanVienTao;
	}

	public String getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(String khachHang) {
		this.khachHang = khachHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	
}
