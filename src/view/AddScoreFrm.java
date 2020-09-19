package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Course;
import model.SelectedCourse;
import model.Student;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddScoreFrm extends JInternalFrame {
	private JTextField scoreTxt;
	private JComboBox stuNameJcb;
	private JComboBox courseJcb;
	
	private DbUtil dbUtil = new DbUtil();
	private CourseDao courseDao = new CourseDao();
	private StudentDao studentDao = new StudentDao();
	private SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
	private TeacherDao teacherDao = new TeacherDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScoreFrm frame = new AddScoreFrm();
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
	public AddScoreFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 657, 499);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuNameJcb = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u4FE1\u606F\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseJcb = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5F97\u6210\u7EE9\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u6210\u7EE9.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		scoreTxt = new JTextField();
		scoreTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5F55\u5165\u6210\u7EE9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addScoreAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(137)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scoreTxt)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(courseJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(stuNameJcb, 0, 172, Short.MAX_VALUE)))
							.addContainerGap(289, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(183))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(90)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(stuNameJcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseJcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(scoreTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		getContentPane().setLayout(groupLayout);
		
		fillCourseJcb();
		fillStudentJcb();

	}

	private void addScoreAction(ActionEvent e) {
		Student student = (Student) this.stuNameJcb.getSelectedItem();
		Course course = (Course) this.courseJcb.getSelectedItem();
		String score = this.scoreTxt.getText();
		if (StringUtil.isEmpty(score)) {
			JOptionPane.showMessageDialog(this, "请输入成绩！");
			return;
		}
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setStudent_id(student.getStuId());
		selectedCourse.setCourse_id(course.getId());
		selectedCourse.setScore(Integer.parseInt(score));
		
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			boolean isSelected = selectedCourseDao.isSelected(con, selectedCourse);
			if (!isSelected) {
				JOptionPane.showMessageDialog(this, "该学生没有选过该课程，无法录入成绩");
				this.scoreTxt.setText("");
				return;
			}
			int addNum = selectedCourseDao.updateScore(con, selectedCourse);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(this, "成绩录入成功！");
				resetValueAct(e);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "录入失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	private void fillStudentJcb() {
		Connection con = null;
		Student student = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = studentDao.list(con, new Student());
			while(rs.next()) {
				student = new Student();
				student.setStuName(rs.getString("stuName"));
				student.setStuId(rs.getInt("stuId"));
				this.stuNameJcb.addItem(student);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//重置
	private void resetValueAct(ActionEvent e) {
		this.stuNameJcb.setSelectedIndex(0);
		this.courseJcb.setSelectedIndex(0);
		this.scoreTxt.setText("");
	}
	
	private void fillCourseJcb() {
		Connection con = null;
		Course course= null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = courseDao.list(con, new Course());
			while(rs.next()) {
				course = new Course();
				course.setCoursename(rs.getString("coursename"));
				course.setId(rs.getInt("id"));
				course.setTeacherId(rs.getInt("teacherId"));
				if ("教师".equals(MainFrame.userType.getUsertypeName())) {
					String teachername = MainFrame.user.getUsername();
					int teacher_id = teacherDao.getTeacher_idByTeachername(con, teachername);
					if (course.getTeacherId() == teacher_id) {
						this.courseJcb.addItem(course);
					}
					continue;
				}
				this.courseJcb.addItem(course);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
	
	
	
}
