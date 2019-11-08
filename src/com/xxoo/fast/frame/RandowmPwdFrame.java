package com.xxoo.fast.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.xxoo.fast.Tools;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RandowmPwdFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pwdLengthField;
	private JTextField textField_1;
	private JTextField resultTextField;
	
	private JCheckBox lowerCheckBox;
	private JCheckBox upcaseCheckBox;
	private JCheckBox numberCheckBox;
	private JCheckBox symbolCheckBox;
	
	static RandowmPwdFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RandowmPwdFrame();
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
	public RandowmPwdFrame() {
		setTitle("\u968F\u673A\u5BC6\u7801\u751F\u6210\u5668");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\huangzhong\\Downloads\\70d5639b5f29744464df35aafc3c1fb4.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 343);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u6240\u6709\u5B57\u7B26");
		label.setFont(new Font("宋体", Font.BOLD, 12));
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801\u957F\u5EA6");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("\u751F\u6210\u7ED3\u679C");
		lblNewLabel_1.setIcon(new ImageIcon(RandowmPwdFrame.class.getResource("/conf/return.ico")));
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 12));
		
		lowerCheckBox = new JCheckBox("a-z");
		lowerCheckBox.setSelected(true);
		
		upcaseCheckBox = new JCheckBox("A-Z");
		upcaseCheckBox.setSelected(true);
		
		numberCheckBox = new JCheckBox("0-9");
		numberCheckBox.setSelected(true);
		
		symbolCheckBox = new JCheckBox("!@#$%");
		
		pwdLengthField = new JTextField();
		pwdLengthField.setText("6");
		pwdLengthField.setColumns(10);
		pwdLengthField.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("SimSun", Font.PLAIN, 12));
		textField_1.setForeground(new Color(0, 0, 0));
		textField_1.setEditable(false);
		textField_1.setEnabled(false);
		textField_1.setText("\u4F4D");
		textField_1.setColumns(3);
		textField_1.setBorder(null);
		
		resultTextField = new JTextField();
		resultTextField.setColumns(50);
		resultTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
		JButton button = new JButton("\u751F\u6210\u5BC6\u7801");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] pwdChar = validCheckBoxSelectState();
				if(pwdChar.length==0) {
					JOptionPane.showInternalMessageDialog(contentPane, "请至少选择1种复杂模式", "生成密码失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				String length = pwdLengthField.getText();
				if(StringUtils.isEmpty(length)){
					JOptionPane.showInternalMessageDialog(contentPane, "请输入密码长度","生成密码失败",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(!NumberUtils.isNumber(length)) {
					JOptionPane.showInternalMessageDialog(contentPane, "密码长度非数字","生成密码失败",JOptionPane.ERROR_MESSAGE);
					return;
				}
				String password = RandomStringUtils.random(Integer.parseInt(length),pwdChar);
				resultTextField.setText(password);
			}
		});
//		button.setBackground(Color.BLUE);
		button.setContentAreaFilled(false);
//		button.setBorderPainted(false);
		button.setBackground(new Color(0, 255, 255));
		button.setOpaque(true);
//		button.setBorderPainted(false);
//		button.setBorder(BorderFactory.createLoweredBevelBorder());
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		JButton button_1 = new JButton("返回",new ImageIcon(RandowmPwdFrame.class.getResource("/conf/return.ico")));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
				new Tools().main(null);
			}
		});
		button_1.setEnabled(false);
		button_1.setVerticalAlignment(SwingConstants.TOP);
		button_1.setHorizontalTextPosition(SwingConstants.CENTER);
		button_1.setVerticalTextPosition(SwingConstants.CENTER);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(129, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(18)
									.addComponent(pwdLengthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(18)
									.addComponent(lowerCheckBox)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(upcaseCheckBox)))
							.addGap(12)
							.addComponent(numberCheckBox)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(symbolCheckBox))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addComponent(resultTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(127))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(549, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(button_1)
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(lowerCheckBox)
						.addComponent(upcaseCheckBox)
						.addComponent(numberCheckBox)
						.addComponent(symbolCheckBox))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(pwdLengthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(resultTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(button)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//单元个内容居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
	}
	
	public char[] validCheckBoxSelectState() {
		boolean lowerState  = lowerCheckBox.isSelected();
		boolean upcaseState = upcaseCheckBox.isSelected();
		boolean numberState = numberCheckBox.isSelected();
		boolean symbolState = symbolCheckBox.isSelected();
		
		char[] pwdChar = {};
		char[] lowerChar = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] upcaseChar = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char[] numberChar = {'0','1','2','3','4','5','6','7','8','9'};
		char[] symbolChar = {'!','@','#','$','%'};
		
//		if(!lowerState&&!upcaseState&&!numberState&&!SymbolState) {
//			JOptionPane.showInternalMessageDialog(contentPane, "请至少选择复杂模式", "生成密码失败", JOptionPane.ERROR_MESSAGE);
//		}
		
		if(lowerState) {
			pwdChar = ArrayUtils.addAll(pwdChar, lowerChar);
		}
		if(upcaseState) {
			pwdChar = ArrayUtils.addAll(pwdChar, upcaseChar);
		}
		if(numberState) {
			pwdChar = ArrayUtils.addAll(pwdChar, numberChar);
		}
		if(symbolState) {
			pwdChar = ArrayUtils.addAll(pwdChar, symbolChar);
		}
		return pwdChar;
	}

	public void showRandomPwdFrame() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
					RandowmPwdFrame frame = new RandowmPwdFrame();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
	
	public void close() {
		if(contentPane != null && contentPane.isShowing()) {
			frame.dispose();
		}
	}
}
