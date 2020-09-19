package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.SelectedCourse;

public class SelectedCourseDao {

	//查询选课表
	public ResultSet list(Connection con, SelectedCourse selectedCourse)throws Exception{
		StringBuffer sql = new StringBuffer("select *from s_selected_course ss, s_student st, s_course sc where ss.student_id = st.stuId and ss.course_id = sc.id");
		if (selectedCourse.getStudent_id() != 0 && selectedCourse.getStudent_id() != -1) {
			sql.append(" and ss.student_id ="+ selectedCourse.getStudent_id());
		}
		if (selectedCourse.getCourse_id() != 0 && selectedCourse.getCourse_id() != -1) {
			sql.append(" and ss.course_id ="+ selectedCourse.getCourse_id());
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	
	//添加选课
	public int addSelectedCourse(Connection con, SelectedCourse selectedCourse)throws Exception{
		String  sql = "insert into s_selected_course values(null, ?, ?, 0)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getStudent_id());
		pstmt.setInt(2, selectedCourse.getCourse_id());
		
		return pstmt.executeUpdate();
	}
	
	//修改选课
	public int updateSelectedCourse(Connection con, SelectedCourse selectedCourse)throws Exception {
		String sql = "update s_selected_course set student_id=?, course_id=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getStudent_id());
		pstmt.setInt(2, selectedCourse.getCourse_id());
		pstmt.setInt(3, selectedCourse.getId());
		
		return pstmt.executeUpdate();
	}
	
	//删除选课
	public int deleteSelectedCourse(Connection con, String id)throws Exception{
		String sql = "delete from s_selected_course where id=?";
		PreparedStatement pstmt  = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		return pstmt.executeUpdate();
	}
	
	//判断是否选过该课程
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
	
	//修改成绩
	public int updateScore(Connection con, SelectedCourse selectedCourse)throws Exception{
		String sql = "update s_selected_course set score=? where student_id=? and course_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getScore());
		pstmt.setInt(2, selectedCourse.getStudent_id());
		pstmt.setInt(3, selectedCourse.getCourse_id());
		return pstmt.executeUpdate();
	}
	
	public Map<String,String> scoreList(Connection con, SelectedCourse selectedCourse)throws Exception{
		Map<String,String> ret = new HashMap<String,String>();
		String sql = "select count(id) as student_num,max(score) as max_score,min(score) as min_score,AVG(score) as mid_score from s_selected_course where course_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, selectedCourse.getCourse_id());
		ResultSet  rSet = pstmt.executeQuery();
		while(rSet.next()) {
			ret.put("student_num", rSet.getInt("student_num")+"");
			ret.put("max_score", rSet.getInt("max_score")+"");
			ret.put("min_score", rSet.getInt("min_score")+"");
			ret.put("mid_score", rSet.getFloat("mid_score")+"");
			
			return ret;
		}
		
		return null;
	}

}
