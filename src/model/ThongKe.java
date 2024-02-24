package model;

public class ThongKe {
	
	private double doanhThu;
	private int  tongHoaDon;
	private int tongKhachHang;
	
	public ThongKe() {
	}

	public ThongKe(double doanhThu, int tongHoaDon, int tongKhachHang) {
		this.doanhThu = doanhThu;
		this.tongHoaDon = tongHoaDon;
		this.tongKhachHang = tongKhachHang;
	}

	@Override
	public String toString() {
		return "ThongKe [doanhThu=" + doanhThu + ", tongHoaDon=" + tongHoaDon + ", tongKhachHang=" + tongKhachHang
				+ "]";
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public int getTongHoaDon() {
		return tongHoaDon;
	}

	public void setTongHoaDon(int tongHoaDon) {
		this.tongHoaDon = tongHoaDon;
	}

	public int getTongKhachHang() {
		return tongKhachHang;
	}

	public void setTongKhachHang(int tongKhachHang) {
		this.tongKhachHang = tongKhachHang;
	}
	
	

}
