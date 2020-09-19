package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CourseDao;
import dao.TeacherDao;
import model.Course;
import model.Teacher;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCourseFrm extends JInternalFrame {
	private JTextField s_courseNameTxt;
	private JComboBox s_teacherJcb;
	private JTable courseTable;
	private JTextField idTxt;
	private JTextField courseNameTxt;
	private JComboBox teacherJcb;
	private JTextField studentNumTxt;
	private JTextArea infoTxt;
	
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
					ManageCourseFrm frame = new ManageCourseFrm();
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
	public ManageCourseFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(50, 50, 881, 693);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_courseNameTxt = new JTextField();
		s_courseNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_teacherJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCourseAct(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u8BFE\u7A0B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 716, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(scrollPane, Alignment.LEADING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(s_courseNameTxt, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGap(29)
								.addComponent(lblNewLabel_1)
								.addGap(18)
								.addComponent(s_teacherJcb, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addGap(67)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_courseNameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_teacherJcb, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BFE\u7A0B\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		courseNameTxt = new JTextField();
		courseNameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		
		JLabel lblNewLabel_5 = new JLabel("\u6388\u8BFE\u6559\u5E08\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		teacherJcb = new JComboBox();
		
		JLabel lblNewLabel_6 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		
		studentNumTxt = new JTextField();
		studentNumTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 16));
		
		infoTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u8BFE\u7A0B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCourseAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateCourseAct(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAct(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(studentNumTxt)
								.addComponent(teacherJcb, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(idTxt, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(193)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(81)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(infoTxt, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(courseNameTxt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6)
								.addComponent(studentNumTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(teacherJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(infoTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		courseTable = new JTable();
		courseTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				courseTableMousePressed(e);
			}
		});
		courseTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u6559\u5E08", "\u8BFE\u7A0B\u6700\u5927\u4EBA\u6570", "\u5DF2\u9009\u4EBA\u6570", "\u8BFE\u7A0B\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		courseTable.getColumnModel().getColumn(0).setResizable(false);
		courseTable.getColumnModel().getColumn(1).setResizable(false);
		courseTable.getColumnModel().getColumn(2).setResizable(false);
		courseTable.getColumnModel().getColumn(3).setResizable(false);
		courseTable.getColumnModel().getColumn(4).setResizable(false);
		courseTable.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(courseTable);
		getContentPane().setLayout(groupLayout);
		fillCourseTable(new Course());
		fillTeacher();

	}

	//修改事件处理
	private void updateCourseAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的课程记录！");
			return;
		}
		String coursename = this.courseNameTxt.getText();
		String max_student_num = this.studentNumTxt.getText();
		String info = this.infoTxt.getText();
		Teacher teacher =  (Teacher) this.teacherJcb.getSelectedItem();
		int teacherId = teacher.getId();
		if (StringUtil.isEmpty(coursename)) {
			JOptionPane.showMessageDialog(this, "课程名称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(max_student_num)) {
			JOptionPane.showMessageDialog(this, "学生人数不能为空！");
			return;
		}
		if (teacherId == -1) {
			JOptionPane.showMessageDialog(this, "请选择授课教师！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Course course = new Course(Integer.parseInt(id), coursename, Integer.parseInt(max_student_num), teacherId, info);
			int updateNum = courseDao.update(con, course);
			if (updateNum == 1) {
				JOptionPane.showMessageDialog(this, "修改成功！");
				fillCourseTable(new Course());
				resetValueAct(e);
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

	//删除事件处理
	private void deleteCourseAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要删除的课程记录！");
			return;
		}
		Connection  con = null;
		try {
			con = dbUtil.getConnection();
			int deleteNum = courseDao.delete(con, id);
			if (deleteNum == 1) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				fillCourseTable(new Course());
				resetValueAct(e);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "删除失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
	}

	//搜索事件处理
	private void searchCourseAct(ActionEvent e) {
		String coursename = this.s_courseNameTxt.getText();
		Teacher teacher = (Teacher) this.s_teacherJcb.getSelectedItem();
		int teacherId = teacher.getId();
		Course course = new Course(coursename, teacherId);
		fillCourseTable(course);
		
	}

	//表格点击事件处理
	private void courseTableMousePressed(MouseEvent e) {
		int row = this.courseTable.getSelectedRow();
		this.idTxt.setText((String) courseTable.getValueAt(row, 0));
		this.courseNameTxt.setText((String) courseTable.getValueAt(row, 1));
		String teacherName = (String) courseTable.getValueAt(row, 2);
		int n = this.teacherJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			Teacher item = (Teacher) this.teacherJcb.getItemAt(i);
			if (item.getTeacherName().equals(teacherName)) {
				this.teacherJcb.setSelectedIndex(i);
			}
		}
		this.studentNumTxt.setText((String) courseTable.getValueAt(row, 3));
		this.infoTxt.setText((String) courseTable.getValueAt(row, 5));
		
		
	}

	//初始化表格
	private void fillCourseTable(Course course) {
		DefaultTableModel dtm = (DefaultTableModel) courseTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = courseDao.list(con, course);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("coursename"));
				v.add(rs.getString("teacherName"));
				v.add(rs.getString("max_student_num"));
				v.add(rs.getString("selected_num"));
				v.add(rs.getString("info"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
		
	}
	
	//填充下拉框
	private void fillTeacher() {
		Connection con = null;
		Teacher teacher = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = teacherDao.list(con, new Teacher());
			teacher = new Teacher();
			teacher.setTeacherName("请选择！");
			teacher.setId(-1);
			this.s_teacherJcb.addItem(teacher);
			this.teacherJcb.addItem(teacher);
			while(rs.next()) {
				teacher = new Teacher();
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setId(rs.getInt("id"));
				this.s_teacherJcb.addItem(teacher);
				this.teacherJcb.addItem(teacher);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//重置
	private void resetValueAct(ActionEvent e) {
		this.idTxt.setText("");
		this.courseNameTxt.setText("");
		this.teacherJcb.setSelectedIndex(0);
		this.studentNumTxt.setText("");
		this.infoTxt.setText("");
	}
}
