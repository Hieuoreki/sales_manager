package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connection.ConnectionData;
import controller.BanHangController;
import model.BanHang;
import model.SanPham;


public class ViewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewLogin() {
		setLocationRelativeTo(null);
		setTitle("Đăng nhập tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 476);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCOUNT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(136, 10, 165, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 168, 106, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(20, 229, 106, 33);
		contentPane.add(lblNewLabel_1_1);
		
		JTextField username = new JTextField();
		username.setBounds(126, 170, 200, 33);
		contentPane.add(username);
		username.setColumns(10);
		
		JPasswordField password = new JPasswordField();
		password.setBounds(126, 231, 200, 33);
		contentPane.add(password);
		password.setColumns(10);
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.setForeground(new Color(255, 51, 0));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ConnectionData conn = new ConnectionData();
				Connection connection = null;
				try {
						connection = conn.getConnection();
						String sql = " SELECT * FROM ds_nhanvien WHERE `Mã nhân viên`=? and `Mật khẩu`=?";
						PreparedStatement prepareStatement = connection.prepareStatement(sql);
						prepareStatement.setString(1, username.getText());
						prepareStatement.setString(2, password.getText());
						ResultSet resultSet = prepareStatement.executeQuery();
						if(resultSet.next()) {
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							dispose();
							ViewBanHang banhang = new ViewBanHang();
							banhang.setLocationRelativeTo(null);
							BanHangController controller = new BanHangController(banhang, null, null);
							controller.showViewBanHang();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!");
						}
				} catch (SQLException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(ViewLogin.this, e2.toString());
				}
			}
		});
		loginBtn.setBackground(new Color(255, 182, 193));
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 22));
		loginBtn.setBounds(126, 314, 160, 69);
		contentPane.add(loginBtn);
		
		String imagePath = "C:\\Users\\DELL\\OneDrive\\Pictures/login.png";
		JLabel image = new JLabel("");
		image.setBounds(136, 50, 136, 124);
		ImageIcon imageIcon = new ImageIcon(imagePath);
		Image image1 = imageIcon.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(image1);
		image.setIcon(scaledIcon);

		contentPane.add(image);
	}

}
