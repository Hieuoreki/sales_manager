package model;

public class BanHang {
	
	private SanPham sanPham;
	private HoaDon hoaDons;
	private GioHang gioHangs;
	
	public BanHang() {
	}


	public BanHang(SanPham sanPham, HoaDon hoaDons, GioHang gioHangs) {
		this.sanPham = sanPham;
		this.hoaDons = hoaDons;
		this.gioHangs = gioHangs;
	}


	@Override
	public String toString() {
		return "BanHang [sanPham=" + sanPham + ", hoaDons=" + hoaDons + ", gioHangs=" + gioHangs + "]";
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}


	public HoaDon getHoaDons() {
		return hoaDons;
	}


	public void setHoaDons(HoaDon hoaDons) {
		this.hoaDons = hoaDons;
	}


	public GioHang getGioHangs() {
		return gioHangs;
	}


	public void setGioHangs(GioHang gioHangs) {
		this.gioHangs = gioHangs;
	}
	
	

}
