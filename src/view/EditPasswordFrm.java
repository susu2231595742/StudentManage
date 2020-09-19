package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.UserDao;
import model.User;
import model.UserType;
import util.DbUtil;
import util.StringUtil;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class EditPasswordFrm extends JInternalFrame {
	private JPasswordField oldPasswordTxt;
	private JPasswordField newPasswordTxt;
	private JPasswordField confirmPasswordTxt;
	private JLabel currentUserLabel;
	
	private UserDao userDao = new UserDao();
	private DbUtil dbUtil = new DbUtil();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrm frame = new EditPasswordFrm();
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
	public EditPasswordFrm() {
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 592, 417);
		
		JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u7528\u6237\u540D.png")));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		currentUserLabel = new JLabel("New label");
		currentUserLabel.setFont(new Font("宋体", Font.BOLD, 16));
		currentUserLabel.setEnabled(false);
		
		JLabel lblNewLabel_2 = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		oldPasswordTxt = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_4.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		newPasswordTxt = new JPasswordField();
		
		confirmPasswordTxt = new JPasswordField();
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton.setFont(new Font("宋体", Font.BOLD, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(EditPasswordFrm.class.getResource("/images/\u91CD\u7F6E.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(confirmPasswordTxt)
						.addComponent(newPasswordTxt)
						.addComponent(oldPasswordTxt)
						.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
					.addGap(128))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
					.addGap(113)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(143))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(currentUserLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(oldPasswordTxt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(newPasswordTxt, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPasswordTxt, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		getContentPane().setLayout(groupLayout);
		
		//显示当前用户
		currentUserLabel.setText("【"+MainFrame.userType.getUsertypeName()+"】:"+ MainFrame.user.getUsername());
	}


	
	private void submitEdit(ActionEvent e) {
		String oldPassword = new String(oldPasswordTxt.getPassword());
		String newPassword = new String(newPasswordTxt.getPassword());
		String confirmPassword = new String(confirmPasswordTxt.getPassword());
		if (StringUtil.isEmpty(oldPassword)) {
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if (StringUtil.isEmpty(newPassword)) {
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if (StringUtil.isEmpty(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if (!newPassword.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}else {
			String username = MainFrame.user.getUsername();
			int usertypeId = MainFrame.user.getUsertypeId();
			Connection con = null;
			try {
				con = dbUtil.getConnection();
				User user = new User(username,oldPassword,usertypeId);
				User currentUser = userDao.login(con, user);
				if (currentUser == null) {
					JOptionPane.showMessageDialog(this, "旧密码输入错误！");
					return;
				}else {
					User user2 = new User(username,newPassword,usertypeId);
					int ediUser = userDao.editPassword(con, user2);
					if (ediUser > 0) {
						JOptionPane.showMessageDialog(this, "密码修改成功！");
						resetValue(e);
					}
				}
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}finally {
				dbUtil.closeCon(con);
			}
		}
	}



	//重置事件处理
	private void resetValue(ActionEvent e) {
		this.oldPasswordTxt.setText("");
		this.newPasswordTxt.setText("");
		this.confirmPasswordTxt.setText("");	
	}
	
}
