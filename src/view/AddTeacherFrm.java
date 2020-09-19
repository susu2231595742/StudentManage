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
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.TeacherDao;
import dao.UserDao;
import dao.UserTypeDao;
import model.Student;
import model.Teacher;
import model.User;
import model.UserType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddTeacherFrm extends JInternalFrame {
	private JTextField teacherNameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ageTxt;
	private JTextField passwordTxt;
	private JTextField titleTxt;
	private JRadioButton manJrb;
	private JRadioButton famleJrb;
	private DbUtil dbUtil = new DbUtil();
	private UserTypeDao userTypeDao = new UserTypeDao();
	private UserDao userDao = new UserDao();
	private TeacherDao teacherDao = new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrm frame = new AddTeacherFrm();
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
	public AddTeacherFrm() {
		setTitle("\u6559\u5E08\u6DFB\u52A0\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 536, 462);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		teacherNameTxt = new JTextField();
		teacherNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u6027\u522B.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		manJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		famleJrb = new JRadioButton("\u5973");
		buttonGroup.add(famleJrb);
		famleJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u6559\u5E08\u804C\u9F84\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u5E74\u9F84.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		passwordTxt = new JTextField();
		passwordTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTeacherAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("\u804C\u79F0\u8BC4\u5B9A\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(AddTeacherFrm.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		titleTxt = new JTextField();
		titleTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(ageTxt, 140, 140, 140)
								.addComponent(passwordTxt, 140, 140, 140)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(titleTxt, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(teacherNameTxt, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(manJrb)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(famleJrb, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))))
					.addGap(190))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(teacherNameTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(manJrb)
						.addComponent(famleJrb))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(ageTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void addTeacherAction(ActionEvent e) {
		String teacherName = this.teacherNameTxt.getText();
		String sex = "";
		if (manJrb.isSelected()) {
			sex = "男";
		}else if (famleJrb.isSelected()) {
			sex = "女";
		}
		String title = this.titleTxt.getText();
		String age = this.ageTxt.getText();
		String password = this.passwordTxt.getText();
		
		if (StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(this, "教师姓名不能为空！");
			return;
		}
		if (StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(this, "教师职称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(age)) {
			JOptionPane.showMessageDialog(this, "教师年龄不能为空！");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "登录密码不能为空！");
			return;
		}
		
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			String usertypeName = "教师";
			UserType userType = new UserType(usertypeName);
			ResultSet rs = userTypeDao.searcheId(con, userType);
			while(rs.next()) {
				int usertypeId = rs.getInt("id");  // 查询出 id
				User user = new User(teacherName, password, usertypeId);
				int addUserNum = userDao.addUser(con, user);
				if (addUserNum == 1) {
					ResultSet rs2 = userDao.list(con, user);
					while(rs2.next()) {
						int userId = rs2.getInt("uId");   //查询出添加后的用户名的id
						Teacher teacher = new Teacher(teacherName, sex, title, Integer.parseInt(age), userId);
						int addstuNUm = teacherDao.addTeacher(con, teacher);
						if (addstuNUm == 1) {
							JOptionPane.showMessageDialog(this, "添加成功！");
							resetValueAct(e);
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

	private void resetValueAct(ActionEvent e) {
		this.teacherNameTxt.setText("");
		this.manJrb.setSelected(true);
		this.titleTxt.setText("");
		this.ageTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
