package com.xxoo.fast.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

public class MD5Frame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTable table;
	private JButton btnNewButton;
	private GroupLayout groupLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
					MD5Frame frame = new MD5Frame();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public MD5Frame() {
		getContentPane().setEnabled(false);
		setTitle("MD5\u52A0\u5BC6");
		setBounds(100, 100, 553, 388);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBorder(new EmptyBorder(0, 0, 0, 0));
		textField.setText("\u8981\u52A0\u5BC6\u7684\u5B57\u7B26\u4E32\uFF1A");
		textField.setColumns(15);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("宋体", Font.BOLD, 14));
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
				{"\u5B57\u7B26\u4E32", null},
				{"16\u4F4D \u5C0F\u5199", null},
				{"16\u4F4D \u5927\u5199", null},
				{"32\u4F4D \u5C0F\u5199", null},
				{"32\u4F4D \u5927\u5199", null},
			},
			new String[] {
				"", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		
		btnNewButton = new JButton("\u52A0\u5BC6");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sourceStr = textField.getText();
				if(StringUtils.isEmpty(sourceStr)) {
					JOptionPane.showInternalMessageDialog(getContentPane(), "请至少选择1种复杂模式", "生成密码失败", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JTextArea textArea = new JTextArea();
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(260, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(220))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(37)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
					.addGap(89))
		);
		
		getContentPane().setLayout(groupLayout);

	}

	public void showMD5Frame() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
					MD5Frame frame = new MD5Frame();
					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}
}
