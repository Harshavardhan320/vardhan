package practiceproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {

	private String url ="jdbc:mysql://localhost:3306/phase2";
	private String username ="root";
	private String password ="K.harsha@2000";
	
	
	private Connection conn =null;

	
	
	public Databaseconnection() {
		db();
	}
	public Databaseconnection(String url, String username, String password) {
		
		this.url=url;
		this.username = username;
		this.password = password;
		
		db(url,username,password);
	}
	
	
	
	//getting connection to database;
	private void db(String url, String username,String password) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.err.println("My sql class not found");
//		}
		try {
			this.conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.err.println("Connection fails");
		}
	}
	
	
	
	
	private void db() {
//		try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//			System.err.println("My sql class not found");
//		}
		try {
			this.conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.err.println("Connection fails");
		}
	}
	// return the connection object
	
	public Connection getconnection() {
		return conn;
	}

}
