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
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.BanHangController;
import controller.HoaDonController;
import controller.NhanVienController;
import controller.ThongKeController;
import model.SanPham;
import table.TableSanPham;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTable table;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private TableSanPham modelTable;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnThoat;
	private JComboBox cbbLoai;
	private JTextField txtTimKiem;
	private JButton btnTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSanPham frame = new ViewSanPham();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewSanPham() {
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
		btnNhnVin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewNhanVien nhanvien = new ViewNhanVien();
				nhanvien.setLocationRelativeTo(null);
				NhanVienController controller = new NhanVienController(nhanvien);
				controller.showViewNhanVien();
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(236, 0, 169, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2.setBounds(236, 30, 1060, 207);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Lọc sản phẩm");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(236, 238, 153, 32);
		contentPane_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1.setBounds(236, 266, 1060, 156);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1_1.setBounds(236, 432, 1060, 281);
		contentPane_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Mã sản phẩm:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(258, 60, 122, 24);
		contentPane_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(258, 100, 122, 24);
		contentPane_1.add(lblNewLabel_3_1);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(369, 64, 187, 19);
		contentPane_1.add(txtMaSP);
		txtMaSP.setColumns(10);
		
		txtTenSP = new JTextField();
		txtTenSP.setColumns(10);
		txtTenSP.setBounds(369, 104, 187, 19);
		contentPane_1.add(txtTenSP);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(51, 255, 102));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(705, 84, 100, 48);
		contentPane_1.add(btnAdd);
		
		btnEdit = new JButton("Sửa");
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEdit.setBackground(new Color(255, 255, 51));
		btnEdit.setBounds(882, 84, 100, 48);
		contentPane_1.add(btnEdit);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBackground(new Color(255, 51, 51));
		btnDelete.setBounds(1053, 84, 100, 48);
		contentPane_1.add(btnDelete);
		
		JLabel lblNewLabel_4 = new JLabel("Loại:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(410, 295, 43, 24);
		contentPane_1.add(lblNewLabel_4);
		
		cbbLoai = new JComboBox();
		cbbLoai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String query = cbbLoai.getSelectedItem().toString();
					filter(query);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		cbbLoai.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbbLoai.setModel(new DefaultComboBoxModel(new String[] {"None", "RAM", "Ổ cứng", "Bàn phím", "VGA", "Bo mạch chủ ", "CPU"}));
		cbbLoai.setBounds(340, 333, 188, 24);
		contentPane_1.add(cbbLoai);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		lblNewLabel_2_1_2.setBounds(300, 280, 269, 106);
		contentPane_1.add(lblNewLabel_2_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(269, 450, 995, 242);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		modelTable = new TableSanPham();
		table.setModel(modelTable);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3_2 = new JLabel("Đơn giá:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(258, 140, 122, 24);
		contentPane_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Số lượng:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(258, 180, 122, 24);
		contentPane_1.add(lblNewLabel_3_3);
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(369, 144, 187, 19);
		contentPane_1.add(txtDonGia);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(369, 184, 187, 19);
		contentPane_1.add(txtSoLuong);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("");
		lblNewLabel_2_1_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 3));
		lblNewLabel_2_1_2_1.setBounds(960, 280, 269, 106);
		contentPane_1.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(1050, 295, 107, 24);
		contentPane_1.add(lblNewLabel_4_1);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		txtTimKiem.setBounds(1002, 337, 187, 19);
		contentPane_1.add(txtTimKiem);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTimKiem.setBackground(new Color(192, 192, 192));
		btnTimKiem.setBounds(690, 325, 158, 32);
		contentPane_1.add(btnTimKiem);
	}
	
	public void addThoatListener(ActionListener listener) {
		btnThoat.addActionListener(listener);
	}

	public void showListSanPham(List<SanPham> sanPhams) {
		// TODO Auto-generated method stub
		modelTable.setData(sanPhams);
	}
	
	public void addAddSanPhamListener(ActionListener listener) {
		btnAdd.addActionListener(listener);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	public boolean validateSanPhamData(String id, String tenSP, double donGia, int soLuong) {
		if(id.length()==0 || tenSP.length()==0 || donGia==0 || soLuong==0)
		{
			return false;
		}
		return true;
	}
	
	public SanPham getSanPhamData() {
		String id = txtMaSP.getText();
		String tenSP = txtTenSP.getText();
		
		double donGia = 0;
		try {
			donGia = Double.parseDouble(txtDonGia.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		int soLuong = 0;
		try {
			soLuong = Integer.parseInt(txtSoLuong.getText());
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		
		if(validateSanPhamData(id, tenSP, donGia, soLuong)==false)
		{
			showMessage("Thông tin không hợp lệ!");
			return null;
		}
		SanPham sanPham = new SanPham(id, tenSP, donGia, soLuong);
		return sanPham;
	}
		
	public void addTableSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	
	public void fillInputForm() {
		int row = table.getSelectedRow();
		if(row >= 0)
		{
			txtMaSP.setText(table.getValueAt(row, 0).toString());
			txtTenSP.setText(table.getValueAt(row, 1).toString());
			txtDonGia.setText(table.getValueAt(row, 2).toString());
			txtSoLuong.setText(table.getValueAt(row, 3).toString());
		}
	}
	
	public void editAddSanPhamListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	
	public void deleteAddSanPhamListener(ActionListener listener) {
		btnDelete.addActionListener(listener);
	}
	
	public void searchAddSanPhamListener(ActionListener listener) {
		btnTimKiem.addActionListener(listener);
	}
	
	public boolean setSanPhamAll() {
		String tenSP = txtTimKiem.getText();
		if(tenSP.equals(""))
		{
			return true;
		}
		return false;
	}
	
	public void addRefreshTableSanPham(ActionListener listener) {
		txtTimKiem.addActionListener(listener);
	}
	
	public String findSanPham() {
		String tenSP = txtTimKiem.getText();
		return tenSP;
	}
	
	public void filter(String query) {
		TableRowSorter<TableSanPham> tr = new TableRowSorter<TableSanPham>(modelTable);
		table.setRowSorter(tr);
		if(query != "None")
		{
			tr.setRowFilter(RowFilter.regexFilter(query));
		}
		else
		{
			table.setRowSorter(null);
		}
	}
	
}
