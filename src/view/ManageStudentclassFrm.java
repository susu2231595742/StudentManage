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
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.StudentClassDao;
import dao.StudentDao;
import model.Student;
import model.StudentClass;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageStudentclassFrm extends JInternalFrame {
	private JTextField s_stuclassNameTxt;
	private JTable studentClassTable;
	private JTextField idTxt;
	private JComboBox studentClassJcb;
	private JTextArea stuclassInfoTxt;
	
	private DbUtil dbUtil = new DbUtil();
	private StudentClassDao studentClassDao = new StudentClassDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentclassFrm frame = new ManageStudentclassFrm();
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
	public ManageStudentclassFrm() {
		setTitle("\u8BFE\u7A0B\u7BA1\u7406\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 714, 635);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(ManageStudentclassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		s_stuclassNameTxt = new JTextField();
		s_stuclassNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchStuClassAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ManageStudentclassFrm.class.getResource("/images/\u641C\u7D22.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u5904\u7406", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		studentClassTable = new JTable();
		studentClassTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				stuClassTableMousePressed(e);
			}
		});
		studentClassTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentClassTable);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(s_stuclassNameTxt, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addGap(110)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 501, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(130, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(s_stuclassNameTxt, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnNewButton)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(4))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		studentClassJcb = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("\u73ED\u7EA7\u63CF\u8FF0\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuclassInfoTxt = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateStuclassAction(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(ManageStudentclassFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudentClass(e);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(ManageStudentclassFrm.class.getResource("/images/\u5220\u9664.png")));
		btnNewButton_2.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_3 = new JButton("\u91CD\u7F6E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAction(e);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(ManageStudentclassFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_3.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentClassJcb, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(35)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(stuclassInfoTxt, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(studentClassJcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(stuclassInfoTxt, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		this.fillstuClassTable(new StudentClass());
		this.fillStudentClass();
	}
	
	//搜索操作
	private void searchStuClassAction(ActionEvent e) {
		String stuClassName = this.s_stuclassNameTxt.getText();
		StudentClass studentClass = new StudentClass(stuClassName);
		this.fillstuClassTable(studentClass);
	}

	//修改班级信息
	private void updateStuclassAction(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要修改的记录！");
			return;
		}
		String stuclassName = (String) this.studentClassJcb.getSelectedItem();
		if (StringUtil.isEmpty(stuclassName)){
			JOptionPane.showMessageDialog(this, "班级名称不能为空");
			return;
		}
		String stuclassInfo = this.stuclassInfoTxt.getText();
		
		StudentClass studentClass = new StudentClass(Integer.parseInt(id), stuclassName, stuclassInfo);
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int addNum = studentClassDao.addStuclass(con, studentClass);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(this, "修改成功！");
				fillstuClassTable(new StudentClass());
				resetValueAction(e);
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

	//删除操作
	private void deleteStudentClass(ActionEvent e) {
		String id = this.idTxt.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(this, "请选择要删除的记录！");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			int deleteNum = studentClassDao.deleteStuClass(con, id);
			if (deleteNum == 1) {
				JOptionPane.showMessageDialog(this, "删除成功！");
				resetValueAction(e);
				fillstuClassTable(new StudentClass());
			}else {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	//重置
	private void resetValueAction(ActionEvent e) {
		this.idTxt.setText("");
		this.studentClassJcb.setSelectedIndex(0);
		this.stuclassInfoTxt.setText("");
		
	}

	//表格点击事件处理
	private void stuClassTableMousePressed(MouseEvent e) {
		int row = this.studentClassTable.getSelectedRow();
		this.idTxt.setText((String) studentClassTable.getValueAt(row, 0));
		String stuclassName = (String) studentClassTable.getValueAt(row, 1);
		int n = this.studentClassJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			StudentClass item = (StudentClass) this.studentClassJcb.getItemAt(i);
			if (item.getClassName().equals(stuclassName)) {
				this.studentClassJcb.setSelectedIndex(i);
			}
		}
		this.stuclassInfoTxt.setText((String) studentClassTable.getValueAt(row, 2));
		
	}

	//初始化表格
	private void fillstuClassTable(StudentClass studentClass) {
		DefaultTableModel dtm = (DefaultTableModel)studentClassTable.getModel();
		dtm.setRowCount(0);  // 设置成0行
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			ResultSet  rs = studentClassDao.list(con, studentClass);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("className"));
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
				this.studentClassJcb.addItem(studentClass);
			while(rs.next()) {
				studentClass = new StudentClass();
				studentClass.setClassName(rs.getString("className"));
				studentClass.setId(rs.getInt("id"));
				this.studentClassJcb.addItem(studentClass);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
