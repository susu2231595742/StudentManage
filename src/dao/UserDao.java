package dao;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;

/**
 * 用户dao类
 * @author 22315
 *
 */
public class UserDao {
	//用户登录验证
	public User login(Connection con, User user)throws Exception {
		User resultUser = null;
		String sql = "select * from s_user where username=? and password=? and usertypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3, user.getUsertypeId());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			resultUser = new User();
			resultUser.setuId(rs.getInt("uId"));
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setUsertypeId(rs.getInt("usertypeId"));
		}
//		C3P0DataSource.close(rs, pstmt, con);
		return resultUser;
	}
	
	//用户注册
	public int addUser(Connection con, User user)throws Exception {
		String sql = "insert into s_user values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3, user.getUsertypeId());
		
		return pstmt.executeUpdate();
	}
	public ResultSet list(Connection con, User user)throws Exception {
		String sql = "select * from s_user where username=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		return pstmt.executeQuery();
	}
	
	//修改用户密码
	public int editPassword(Connection con, User user)throws Exception {
		String sql1 = "select * from s_user where username=?";
		PreparedStatement pstmt = null;
		int id = 0;
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1, user.getUsername());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			id = rs.getInt("uId");
		}
		String sql2 = "update s_user set password=? where uId=?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, user.getPassword());
		pstmt.setInt(2, id);
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con, String username)throws Exception{
		String sql = "delete from s_user where username=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		return pstmt.executeUpdate();
	}
	
	public int getUser_uIdByUsername(Connection con, String username)throws Exception {
		String sql = "select *from s_user where username = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			return rs.getInt("uId");
		}
		return 0;	
	}
}
