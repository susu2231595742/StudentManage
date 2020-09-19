package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.crypto.NullCipher;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.CourseDao;
import dao.TeacherDao;
import model.Course;
import model.Teacher;
import util.DbUtil;
import util.StringUtil;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddCourseFrm extends JInternalFrame {
	private JTextField courseTxt;
	private JTextField studentNumTxt;
	private JTextArea courseInfoTxt;
	private JComboBox teacherJcb;
	private DbUtil dbUtil = new DbUtil();
	private CourseDao courseDao = new CourseDao();
	private TeacherDao teacherDao = new TeacherDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseFrm frame = new AddCourseFrm();
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
	public AddCourseFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 629, 505);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseTxt = new JTextField();
		courseTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		teacherJcb = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u4EBA\u6570\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u4EBA\u6570.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		studentNumTxt = new JTextField();
		studentNumTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseInfoTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCourseAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(btnNewButton)
							.addGap(68)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(103)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(studentNumTxt, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(teacherJcb, 0, 209, Short.MAX_VALUE)
								.addComponent(courseTxt, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addComponent(courseInfoTxt, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
					.addGap(187))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(teacherJcb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(studentNumTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseInfoTxt, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(35))
		);
		getContentPane().setLayout(groupLayout);
		fillTeacher();
	}

	//添加课程事件管理
	private void addCourseAction(ActionEvent e) {
		String courseName = this.courseTxt.getText();
		if (StringUtil.isEmpty(courseName)) {
			JOptionPane.showMessageDialog(this, "课程名称不能为空！");
			return;
		}
		String couseInfo = this.courseInfoTxt.getText();
		Teacher teacher = (Teacher) this.teacherJcb.getSelectedItem();
		int teacherId = teacher.getId();
		int studentNum = 0;
		try {
			studentNum = Integer.parseInt(studentNumTxt.getText());
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "学生人数只能输入数字!");
			resetValueAct(e);
			return;
		}
		if (studentNum <=0 ) {
			JOptionPane.showMessageDialog(this, "学生人数只能输大于0的数字！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Course course = new Course(courseName, studentNum,  teacherId, couseInfo);
			int addNum = courseDao.addCourse(con, course);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(this, "添加成功！");
				resetValueAct(e);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "添加失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//重置
	private void resetValueAct(ActionEvent e) {
		this.courseTxt.setText("");
		this.teacherJcb.setSelectedIndex(0);
		this.studentNumTxt.setText("");
		this.courseInfoTxt.setText("");
	}
	
	//填充下拉框
	private void fillTeacher() {
		Connection con = null;
		Teacher teacher = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = teacherDao.list(con, new Teacher());
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setId(rs.getInt("id"));
				this.teacherJcb.addItem(teacher);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
