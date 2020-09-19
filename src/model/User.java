package model;


/**
 * 用户实体
 * @author 22315
 *
 */
public class User {
	
	private int uId;
	private String username; //用户名
	private String password; //密码
	private int usertypeId; //用户类型
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, int usertypeId) {
		super();
		this.username = username;
		this.password = password;
		this.usertypeId = usertypeId;
	}
	
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getUsertypeId() {
		return usertypeId;
	}

	public void setUsertypeId(int usertypeId) {
		this.usertypeId = usertypeId;
	}
}
