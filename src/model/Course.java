package model;

public class Course {

	private int id;
	private String coursename;
	private int max_student_num;
	private int teacherId;	
	private String info;
	private int selected_num = 0;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String coursename, int max_student_num, int teacherId, String info) {
		super();
		this.coursename = coursename;
		this.teacherId = teacherId;
		this.max_student_num = max_student_num;
		this.info = info;
	}

	public Course(int id, String coursename, int max_student_num, int teacherId, String info) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.max_student_num = max_student_num;
		this.teacherId = teacherId;
		this.info = info;
	}
	public Course(String coursename, int teacherId) {
		super();
		this.coursename = coursename;
		this.teacherId = teacherId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getMax_student_num() {
		return max_student_num;
	}
	public void setMax_student_num(int max_student_num) {
		this.max_student_num = max_student_num;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getSelected_num() {
		return selected_num;
	}
	public void setSelected_num(int selected_num) {
		this.selected_num = selected_num;
	}
	@Override
	public String toString() {
		return this.coursename;
	}
	
}
