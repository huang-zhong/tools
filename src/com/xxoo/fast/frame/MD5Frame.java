package com.xxoo.fast.frame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Encoder;

public class MD5Frame extends JFrame {
	Logger log = Logger.getLogger("MD5Frame"); 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private GroupLayout groupLayout;

	/**
	 * Create the frame.
	 */
	public MD5Frame() {
		log.setLevel(Level.INFO);
		getContentPane().setEnabled(false);
		setTitle("MD5\u52A0\u5BC6");
		setBounds(100, 100, 599, 413);
		
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		table.setBorder(null);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
				{"\u5B57\u7B26\u4E32", null},
				{"16\u4F4D", null},
				{"32\u4F4D", null},
				{"64\u4F4D", null},
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
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.getColumnModel().getColumn(0).setMaxWidth(100);
		
		final JTextArea textArea = new JTextArea();
		textArea.setToolTipText("\u8BF7\u8F93\u5165\u8981\u52A0\u5BC6\u7684\u5B57\u7B26\u4E32");
		textArea.setRows(6);
		textArea.setColumns(80);
		textArea.setLineWrap(true);//设置自动换行
		
		JButton btnMd = new JButton("MD5\u52A0\u5BC6");
		btnMd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				log.info("开始进行MD5加密：");
				String sourceStr = textArea.getText();
				if(StringUtils.isEmpty(sourceStr)) {
					JOptionPane.showInternalMessageDialog(getContentPane(), "请输入要加密的字符串","MD5加密失败",JOptionPane.ERROR_MESSAGE);
				}
				table.setValueAt(sourceStr, 1, 1);//填充“字符串”对应的值
				
				try {
					String md5_16Str = MD5_16bit(sourceStr);
					log.info("16位小写=>"+md5_16Str);
					table.setValueAt(md5_16Str, 2, 1);//填充“32位小写”对应的值
					
					String md5_32Str = MD532Upcase(sourceStr);
					log.info("32位小写=>"+md5_32Str);
					table.setValueAt(md5_32Str, 3, 1);//填充“32位小写”对应的值
					
					String md5_64Str = MD5_64bit(sourceStr);
					log.info("64位大写=>"+md5_64Str);
					table.setValueAt(md5_64Str, 4, 1);//填充“64位大写”对应的值
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u52A0\u5BC6\u7684\u5B57\u7B26\u4E32\uFF1A");
		
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(235)
					.addComponent(btnMd)
					.addContainerGap(273, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 502, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(405, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 454, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
					.addComponent(btnMd)
					.addGap(26)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55))
		);
		
		getContentPane().setLayout(groupLayout);

	}

	public void showMD5Frame() {
		MD5Frame frame = new MD5Frame();
		frame.setVisible(true);
	}
	
	public String encryptMD5(String sourceStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messageDigest = null;
		messageDigest = messageDigest.getInstance("MD5");
		messageDigest.reset();
		messageDigest.update(sourceStr.getBytes("UTF-8"));
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5Buffer = new StringBuffer();
		
		 for (int i = 0; i < byteArray.length; i++) {
	            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
	            	md5Buffer.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
	            else
	            	md5Buffer.append(Integer.toHexString(0xFF & byteArray[i]));
	        }
		 return md5Buffer.toString();
	}
	
	public String MD532Lower(String sourceStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String md5Str = encryptMD5(sourceStr);
		if(md5Str == null) {
			return "";
		}
		return md5Str.toLowerCase();
	}
	
	public String MD532Upcase(String sourceStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String md5Str = encryptMD5(sourceStr);
		if(md5Str == null) {
			return "";
		}
		return md5Str.toUpperCase();
	}
	
	public final String MD5_64bit(String readyEncryptStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		BASE64Encoder base64Encoder = new BASE64Encoder();
		return base64Encoder.encode(md.digest(readyEncryptStr.getBytes("UTF-8")));
	}
	
	
	public final String MD5_16bit(String readyEncryptStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(readyEncryptStr != null){
			return MD532Upcase(readyEncryptStr).substring(8, 24);
		}else{
			return "";
		}
	}
}
