package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import model.UserType;
import util.StringUtil;

public class UserTypeDao {

	public ResultSet list(Connection con, UserType userType)throws Exception {
		String sql = "select * from s_usertype";
		PreparedStatement pstmt = con.prepareStatement(sql);

		return pstmt.executeQuery();
	}
	
	public ResultSet searcheId(Connection con, UserType userType)throws Exception{
		String sql = "select * from s_usertype where usertypeName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userType.getUsertypeName());
		return pstmt.executeQuery();
	}
	
}
