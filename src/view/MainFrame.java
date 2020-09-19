package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.UserType;
import model.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static UserType userType;
	private JDesktopPane table = null;
	public static User user;
	
	private JMenuItem addStudentFrmItem;
	private JMenuItem manageStudentFrmItem;
	private JMenuItem addStudentClassFrmItem;
	private JMenuItem manageStudentClassFrmItem;
	private JMenuItem addTeacherFrmItem;
	private JMenuItem manageTeacherFrmItem;
	private JMenuItem addCourseFrmItem;
	private JMenuItem manageCourseFrmItem;
	private JMenuItem manageSelectedCourseFrmItem;
	private JMenuItem addScoreFrmItem;
	
	private JMenu manageStudentMenu;
	private JMenu manageStudentclassMenu;
	private JMenu manageTeacherMenu;
	private JMenu manageCourseMenu;
	private JMenu manageScoreMenu;
	private JMenu manageSelectedCourseMenu;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
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
	public MainFrame(UserType userType, User user) {
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		this.userType = userType;
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1550, 730);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mnNewMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPasswordFrm editPasswordFrm = new EditPasswordFrm();
				editPasswordFrm.setVisible(true);
				table.add(editPasswordFrm);
			}
		});
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "是否确定退出？");
				if(result == 0) {
					dispose();
				}
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u9000\u51FA.png")));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		manageStudentMenu = new JMenu("\u5B66\u751F\u7BA1\u7406");
		manageStudentMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		manageStudentMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageStudentMenu);
		
		addStudentFrmItem = new JMenuItem("\u6DFB\u52A0\u5B66\u751F");
		addStudentFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddstudentFrm addstudentFrm = new AddstudentFrm();
				addstudentFrm.setVisible(true);
				table.add(addstudentFrm);
			}
		});
		addStudentFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		addStudentFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageStudentMenu.add(addStudentFrmItem);
		
		manageStudentFrmItem = new JMenuItem("\u5B66\u751F\u5217\u8868");
		manageStudentFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentFrm manageStudentFrm = new ManageStudentFrm();
				manageStudentFrm.setVisible(true);
				table.add(manageStudentFrm);
			}
		});
		manageStudentFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		manageStudentFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageStudentMenu.add(manageStudentFrmItem);
		
		manageStudentclassMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		manageStudentclassMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		manageStudentclassMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageStudentclassMenu);
		
		addStudentClassFrmItem = new JMenuItem("\u6DFB\u52A0\u73ED\u7EA7");
		addStudentClassFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentclassFrm addStudentclassFrm = new AddStudentclassFrm();
				addStudentclassFrm.setVisible(true);
				table.add(addStudentclassFrm);
			}
		});
		addStudentClassFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		addStudentClassFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageStudentclassMenu.add(addStudentClassFrmItem);
		
		manageStudentClassFrmItem = new JMenuItem("\u73ED\u7EA7\u7BA1\u7406");
		manageStudentClassFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudentclassFrm manageStudentclassFrm = new ManageStudentclassFrm();
				manageStudentclassFrm.setVisible(true);
				table.add(manageStudentclassFrm);
			}
		});
		manageStudentClassFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		manageStudentClassFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageStudentclassMenu.add(manageStudentClassFrmItem);
		
		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u8001\u5E08.png")));
		manageTeacherMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageTeacherMenu);
		
		addTeacherFrmItem = new JMenuItem("\u6DFB\u52A0\u6559\u5E08");
		addTeacherFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrm addTeacherFrm = new AddTeacherFrm();
				addTeacherFrm.setVisible(true);
				table.add(addTeacherFrm);
			}
		});
		addTeacherFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		addTeacherFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageTeacherMenu.add(addTeacherFrmItem);
		
		manageTeacherFrmItem = new JMenuItem("\u6559\u5E08\u5217\u8868");
		manageTeacherFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageTeacherFrm manageTeacherFrm = new ManageTeacherFrm();
				manageTeacherFrm.setVisible(true);
				table.add(manageTeacherFrm);
			}
		});
		manageTeacherFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		manageTeacherFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageTeacherMenu.add(manageTeacherFrmItem);
		
		manageCourseMenu = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		manageCourseMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u8BFE\u7A0B.png")));
		manageCourseMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageCourseMenu);
		
		addCourseFrmItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourseFrm addCourseFrm = new AddCourseFrm();
				addCourseFrm.setVisible(true);
				table.add(addCourseFrm);
			}
		});
		addCourseFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		addCourseFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageCourseMenu.add(addCourseFrmItem);
		
		manageCourseFrmItem = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		manageCourseFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageCourseFrm manageCourseFrm = new ManageCourseFrm();
				manageCourseFrm.setVisible(true);
				table.add(manageCourseFrm);
			}
		});
		manageCourseFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		manageCourseFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageCourseMenu.add(manageCourseFrmItem);
		
		manageSelectedCourseMenu = new JMenu("\u9009\u8BFE\u7BA1\u7406");
		manageSelectedCourseMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u9009\u62E9.png")));
		manageSelectedCourseMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageSelectedCourseMenu);
		
		manageSelectedCourseFrmItem = new JMenuItem("\u9009\u8BFE\u7BA1\u7406");
		manageSelectedCourseFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSelectedCourseFrm manageSelectedCourseFrm = new ManageSelectedCourseFrm();
				manageSelectedCourseFrm.setVisible(true);
				table.add(manageSelectedCourseFrm);
			}
		});
		manageSelectedCourseFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u9009\u62E9.png")));
		manageSelectedCourseFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageSelectedCourseMenu.add(manageSelectedCourseFrmItem);
		
		manageScoreMenu = new JMenu("\u6210\u7EE9\u7BA1\u7406");
		manageScoreMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6210\u7EE9.png")));
		manageScoreMenu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(manageScoreMenu);
		
		addScoreFrmItem = new JMenuItem("\u5F55\u5165\u6210\u7EE9");
		addScoreFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScoreFrm addScoreFrm = new AddScoreFrm();
				addScoreFrm.setVisible(true);
				table.add(addScoreFrm);
			}
		});
		addScoreFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		addScoreFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageScoreMenu.add(addScoreFrmItem);
		
		JMenuItem ManageScoreFrmItem = new JMenuItem("\u6210\u7EE9\u7BA1\u7406");
		ManageScoreFrmItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageScoreFrm manageScoreFrm = new ManageScoreFrm();
				manageScoreFrm.setVisible(true);
				table.add(manageScoreFrm);
			}
		});
		ManageScoreFrmItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6210\u7EE9.png")));
		ManageScoreFrmItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageScoreMenu.add(ManageScoreFrmItem);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u6210\u7EE9\u7EDF\u8BA1");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatsScoreFrm scoreFrm = new StatsScoreFrm();
				scoreFrm.setVisible(true);
				table.add(scoreFrm);
			}
		});
		mntmNewMenuItem_12.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7EDF\u8BA1.png")));
		mntmNewMenuItem_12.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		manageScoreMenu.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_7 = new JMenu("\u5E2E\u52A9");
		mnNewMenu_7.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5E2E\u52A9.png")));
		mnNewMenu_7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mnNewMenu_7.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 1526, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 750, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setAuthority();
	}

	private void setAuthority() {
		if ("学生".equals(userType.getUsertypeName())) {
			this.addStudentFrmItem.setEnabled(false);
			this.manageTeacherMenu.setEnabled(false);
			this.manageCourseMenu.setEnabled(false);
			this.manageStudentclassMenu.setEnabled(false);
			this.addScoreFrmItem.setEnabled(false);
		}
		if ("教师".equals(userType.getUsertypeName())) {
			this.addTeacherFrmItem.setEnabled(false);
		}
	}

}
