package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.SelectedCourse;

public class SelectedCourseDao {

	//��ѯѡ�α�
	public ResultSet list(Connection con, SelectedCourse selectedCourse)throws Exception{
		StringBuffer sql = new StringBuffer("select *from s_selected_course ss, s_student st, s_course sc where ss.student_id = st.stuId and ss.course_id = sc.id");
		if (selectedCourse.getStudent_id() != 0) {
			sql.append(" and ss.student_id ="+ selectedCourse.getStudent_id());
		}
		if (selectedCourse.getCourse_id() != 0) {
			sql.append(" and ss.course_id ="+ selectedCourse.getCourse_id());
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	
	//����ѡ��
	public int addSelectedCourse(Connection con, SelectedCourse selectedCourse)throws Exception{
		String  sql = "insert into s_selected_course values(null, ?, ?, 0)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getStudent_id());
		pstmt.setInt(2, selectedCourse.getCourse_id());
		
		return pstmt.executeUpdate();
	}
	
	//�޸�ѡ��
	public int updateSelectedCourse(Connection con, SelectedCourse selectedCourse)throws Exception {
		String sql = "update s_selected_course set student_id=?, course_id=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getStudent_id());
		pstmt.setInt(2, selectedCourse.getCourse_id());
		pstmt.setInt(3, selectedCourse.getId());
		
		return pstmt.executeUpdate();
	}
	
	//ɾ��ѡ��
	public int deleteSelectedCourse(Connection con, String id)throws Exception{
		String sql = "delete from s_selected_course where id=?";
		PreparedStatement pstmt  = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}
	
	//�ж��Ƿ�ѡ���ÿγ�
	public boolean isSelected(Connection con, SelectedCourse selectedCourse)throws Exception{
		String sql = "select * from s_selected_course  where student_id=? and course_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getStudent_id());
		pstmt.setInt(2, selectedCourse.getCourse_id());
		ResultSet rSet = pstmt.executeQuery();
		if (rSet.next()) {
			return true;
		}
		return false;
	}
}