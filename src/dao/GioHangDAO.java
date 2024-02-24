package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionData;
import model.GioHang;

public class GioHangDAO implements interfacesDAO<GioHang> {
	
	private Connection connection;
	
	public GioHangDAO() {
		connection = ConnectionData.getConnection();
	}

	public GioHangDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static GioHangDAO getInstance() {
		return new GioHangDAO();
	}

	@Override
	public boolean insert(GioHang t) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO ds_giohang(`Mã sản phẩm`, `Tên sản phẩm`, `Đơn giá`, `Số lượng`) VALUE(?,?,?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, t.getMaSP());
			preparestatement.setString(2, t.getTenSP());
			preparestatement.setDouble(3, t.getDonGia());
			preparestatement.setInt(4, t.getSoLuong());
			preparestatement.executeUpdate();
			preparestatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(GioHang t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(GioHang t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM ds_giohang WHERE `Mã sản phẩm`=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, t.getMaSP());
			prepareStatement.executeUpdate();
			prepareStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteAll(GioHang t) {
		try {
			String sql = "DELETE FROM ds_giohang";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.executeUpdate();
			preparestatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<GioHang> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<GioHang> giohangs = new ArrayList<GioHang>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT *FROM ds_giohang";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				String MaSP = resultSet.getString("Mã sản phẩm");
				String TenSP = resultSet.getString("Tên sản phẩm");
				double DonGia = resultSet.getDouble("Đơn giá");
				int SoLuong = resultSet.getInt("Số lượng");
				GioHang giohang = new GioHang(MaSP, TenSP, DonGia, SoLuong);
				giohangs.add(giohang);
			}
			statement.close();
			resultSet.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return giohangs;
	}

	@Override
	public GioHang selectById(GioHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<GioHang> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
