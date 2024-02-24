package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.NhanVien;

public class TableNhanVien extends AbstractTableModel {
	
	private String[] columnNames = {"Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Vai trò", "Địa chỉ", "Điện thoại", "Ngày sinh", "Giới tính", "Trạng thái"};
	private List<NhanVien> nhanViens;
	
	

	public TableNhanVien() {
		nhanViens = new ArrayList<NhanVien>();
	}
	
	public void setData(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
		//Mõi khi dữ liệu của tableModel đc cập nhật qua setData thì tableModel sẽ thông báo cho table trong View cập nhật lại
		fireTableDataChanged();
	}
	
	

	@Override
	public String getColumnName(int column) {
		//Trả về tên cột
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		//Số đối tượng đọc lên ở database
		// TODO Auto-generated method stub
		return nhanViens.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	//Lấy giá trị của 1 ô trong bảng
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		NhanVien nhanvien = nhanViens.get(rowIndex);
		//Lấy cấy dối tượng nhân viên tại vị trí rowIndex
		//Sau đó dùng switch để xác định columnIndex cần lấy
		switch(columnIndex)
		{
		case 0:
			return nhanvien.getMaNV();
		case 1:
			return nhanvien.getMatKhau();
		case 2:
			return nhanvien.getTenNV();
		case 3:
			return nhanvien.getVaiTro();
		case 4:
			return nhanvien.getDiaChi();
		case 5:
			return nhanvien.getDienThoai();
		case 6:
			return nhanvien.getNgaySinh();
		case 7:
			return nhanvien.getGioiTinh();
		case 8:
			return nhanvien.getTrangThai();
		}
		return null;
	}

}
