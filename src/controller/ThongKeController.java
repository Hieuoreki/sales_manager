package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import dao.HoaDonDAO;
import model.HoaDon;
import model.ThongKe;
import view.ViewHoaDon;
import view.ViewThongKe;

public class ThongKeController {
	
	private ViewThongKe viewThongKe;
	private HoaDonDAO hoadonDAO;

	public ThongKeController(ViewThongKe viewThongKe) {
		this.viewThongKe = viewThongKe;
		hoadonDAO = new HoaDonDAO();
		
		viewThongKe.addThoatListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		viewThongKe.addItemTongDoanhThuListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            ArrayList<HoaDon> hoadons = viewThongKe.getData();
		            if(hoadons!=null)
		            {
		            	ArrayList<HoaDon> hoadon = hoadonDAO.selectAll();
		            	viewThongKe.getTongDoanhThu(hoadon);
		            	viewThongKe.getTongHoaDon(hoadon);
		            	viewThongKe.getTongKhachHang(hoadon);
		            }
		        } else if (e.getStateChange() == ItemEvent.DESELECTED) {
		            viewThongKe.doSomeThing();
		        }
			}
		});
		
		viewThongKe.addItemDoanhThuThang(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String month = viewThongKe.listThang();
				if(month!="None")
				{
					ArrayList<HoaDon> hoadons = viewThongKe.getData();
					if(hoadons!=null)
					{
						ArrayList<HoaDon> hoadon = hoadonDAO.selectMonth(month);
						viewThongKe.getTongDoanhThu(hoadon);
						viewThongKe.getTongHoaDon(hoadon);
						viewThongKe.getTongKhachHang(hoadon);
					}
				}
				else
				{
					viewThongKe.doSomeThing();
				}
			}
		});
		
		viewThongKe.addItemDoanhThuNam(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String year = viewThongKe.listNam();
				if(year!="None")
				{
					ArrayList<HoaDon> hoadons = viewThongKe.getData();
					if(hoadons!=null)
					{
						ArrayList<HoaDon> hoadon = hoadonDAO.selectYear(year);
						viewThongKe.getTongDoanhThu(hoadon);
						viewThongKe.getTongHoaDon(hoadon);
						viewThongKe.getTongKhachHang(hoadon);
					}
				}
				else
				{
					viewThongKe.doSomeThing();
				}
			}
		});
		
		viewThongKe.addGuiBaoCaoListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String month = viewThongKe.listThang();
				if(month!="None")
				{
					ArrayList<HoaDon> hoadons = viewThongKe.getData();
				if(hoadons!=null)
				{
					ArrayList<HoaDon> hoadon = hoadonDAO.selectMonth(month);
					ViewThongKe.email("tnguyentran659@gmail.com", "Báo Cáo Doanh Thu Cửa Hàng", viewThongKe.noiDung(hoadon));
				}
				else
				{
					viewThongKe.showMessage("Gửi báo cáo thất bại");
				}
				}
				
			}
		});
	}
	
	public void showViewThongKe() {
		viewThongKe.setVisible(true);
	}
	

}
