//package util;
//
//import java.beans.PropertyVetoException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mysql.jdbc.Statement;
//
//public class C3P0DataSource {
//	private static final String connectionURL = "jdbc:mysql://localhost:3306/stus?useUnicode=true&characterEncoding=UTF8&useSSL=false";
//	private static final String username = "root";
//	private static final String password = "root";
//	
//	private static ComboPooledDataSource ds; //c3p0����Դ
//	
//	static {
//		try {
//			ds = new ComboPooledDataSource();
//			ds.setDriverClass("com.mysql.jdbc.Driver");
//			ds.setJdbcUrl(connectionURL);
//			ds.setUser(username);
//			ds.setPassword(password);
//			
//			ds.setInitialPoolSize(5);
//			ds.setMaxPoolSize(20);
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	public static Connection getConnection() {
//		try {
//			return ds.getConnection();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public static void close(ResultSet rs,PreparedStatement pstmt,Connection con) {
//		closeResultSet(rs);
//		closePrepareStatement(pstmt);
//		closeConnection(con);
//	}
//	
//	public static void closeResultSet(ResultSet rs ) {
//		try {
//			if(rs!=null)rs.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void closePrepareStatement(PreparedStatement pstmt) {
//		try {
//			if(pstmt!=null)
//				pstmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	public static void closeConnection(Connection con) {
//		try {
//			if(con!=null)con.close();//���������ӹ黹�����ӳأ������������ĶϿ�����
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//}
