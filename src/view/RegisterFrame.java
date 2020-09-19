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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class RegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameTxt;
	private JPasswordField passwordTxt;
	private JPasswordField repeatpasswordTxt;
	private JComboBox userTypeJcb;
//	private C3P0DataSource c3p0DataSource = new C3P0DataSource();
	private UserDao userDao = new UserDao();
	private UserTypeDao userTypeDao = new UserTypeDao();
	
	private DbUtil dbUtil = new DbUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame frame = new RegisterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println();
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrame() {
		setTitle("\u6CE8\u518C");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u6CE8\u518C\u9875\u97625.png")));
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 16));
		lblNewLabel_1.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/userType.png")));
		
		userTypeJcb = new JComboBox();
		userTypeJcb.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		usernameTxt = new JTextField();
		usernameTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 16));
		
		passwordTxt = new JPasswordField();
		
		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/password.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.BOLD, 16));
		
		repeatpasswordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u6CE8\u518C.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton_1.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u91CD\u7F6E.png")));
		
		JButton btnNewButton_2 = new JButton("\u53BB\u767B\u5F55");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame loginFrame = new LoginFrame();
				loginFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(RegisterFrame.class.getResource("/images/\u767B\u5F55.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(114)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(39)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(repeatpasswordTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addComponent(usernameTxt, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
												.addComponent(userTypeJcb, 0, 174, Short.MAX_VALUE))))
									.addGap(163))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
									.addGap(40)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(46)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTypeJcb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(repeatpasswordTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.fillUserType();
	}

	//注册事件处理
	private void registerActionPerformed(ActionEvent e) {
		UserType usertype = (UserType) userTypeJcb.getSelectedItem();
		int usertypeId = usertype.getId(); 
		String username = this.usernameTxt.getText();
		String password = new String(this.passwordTxt.getPassword());
		String repeatpassword = new String(this.repeatpasswordTxt.getPassword());
		if (StringUtil.isEmpty(username)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return;
		}
		if (StringUtil.isEmpty(repeatpassword)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空！");
			return;
		}
		if (password.equals(repeatpassword)) {
			Connection con = null;
			User user = new User(username,password,usertypeId);
			try {
				con = dbUtil.getConnection();
				int addNum = userDao.addUser(con, user);
				if (addNum == 1) {
					JOptionPane.showMessageDialog(null, "注册成功！");
					this.resetValueActionPerformed(e);
				}else {
					JOptionPane.showMessageDialog(null, "注册失败！");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
 		}else {
			JOptionPane.showMessageDialog(null, "两次输入不一致！");
		}
		
	}

	//重置事件处理
	private void resetValueActionPerformed(ActionEvent e) {
		if (this.userTypeJcb.getItemCount() > 0) {
			this.userTypeJcb.setSelectedIndex(0);
		}
		this.usernameTxt.setText("");
		this.passwordTxt.setText("");
		this.repeatpasswordTxt.setText("");
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
