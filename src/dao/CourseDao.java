package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Course;
import model.SelectedCourse;
import util.StringUtil;

public class CourseDao {

	public ResultSet list(Connection con, Course course)throws Exception{
		StringBuffer sb = new StringBuffer("select * from s_course sc, s_teacher st where sc.teacherId = st.id");
		if (StringUtil.isNotEmpty(course.getCoursename())) {
			sb.append(" and sc.coursename like '%" + course.getCoursename()+ "%'");
		}
		if (course.getTeacherId() != 0 && course.getTeacherId() != -1) {
			sb.append(" and sc.teacherId=" + course.getTeacherId()); 
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	//Ìí¼Ó¿Î³Ì
	public int addCourse(Connection con, Course course)throws Exception{
		String sql = "insert into s_course values(null, ?, ?, ?, ?, 0)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, course.getCoursename());
		pstmt.setInt(2, course.getMax_student_num());
		pstmt.setInt(3, course.getTeacherId());		
		pstmt.setString(4, course.getInfo());
		
		return pstmt.executeUpdate();
	}
	
	//ĞŞ¸Ä¿Î³Ì
	public int update(Connection con, Course course)throws Exception{
		String sql = "update s_course set coursename=?, max_student_num=?, teacherId=?, info=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, course.getCoursename());
		pstmt.setInt(2, course.getMax_student_num());
		pstmt.setInt(3, course.getTeacherId());
		pstmt.setString(4, course.getInfo());
		pstmt.setInt(5, course.getId());
		
		return pstmt.executeUpdate();
	}
	
	//É¾³ı¿Î³Ì
	public int delete(Connection con, String id)throws Exception{
		String sql = " delete from s_course where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}
	
	//ÅĞ¶Ï¿Î³ÌÊÇ·ñÑ¡Âú
	public boolean selectedEnable(Connection con, int id)throws Exception{
		String sql = "select * from s_course where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int max_student_num = rs.getInt("max_student_num");
			int selected_num = rs.getInt("selected_num");
			if (selected_num >= max_student_num) {
				return false;
			}
		}
		
		return true;
	}
	
	public int updateSelectedNum(Connection con, SelectedCourse selectedCourse, int num)throws Exception{
		String sql = null;
		if (num > 0) {
			sql = "update s_course set selected_num = selected_num + ? where id = ?";
		}
		if (num < 0) {
			 sql = "update s_course set selected_num = selected_num - ? where id = ?";
		}
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, 1);
		pstmt.setInt(2, selectedCourse.getCourse_id());
		
		return pstmt.executeUpdate();
	}
	
	public int getCourseIdByCoursename(Connection con, String coursename)throws Exception {
		String sql = "select * from s_course where coursename=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, coursename);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			return id;
			
		}
		return 0;
	}
	
}
