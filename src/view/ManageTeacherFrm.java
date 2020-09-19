package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.TeacherDao;
import model.Teacher;
import model.User;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageTeacherFrm extends JInternalFrame {
	private JTextField s_teachernameTxt;
	private JTable teacherTable;
	private JTextField idTxt;
	private JTextField teachernameTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField ageTxt;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JRadioButton manJrb;
	private JRadioButton famleJrb;
	
	private DbUtil dbUtil = new DbUtil();
	private TeacherDao teacherDao = new TeacherDao();
	private JTextField titleTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTeacherFrm frame = new ManageTeacherFrm();
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
	public ManageTeacherFrm() {
		setTitle("\u6559\u5E08\u7BA1\u7406\u9875\u9762");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 813, 655);
		
		JLabel lblNewLabel = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u8001\u5E08.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_teachernameTxt = new JTextField();
		s_teachernameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchTeacherNameAct(e);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		btnNewButton.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u641C\u7D22.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u7BA1\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(87)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(s_teachernameTxt, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(82)
							.addComponent(btnNewButton))
						.addComponent(scrollPane))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(s_teachernameTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_2 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		teachernameTxt = new JTextField();
		teachernameTxt.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		manJrb.setSelected(true);
		
		famleJrb = new JRadioButton("\u5973");
		buttonGroup.add(famleJrb);
		famleJrb.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("\u804C\u79F0\u8BC4\u5B9A\uFF1A");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("\u804C\u9F84\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 16));
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 16));
		
		usernameTxt = new JTextField();
		usernameTxt.setEditable(false);
		usernameTxt.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 15));
		
		passwordTxt = new JTextField();
		passwordTxt.setEditable(false);
		passwordTxt.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTeacherAct(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteTeacheAct(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		titleTxt = new JTextField();
		titleTxt.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAct(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ManageTeacherFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(lblNewLabel_3)
							.addGap(4)
							.addComponent(teachernameTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ageTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(btnNewButton_1)))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblNewLabel_4))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(8)
									.addComponent(btnNewButton_2)))
							.addGap(15)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(manJrb, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addComponent(famleJrb))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(12)
									.addComponent(btnNewButton_3))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(teachernameTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(manJrb)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(1)
							.addComponent(famleJrb)))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addComponent(titleTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(ageTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addComponent(usernameTxt, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(17))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		
		teacherTable = new JTable();
		teacherTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				teacherTableMousePressed(e);
			}
		});
		teacherTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u6027\u522B", "\u804C\u79F0\u8BC4\u5B9A", "\u804C\u9F84", "\u7528\u6237\u540D", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teacherTable);
		getContentPane().setLayout(groupLayout);

		fillTeacherTable(new Teacher());
	}
	
	

	private void updateTeacherAct(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的教师信息！");
			return;
		}
		String teacherName = this.teachernameTxt.getText();
		if ("教师".equals(MainFrame.userType.getUsertypeName())) {
			if (!teacherName.equals(MainFrame.user.getUsername())) {
				JOptionPane.showMessageDialog(this, "不能修改他人信息！");
				return;
			}
		}
		if (StringUtil.isEmpty(teacherName)) {
			JOptionPane.showMessageDialog(this, "教师姓名不能为空！");
			return;
		}
		String sex = "";
		if (manJrb.isSelected()) {
			sex = "男";
		}else if (famleJrb.isSelected()) {
			sex = "女";
		}
		String title = this.titleTxt.getText();
		String age = this.ageTxt.getText();
		if (StringUtil.isEmpty(title)) {
			JOptionPane.showMessageDialog(this, "教师职称不能为空！");
			return;
		}
		if (StringUtil.isEmpty(age)) {
			JOptionPane.showMessageDialog(this, "教师年龄不能为空！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			Teacher teacher = new Teacher(Integer.parseInt(id), teacherName, sex, title, Integer.parseInt(age));
			int updateNum = teacherDao.update(con, teacher);
			if (updateNum == 1) {
				JOptionPane.showMessageDialog(this, "修改成功！");
				fillTeacherTable(new Teacher());
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

	private void deleteTeacheAct(ActionEvent e) {
		String id = idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要删除的记录！");
			return;
		}
		String teacherName = this.teachernameTxt.getText();
		if ("教师".equals(MainFrame.userType.getUsertypeName())) {
			if (!teacherName.equals(MainFrame.user.getUsername())) {
				JOptionPane.showMessageDialog(this, "不能删除他人信息！");
				return;
			}
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int deleteNum = teacherDao.delete(con, id);
			if (deleteNum == 1) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				fillTeacherTable(new Teacher());
				resetValueAct(e);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "删除失败！");
				return;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	//表格点击事件处理
	private void teacherTableMousePressed(MouseEvent e) {
		int row = this.teacherTable.getSelectedRow();
		this.idTxt.setText((String) teacherTable.getValueAt(row, 0));
		this.teachernameTxt.setText((String) teacherTable.getValueAt(row, 1));
		String sex = (String) teacherTable.getValueAt(row, 2);
		if ("男".equals(sex)) {
			this.manJrb.setSelected(true);
		}else if ("女".equals(sex)) {
			this.famleJrb.setSelected(true);
		}
		this.titleTxt.setText((String) teacherTable.getValueAt(row, 3));
		this.ageTxt.setText((String) teacherTable.getValueAt(row, 4));
		this.usernameTxt.setText((String) teacherTable.getValueAt(row, 5));
		this.passwordTxt.setText((String) teacherTable.getValueAt(row, 6));
	}

	//查询
	private void searchTeacherNameAct(ActionEvent e) {
		String teacherName = this.s_teachernameTxt.getText();
		Teacher teacher = new Teacher(teacherName);
		fillTeacherTable(teacher);		
	}

	//初始化表格
	private void fillTeacherTable(Teacher teacher) {
		DefaultTableModel dtm = (DefaultTableModel)teacherTable.getModel();
		dtm.setRowCount(0);  // 设置成0行
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet  rs = teacherDao.list(con, teacher);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("teacherName"));
				v.add(rs.getString("sex"));
				v.add(rs.getString("title"));
				v.add(rs.getString("age"));
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
	
	//重置
	private void resetValueAct(ActionEvent e) {
		this.idTxt.setText("");
		this.teachernameTxt.setText("");
		this.manJrb.setSelected(true);
		this.titleTxt.setText("");
		this.ageTxt.setText("");
		this.usernameTxt.setText("");
		this.passwordTxt.setText("");
		
	}
}
