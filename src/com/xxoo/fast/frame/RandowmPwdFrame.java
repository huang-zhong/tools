package com.xxoo.fast.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class RandowmPwdFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandowmPwdFrame frame = new RandowmPwdFrame();
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"\u6240\u6709\u5B57\u7B26", ""},
				{"\u5BC6\u7801\u957F\u5EA6", ""},
				{"\u751F\u6210\u7ED3\u679C", null},
			},
			new String[] {
				"", ""
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		table.setPreferredScrollableViewportSize(new Dimension(500, 300));
		table.setFillsViewportHeight(true);
		
		//单元个内容居中
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.setDefaultRenderer(Object.class, renderer);
		
		//定义复选框
		final JCheckBox box = new JCheckBox();
		/*getColumn()中数字填对应的第几行添加复选框*/
		table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer() {
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus,int row, int column) {
			/*设置当复选框被选中整行被渲染*/
			box.setSelected(isSelected);
			/*设置复选框在单元格中居中*/
			box.setHorizontalAlignment((int) 0.5f);
			return box;
		}
	});
		
		
		contentPane.add(table, BorderLayout.CENTER);
	}

	public void showRandomPwdFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandowmPwdFrame frame = new RandowmPwdFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
