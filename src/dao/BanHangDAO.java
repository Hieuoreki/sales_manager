package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionData;
import model.BanHang;
import model.HoaDon;
import model.SanPham;

public class BanHangDAO implements interfacesDAO<BanHang> {
	
	private Connection connection;
	
	public BanHangDAO() {
		connection = ConnectionData.getConnection();
	}

	public BanHangDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static BanHangDAO getInstance() {
		return new BanHangDAO();
	}

	@Override
	public boolean insert(BanHang t) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean update(BanHang t) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean delete(BanHang t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<BanHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<BanHang> banHangs = new ArrayList<BanHang>();
		try {
			/*`Mã hóa đơn`, `Ngày tạo`, `Nhân viên tạo`, `Khách hàng`*/
			String sql = "SELECT `Mã hóa đơn`, `Ngày tạo`, `Nhân viên tạo`, `Khách hàng` FROM ds_hoadons";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while(resultSet.next())
			{
				int MaHD = resultSet.getInt("Mã hóa đơn");
				String ngayTao = resultSet.getString("Ngày tạo");
				String nhanVienTao = resultSet.getString("Nhân viên tạo");
				String khachKhang = resultSet.getString("Khách hàng");
				
				HoaDon hoaDon = new HoaDon(MaHD, 0, 0, 0, ngayTao, null, nhanVienTao, khachKhang, null);
				BanHang banHang = new BanHang(null, hoaDon, null);
				banHangs.add(banHang);
			}
			statement.close();
			resultSet.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return banHangs;
	}

	@Override
	public BanHang selectById(BanHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<BanHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
