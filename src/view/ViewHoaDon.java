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
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.BanHangController;
import controller.NhanVienController;
import controller.SanPhamController;
import controller.ThongKeController;
import model.HoaDon;
import table.TableHoaDon;
import table.TableSanPham;

import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimKiem;
	private JTable table;
	private TableHoaDon tableModel;
	private JButton btnThoat;
	private JComboBox cbbThang;
	private JComboBox cbbNam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewHoaDon frame = new ViewHoaDon();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewHoaDon() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(236, 4, 169, 32);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2.setBounds(236, 56, 1060, 667);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm hóa đơn:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(448, 66, 147, 25);
		contentPane_1.add(lblNewLabel_3);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(589, 67, 480, 25);
		contentPane_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Trạng thái thanh toán:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(360, 146, 169, 25);
		contentPane_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Hình thức thanh toán:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(690, 146, 147, 25);
		contentPane_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_4 = new JLabel("Tháng:");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(1005, 146, 147, 25);
		contentPane_1.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("Năm:");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(1100, 146, 147, 25);
		contentPane_1.add(lblNewLabel_3_5);
		
		JComboBox cbbTrangThai = new JComboBox();
		cbbTrangThai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String query = cbbTrangThai.getSelectedItem().toString();
					filter(query);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		cbbTrangThai.setModel(new DefaultComboBoxModel(new String[] {"None", "Đã thanh toán", "Chưa thanh toán"}));
		cbbTrangThai.setBounds(360, 181, 147, 21);
		contentPane_1.add(cbbTrangThai);
		
		JComboBox cbbHinhThuc = new JComboBox();
		cbbHinhThuc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {
					String query1 = cbbHinhThuc.getSelectedItem().toString();
					filter(query1);
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		cbbHinhThuc.setModel(new DefaultComboBoxModel(new String[] {"None", "Tiền mặt", "Chuyển khoản", "Quẹt thẻ"}));
		cbbHinhThuc.setBounds(690, 181, 147, 21);
		contentPane_1.add(cbbHinhThuc);
		
		cbbThang = new JComboBox();
		cbbThang.setModel(new DefaultComboBoxModel(new String[] {"None", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cbbThang.setBounds(998, 181, 59, 21);
		contentPane_1.add(cbbThang);
		
		cbbNam = new JComboBox();
		cbbNam.setModel(new DefaultComboBoxModel(new String[] {"None", "2024", "2023", "2022", "2021"}));
		cbbNam.setBounds(1093, 181, 59, 21);
		contentPane_1.add(cbbNam);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1.setBounds(314, 130, 232, 92);
		contentPane_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_1_1.setBounds(645, 130, 232, 92);
		contentPane_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setBorder(new LineBorder(new Color(192, 192, 192), 4));
		lblNewLabel_2_2_1.setBounds(975, 130, 194, 91);
		contentPane_1.add(lblNewLabel_2_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 293, 1022, 406);
		contentPane_1.add(scrollPane);
		
		table = new JTable();
		tableModel = new TableHoaDon();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
	}
	
	public void addThoatListener(ActionListener listener) {
		btnThoat.addActionListener(listener);
	}

	public void showListHoaDon(List<HoaDon> hoaDon) {
		// TODO Auto-generated method stub
		tableModel.setData(hoaDon);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	public void filter(String query) {
		TableRowSorter<TableHoaDon> tb = new TableRowSorter<TableHoaDon>(tableModel);
		table.setRowSorter(tb);
		
		if(query != "None")
		{
			tb.setRowFilter(RowFilter.regexFilter(query));
		}
		else
		{
			tb.setRowFilter(null);
		}
	}

	public void addTimKiemHoaDonListener(ActionListener listener) {
		txtTimKiem.addActionListener(listener);
	}
	
	public boolean showHDAll() {
		String tenKH = txtTimKiem.getText();
		if(tenKH.equals(""))
		{
			return true;
		}
		return false;
	}
	
	public String findTenKhachHang() {
		String tenKH = txtTimKiem.getText();
		return tenKH;
	}
	
	public void addItemTimKiemThangListener(ItemListener listener) {
		cbbThang.addItemListener(listener);
	}
	
	public String listThang() {
		String month = cbbThang.getSelectedItem().toString();
		return month;
	}
	
	public void addItemTimKiemNamListener(ItemListener listener) {
		cbbNam.addItemListener(listener);
	}
	
	public String listNam() {
		String year = cbbNam.getSelectedItem().toString();
		return year;
	}
	
}
