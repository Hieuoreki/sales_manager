package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.NhanVienDAO;
import model.NhanVien;
import view.ViewNhanVien;

public class NhanVienController {
	
	private ViewNhanVien nhanvienView;
	private NhanVienDAO nhanvienDAO;
	
	public NhanVienController(ViewNhanVien nhanvienView) {
		
		this.nhanvienView = nhanvienView;
		nhanvienDAO = new NhanVienDAO();
		
		nhanvienView.addThoatListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		nhanvienView.addAddNhanVienListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NhanVien nhanvien = nhanvienView.getNhanVienData();
				if(nhanvien!=null)
				{
					boolean success = nhanvienDAO.insert(nhanvien);
					
					if(success)
					{
						nhanvienView.showListNhanVien(nhanvienDAO.selectAll());
						nhanvienView.setStart();
						nhanvienView.showMessage("Thêm thành công");
					}
					else
					{
						nhanvienView.showMessage("Thêm thất bại");
					}
				}
			}
		});
		
		nhanvienView.addTableSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				nhanvienView.fillInputForm();
			}
		});
		
		nhanvienView.editAddNhanVienListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NhanVien nhanvien = nhanvienView.getNhanVienData();
				if(nhanvien!=null)
				{
					boolean success = nhanvienDAO.update(nhanvien);
					
					if(success)
					{
						nhanvienView.showListNhanVien(nhanvienDAO.selectAll());
						nhanvienView.setStart();
						nhanvienView.showMessage("Sửa thành công");
					}
					else
					{
						nhanvienView.showMessage("Sửa thất bại");
					}
				}
			}
		});
		
		nhanvienView.deleteAddNhanVienListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NhanVien nhanvien = nhanvienView.getNhanVienData();
				if(nhanvien!=null)
				{
					boolean success = nhanvienDAO.delete(nhanvien);
					
					if(success)
					{
						nhanvienView.showListNhanVien(nhanvienDAO.selectAll());
						nhanvienView.setStart();
						nhanvienView.showMessage("Xóa thành công");
					}
					else
					{
						nhanvienView.showMessage("Xóa thất bại");
					}
				}
			}
		});
		
	}
	
	//Ta không hiển thị giao diện ở View mà ở controller, nên ta viết hàm này
	public void showViewNhanVien() {
		
		//Trước khi hiển thị lên thì ta cần đọc cấy thông tin từ database để view vào cấy bảng
		List<NhanVien> nhanViens = nhanvienDAO.selectAll();
		
		//Cập nhật lại dữ liệu cho bảng bằng showListNhanVien ở bên ViewNhanVien
		nhanvienView.showListNhanVien(nhanViens);
		
		//Hiển thị lên
		nhanvienView.setVisible(true);
	}
	

}
