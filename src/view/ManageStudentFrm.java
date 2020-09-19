package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentClassDao;
import dao.StudentDao;
import dao.UserDao;
import model.Student;
import model.StudentClass;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class ManageStudentFrm extends JInternalFrame {
	private JTextField s_studentnameTxt;
	private JTextField s_studentsnoTxt;
	private JTable studentTable;
	private JComboBox s_studentclassJcb;
	private JComboBox studentclassJcb;
	private JRadioButton manJrb;
	private JRadioButton famleJrb;
	private JTextField idTxt;
	private JTextField snoTxt;
	private JTextField stunameTxt;
	private JTextField telTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DbUtil dbUtil = new DbUtil();
	private StudentDao studentDao = new StudentDao();
	private StudentClassDao studentClassDao = new StudentClassDao();
	private UserDao userDao = new UserDao();
	private JTextField usernameTxt;


	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ManageStudentFrm frame = new ManageStudentFrm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ManageStudentFrm() {
		setTitle("\u5B66\u751F\u7BA1\u7406\u5217\u8868");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 899, 654);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u641C\u7D22\u8868\u5355", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 809, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 740, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		
		s_studentnameTxt = new JTextField();
		s_studentnameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u4EBA\u6570\u7EDF\u8BA1.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		
		s_studentsnoTxt = new JTextField();
		s_studentsnoTxt.setFont(new Font("宋体", Font.PLAIN, 14));
		s_studentsnoTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		
		s_studentclassJcb = new JComboBox();
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentSerchActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(s_studentnameTxt, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(s_studentsnoTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(s_studentclassJcb, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_studentnameTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_studentsnoTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(s_studentclassJcb, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		
		snoTxt = new JTextField();
		snoTxt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		
		stunameTxt = new JTextField();
		stunameTxt.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u624B\u673A\u53F7\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		
		telTxt = new JTextField();
		telTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		manJrb.setFont(new Font("宋体", Font.PLAIN, 14));
		
		famleJrb = new JRadioButton("\u5973");
		buttonGroup.add(famleJrb);
		famleJrb.setFont(new Font("宋体", Font.PLAIN, 14));
		
		JLabel lblNewLabel_8 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 14));
		
		studentclassJcb = new JComboBox();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentUpdateActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAction(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ManageStudentFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
		
		JLabel lblNewLabel_9 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 16));
		
		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(usernameTxt))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(telTxt, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(famleJrb))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(34)
									.addComponent(btnNewButton_1))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(snoTxt, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(stunameTxt, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
								.addComponent(studentclassJcb, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(4)
								.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(5)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(snoTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(stunameTxt, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(telTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(manJrb)
								.addComponent(famleJrb)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(studentclassJcb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(usernameTxt, Alignment.LEADING)
								.addComponent(lblNewLabel_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		studentTable = new JTable();
		studentTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				studentTableMousePressed(e);
			}
		});
		studentTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u624B\u673A\u53F7", "\u73ED\u7EA7", "\u7528\u6237\u540D", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		studentTable.getColumnModel().getColumn(4).setPreferredWidth(99);
		scrollPane.setViewportView(studentTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new Student());
		this.fillStudentClass();
	}

	//查询事件处理
	private void studentSerchActionPerformed(ActionEvent e) {
		String stuName = this.s_studentnameTxt.getText();
		String sno = this.s_studentsnoTxt.getText();
		StudentClass studentClass = (StudentClass) s_studentclassJcb.getSelectedItem();
		int classId = studentClass.getId();
		Student student = new Student(sno, stuName, classId);
		this.fillTable(student);
	}


	//修改事件处理
	private void studentUpdateActionPerformed(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的记录");
			return;
		}
		String stuName = this.stunameTxt.getText();
		if ("学生".equals(MainFrame.userType.getUsertypeName())) {
			if (!stuName.equals(MainFrame.user.getUsername())) {
				JOptionPane.showMessageDialog(this, "不能修改他人信息！");
				return;
			}
		}
		String sno = this.snoTxt.getText();
		String tel = this.telTxt.getText();
		if (StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(this, "学号不能为空！");
			return;
		}
		if (StringUtil.isEmpty(stuName)) {
			JOptionPane.showMessageDialog(this, "学生不能为空！");
			return;
		}
		if (StringUtil.isEmpty(tel)) {
			JOptionPane.showMessageDialog(this, "手机号不能为空！");
			return;
		}
		
		String sex = "";
		if (manJrb.isSelected()) {
			sex = "男";
		}else if (famleJrb.isSelected()) {
			sex = "女";
		}
		
		StudentClass studentClass = (StudentClass) studentclassJcb.getSelectedItem();
		int classId = studentClass.getId();
		
		Student student = new Student(Integer.parseInt(id), sno, stuName, sex, tel, classId);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int addNum = studentDao.update(con, student);
			if (addNum ==1) {
				JOptionPane.showMessageDialog(this, "学生信息修改成功！");
				resetValueAction(e);
				this.fillTable(new Student());
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
	private void deleteAction(ActionEvent e) {
		String id = idTxt.getText();
		String username = usernameTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要删除的学生信息！");
			return;
		}
		if ("学生".equals(MainFrame.userType.getUsertypeName())) {
			if (!username.equals(MainFrame.user.getUsername())) {
				JOptionPane.showMessageDialog(this, "不能删除他人信息！");
				return;
			}
		}
		int n = JOptionPane.showConfirmDialog(this, "是否确定删除？");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getConnection();
				int deleteStu = studentDao.delete(con, id);
				int deleteUser = userDao.delete(con, username);
				if (deleteStu == 1 && deleteUser == 1) {
					JOptionPane.showMessageDialog(this, "删除成功！");
					fillTable(new Student());
					return;
				}else {
					JOptionPane.showMessageDialog(this, "删除失败！");
					return;
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(this, "删除失败！");
				e1.printStackTrace();
			}finally {
				dbUtil.closeCon(con);
			}
		}
		
	}

	//表格点击事件处理
	private void studentTableMousePressed(MouseEvent e) {
		int row = this.studentTable.getSelectedRow();
		this.idTxt.setText((String) studentTable.getValueAt(row, 0));
		this.snoTxt.setText((String) studentTable.getValueAt(row, 1));
		this.stunameTxt.setText((String) studentTable.getValueAt(row, 2));
		String sex = (String) studentTable.getValueAt(row, 3);
		if ("男".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if ("女".equals(sex)) {
			this.famleJrb.setSelected(true);
		}
		this.telTxt.setText((String) studentTable.getValueAt(row, 4));
		String className = (String) studentTable.getValueAt(row, 5);
		int n = this.studentclassJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			StudentClass item = (StudentClass) this.studentclassJcb.getItemAt(i);
			if (item.getClassName().equals(className)) {
				this.studentclassJcb.setSelectedIndex(i);
			}
		}
		this.usernameTxt.setText((String) studentTable.getValueAt(row, 6));
	}

	//初始化表格
	private void fillTable(Student student) {
		DefaultTableModel dtm = (DefaultTableModel)studentTable.getModel();
		dtm.setRowCount(0);  // 设置成0行
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet  rs = studentDao.list(con, student);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("stuId"));
				v.add(rs.getString("sno"));
				v.add(rs.getString("stuName"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("tel"));
				v.add(rs.getString("className"));
				v.add(rs.getString("username"));
				v.add(rs.getString("password"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.closeCon(con);
		}
		
	}
	//初始化班级下拉框
	private void fillStudentClass(){
		Connection con = null;
		StudentClass studentClass = null;
		try {
			con = dbUtil.getConnection();
			ResultSet rs = studentClassDao.list(con, new StudentClass());
				studentClass = new StudentClass();
				studentClass.setClassName("请选择...");
				studentClass.setId(-1);
				this.s_studentclassJcb.addItem(studentClass);
				this.studentclassJcb.addItem(studentClass);
			while(rs.next()) {
				studentClass = new StudentClass();
				studentClass.setClassName(rs.getString("className"));
				studentClass.setId(rs.getInt("id"));
				this.s_studentclassJcb.addItem(studentClass);
				this.studentclassJcb.addItem(studentClass);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//重置事件处理
	private void resetValueAction(ActionEvent e) {
		this.idTxt.setText("");
		this.snoTxt.setText("");
		this.stunameTxt.setText("");
		this.telTxt.setText("");
		this.manJrb.setSelected(true);
		if(this.studentclassJcb.getItemCount()>0) {
			this.studentclassJcb.setSelectedIndex(0);
		}
	}
}
