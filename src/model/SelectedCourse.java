package model;

public class SelectedCourse {

	private int id;
	private int student_id;
	private int course_id;
	private int score;
	
	public SelectedCourse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectedCourse(int student_id) {
		super();
		this.student_id = student_id;
	}
	
	public SelectedCourse(int student_id, int course_id, int score) {
		super();
		this.student_id = student_id;
		this.course_id = course_id;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
