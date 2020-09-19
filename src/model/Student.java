package model;

public class Student {

	private int stuId; //���
	private String sno; // ѧ��
	private String stuName; //ѧ������
	private String sex; //ѧ���Ա�
	private String tel; // �绰
	private Integer classId; // �༶
	private Integer userId; // �û� 
	
	
	
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
