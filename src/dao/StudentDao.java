package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Student;
import util.StringUtil;

public class StudentDao {

	//添加
	public int addStudent(Connection con, Student student)throws Exception {
		String sql = "insert into s_student values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getSno());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, student.getTel());
		pstmt.setInt(5, student.getClassId());
		pstmt.setInt(6, student.getUserId());
		
		return pstmt.executeUpdate();
	}

	
	//查询学生信息
	public ResultSet list(Connection con, Student student)throws Exception {
		StringBuffer sb = new StringBuffer("select * from s_user u, s_student st, s_class c where u.uId=st.userId and st.classId = c.id ");
		if (student.getClassId() != null && student.getClassId() != -1) {
			sb.append(" and st.classId=" + student.getClassId());
		}
		if (student.getSno() != null) {
			sb.append(" and st.sno like '%" + student.getSno()+"%'");
		}
		if (StringUtil.isNotEmpty(student.getStuName())) {
			sb.append(" and st.stuName like '%" + student.getStuName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	//修改学生信息
	public int update(Connection con, Student student)throws Exception{
		String sql ="update s_student set sno=? , stuName=? , sex=? , tel=? , classId=? where stuId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getSno());
		pstmt.setString(2, student.getStuName());
		pstmt.setString(3, student.getSex());
		pstmt.setString(4, student.getTel());
		pstmt.setInt(5, student.getClassId());
		pstmt.setInt(6, student.getStuId());
		
		return pstmt.executeUpdate();
		
	}
	
	//删除学生信息
	public int delete(Connection con, String stuId)throws Exception{
		String sql = "delete from s_student where stuId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, stuId);
		return pstmt.executeUpdate();
	}
	
	public int getStudent_userIdByStuName(Connection con, Student student)throws Exception {
		String sql = "select *from s_student where stuName = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getStuName());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			return rs.getInt("userId");
		}
		return 0;	
	}


	public int getStuIdByStuName(Connection con, String stuName)throws Exception {
		String sql = "select * from s_student where stuName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, stuName);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			return rs.getInt("stuId");
		}
		return 0;
	}
}
