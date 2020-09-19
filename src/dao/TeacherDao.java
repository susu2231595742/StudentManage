package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Teacher;
import util.StringUtil;

public class TeacherDao {

	public ResultSet list(Connection con, Teacher teacher)throws Exception {
		StringBuffer sb = new StringBuffer("select * from s_teacher t, s_user u  where t.userId = u.uId");
		if (StringUtil.isNotEmpty(teacher.getTeacherName())) {
			sb.append(" and t.teacherName like '%" + teacher.getTeacherName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int addTeacher(Connection con, Teacher teacher)throws Exception{
		String sql = "insert into s_teacher values(null, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, teacher.getTeacherName());
		pstmt.setString(2, teacher.getSex());
		pstmt.setString(3, teacher.getTitle());
		pstmt.setInt(4, teacher.getAge());
		pstmt.setInt(5, teacher.getUserId());
		return pstmt.executeUpdate();
	}
	
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from s_teacher where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	public int update(Connection con, Teacher teacher)throws Exception{
		String sql = "update s_teacher set teacherName=?, sex=?, title=?, age=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, teacher.getTeacherName());
		pstmt.setString(2, teacher.getSex());
		pstmt.setString(3, teacher.getTitle());
		pstmt.setInt(4, teacher.getAge());
		pstmt.setInt(5, teacher.getId());
		return pstmt.executeUpdate();
		
	}
	public int getTeacher_idByTeachername(Connection con, String teachername)throws Exception {
		String sql = "select *from s_teacher where teacherName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, teachername);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			return id;
		}
		return 0;
	}
}

	
