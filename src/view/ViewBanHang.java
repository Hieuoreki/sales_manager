package view;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.HoaDonController;
import controller.NhanVienController;
import controller.SanPhamController;
import controller.ThongKeController;
import model.BanHang;
import model.GioHang;
import model.HoaDon;
import model.SanPham;
import table.TableGioHang;
import table.TableHoaDon;
import table.TableHoaDon2;
import table.TableSanPham;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ViewBanHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableHD;
	private JTable tableGH;
	private JTextField txtSoLuong;
	private JTable tableSP;
	private JTextField txtKhachHang;
	private JTextField txtMaHD;
	private JTextField txtTongTien;
	private JTextField txtThanhToan;
	private JTextField txtTienKhachDua;
	private JTextField txtTienThua;
	private JTextField txtGhiChu;
	private JTextField txtNgayTao;
	private JTextField txtNhanVienTao;
	private JButton btnEdit;
	private JButton btnAdd;
	private JButton btnXoaSP;
	private JButton btnXoaAll;
	private JButton btnHuy;
	private JButton btnThemSP;
	private JButton btnThanhToan;
	private JButton btnThoat;
	private JComboBox cbbHinhThuc;
	private TableSanPham tableModelSP;
	private TableHoaDon2 tableModelHD;
	private TableGioHang tableModelGH;
	private ViewSanPham viewSanpham;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBanHang frame = new ViewBanHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewBanHang() {
		setTitle("Phần mềm quản lý bán hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 226, 723);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nguyễn Trung Hiếu");
		lblNewLabel.setFont(new Font("UTM Alexander", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 168, 172, 40);
		panel.add(lblNewLabel);
		
		String imagePath = "C:\\Users\\DELL\\OneDrive\\Pictures/anh.png";
		JLabel image = new JLabel("");
		image.setBounds(20, 10, 206, 168);
		ImageIcon imageIcon = new ImageIcon(imagePath);
		//ImageIcon là 1 lớp đại diện cho 1 icon hay hình ảnh, cung cấp các phương thức
		Image image0 = imageIcon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), DO_NOTHING_ON_CLOSE);
		//Image là 1 lớp để điều chỉnh kích thước, getImage() là 1 phương thức của ImageIcon
		//getScaledInstance() dùng để điều chỉnh kích thước
		ImageIcon scaleIcon = new ImageIcon(image0);
		//Tạo 1 ImageIcon mới từ đối tượng image0 sau khi đã chỉnh sửa kích thước
		image.setIcon(scaleIcon);
		//Thiết lập scaleIcon là hình ảnh cho JLabel.
		panel.add(image);
		
		
		JButton btnNewButton = new JButton("Bán hàng");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnNewButton.setBounds(0, 269, 226, 65);
		panel.add(btnNewButton);
		
		JButton btnSnPhm = new JButton("Sản phẩm");
		btnSnPhm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewSanPham sanpham = new ViewSanPham();
				sanpham.setLocationRelativeTo(null);
				SanPhamController controller = new SanPhamController(sanpham);
				controller.showSanPhamView();
			}
		});
		btnSnPhm.setBackground(new Color(192, 192, 192));
		btnSnPhm.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnSnPhm.setBounds(0, 332, 226, 65);
		panel.add(btnSnPhm);
					
		JButton btnHan = new JButton("Hóa đơn");
		btnHan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewHoaDon hoadon = new ViewHoaDon();
				hoadon.setLocationRelativeTo(null);
				HoaDonController controller = new HoaDonController(hoadon);
				controller.showViewHoaDon();
			}
		});
		btnHan.setBackground(new Color(192, 192, 192));
		btnHan.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnHan.setBounds(0, 395, 226, 65);
		panel.add(btnHan);
						
		JButton btnNhnVin = new JButton("Nhân viên");
		btnNhnVin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewNhanVien nhanvien = new ViewNhanVien();
				nhanvien.setLocationRelativeTo(null);
				NhanVienController controller = new NhanVienController(nhanvien);
				controller.showViewNhanVien();
			}
		});
		btnNhnVin.setBackground(new Color(192, 192, 192));
		btnNhnVin.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnNhnVin.setBounds(0, 458, 226, 65);
		panel.add(btnNhnVin);
		
		JButton btnTK = new JButton("Thống kê");
		btnTK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewThongKe thongke = new ViewThongKe();
				thongke.setLocationRelativeTo(null);
				ThongKeController controller = new ThongKeController(thongke);
				controller.showViewThongKe();
			}
		});
		btnTK.setBackground(new Color(192, 192, 192));
		btnTK.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnTK.setBounds(0, 521, 226, 65);
		panel.add(btnTK);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(192, 192, 192));
		btnThoat.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnThoat.setBounds(0, 584, 226, 65);
		panel.add(btnThoat);
		
		JLabel lblNewLabel_1 = new JLabel("Hóa đơn chờ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(236, 0, 96, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2.setBounds(236, 28, 551, 142);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(263, 42, 499, 107);
		contentPane.add(scrollPane);
		
		tableHD = new JTable();
		tableModelHD = new TableHoaDon2();
		tableHD.setModel(tableModelHD);
		scrollPane.setViewportView(tableHD);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		lblNewLabel_3.setBounds(886, 28, 410, 685);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đơn hàng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(886, 0, 96, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giỏ hàng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(236, 169, 96, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1.setBounds(236, 195, 640, 156);
		contentPane.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(265, 211, 433, 128);
		contentPane.add(scrollPane_1);
		
		tableGH = new JTable();
		tableModelGH = new TableGioHang();
		tableGH.setModel(tableModelGH);
		scrollPane_1.setViewportView(tableGH);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(236, 349, 163, 32);
		contentPane.add(lblNewLabel_1_2_1);
		
		btnXoaSP = new JButton("Xóa sản phẩm");
		btnXoaSP.setBackground(new Color(255, 255, 51));
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaSP.setBounds(730, 229, 130, 32);
		contentPane.add(btnXoaSP);
		
		btnXoaAll = new JButton("Xóa tất cả");
		btnXoaAll.setBackground(new Color(255, 51, 51));
		btnXoaAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnXoaAll.setBounds(730, 283, 130, 32);
		contentPane.add(btnXoaAll);
		
		JLabel lblNewLabel_4 = new JLabel("Số lượng");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(258, 385, 153, 22);
		contentPane.add(lblNewLabel_4);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(256, 405, 188, 26);
		contentPane.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		btnThemSP = new JButton("Thêm sản phẩm");
		btnThemSP.setBackground(new Color(255, 255, 51));
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemSP.setBounds(467, 402, 177, 32);
		contentPane.add(btnThemSP);
		
		JLabel lblNewLabel_4_1 = new JLabel("Danh mục");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(669, 385, 153, 22);
		contentPane.add(lblNewLabel_4_1);
		
		JComboBox cbbSP = new JComboBox();
		cbbSP.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String query = cbbSP.getSelectedItem().toString();
					filter(query);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		cbbSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbbSP.setModel(new DefaultComboBoxModel(new String[] {"None", "RAM", "Ổ cứng", "Bàn phím", "VGA", "Bo mạch chủ", "CPU"}));
		cbbSP.setBounds(669, 405, 188, 26);
		contentPane.add(cbbSP);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(258, 450, 603, 250);
		contentPane.add(scrollPane_2);
		
		tableSP = new JTable();
		tableModelSP = new TableSanPham();
		tableSP.setModel(tableModelSP);
		scrollPane_2.setViewportView(tableSP);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1_1.setBounds(236, 375, 640, 338);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tên khách hàng:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(915, 138, 114, 32);
		contentPane.add(lblNewLabel_5_1);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(1024, 146, 145, 19);
		contentPane.add(txtKhachHang);
		
		JLabel lblNewLabel_5_2 = new JLabel("Mã hóa đơn:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2.setBounds(915, 54, 96, 32);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Tổng tiền:");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_3.setBounds(909, 195, 114, 32);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Thanh toán:");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_4.setBounds(909, 236, 114, 32);
		contentPane.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Tiền khách đưa:");
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_5.setBounds(909, 277, 114, 32);
		contentPane.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("Tiền thừa trả khách:");
		lblNewLabel_5_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_6.setBounds(909, 318, 145, 32);
		contentPane.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("Hình thức thanh toán:");
		lblNewLabel_5_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_7.setBounds(909, 359, 145, 32);
		contentPane.add(lblNewLabel_5_7);
		
		JLabel lblNewLabel_5_11 = new JLabel("Ghi chú:");
		lblNewLabel_5_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_11.setBounds(909, 400, 114, 32);
		contentPane.add(lblNewLabel_5_11);
		
		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(1024, 58, 145, 19);
		contentPane.add(txtMaHD);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(1055, 200, 114, 19);
		contentPane.add(txtTongTien);
		
		txtThanhToan = new JTextField();
		txtThanhToan.setColumns(10);
		txtThanhToan.setBounds(1055, 238, 114, 19);
		contentPane.add(txtThanhToan);
		
		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setColumns(10);
		txtTienKhachDua.setBounds(1055, 280, 114, 19);
		contentPane.add(txtTienKhachDua);
		
		txtTienThua = new JTextField();
		txtTienThua.setColumns(10);
		txtTienThua.setBounds(1055, 325, 114, 19);
		contentPane.add(txtTienThua);
		
		btnAdd = new JButton("Tạo");
		btnAdd.setBackground(new Color(255, 204, 51));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBounds(1194, 58, 76, 38);
		contentPane.add(btnAdd);
		
		cbbHinhThuc = new JComboBox();
		cbbHinhThuc.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbbHinhThuc.setModel(new DefaultComboBoxModel(new String[] {"Tiền mặt", "Chuyển khoản", "Quẹt thẻ"}));
		cbbHinhThuc.setBounds(1055, 360, 139, 21);
		contentPane.add(cbbHinhThuc);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setBounds(909, 431, 318, 114);
		contentPane.add(txtGhiChu);
		txtGhiChu.setColumns(10);
		
		btnThanhToan = new JButton("Thanh toán");
		btnThanhToan.setBackground(new Color(0, 204, 0));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnThanhToan.setBounds(909, 620, 346, 80);
		contentPane.add(btnThanhToan);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1_2.setBounds(896, 42, 386, 142);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Ngày tạo:");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2_1.setBounds(915, 80, 96, 32);
		contentPane.add(lblNewLabel_5_2_1);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("Nhân viên tạo:");
		lblNewLabel_5_2_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2_2.setBounds(915, 108, 96, 32);
		contentPane.add(lblNewLabel_5_2_2);
		
		txtNgayTao = new JTextField();
		txtNgayTao.setColumns(10);
		txtNgayTao.setBounds(1024, 87, 145, 19);
		contentPane.add(txtNgayTao);
		
		txtNhanVienTao = new JTextField();
		txtNhanVienTao.setColumns(10);
		txtNhanVienTao.setBounds(1024, 116, 145, 19);
		contentPane.add(txtNhanVienTao);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBackground(new Color(255, 204, 51));
		btnEdit.setBounds(1194, 126, 76, 38);
		contentPane.add(btnEdit);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHuy.setBackground(new Color(255, 0, 0));
		btnHuy.setBounds(906, 571, 76, 22);
		contentPane.add(btnHuy);

	}
	
	public void addThoatListener(ActionListener listener) {
		btnThoat.addActionListener(listener);
	}

	public void showListGioHang(List<GioHang> giohangs) {
		// TODO Auto-generated method stub
		tableModelGH.setData(giohangs);
	}
	
	public void showListHoaDon(List<HoaDon> hoadons) {
		// TODO Auto-generated method stub
		tableModelHD.setData(hoadons);
	}
	
	public void showListSanPham(List<SanPham> sanphams) {
		// TODO Auto-generated method stub
		tableModelSP.setData(sanphams);
	}
	
	public boolean validateHoaDonDataAll(int id, String ngaytao, String nhanvientao, String khachhang ,double tongTien, double thanhToan, double khachDua, String hinhThuc, String trangThai) {
		if(id==0 || ngaytao.length() == 0 || nhanvientao.length() == 0 || khachhang.length() == 0 || tongTien == 0 || thanhToan == 0 || khachDua == 0 || hinhThuc.length() == 0 || trangThai.length() == 0)
		{
			return false;
		}
		return true;
	}
	
	public boolean validateHoaDonData(int id, String ngaytao, String nhanvientao, String khachhang) {
		if(id==0 || ngaytao.length() == 0 || nhanvientao.length() == 0 || khachhang.length() == 0 )
		{
			return false;
		}
		return true;
	}
	
	public HoaDon getHoaDonData() {
		int id = 0;
		try {
			id = Integer.parseInt(txtMaHD.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String ngaytao = txtNgayTao.getText();
		String nhanvientao = txtNhanVienTao.getText();
		String khachhang = txtKhachHang.getText();
		
		if(validateHoaDonData(id, ngaytao, nhanvientao, khachhang)==false)
		{
			showMessage("Thông tin không hợp lệ!");
			return null;
		}
		
		HoaDon hoadon = new HoaDon(id, 0, 0, 0, ngaytao, null, nhanvientao, khachhang, null);
		return hoadon;
	}
	
	public HoaDon getHoaDonAllData() {
		HoaDon data0 = getHoaDonData();
		
		double tongTien = 0;
		try {
			tongTien = Double.parseDouble(txtTongTien.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		double thanhToan = 0;
		try {
			thanhToan = Double.parseDouble(txtThanhToan.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		double khachDua = 0;
		try {
			khachDua = Double.parseDouble(txtTienKhachDua.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		double tienThua = 0;
		try {
			tienThua = Double.parseDouble(txtTienThua.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String hinhThuc = cbbHinhThuc.getSelectedItem().toString();
		String trangThai = txtGhiChu.getText();
		
		if(validateHoaDonDataAll( data0.getMaHD(), data0.getNgayTao(), data0.getNhanVienTao(), data0.getKhachHang(), tongTien, thanhToan, khachDua, hinhThuc, trangThai) == false)
		{
			showMessage("Thông tin không hợp lệ");
			return null;
		}
		HoaDon hoadon = new HoaDon(data0.getMaHD(), tongTien, thanhToan, tienThua, data0.getNgayTao(), hinhThuc, data0.getNhanVienTao(), data0.getKhachHang(), trangThai);
		return hoadon;
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void addAddDonHangListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}
	
	public void addTableSelectionListener(ListSelectionListener listener) {
		tableHD.getSelectionModel().addListSelectionListener(listener);
	}
	
	public void fillInputFormHoaDon() {
		int row = tableHD.getSelectedRow();
		if(row >= 0)
		{
			txtMaHD.setText(tableHD.getValueAt(row, 0).toString());
			txtNgayTao.setText(tableHD.getValueAt(row, 1).toString());
			txtNhanVienTao.setText(tableHD.getValueAt(row, 2).toString());
			txtKhachHang.setText(tableHD.getValueAt(row, 3).toString());
		}
	}
	
	public void addEditDonHangListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	
	public void addHuyDonHangListener(ActionListener listener) {
		btnHuy.addActionListener(listener);
	}
	
	public void filter(String query) {
		TableRowSorter<TableSanPham> sp = new TableRowSorter<TableSanPham>(tableModelSP);
		tableSP.setRowSorter(sp);
		if(query!="None")
		{
			sp.setRowFilter(RowFilter.regexFilter(query));
		}
		else
		{
			tableSP.setRowSorter(null);
		}
	}
	
	public void addXoaSanPhamListener(ActionListener listener) {
		btnXoaSP.addActionListener(listener);
	}
	
	public void addXoaTatCaSanPhamListener(ActionListener listener) {
		btnXoaAll.addActionListener(listener);
	}
	
	public GioHang getGioHangData() {
	    GioHang giohang = null;
	    int row = tableGH.getSelectedRow();
	    if (row >= 0) {
	        String id = tableGH.getValueAt(row, 0).toString();
	        String ten = tableGH.getValueAt(row, 1).toString();
	        double gia = Double.parseDouble(tableGH.getValueAt(row, 2).toString());
	        int soluong = Integer.parseInt(tableGH.getValueAt(row, 3).toString());
	        giohang = new GioHang(id, ten, gia, soluong);
	    }
	    return giohang;
	}
	
	public SanPham getSanPhamGioHang() {
		SanPham sanpham = null;
		int row = tableSP.getSelectedRow();
		if(row >= 0)
		{
			String id = tableSP.getValueAt(row, 0).toString();
	        String ten = tableSP.getValueAt(row, 1).toString();
	        double gia = Double.parseDouble(tableSP.getValueAt(row, 2).toString());
	        int soluong = Integer.parseInt(txtSoLuong.getText().toString());
	        int soluongton = Integer.parseInt(tableSP.getValueAt(row, 3).toString());
	        sanpham = new SanPham(id, ten, gia, soluongton);
		}
		return sanpham;
	}
	
	public List<SanPham> getSanPham() {
		List<SanPham> sanphams = new ArrayList<SanPham>();
		int rowCount = tableSP.getRowCount();
		for(int i = 0; i<rowCount; i++)
		{
			String id = tableSP.getValueAt(i, 0).toString();
	        String ten = tableSP.getValueAt(i, 1).toString();
	        double gia = Double.parseDouble(tableSP.getValueAt(i, 2).toString());
	        int soluongton = Integer.parseInt(tableSP.getValueAt(i, 3).toString());
	        SanPham sanpham = new SanPham(id, ten, gia, soluongton);
	        sanphams.add(sanpham);
		}
		return sanphams;
	}
	
	public ArrayList<SanPham> getAllSanPham() {
		ArrayList<SanPham> sanphams = new ArrayList<SanPham>();
		int rowCount = tableSP.getRowCount();	
		for(int i = 0; i<rowCount; i++)
		{
				String id = tableSP.getValueAt(i, 0).toString();
		        String ten = tableSP.getValueAt(i, 1).toString();
		        double gia = Double.parseDouble(tableSP.getValueAt(i, 2).toString());
		        int soluongton = Integer.parseInt(tableSP.getValueAt(i, 3).toString());
		        SanPham s = new SanPham(id, ten, gia, soluongton);
		        sanphams.add(s);
			
		}
		return sanphams;
	}
	
	public int getSoLuong() {
        int soluong = Integer.parseInt(txtSoLuong.getText());
		return soluong;
	}
	
	public void AddThemSanPhamListener(ActionListener listener) {
		btnThemSP.addActionListener(listener);
	}
	
	public void setTongTien(ArrayList<GioHang> giohangs) {
		double tongtien = 0;
		for(GioHang sanpham : giohangs)
		{
			tongtien += sanpham.getSoLuong() * sanpham.getDonGia();
		}
		txtTongTien.setText(String.valueOf(tongtien));
		txtSoLuong.setText("");
	}
	
	public void addThanhToanHoaDonListener(ActionListener listener) {
		txtTongTien.addActionListener(listener);
	}
	
	public void thanhToan() {
		double tongTien = Double.parseDouble(txtTongTien.getText());
		double thanhToan = tongTien;
		txtThanhToan.setText(String.valueOf(thanhToan));
	}
	
	public void soTienTraKhach() {
		double tongTien = Double.parseDouble(txtTongTien.getText());
		double tienKhachDua = Double.parseDouble(txtTienKhachDua.getText());
		
		if(tienKhachDua >= tongTien)
		{
			double tienTra = tienKhachDua - tongTien;
			txtTienThua.setText(String.valueOf(tienTra));
		}
		else
		{
			showMessage("Số tiền không đủ!");
		}
		
	}
	
	public void addTenThuaHoaDonListener(ActionListener listener) {
		txtTienKhachDua.addActionListener(listener);
	}
	
	public void addThanhToanListener(ActionListener listener) {
		btnThanhToan.addActionListener(listener);
	}
	
	public void setThongTinAll() {
		txtMaHD.setText("");
		txtNgayTao.setText("");
		txtNhanVienTao.setText("");
		txtKhachHang.setText("");
		txtTongTien.setText("");
		txtThanhToan.setText("");
		txtTienKhachDua.setText("");
		txtTienThua.setText("");
		cbbHinhThuc.setSelectedItem("Tiền mặt");
		txtGhiChu.setText("");
	}
	
	
}
