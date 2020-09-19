package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CourseDao;
import dao.SelectedCourseDao;
import dao.StudentClassDao;
import dao.StudentDao;
import dao.UserDao;
import model.Course;
import model.SelectedCourse;
import model.Student;
import model.StudentClass;
import model.User;
import model.UserType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageSelectedCourseFrm extends JInternalFrame {
	private JTable selectedCourseTable;
	private JComboBox new_courseJcb;
	private JComboBox confimstuNameTxt;
	private JComboBox confimCourseJcb;
	private StudentDao studentDao = new StudentDao();
	private CourseDao courseDao = new CourseDao();
	private UserDao userDao = new UserDao();
	
	private DbUtil dbUtil = new DbUtil();
	private SelectedCourseDao selectedCourseDao = new SelectedCourseDao();
	private JTextField stuNameTxt;
	private JTextField oldcourseTxt;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSelectedCourseFrm frame = new ManageSelectedCourseFrm();
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
	public ManageSelectedCourseFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 795, 687);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u9009\u8BFE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u9009\u8BFE\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 682, Short.MAX_VALUE))
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(84, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 634, GroupLayout.PREFERRED_SIZE)
					.addGap(65))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		confimstuNameTxt = new JComboBox();
		confimstuNameTxt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				studentChangeAct(e);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		confimCourseJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u9009\u8BFE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confimSelectedcourseAct(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(confimstuNameTxt, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(confimCourseJcb, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(btnNewButton)
					.addGap(41))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(confimstuNameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(confimCourseJcb, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5B66\u751F\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u65B0\u8BFE\u7A0B\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		new_courseJcb = new JComboBox();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u9009\u8BFE\uFF1A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateSelectedCourseAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u8BFE\u7A0B");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteSelectedCourseAct(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		stuNameTxt = new JTextField();
		stuNameTxt.setEditable(false);
		stuNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_5 = new JLabel("\u8BFE\u7A0B\uFF1A");
		lblNewLabel_5.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		oldcourseTxt = new JTextField();
		oldcourseTxt.setEditable(false);
		oldcourseTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_6.setIcon(new ImageIcon(ManageSelectedCourseFrm.class.getResource("/images/\u5E74\u9F84.png")));
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(oldcourseTxt))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 51, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(93)
							.addComponent(btnNewButton_1)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(stuNameTxt, Alignment.TRAILING)
								.addComponent(new_courseJcb, Alignment.TRAILING, 0, 146, Short.MAX_VALUE))))
					.addGap(56))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(stuNameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(new_courseJcb, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(oldcourseTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		selectedCourseTable = new JTable();
		selectedCourseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				selectedCourseMousePressed(e);
			}
		});
		selectedCourseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u8BFE\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selectedCourseTable.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(selectedCourseTable);
		getContentPane().setLayout(groupLayout);

