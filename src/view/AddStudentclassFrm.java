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

import dao.StudentClassDao;
import model.StudentClass;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class AddStudentclassFrm extends JInternalFrame {
	private JTextField stuclassNameTxt;
	private JTextArea stuclassInfoTxt ;
	private DbUtil dbUtil = new DbUtil();
	private StudentClassDao studentClassDao = new StudentClassDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentclassFrm frame = new AddStudentclassFrm();
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
	public AddStudentclassFrm() {
		setTitle("\u8BFE\u7A0B\u6DFB\u52A0\u5217\u8868");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 664, 450);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddStudentclassFrm.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuclassNameTxt = new JTextField();
		stuclassNameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u63CF\u8FF0\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentclassFrm.class.getResource("/images/\u4ECB\u7ECD.png")));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		stuclassInfoTxt = new JTextArea();
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentclassAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStudentclassFrm.class.getResource("/images/\u6DFB\u52A0.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueAction(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddStudentclassFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(142)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stuclassNameTxt, 227, 227, 227))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(stuclassInfoTxt, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(74)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(165, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(stuclassNameTxt, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(stuclassInfoTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
		);
		getContentPane().setLayout(groupLayout);

	}

	private void AddStudentclassAction(ActionEvent e) {
		String stuclassName = this.stuclassNameTxt.getText();
		String stuclassInfo = this.stuclassInfoTxt.getText();
		
		if (StringUtil.isEmpty(stuclassName)) {
			JOptionPane.showMessageDialog(this, "班级名称不能为空");
			return;
		}
		
		Connection con = null;
		try {
			con = dbUtil.getConnection();
			StudentClass studentClass = new StudentClass(stuclassName, stuclassInfo);
			int addNum = studentClassDao.addStuclass(con, studentClass);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(this, "添加成功！");
				resetValueAction(e);
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
	private void resetValueAction(ActionEvent e) {
		this.stuclassNameTxt.setText("");
		this.stuclassInfoTxt.setText("");
	}
}
