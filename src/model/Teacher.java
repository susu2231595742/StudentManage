package model;

public class Teacher {

	private int id;
	private String teacherName;
	private String sex;
	private String title;
	private int age;
	private int userId;
	
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}
	
	public Teacher(int id, String teacherName, String sex, String title, int age) {
		super();
		this.id = id;
		this.teacherName = teacherName;
		this.sex = sex;
		this.title = title;
		this.age = age;
	}
	public Teacher(String teacherName, String sex, String title, int age, int userId) {
		super();
		this.teacherName = teacherName;
		this.sex = sex;
		this.title = title;
		this.age = age;
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return this.teacherName;
	}
	
}
