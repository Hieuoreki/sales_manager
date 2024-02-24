package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionData;
import model.SanPham;

public class SanPhamDAO implements interfacesDAO<SanPham> {
	
	private Connection connection;
	
	public SanPhamDAO() {
		connection = ConnectionData.getConnection();
	}

	public SanPhamDAO(Connection connection) {
		this.connection = connection;
	}
	
	public static SanPhamDAO getInstance() {
		return new SanPhamDAO();
	}

	@Override
	public boolean insert(SanPham t) {
		// TODO Auto-generated method stub
		try {
			String sql = "INSERT INTO ds_sanpham(`Mã sản phẩm`, `Tên sản phẩm`, `Đơn giá`, `Số lượng tồn`) VALUES(?, ?, ?, ?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, t.getMaSP());
			prepareStatement.setString(2, t.getTenSP());
			prepareStatement.setDouble(3, t.getGiaSp());
			prepareStatement.setInt(4, t.getSoLuongTon());
			prepareStatement.executeUpdate();
			prepareStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(SanPham t) {
		// TODO Auto-generated method stub
		try {
			String sql = "UPDATE ds_sanpham SET `Tên sản phẩm`=?, `Đơn giá`=?, `Số lượng tồn`=? WHERE `Mã sản phẩm`=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getTenSP());
			preparedStatement.setDouble(2, t.getGiaSp());
			preparedStatement.setInt(3, t.getSoLuongTon());
			preparedStatement.setString(4, t.getMaSP());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateSoLuongTon(SanPham t) {
		try {
			String sql = "UPDATE ds_sanpham SET `Số lượng tồn` = ? WHERE `Mã sản phẩm` = ?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, t.getSoLuongTon());
			preparestatement.setString(2, t.getMaSP());
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
	public boolean delete(SanPham t) {
		// TODO Auto-generated method stub
		try {
			String sql = "DELETE FROM ds_sanpham WHERE `Mã sản phẩm` = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getMaSP());
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
	public ArrayList<SanPham> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			Statement statement = connection.createStatement();
			String sql = "SELECT *FROM ds_sanpham";
			ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				String MaSP = resultSet.getString("Mã sản phẩm");
				String TenSP = resultSet.getString("Tên sản phẩm");
				double giaSP = resultSet.getDouble("Đơn giá");
				int soLuong = resultSet.getInt("Số lượng tồn");
				
				SanPham sanPham = new SanPham(MaSP, TenSP, giaSP, soLuong);
				sanPhams.add(sanPham);
			}
			statement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sanPhams;
	}

	@Override
	public SanPham selectById(SanPham t) {
		// TODO Auto-generated method stub
		SanPham sanPham = new SanPham();
		try {
			String sql = "SELECT *FROM ds_sanpham WHERE `Mã sản phẩm`=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getMaSP());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String MaSP = resultSet.getString("Mã sản phẩm");
				String TenSP = resultSet.getString("Tên sản phẩm");
				double giaSP = resultSet.getDouble("Đơn giá");
				int soLuong = resultSet.getInt("Số lượng tồn");
				
				sanPham = new SanPham(MaSP, TenSP, giaSP, soLuong);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sanPham;
	}

	@Override
	public ArrayList<SanPham> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			String sql = "SELECT *FROM ds_sanpham WHERE " + condition;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String MaSP = resultSet.getString("Mã sản phẩm");
				String TenSP = resultSet.getString("Tên sản phẩm");
				double giaSP = resultSet.getDouble("Đơn giá");
				int soLuong = resultSet.getInt("Số lượng tồn");
				SanPham sanpham = new SanPham(MaSP, TenSP, giaSP, soLuong);
				sanPhams.add(sanpham);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sanPhams;
	}
	
	public ArrayList<SanPham> selectByName(String tenSp) {
		// TODO Auto-generated method stub
		ArrayList<SanPham> sanPhams = new ArrayList<SanPham>();
		try {
			String sql = "SELECT *FROM ds_sanpham WHERE `Tên sản phẩm`=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tenSp);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String MaSP = resultSet.getString("Mã sản phẩm");
				String TenSP = resultSet.getString("Tên sản phẩm");
				double giaSP = resultSet.getDouble("Đơn giá");
				int soLuong = resultSet.getInt("Số lượng tồn");
				SanPham sanpham = new SanPham(MaSP, TenSP, giaSP, soLuong);
				sanPhams.add(sanpham);
			}
			preparedStatement.close();
			resultSet.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sanPhams;
	}

}
