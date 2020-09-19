package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.TeacherDao;
import model.Course;
import model.SelectedCourse;
import util.DbUtil;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;
import java.awt.event.ActionEvent;

public class StatsScoreFrm extends JInternalFrame {
	private JTextField maxScoreTxt;
	private JTextField minScoreTxt;
	private JTextField middScoreTxt;
	private JTextField studentNumTxt;
	private JComboBox courseJcb;
	
	private DbUtil dbUtil = new DbUtil();
	private CourseDao courseDao = new CourseDao();
	private TeacherDao teacherDao = new TeacherDao();
	private SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatsScoreFrm frame = new StatsScoreFrm();
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
	public StatsScoreFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 744, 540);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchScoreAct(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u6210\u7EE9\u7EDF\u8BA1\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(96)
							.addComponent(lblNewLabel)
							.addGap(30)
							.addComponent(courseJcb, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(153, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(courseJcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u6700\u9AD8\u5206");
		lblNewLabel_1.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u6700\u9AD8\u5206.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		maxScoreTxt = new JTextField();
		maxScoreTxt.setEditable(false);
		maxScoreTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6700\u4F4E\u5206");
		lblNewLabel_2.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u6700\u4F4E\u5206.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		minScoreTxt = new JTextField();
		minScoreTxt.setEditable(false);
		minScoreTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E73\u5747\u5206");
		lblNewLabel_3.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u5E73\u5747.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		middScoreTxt = new JTextField();
		middScoreTxt.setEditable(false);
		middScoreTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u603B\u4EBA\u6570");
		lblNewLabel_4.setIcon(new ImageIcon(StatsScoreFrm.class.getResource("/images/\u4EBA\u6570\u7EDF\u8BA1.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		studentNumTxt = new JTextField();
		studentNumTxt.setEditable(false);
		studentNumTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(76)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(studentNumTxt)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(middScoreTxt)
							.addComponent(minScoreTxt)
							.addComponent(maxScoreTxt, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
					.addContainerGap(224, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxScoreTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(minScoreTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(middScoreTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(studentNumTxt, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		fillCourseJcb();
	}

	private void searchScoreAct(ActionEvent e) {
		Course course = (Course) this.courseJcb.getSelectedItem();
		SelectedCourse selectedCourse = new SelectedCourse();
		selectedCourse.setCourse_id(course.getId());
		
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Map<String, String> statsInfo = selectedCourseDao.scoreList(con, selectedCourse);
			if (statsInfo.size()>0) {
				this.maxScoreTxt.setText(statsInfo.get("max_score"));
				this.minScoreTxt.setText(statsInfo.get("min_score"));
				this.middScoreTxt.setText(statsInfo.get("mid_score"));
				this.studentNumTxt.setText(statsInfo.get("student_num"));
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
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
