package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionData;
import model.HoaDon;

public class HoaDonDAO implements interfacesDAO<HoaDon> {
	
	private Connection connection;
	
	public HoaDonDAO() {
		this.connection = ConnectionData.getConnection();
	}
	
	public HoaDonDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static HoaDonDAO getInstance() {
		return new HoaDonDAO();
	}
	
	@Override
	public boolean insert(HoaDon t) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO ds_hoadons(`Mã hóa đơn`, `Ngày tạo`, `Nhân viên tạo`, `Khách hàng`) VALUES(?, ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMaHD());
			preparedStatement.setString(2, t.getNgayTao());
			preparedStatement.setString(3, t.getNhanVienTao());
			preparedStatement.setString(4, t.getKhachHang());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertAll(HoaDon t) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO ds_hoadons(`Mã hóa đơn`, `Ngày tạo`, `Nhân viên tạo`, `Khách hàng`, `Tổng tiền`, `Thanh toán`, `Trạng thái thanh toán`, `Tiền thừa`, `Hình thức thanh toán`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getMaHD());
			preparedStatement.setString(2, t.getNgayTao());
			preparedStatement.setString(3, t.getNhanVienTao());
			preparedStatement.setString(4, t.getKhachHang());
			preparedStatement.setDouble(5, t.getTongTien());
			preparedStatement.setDouble(6, t.getThanhToan());
			preparedStatement.setString(7, t.getTrangThai());
			preparedStatement.setDouble(8, t.getTienThua());
			preparedStatement.setString(9, t.getHinhThuc());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(HoaDon t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE ds_hoadons SET `Ngày tạo` = ?, `Nhân viên tạo` = ?, `Khách hàng` = ? WHERE `Mã hóa đơn` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getNgayTao());
			preparedStatement.setString(2, t.getNhanVienTao());
			preparedStatement.setString(3, t.getKhachHang());
			preparedStatement.setInt(4, t.getMaHD());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateAll(HoaDon t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE ds_hoadons SET `Ngày tạo` = ?, `Nhân viên tạo` = ?, `Khách hàng` = ?, `Tổng tiền` = ?, `Thanh toán` = ?, `Trạng thái thanh toán` = ?, `Tiền thừa` = ?, `Hình thức thanh toán` = ? WHERE `Mã hóa đơn` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getNgayTao());
			preparedStatement.setString(2, t.getNhanVienTao());
			preparedStatement.setString(3, t.getKhachHang());
			preparedStatement.setDouble(4,  t.getTongTien());
			preparedStatement.setDouble(5, t.getThanhToan());
			preparedStatement.setString(6, t.getTrangThai());
			preparedStatement.setDouble(7, t.getTienThua());
			preparedStatement.setString(8, t.getHinhThuc());
			preparedStatement.setInt(9, t.getMaHD());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(HoaDon t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM ds_hoadons WHERE `Mã hóa đơn`=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, t.getMaHD());
			preparestatement.executeUpdate();
			preparestatement.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<HoaDon> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<HoaDon> hoaDons = new ArrayList<HoaDon>();
		try {
			String sql = "SELECT *FROM ds_hoadons";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				int MaHD = resultSet.getInt("Mã hóa đơn");
				double tongTien = resultSet.getDouble("Tổng tiền");
				double thanhToan = resultSet.getDouble("Thanh toán");
				double tienThua = resultSet.getDouble("Tiền thừa");
				String ngayTao = resultSet.getString("Ngày tạo");
				String hinhThuc = resultSet.getString("Hình thức thanh toán");
				String nhanVienTao = resultSet.getString("Nhân viên tạo");
				String khachKhang = resultSet.getString("Khách hàng");
				String trangThai = resultSet.getString("Trạng thái thanh toán");
				
				HoaDon hoadon = new HoaDon(MaHD, tongTien, thanhToan, tienThua, ngayTao, hinhThuc, nhanVienTao, khachKhang, trangThai);
				hoaDons.add(hoadon);
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoaDons;
	}
	
	public ArrayList<HoaDon> selectByTenKhachHang(String tenKH){
		ArrayList<HoaDon> hoadons = new ArrayList<HoaDon>();
		try {
			String sql = "SELECT *FROM ds_hoadons WHERE `Khách hàng`=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tenKH);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				int MaHD = resultSet.getInt("Mã hóa đơn");
				double tongTien = resultSet.getDouble("Tổng tiền");
				double thanhToan = resultSet.getDouble("Thanh toán");
				double tienThua = resultSet.getDouble("Tiền thừa");
				String ngayTao = resultSet.getString("Ngày tạo");
				String hinhThuc = resultSet.getString("Hình thức thanh toán");
				String nhanVienTao = resultSet.getString("Nhân viên tạo");
				String khachKhang = resultSet.getString("Khách hàng");
				String trangThai = resultSet.getString("Trạng thái thanh toán");
				
				HoaDon hoadon = new HoaDon(MaHD, tongTien, thanhToan, tienThua, ngayTao, hinhThuc, nhanVienTao, khachKhang, trangThai);
				hoadons.add(hoadon);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoadons;
	}
	
	
	public ArrayList<HoaDon> selectMonth(String month){
		ArrayList<HoaDon> hoadons = new ArrayList<HoaDon>();
		try {
			String sql = "SELECT *FROM ds_hoadons WHERE MONTH(`Ngày tạo`)=?"; 
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, month);
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next())
			{
				int MaHD = resultSet.getInt("Mã hóa đơn");
				double tongTien = resultSet.getDouble("Tổng tiền");
				double thanhToan = resultSet.getDouble("Thanh toán");
				double tienThua = resultSet.getDouble("Tiền thừa");
				String ngayTao = resultSet.getString("Ngày tạo");
				String hinhThuc = resultSet.getString("Hình thức thanh toán");
				String nhanVienTao = resultSet.getString("Nhân viên tạo");
				String khachKhang = resultSet.getString("Khách hàng");
				String trangThai = resultSet.getString("Trạng thái thanh toán");
				
				HoaDon hoadon = new HoaDon(MaHD, tongTien, thanhToan, tienThua, ngayTao, hinhThuc, nhanVienTao, khachKhang, trangThai);
				hoadons.add(hoadon);
			}
			preparedstatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoadons;
	}
	
	public ArrayList<HoaDon> selectYear(String year){
		ArrayList<HoaDon> hoadons = new ArrayList<HoaDon>();
		try {
			String sql = "SELECT *FROM ds_hoadons WHERE YEAR(`Ngày tạo`)=?"; 
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, year);
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next())
			{
				int MaHD = resultSet.getInt("Mã hóa đơn");
				double tongTien = resultSet.getDouble("Tổng tiền");
				double thanhToan = resultSet.getDouble("Thanh toán");
				double tienThua = resultSet.getDouble("Tiền thừa");
				String ngayTao = resultSet.getString("Ngày tạo");
				String hinhThuc = resultSet.getString("Hình thức thanh toán");
				String nhanVienTao = resultSet.getString("Nhân viên tạo");
				String khachKhang = resultSet.getString("Khách hàng");
				String trangThai = resultSet.getString("Trạng thái thanh toán");
				
				HoaDon hoadon = new HoaDon(MaHD, tongTien, thanhToan, tienThua, ngayTao, hinhThuc, nhanVienTao, khachKhang, trangThai);
				hoadons.add(hoadon);
			}
			preparedstatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hoadons;
	}

	@Override
	public HoaDon selectById(HoaDon t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HoaDon> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
