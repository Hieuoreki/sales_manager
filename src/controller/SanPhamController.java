package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.SanPhamDAO;
import model.SanPham;
import view.ViewSanPham;

public class SanPhamController {
	
	private ViewSanPham viewsanPham;
	private SanPhamDAO sanphamDAO;
	
	public SanPhamController(ViewSanPham viewsanPham) {
		this.viewsanPham = viewsanPham;
		sanphamDAO = new SanPhamDAO();
		
		viewsanPham.addThoatListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		viewsanPham.addAddSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SanPham sanpham = viewsanPham.getSanPhamData();
				if(sanpham!=null)
				{
					boolean success = sanphamDAO.insert(sanpham);
					if(success)
					{
						viewsanPham.showListSanPham(sanphamDAO.selectAll());
						viewsanPham.showMessage("Thêm thành công");
					}
					else {
						viewsanPham.showMessage("Thêm thất bại");
					}
				}
			}
		});
		
		viewsanPham.addTableSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				viewsanPham.fillInputForm();
			}
		});
		
		viewsanPham.editAddSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SanPham sanpham = viewsanPham.getSanPhamData();
				if(sanpham!=null)
				{
					boolean success = sanphamDAO.update(sanpham);
					if(success)
					{
						viewsanPham.showListSanPham(sanphamDAO.selectAll());
						viewsanPham.showMessage("Sửa thành công");
					}
					else
					{
						viewsanPham.showMessage("Sửa thất bại");
					}
				}
			}
		});
		
		viewsanPham.deleteAddSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SanPham sanpham = viewsanPham.getSanPhamData();
				if(sanpham!=null)
				{
					boolean success = sanphamDAO.delete(sanpham);
					if(success)
					{
						viewsanPham.showListSanPham(sanphamDAO.selectAll());
						viewsanPham.showMessage("Đã xóa thành công");
					}
					else
					{
						viewsanPham.showMessage("Xóa thất bại");
					}
				}
			}
		});
		
		viewsanPham.searchAddSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sanpham = viewsanPham.findSanPham();
				if(sanpham!=null)
				{
					ArrayList<SanPham> success = sanphamDAO.selectByName(sanpham);
					if(success!=null)
					{
						viewsanPham.showListSanPham(success);
					}
					else 
					{
						viewsanPham.showMessage("Không tìm thấy sản phẩm");
					}
				}
			}
		});
		
		viewsanPham.addRefreshTableSanPham(new ActionListener() { 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				boolean success = viewsanPham.setSanPhamAll();
				if(success)
				{
					viewsanPham.showListSanPham(sanphamDAO.selectAll());
				}
			}
		});
		
	}
	
	//Giao diện sẽ không hiển thị ở view mà ở đây, nên ta tạo hàm ni
	public void showSanPhamView() {
		//Trước khi hiển thị giao diện thì cần lấy dữ liệu từ database vào bảng đã
		List<SanPham> sanPhams = sanphamDAO.selectAll();
		// Sau khi lấy xong thì cập nhật lại dữ liệu rồi hiển thị lên bằng showListSanPham đc tạo bên view
		viewsanPham.showListSanPham(sanPhams);
		// rồi mới hiển thị dao diện
		viewsanPham.setVisible(true);
	}

}
