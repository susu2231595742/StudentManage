package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.StudentClassDao;
import dao.StudentDao;
import dao.UserDao;
import dao.UserTypeDao;
import model.Student;
import model.StudentClass;
import model.User;
import model.UserType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddstudentFrm extends JInternalFrame {
	private JTextField studentNameTxt;
	private JComboBox stuClassJcb;
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	private DbUtil dbUtil = new DbUtil();
	private StudentClassDao studentClassDao = new StudentClassDao();
	private JTextField stuPasswordTxt;
	private JTextField snoTxt;
	private JTextField telTxt;
	private UserDao userDao = new UserDao();
	private StudentDao studentDao= new StudentDao();
	private UserTypeDao userTypeDao = new UserTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddstudentFrm frame = new AddstudentFrm();
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
	public AddstudentFrm() {
		setTitle("\u5B66\u751F\u6DFB\u52A0\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 631, 468);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		studentNameTxt = new JTextField();
		studentNameTxt.setFont(new Font("宋体", Font.PLAIN, 16));
		studentNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuClassJcb = new JComboBox();
		stuClassJcb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u6027\u522B.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		manJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		femaleJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		stuPasswordTxt = new JTextField();
		stuPasswordTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/userType.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		snoTxt = new JTextField();
		snoTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(AddstudentFrm.class.getResource("/images/\u624B\u673A.png")));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		telTxt = new JTextField();
		telTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(111)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(8))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(telTxt, 171, 171, 171)
												.addComponent(stuClassJcb, 0, 173, Short.MAX_VALUE))
											.addGap(4))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(snoTxt, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(109)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
										.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(femaleJrb, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(94)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnNewButton)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(stuPasswordTxt, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1))))
							.addGap(1)))
					.addGap(227))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentNameTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(snoTxt, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(stuClassJcb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(telTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(stuPasswordTxt, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(7))
		);
		getContentPane().setLayout(groupLayout);
		this.fillStudentClass();
	}

	
	private void addStudentActionPerformed(ActionEvent e) {
		String stuName = this.studentNameTxt.getText();
		String tel = this.telTxt.getText();
		String sno = this.snoTxt.getText();
		StudentClass studentclass = (StudentClass)stuClassJcb.getSelectedItem();
		int classId = studentclass.getId();
		String password = stuPasswordTxt.getText();
		if (StringUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog(this, "学生姓名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(this, "学号不能为空！");
			return;
		}
		if (stuClassJcb.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(this, "请选择学生班级！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "登录密码不能为空！");
			return;
		}
		String sex = "";
		if (manJrb.isSelected()) {
			sex = "男";
		}else if (femaleJrb.isSelected()) {
			sex = "女";
		}
		
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			String usertypeName = "学生";
			UserType userType = new UserType(usertypeName);
			ResultSet rs = userTypeDao.searcheId(con, userType);
			while(rs.next()) {
				int usertypeId = rs.getInt("id");  // 查询出 学生的id
				User user = new User(stuName, password, usertypeId);
				int addUserNum = userDao.addUser(con, user);
				if (addUserNum == 1) {
					ResultSet rs2 = userDao.list(con, user);
					while(rs2.next()) {
						int userId = rs2.getInt("uId");   //查询出添加后的用户名的id
						Student student = new Student(sno, stuName, sex, tel, classId, userId);
						int addstuNUm = studentDao.addStudent(con, student);
						if (addstuNUm == 1) {
							JOptionPane.showMessageDialog(this, "添加成功！");
							resetValue(e);
							return;
						}else {
							JOptionPane.showMessageDialog(this, "添加失败！");
							return;
						}
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}

	}

	//初始化下拉框
	private void fillStudentClass(){
		Connection con = null;
		StudentClass studentClass = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = studentClassDao.list(con, new StudentClass());
				studentClass = new StudentClass();
				studentClass.setClassName("请选择...");
				studentClass.setId(-1);
				this.stuClassJcb.addItem(studentClass);
			while(rs.next()) {
				studentClass = new StudentClass();
				studentClass.setClassName(rs.getString("className"));
				studentClass.setId(rs.getInt("id"));
				this.stuClassJcb.addItem(studentClass);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//重置
	private void resetValue(ActionEvent e) {
		this.studentNameTxt.setText("");
		this.stuPasswordTxt.setText("");
		this.snoTxt.setText("");
		this.telTxt.setText("");
		if (this.stuClassJcb.getItemCount()> 0) {
			this.stuClassJcb.setSelectedIndex(0);
		}
		this.manJrb.setSelected(true);
		
	}
}
