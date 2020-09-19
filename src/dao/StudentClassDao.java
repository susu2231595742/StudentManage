package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.StudentClass;
import util.StringUtil;

public class StudentClassDao {

	//
	public ResultSet list(Connection con, StudentClass studentClass)throws Exception {
		StringBuffer sb = new StringBuffer("select * from s_class");
		if(StringUtil.isNotEmpty(studentClass.getClassName())){
			sb.append(" and className like '%"+studentClass.getClassName()+"%'") ;
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	//ÐÞ¸Ä°à¼¶
	public int addStuclass(Connection con, StudentClass studentClass)throws Exception{
		String sql = "insert into s_class values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, studentClass.getClassName());
		pstmt.setString(2, studentClass.getInfo());
		
		return pstmt.executeUpdate();
	}
	
	//É¾³ý°à¼¶
	public int deleteStuClass(Connection con, String id)throws Exception{
		String sql = "delete from s_class where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
}
