package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionData {
	
	public static  Connection getConnection() {
		Connection connection = null;
		try {
			String username = "hieu";
			String password = "hieu123456";
			String DatabaseName = "ban_hang";
			String url = "jdbc:mysql://localhost/" + DatabaseName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
		ConnectionData.getConnection();
	}

}
