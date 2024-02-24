package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao.BanHangDAO;
import dao.GioHangDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import model.BanHang;
import model.GioHang;
import model.HoaDon;
import model.NhanVien;
import model.SanPham;
import view.ViewBanHang;
import view.ViewHoaDon;
import view.ViewSanPham;

public class BanHangController {
	
	private ViewBanHang viewBanHang;
	private HoaDonDAO hoadonDAO;
	private GioHangDAO giohangDAO;
	private SanPhamDAO sanphamDAO;
	private ViewHoaDon viewHoadon;
	private ViewSanPham viewSanpham;
	
	public BanHangController() {
		viewHoadon = new ViewHoaDon();
		viewSanpham = new ViewSanPham();
	}
	
	public BanHangController(ViewBanHang viewBanHang, ViewHoaDon viewHoadon, ViewSanPham viewSanpham) {
		this.viewBanHang = viewBanHang;
		this.viewHoadon = viewHoadon;
		this.viewSanpham = viewSanpham;
		hoadonDAO = new HoaDonDAO();
		giohangDAO = new GioHangDAO();
		sanphamDAO = new SanPhamDAO();
		
		viewBanHang.addThoatListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		viewBanHang.addAddDonHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoaDon hoadon = viewBanHang.getHoaDonData();
				
				if(hoadon!=null)
				{
					boolean success = hoadonDAO.insert(hoadon);
					if(success)
					{
						viewBanHang.showListHoaDon(hoadonDAO.selectAll());
						viewBanHang.showMessage("Đã tạo hóa đơn");
					}
					else
					{
						viewBanHang.showMessage("Tạo hóa đơn thất bại");
					}
				}
			}
		});
		
		viewBanHang.addTableSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				viewBanHang.fillInputFormHoaDon();
			}
		});
		
		viewBanHang.addEditDonHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                HoaDon hoadon = viewBanHang.getHoaDonData();
				
				if(hoadon!=null)
				{
					boolean success = hoadonDAO.update(hoadon);
					if(success)
					{
						viewBanHang.showListHoaDon(hoadonDAO.selectAll());
						viewBanHang.showMessage("Đã sửa thành công.");
					}
					else
					{
						viewBanHang.showMessage("Sửa hóa đơn thất bại!");
					}
				}
			}
		});
		
		viewBanHang.addHuyDonHangListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                HoaDon hoadon = viewBanHang.getHoaDonData();
				GioHang giohang = viewBanHang.getGioHangData();
				if(hoadon!=null)
				{
					boolean success = hoadonDAO.delete(hoadon);
					boolean success1 = giohangDAO.deleteAll(giohang);
					if(!success && success1)
					{
						ArrayList<GioHang> giohangs = giohangDAO.selectAll();
						viewBanHang.showListGioHang(giohangs);
						viewBanHang.showListHoaDon(hoadonDAO.selectAll());
						viewBanHang.setThongTinAll();
						viewBanHang.showMessage("Đã hủy hóa đơn.");
					}
					else
					{
						viewBanHang.showMessage("Hủy hóa đơn thất bại!");
					}
				}
			}
		});
		
		viewBanHang.addXoaSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GioHang giohang = viewBanHang.getGioHangData();
				
				if(giohang!=null)
				{
					boolean success = giohangDAO.delete(giohang);
					if(success)
					{
						ArrayList<GioHang> giohangs = giohangDAO.selectAll();
						viewBanHang.setTongTien(giohangs);
						viewBanHang.showListGioHang(giohangDAO.selectAll());
						viewBanHang.showMessage("Đã xóa sản phẩm.");
					}
					else
					{
						viewBanHang.showMessage("Xóa sản phẩm không thành công!");
					}
				}
			}
		});
		
		viewBanHang.addXoaTatCaSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GioHang giohang = viewBanHang.getGioHangData();
				if(giohang!=null)
				{
					boolean success = giohangDAO.deleteAll(giohang);
					if(success)
					{
						ArrayList<GioHang> giohangs = giohangDAO.selectAll();
						viewBanHang.setTongTien(giohangs);
						viewBanHang.showListGioHang(giohangDAO.selectAll());
						viewBanHang.showMessage("Đã xóa tất cả sản phẩm.");
					}
					else
					{
						viewBanHang.showMessage("Xóa thất bại!");
					}
				}
			}
		});
		
		viewBanHang.AddThemSanPhamListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SanPham sanpham = viewBanHang.getSanPhamGioHang();
				if(sanpham!=null)
				{
					int soluong = viewBanHang.getSoLuong();
					int soluongton = sanpham.getSoLuongTon();
					
					if(soluong > 0 && soluong <= soluongton ) 
					{
						GioHang giohang = new GioHang(sanpham.getMaSP(), sanpham.getTenSP(), sanpham.getGiaSp(), soluong);
					    boolean success = giohangDAO.insert(giohang);
					    sanpham.setSoLuongTon(soluongton - soluong);
					    sanphamDAO.update(sanpham);
					if(success)
					{
						ArrayList<GioHang> giohangs = giohangDAO.selectAll();
						ArrayList<SanPham> sanphams = sanphamDAO.selectAll();
						viewBanHang.showListGioHang(giohangs);
						viewBanHang.setTongTien(giohangs);
						viewBanHang.showListSanPham(sanphams);
						viewBanHang.showMessage("Đã thêm sản phẩm.");
					}
					else
					{
						viewBanHang.showMessage("Thêm thất bại!");
					}
					}
					else
					{
						viewBanHang.showMessage("Nhập số lượng sai!");
				    }
				}
			}
		});	
		
		viewBanHang.addThanhToanHoaDonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewBanHang.thanhToan();
			}
		});
		
		viewBanHang.addTenThuaHoaDonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				viewBanHang.soTienTraKhach();
			}
		});
		
		viewBanHang.addThanhToanListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoaDon hoadon = viewBanHang.getHoaDonAllData();
				GioHang giohang = viewBanHang.getGioHangData();
				if(hoadon != null)
				{
					boolean success = hoadonDAO.updateAll(hoadon);
					boolean success1 = giohangDAO.deleteAll(giohang);
					if(success && success1)
					{
						ArrayList<GioHang> giohangs = giohangDAO.selectAll();
						viewBanHang.showListGioHang(giohangs);
						viewBanHang.setThongTinAll();
						viewBanHang.showMessage("Đã thanh toán.");
					}
					else
					{
						viewBanHang.showMessage("Thanh toán thất bại!");
					}
				}
			}
		});
		
	}
	
	public void showViewBanHang() {
		List<GioHang> giohangs = giohangDAO.selectAll();
		List<HoaDon> hoadons = hoadonDAO.selectAll();
		List<SanPham> sanphams = sanphamDAO.selectAll();
		viewBanHang.showListGioHang(giohangs);
		viewBanHang.showListHoaDon(hoadons);
		viewBanHang.showListSanPham(sanphams);
		viewBanHang.setVisible(true);
	}
	
}
