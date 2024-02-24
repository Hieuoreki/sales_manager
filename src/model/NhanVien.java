package model;

public class NhanVien {
	
	private String maNV;
	private int matKhau;
	private String tenNV;
	private String vaiTro;
	private String diaChi;
	private String dienThoai;
	private String ngaySinh;
	private String gioiTinh;
	private String trangThai;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, int matKhau, String tenNV, String vaiTro, String diaChi, String dienThoai,
			String ngaySinh, String gioiTinh, String trangThai) {
		super();
		this.maNV = maNV;
		this.matKhau = matKhau;
		this.tenNV = tenNV;
		this.vaiTro = vaiTro;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", matKhau=" + matKhau + ", tenNV=" + tenNV + ", vaiTro=" + vaiTro
				+ ", diaChi=" + diaChi + ", dienThoai=" + dienThoai + ", ngaySinh=" + ngaySinh + ", gioiTinh="
				+ gioiTinh + ", trangThai=" + trangThai + "]";
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public int getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(int matKhau) {
		this.matKhau = matKhau;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getVaiTro() {
		return vaiTro;
	}

	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
	

}
