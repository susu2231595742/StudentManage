package model;

public class StudentClass {

	private int id;
	private String className;
	private String info;
	
	
	public StudentClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentClass(String className, String info) {
		super();
		this.className = className;
		this.info = info;
	}
	public StudentClass(String className) {
		super();
		this.className = className;
	}
	public StudentClass(int id, String className, String info) {
		super();
		this.id = id;
		this.className = className;
		this.info = info;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return this.className;
	}
	
}
