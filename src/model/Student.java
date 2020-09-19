package model;

public class Student {

	private int stuId; //编号
	private String sno; // 学号
	private String stuName; //学生姓名
	private String sex; //学生性别
	private String tel; // 电话
	private Integer classId; // 班级
	private Integer userId; // 用户 
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Student(String sno, String stuName, Integer classId) {
		super();
		this.sno = sno;
		this.stuName = stuName;
		this.classId = classId;
	}

	
	public Student(String sno, String stuName, String sex, String tel, Integer classId, Integer userId) {
		super();
		this.sno = sno;
		this.stuName = stuName;
		this.sex = sex;
		this.tel = tel;
		this.classId = classId;
		this.userId = userId;
	}

	public Student(int stuId, String sno, String stuName, String sex, String tel, Integer classId) {
		super();
		this.stuId = stuId;
		this.sno = sno;
		this.stuName = stuName;
		this.sex = sex;
		this.tel = tel;
		this.classId = classId;
	}

	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return this.stuName;
	}
	
}
