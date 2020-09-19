package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDao;
import dao.UserTypeDao;
import model.User;
import model.UserType;

import util.DbUtil;
import util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;
	private JPasswordField passwordTxt;
	private JComboBox userTypeJcb;
	
	private UserDao userDao =  new UserDao();
	private JLabel lblNewLabel_3;
	private DbUtil dbUtil = new DbUtil();
	private UserTypeDao userTypeDao = new UserTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7559\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF .png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 18));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5B89\u5168\u767B\u5F55.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u6CE8\u518C.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame regesterFrame = new RegisterFrame();
				regesterFrame.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		passwordTxt = new JPasswordField();
		
		lblNewLabel_3 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/userType.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		
		userTypeJcb = new JComboBox();
		userTypeJcb.setFont(new Font("宋体", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(116)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
									.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(passwordTxt, 208, 208, 208)
									.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))
								.addComponent(userTypeJcb, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(233, Short.MAX_VALUE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)))
					.addGap(129))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTypeJcb, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);//设置窗口居中显示
		fillUserType();
	}
	

	//登录事件处理
	private void loginActionPerformed(ActionEvent e) {
		String username = this.usernameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		UserType userType = (UserType) userTypeJcb.getSelectedItem();
		int usertypeId = userType.getId();
		if (StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "请输入用户名！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "请输入密码！");
			return;
		}
		User user = new User(username,password,usertypeId);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "欢迎【"+userType.getUsertypeName()+"】："+user.getUsername()+"登录本系统！");
				MainFrame mainFrame = new MainFrame(userType,user);
				mainFrame.setVisible(true);
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	//初始化用户类型下拉框
	private void fillUserType() {
		Connection con = null;
		UserType userType = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = userTypeDao.list(con, new UserType());
			while(rs.next()) {
				userType = new UserType();
				userType.setId(rs.getInt("id"));
				userType.setUsertypeName(rs.getString("usertypeName"));
				this.userTypeJcb.addItem(userType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
}
