package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UserDao;
import model.Course;
import model.SelectedCourse;
import model.Student;
import util.DbUtil;
import util.StringUtil;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageScoreFrm extends JInternalFrame {
	private JTable scoreTable;
	private JTextField idTxt;
	private JTextField scoreTxt;
	private JComboBox s_stuNameJcb;
	private JComboBox s_courseJcb;
	private JComboBox stuNameJcb;
	private JComboBox courseJcb;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private DbUtil dbUtil = new DbUtil();
	private CourseDao courseDao = new CourseDao();
	private StudentDao studentDao = new StudentDao();
	private SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
	private UserDao userDao = new UserDao();
	private TeacherDao teacherDao = new TeacherDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageScoreFrm frame = new ManageScoreFrm();
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
	public ManageScoreFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 934, 680);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u67E5\u8BE2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))
					.addGap(69))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuNameJcb = new JComboBox();
		
		JLabel lblNewLabel_1_1 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseJcb = new JComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("\u6210\u7EE9\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		scoreTxt = new JTextField();
		scoreTxt.setColumns(10);
		
		btnNewButton_1 = new JButton("\u4FEE\u6539\u6210\u7EE9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateScoreAct(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		btnNewButton_2 = new JButton("\u91CD\u7F6E");
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stuNameJcb, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(courseJcb, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(scoreTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addGap(122)
							.addComponent(btnNewButton_1)
							.addGap(69)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(21)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(22)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addComponent(stuNameJcb, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(courseJcb, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4)
								.addComponent(scoreTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(23))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		panel_1.setLayout(gl_panel_1);
		
		scoreTable = new JTable();
		scoreTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				scoreTableMousePressed(e);
			}
		});
		scoreTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0", "\u6210\u7EE9"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(scoreTable);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageScoreFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_stuNameJcb = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageScoreFrm.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_courseJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchScoreAct(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageScoreFrm.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_stuNameJcb, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_courseJcb, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_stuNameJcb, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_courseJcb, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addGap(23))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		fillStudentJcb();
		fillCourseJcb();
		fillScoreTable(new SelectedCourse());
		setAuthority();
		
	}
	
	private void updateScoreAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的记录");
			return;
		}
		Student student = (Student) this.stuNameJcb.getSelectedItem();
		Course course = (Course) this.courseJcb.getSelectedItem();
		String score = this.scoreTxt.getText();
		
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setId(Integer.parseInt(id));
		selectedCourse.setStudent_id(student.getStuId());
		selectedCourse.setCourse_id(course.getId());
		selectedCourse.setScore(Integer.parseInt(score));
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int updateNum = selectedCourseDao.updateScore(con, selectedCourse);
			if (updateNum == 1) {
				JOptionPane.showMessageDialog(this, "成绩修改成功");
				fillScoreTable(new SelectedCourse());
				
				return;
			}else {
				JOptionPane.showMessageDialog(this, "修改失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//表格点击事件处理
	private void scoreTableMousePressed(MouseEvent e) {
		int row = this.scoreTable.getSelectedRow();
		this.idTxt.setText((String) scoreTable.getValueAt(row, 0));
		String stuName = (String) this.scoreTable.getValueAt(row, 1);
		for (int i = 0; i < stuNameJcb.getItemCount(); i++) {
			Student student = (Student) this.stuNameJcb.getItemAt(i);
			if (student.getStuName().equals(stuName)) {
				this.stuNameJcb.setSelectedIndex(i);
				break;
			}
		}
		String courseName = (String) this.scoreTable.getValueAt(row, 2);
		for (int i = 0; i < courseJcb.getItemCount(); i++) {
			Course course = (Course) this.courseJcb.getItemAt(i);
			if (course.getCoursename().equals(courseName)) {
				this.stuNameJcb.setSelectedIndex(i);
				break;
			}
		}
		String score = (String) this.scoreTable.getValueAt(row, 3);
		if (score == null) {
			this.scoreTxt.setText("0");
		}else {
			this.scoreTxt.setText(score);
		}
	}

	//查询事件操作
	protected void searchScoreAct(ActionEvent e) {
		Student student = (Student) this.s_stuNameJcb.getSelectedItem();
		Course course = (Course) this.s_courseJcb.getSelectedItem();
		
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setStudent_id(student.getStuId());
		selectedCourse.setCourse_id(course.getId());
		fillScoreTable(selectedCourse);
		
	}
	
	//填充学生姓名下拉框
	private void fillStudentJcb() {
		Connection con = null;
		Student student = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = studentDao.list(con, new Student());
			student = new Student();
			student.setStuName("请选择");
			student.setStuId(-1);
			this.s_stuNameJcb.addItem(student);
			while(rs.next()) {
				student = new Student();
				student.setStuName(rs.getString("stuName"));
				student.setStuId(rs.getInt("stuId"));
				this.stuNameJcb.addItem(student);
				this.s_stuNameJcb.addItem(student);
			}
			String username = MainFrame.user.getUsername();
			int uId = userDao.getUser_uIdByUsername(con, username);
			if ("学生".equals(MainFrame.userType.getUsertypeName())) {
				for (int i = 0; i < s_stuNameJcb.getItemCount(); i++) {
					Student student2 = (Student) this.s_stuNameJcb.getItemAt(i);
					int userId = studentDao.getStudent_userIdByStuName(con, student2);
					if (uId == userId) {
						this.s_stuNameJcb.setSelectedIndex(i);
						this.stuNameJcb.setSelectedIndex(i);
						break;
					}
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
	
	//填充课表名称下拉框
	private void fillCourseJcb() {
		Connection con = null;
		Course course= null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = courseDao.list(con, new Course());
			course = new Course();
			course.setCoursename("请选择");
			course.setId(-1);
			this.s_courseJcb.addItem(course);
			while(rs.next()) {
				course = new Course();
				course.setCoursename(rs.getString("coursename"));
				course.setId(rs.getInt("id"));
				course.setTeacherId(rs.getInt("teacherId"));
				this.s_courseJcb.addItem(course);
				if ("教师".equals(MainFrame.userType.getUsertypeName())) {
					String teachername = MainFrame.user.getUsername();
					int teacher_id = teacherDao.getTeacher_idByTeachername(con, teachername);
					if (course.getTeacherId() == teacher_id) {
						this.courseJcb.addItem(course);
					}
					continue;
				}
				this.courseJcb.addItem(course); //执行到这里一定是超级管理员身份
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
	
	//填充表格
	private void fillScoreTable(SelectedCourse selectedCourse) {
		DefaultTableModel dtm = (DefaultTableModel) scoreTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = selectedCourseDao.list(con, selectedCourse);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("stuName"));
				v.add(rs.getString("coursename"));
				v.add(rs.getInt("score"));

				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
	
	private void setAuthority() {
		if ("学生".equals(MainFrame.userType.getUsertypeName())) {
			this.s_stuNameJcb.setEnabled(false);
			this.stuNameJcb.setEnabled(false);
			this.courseJcb.setEnabled(false);
			this.scoreTxt.setEnabled(false);
			this.btnNewButton_1.setEnabled(false);
			this.btnNewButton_2.setEnabled(false);
		}
	}
}
