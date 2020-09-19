package model;

public class UserType {
	
	private int id;
	private String usertypeName; //用户类型
	
	
	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserType(int id, String usertypeName) {
		super();
		this.id = id;
		this.usertypeName = usertypeName;
	}
	
	public UserType(String usertypeName) {
		super();
		this.usertypeName = usertypeName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsertypeName() {
		return usertypeName;
	}
	public void setUsertypeName(String usertypeName) {
		this.usertypeName = usertypeName;
	}

	@Override
	public String toString() {
		return usertypeName;
	}

	
}
