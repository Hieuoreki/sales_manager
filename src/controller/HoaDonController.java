package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import dao.HoaDonDAO;
import model.HoaDon;
import view.ViewHoaDon;

public class HoaDonController {
	
	private ViewHoaDon viewHoaDon;
	private HoaDonDAO hoadonDAO;
	
	public HoaDonController() {
		viewHoaDon = new ViewHoaDon();
	}
	
	public HoaDonController(ViewHoaDon viewHoaDon) {
		this.viewHoaDon = viewHoaDon;
		hoadonDAO = new HoaDonDAO();
		
		viewHoaDon.addThoatListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		viewHoaDon.addTimKiemHoaDonListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tenKH = viewHoaDon.findTenKhachHang();
				
				if(tenKH!="")
				{
					ArrayList<HoaDon> hoadons = hoadonDAO.selectByTenKhachHang(tenKH);
					if(hoadons!=null)
					{
						viewHoaDon.showListHoaDon(hoadons);
					}
					else
					{
						viewHoaDon.showMessage("Không tìm thấy hóa đơn!");
					}
				}
			}
		});
		
		viewHoaDon.addItemTimKiemThangListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
					String month = viewHoaDon.listThang();
					if(month!="None")
					{
						ArrayList<HoaDon> hoadons = hoadonDAO.selectMonth(month);
						if(hoadons!=null)
						{
							viewHoaDon.showListHoaDon(hoadons);
						}
						else
						{
							viewHoaDon.showMessage("Không tồn tại!");
						}
					}
					else
					{
						viewHoaDon.showListHoaDon(hoadonDAO.selectAll());
					}
			}
		});
		
		viewHoaDon.addItemTimKiemNamListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				String year = viewHoaDon.listNam();
				if(year!= "None")
				{
					ArrayList<HoaDon> hoadons = hoadonDAO.selectYear(year);
					if(hoadons!=null)
					{
						viewHoaDon.showListHoaDon(hoadons);
					}
					else
					{
						viewHoaDon.showMessage("Không tồn tại");
					}
				}
				else
				{
					viewHoaDon.showListHoaDon(hoadonDAO.selectAll());
				}
			}
		});
		
	}
	
	
	public void showViewHoaDon() {
		List<HoaDon> hoaDon = hoadonDAO.selectAll();
		viewHoaDon.showListHoaDon(hoaDon);
		viewHoaDon.setVisible(true);
	}

}
