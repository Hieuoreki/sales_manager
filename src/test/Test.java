package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controller.BanHangController;
import controller.HoaDonController;
import controller.NhanVienController;
import controller.SanPhamController;
import controller.ThongKeController;
import dao.BanHangDAO;
import dao.HoaDonDAO;
import dao.SanPhamDAO;
import model.BanHang;
import model.HoaDon;
import model.NhanVien;
import model.SanPham;
import view.ViewBanHang;
import view.ViewHoaDon;
import view.ViewNhanVien;
import view.ViewSanPham;
import view.ViewThongKe;

public class Test {
	public static void main(String[] args) {
		
		/*
		ViewSanPham s = new ViewSanPham();
		SanPhamController c = new SanPhamController(s);
		c.showSanPhamView();
		*/
		
		/*
		SanPham s = new SanPham();
		ArrayList<SanPham> p = SanPhamDAO.getInstance().selectByName("RAM DDR4");
		System.out.println(p);
		*/
		
		ViewBanHang s = new ViewBanHang();
		ViewHoaDon h = new ViewHoaDon();
		s.setLocationRelativeTo(null);
		BanHangController c = new BanHangController(s, h, null);
		c.showViewBanHang();
		
		
		/*
		HoaDon h = new HoaDon(10, 500, 500, 0, "03-01-2024", "Quẹt thẻ", "Nguyễn Khắc Nhật", "Văn Tiến Hùng", "Chưa thanh toán");
		BanHang b = new BanHang(null, h);
		BanHangDAO.getInstance().update(b);
		*/
		
		/*
		ViewHoaDon s = new ViewHoaDon();
		HoaDonController c = new HoaDonController(s);
		c.showViewHoaDon();
		*/
		/*
		ArrayList<BanHang> p = BanHangDAO.getInstance().selectAll();
		for( BanHang k : p) {
			System.out.println(k);
		}
		*/
		
		/*
		ViewNhanVien s = new ViewNhanVien();
		NhanVienController p = new NhanVienController(s);
		p.showViewNhanVien();
		*/
		
		/*
		ArrayList<HoaDon> h = HoaDonDAO.getInstance().selectMonth("01");
		for(HoaDon s : h)
		{
			System.out.println(s);
		}
		*/
		
		/*
		ViewThongKe s = new ViewThongKe();
		s.setLocationRelativeTo(null);
		ThongKeController c = new ThongKeController(s);
		c.showViewThongKe();
		*/
		/*
		final String from = "codehieuhoc@gmail.com";
		final String password = "ngenigyvtbahqkqm";
		
		final String to = "tnguyentran659@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		javax.mail.Authenticator auth = new javax.mail.Authenticator() {

			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new javax.mail.PasswordAuthentication(from, password);
			}
		};
		//Phiên làm việc
		Session session = Session.getInstance(props, auth);
		
		
		//Tạo 1 tin nhắn
		MimeMessage msg = new MimeMessage(session);
		try {
			//Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			
			//Người gửi
			msg.setFrom(from);
			
			//Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			
			//Tiêu đề email
			msg.setSubject("Báo cáo doanh thu");
			
			// Quy định ngày gửi
			msg.setSentDate(new Date());
			
			//Nội dung
			msg.setText("Đây là phần nội dung", "UTF-8");
			
			// Gửi email.
			Transport.send(msg);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		*/
	
		
	}
}
