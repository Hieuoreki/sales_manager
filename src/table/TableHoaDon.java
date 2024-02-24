package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.HoaDon;

public class TableHoaDon extends AbstractTableModel {
	
	private String[] columnNames = {"Mã hóa đơn", "Tổng tiền", "Thanh toán", "Tiền thừa","Ngày tạo", "Hình thức thanh toán","Nhân viên tạo","Khách hàng", "Trạng thái thanh toán"};
	private List<HoaDon> hoaDons;
	
	public TableHoaDon() {
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
			return hoaDon.getTongTien();
		case 2: 
			return hoaDon.getThanhToan();
		case 3:
			return hoaDon.getTienThua();
		case 4:
			return hoaDon.getNgayTao();
		case 5:
			return hoaDon.getHinhThuc();
		case 6:
			return hoaDon.getNhanVienTao();
		case 7:
			return hoaDon.getKhachHang();
		case 8:
			return hoaDon.getTrangThai();
		}
		return null;
	}

}
