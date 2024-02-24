package table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.SanPham;

public class TableSanPham extends AbstractTableModel {
	
	private String[] columnNames = {"Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng tồn"};
	private List<SanPham> sanPhams;
	
	

	public TableSanPham() {
		sanPhams = new ArrayList<SanPham>();
	}
	
	public void setData(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
		fireTableDataChanged();
		//cấy fire ni là dùng để cập nhật lại thông tin rồi gửi về JTable khi ấn nút Thêm sửa xóa
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return columnNames[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return sanPhams.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override	
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		SanPham sanPham = sanPhams.get(rowIndex);
		switch(columnIndex)
		{
			case 0:
				return sanPham.getMaSP();
			case 1:
				return sanPham.getTenSP();
			case 2:
				return sanPham.getGiaSp();
			case 3:
				return sanPham.getSoLuongTon();
				
		}
		return null;
	}

}