//		fillSelectedCourseTable(new SelectedCourse());
		fillstuNameJcb();
		fillCourseJcb();
		setAuthority();
		initTable();
	}
	
	//修改选课
	private void updateSelectedCourseAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的记录！");
			return;
		}
		String oldCourseName = this.oldcourseTxt.getText();
		Course course = (Course) this.new_courseJcb.getSelectedItem();
		if ("请选择".equals(course.getCoursename())) {
			JOptionPane.showMessageDialog(this, "请选择新的课程！");
			return;
		}else {
			if (oldCourseName.equals(course.getCoursename())) {
				JOptionPane.showMessageDialog(this, "数据未修改！");
				return;
			}
		}
		String stuName = this.stuNameTxt.getText();
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Student student = new Student();
			student.setStuId(studentDao.getStuIdByStuName(con, stuName));
			int student_id = student.getStuId();
			int course_id = course.getId();
			if (!courseDao.selectedEnable(con, course_id)) {
				JOptionPane.showMessageDialog(this, "该课程已经选满，不能再选！");
				return;
			}
			SelectedCourse selectedCourse = new SelectedCourse();
			selectedCourse.setId(Integer.parseInt(id));
			selectedCourse.setStudent_id(student_id);
			selectedCourse.setCourse_id(course_id);
			if (selectedCourseDao.isSelected(con, selectedCourse)) {
				JOptionPane.showMessageDialog(this, "已经选过这门课，不能复选！");
				return;
			}
			int updateScNum = selectedCourseDao.updateSelectedCourse(con, selectedCourse);
			if (updateScNum == 1) {
				int new_updateCourseNum =courseDao.updateSelectedNum(con, selectedCourse, 1);
				if (new_updateCourseNum == 1) {
					selectedCourse.setCourse_id(courseDao.getCourseIdByCoursename(con, oldCourseName));
					int old_updateCourseNum = courseDao.updateSelectedNum(con, selectedCourse, -1);
					if (old_updateCourseNum ==1) {
						JOptionPane.showMessageDialog(this, "修改成功！");
						initTable();
						resetValue();
						return;
					}
				}else {
					JOptionPane.showMessageDialog(this, "修改成功，课程信息更新失败 ");
					return;
				}
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

	//删除选课
	private void deleteSelectedCourseAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要退选的课程！");
			return;
		}
		String coursename = this.oldcourseTxt.getText();
		SelectedCourse selectedCourse = new SelectedCourse();
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			selectedCourse.setCourse_id(courseDao.getCourseIdByCoursename(con, coursename));
			int deleteNum = selectedCourseDao.deleteSelectedCourse(con, id);
			if (deleteNum == 1) {
				int updateNum = courseDao.updateSelectedNum(con, selectedCourse, -1);
				if (updateNum ==1) {
					JOptionPane.showMessageDialog(this, "退课成功！");
					initTable();
					resetValue();
					return;
				}else {
					JOptionPane.showMessageDialog(this, "退课成功，但更新课程信息失败！");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(this, "退课失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//选课操作
	private void confimSelectedcourseAct(ActionEvent e) {
		Student student = (Student) this.confimstuNameTxt.getSelectedItem();
		Course course = (Course) this.confimCourseJcb.getSelectedItem();
		SelectedCourse selectedCourse =  new SelectedCourse();
		selectedCourse.setStudent_id(student.getStuId());
		selectedCourse.setCourse_id(course.getId());
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			if (!courseDao.selectedEnable(con, selectedCourse.getId())) {
				JOptionPane.showMessageDialog(this, "该课程已经选满， 不能再选！");
				return;
			}
			if (selectedCourseDao.isSelected(con, selectedCourse)) {
				JOptionPane.showMessageDialog(this, "已经选过该课程，不能复选");
				return;
			}
			int addNum = selectedCourseDao.addSelectedCourse(con, selectedCourse);
			if (addNum == 1) {
				int updateNum = courseDao.updateSelectedNum(con, selectedCourse, 1);
				if (updateNum == 1) {
					JOptionPane.showMessageDialog(this, "选课成功！");
					initTable();
					return;
				}else {
					JOptionPane.showMessageDialog(this, "选课成功，课程信息跟新失败！");
					return;
				}
			}else {
				JOptionPane.showMessageDialog(this, "选课失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
		
	}

	//下拉框点击事件处理
	private void studentChangeAct(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED){
			initTable();
		}
	}

	//初始化表格
	private void initTable() {
		Student student = (Student) this.confimstuNameTxt.getSelectedItem();
		int student_id = student.getStuId();
		SelectedCourse selectedCourse = new SelectedCourse(student_id);
		fillSelectedCourseTable(selectedCourse);
	}
	
	//填充表格
	private void fillSelectedCourseTable(SelectedCourse selectedCourse) {
		DefaultTableModel dtm = (DefaultTableModel) selectedCourseTable.getModel();
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

				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}
	
	//表格点击事件处理
	private void selectedCourseMousePressed(MouseEvent e) {
		int row = this.selectedCourseTable.getSelectedRow();
		this.idTxt.setText((String) selectedCourseTable.getValueAt(row, 0));
		this.stuNameTxt.setText((String) selectedCourseTable.getValueAt(row, 1));
		this.oldcourseTxt.setText((String) selectedCourseTable.getValueAt(row, 2));
	}
	
	//填充学生姓名下拉框
	private void fillstuNameJcb() {
		Connection con = null;
		Student student = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = studentDao.list(con, new Student());
			while(rs.next()) {
				student = new Student();
				student.setStuName(rs.getString("stuName"));
				student.setStuId(rs.getInt("stuId"));
				this.confimstuNameTxt.addItem(student);
			}
			String username = MainFrame.user.getUsername();
			int uId = userDao.getUser_uIdByUsername(con, username);
			if ("学生".equals(MainFrame.userType.getUsertypeName())) {
				for (int i = 0; i < confimstuNameTxt.getItemCount(); i++) {
					Student student2 = (Student) this.confimstuNameTxt.getItemAt(i);
					int userId = studentDao.getStudent_userIdByStuName(con, student2);
					if (uId == userId) {
						this.confimstuNameTxt.setSelectedIndex(i);
						this.stuNameTxt.setText(student2.getStuName());
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//填充课程名称下拉框
	private void fillCourseJcb() {
		Connection con = null;
		Course course= null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = courseDao.list(con, new Course());
			course = new Course();
			course.setCoursename("请选择");
			course.setId(-1);
			this.new_courseJcb.addItem(course);
			while(rs.next()) {
				course = new Course();
				course.setCoursename(rs.getString("coursename"));
				course.setId(rs.getInt("id"));
				this.new_courseJcb.addItem(course);
				this.confimCourseJcb.addItem(course);
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
			this.confimstuNameTxt.setEnabled(false);
			this.stuNameTxt.setEnabled(false);
		}
	}
	
	private void resetValue() {
		this.idTxt.setText("");
		this.stuNameTxt.setText("");
		this.oldcourseTxt.setText("");
		this.new_courseJcb.setSelectedIndex(0);
	}
}
