package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.HoaDon;

public class TableHoaDon2 extends AbstractTableModel {
	
	private String[] columnNames = {"Mã hóa đơn", "Ngày tạo", "Nhân viên tạo","Khách hàng"};
	private List<HoaDon> hoaDons;
	
	public TableHoaDon2() {
		hoaDons = new ArrayList<HoaDon>();
	}
	
	public void setData(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
		fireTableDataChanged();
	}
	
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return hoaDons.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		HoaDon hoaDon = hoaDons.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return hoaDon.getMaHD();
		case 1:
			return hoaDon.getNgayTao();
		case 2:
			return hoaDon.getNhanVienTao();
		case 3:
			return hoaDon.getKhachHang();
		}
		return null;
	}

}
