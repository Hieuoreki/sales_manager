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
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import controller.BanHangController;
import controller.HoaDonController;
import controller.SanPhamController;
import controller.ThongKeController;
import dao.NhanVienDAO;
import model.NhanVien;
import table.TableNhanVien;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewNhanVien extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtDiaChi;
	private JTextField txtDienThoai;
	private JTextField txtNgaySinh;
	private JTable table;
	private TableNhanVien tableModel;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnThoat;
	private JComboBox cbbVaiTro;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JRadioButton rdoDLV;
	private JRadioButton rdoNV;
	private JTextField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNhanVien frame = new ViewNhanVien();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1320, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(new Color(119, 136, 153));
		contentPane_1.setBounds(0, 0, 1306, 723);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 226, 723);
		contentPane_1.add(panel);
		
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
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewBanHang banhang = new ViewBanHang();
				banhang.setLocationRelativeTo(null);
				BanHangController controller = new BanHangController(banhang, null, null);
				controller.showViewBanHang();
			}
		});
		btnNewButton.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
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
		btnSnPhm.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnSnPhm.setBackground(Color.LIGHT_GRAY);
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
		btnHan.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnHan.setBackground(Color.LIGHT_GRAY);
		btnHan.setBounds(0, 395, 226, 65);
		panel.add(btnHan);
		
		JButton btnNhnVin = new JButton("Nhân viên");
		btnNhnVin.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnNhnVin.setBackground(Color.LIGHT_GRAY);
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
		btnTK.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnTK.setBackground(Color.LIGHT_GRAY);
		btnTK.setBounds(0, 521, 226, 65);
		panel.add(btnTK);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("UTM Alexander", Font.PLAIN, 25));
		btnThoat.setBackground(Color.LIGHT_GRAY);
		btnThoat.setBounds(0, 584, 226, 65);
		panel.add(btnThoat);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin nhân viên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(236, 4, 169, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2.setBounds(236, 33, 1056, 297);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mã NV:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(369, 70, 81, 25);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên NV:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(369, 120, 81, 25);
		contentPane_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Vai trò:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(369, 170, 81, 25);
		contentPane_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Địa chỉ:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(369, 220, 81, 25);
		contentPane_1.add(lblNewLabel_3_3);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(425, 74, 169, 21);
		contentPane_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(425, 124, 169, 21);
		contentPane_1.add(txtTenNV);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(425, 224, 169, 21);
		contentPane_1.add(txtDiaChi);
		
		cbbVaiTro = new JComboBox();
		cbbVaiTro.setModel(new DefaultComboBoxModel(new String[] {"Quản lý", "Nhân viên"}));
		cbbVaiTro.setBounds(425, 173, 114, 22);
		contentPane_1.add(cbbVaiTro);
		
		JLabel lblNewLabel_3_4 = new JLabel("Điện thoại:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(891, 77, 81, 25);
		contentPane_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Ngày sinh:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(891, 120, 81, 25);
		contentPane_1.add(lblNewLabel_3_5);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(977, 74, 169, 21);
		contentPane_1.add(txtDienThoai);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(977, 124, 169, 21);
		contentPane_1.add(txtNgaySinh);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Giới tính:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(891, 177, 81, 25);
		contentPane_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Trạng thái:");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_2.setBounds(891, 222, 81, 25);
		contentPane_1.add(lblNewLabel_3_1_2);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBackground(new Color(119, 136, 153));
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNam.setBounds(977, 180, 52, 21);
		contentPane_1.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBackground(new Color(119, 136, 153));
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNu.setBounds(1098, 180, 52, 21);
		contentPane_1.add(rdoNu);
		
		rdoDLV = new JRadioButton("Đang làm việc");
		rdoDLV.setBackground(new Color(119, 136, 153));
		rdoDLV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoDLV.setBounds(977, 223, 103, 21);
		contentPane_1.add(rdoDLV);
		
		rdoNV = new JRadioButton("Nghỉ việc");
		rdoNV.setBackground(new Color(119, 136, 153));
		rdoNV.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNV.setBounds(1098, 223, 103, 21);
		contentPane_1.add(rdoNV);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setBounds(565, 274, 81, 32);
		contentPane_1.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBackground(new Color(255, 255, 51));
		btnEdit.setBounds(676, 274, 81, 32);
		contentPane_1.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(255, 51, 51));
		btnDelete.setBounds(790, 274, 81, 32);
		contentPane_1.add(btnDelete);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1.setBounds(236, 378, 1056, 335);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách nhân viên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(236, 350, 169, 32);
		contentPane_1.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(259, 392, 1008, 303);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		tableModel = new TableNhanVien();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3_6 = new JLabel("Mật khẩu: ");
		lblNewLabel_3_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(369, 264, 81, 25);
		contentPane_1.add(lblNewLabel_3_6);
		
		txtMatKhau = new JTextField();
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(440, 268, 70, 21);
		contentPane_1.add(txtMatKhau);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(rdoDLV);
		buttonGroup1.add(rdoNV);
	}
	
	public void addThoatListener(ActionListener listener) {
		btnThoat.addActionListener(listener);
	}

	public void showListNhanVien(List<NhanVien> nhanViens) {
		// TODO Auto-generated method stub
		tableModel.setData(nhanViens);
	}
	
	public void addAddNhanVienListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}
	
	private boolean validateNhanVienData(String id, int matKhau, String ten, String diaChi, String dienThoai, String ngaySinh, String vaiTro, String trangThai) {
		if(id.length()==0 || matKhau == 0 || ten.length()==0 || diaChi.length()==0 || dienThoai.length()==0 || ngaySinh.length()==0 || vaiTro.length()==0 || trangThai.length()==0)
		{
			return false;
		}
		return true;
	}
	
	public NhanVien getNhanVienData() {
		String id = txtMaNV.getText();
		int matKhau = 0;
		try {
			matKhau = Integer.parseInt(txtMatKhau.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		String ten = txtTenNV.getText();
		String diaChi = txtDiaChi.getText();
		String dienThoai = txtDienThoai.getText();
		String ngaySinh = txtNgaySinh.getText();
		String vaiTro = cbbVaiTro.getSelectedItem().toString();
		String gioiTinh = "";
		if(rdoNam.isSelected())
		{
			gioiTinh = "Nam";
		}
		else if(rdoNu.isSelected())
		{
			gioiTinh = "Nữ";
		}
		String trangThai = "";
		if(rdoDLV.isSelected())
		{
			trangThai = "Đang làm việc";
		}
		else if(rdoNV.isSelected())
		{
			trangThai = "Nghỉ việc";
		}
		
		if(validateNhanVienData(id, matKhau, gioiTinh, ten, diaChi, dienThoai, ngaySinh, vaiTro) == false)
		{
			showMessage("Thông tin không hợp lệ!");
			return null;
		}
		
		NhanVien nhanvien = new NhanVien(id, matKhau, ten, vaiTro, diaChi, dienThoai, ngaySinh, gioiTinh, trangThai);
		return nhanvien;
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public void addTableSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	
	public void fillInputForm() {
		int row = table.getSelectedRow();
		if(row >= 0)
		{
			txtMaNV.setText(table.getValueAt(row, 0).toString());
			txtMatKhau.setText(table.getValueAt(row, 1).toString());
			txtTenNV.setText(table.getValueAt(row, 2).toString());
			cbbVaiTro.setSelectedItem(table.getValueAt(row, 3).toString());
			txtDiaChi.setText(table.getValueAt(row, 4).toString());
			txtDienThoai.setText(table.getValueAt(row, 5).toString());
			txtNgaySinh.setText(table.getValueAt(row, 6).toString());
			
			String gioiTinh = table.getValueAt(row, 7).toString();
			if(gioiTinh.equals("Nam"))
			{
				rdoNam.setSelected(true);
			}
			else if(gioiTinh.equals("Nữ"))
			{
				rdoNu.setSelected(true);
			}
			String trangThai = table.getValueAt(row, 8).toString();
			if(trangThai.equals("Đang làm việc"))
			{
				rdoDLV.setSelected(true);
			}
			else if(trangThai.equals("Nghỉ việc"))
			{
				rdoNV.setSelected(true);
			}
		}
	}
	
	public void editAddNhanVienListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	
	public void deleteAddNhanVienListener(ActionListener listener) {
	    btnDelete.addActionListener(listener);
	}
	
	public void setStart() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		cbbVaiTro.setSelectedItem("Quản lý");
		txtDiaChi.setText("");
		txtMatKhau.setText("");
		txtDienThoai.setText("");
		txtNgaySinh.setText("");
	}
}
