package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.GioHang;

public class TableGioHang extends AbstractTableModel {
	
	private String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng"};
	private List<GioHang> giohangs;
	
	public TableGioHang() {
		giohangs = new ArrayList<GioHang>();
	}
	
	public void setData(List<GioHang> giohangs) {
		this.giohangs = giohangs;
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
		return giohangs.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		GioHang gioHang = giohangs.get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return gioHang.getMaSP();
		case 1:
			return gioHang.getTenSP();
		case 2:
			return gioHang.getDonGia();
		case 3:
			return gioHang.getSoLuong();
		}
		return null;
	}

}
