package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author 22315
 *
 */
public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/stus";
	 private String username = "root";
	 private String password = "root";
	 
	 public Connection getConnection() throws Exception{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(dbUrl, username, password);
		 return con;
	 }
	 
	 public void closeCon(Connection con) {
		 if(con != null) {
			 try {
				 con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		 }
	 }
	 
	 public static void main(String[] args) {
		 DbUtil dbUtil = new DbUtil();
		 try {
			 dbUtil.getConnection();
			 System.out.println("数据库连接成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		System.out.println();
	}
	
}
