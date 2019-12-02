package com.xxoo.fast;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.xxoo.fast.jPanel.IPJPanel;
import com.xxoo.fast.jPanel.MD5JPanel;
import com.xxoo.fast.jPanel.RandomPwdJPanel;

public class Tools extends JFrame{

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	//定义组件	
	JTabbedPane jtbp; //定义选项卡
	JPanel MD5jp = null,jp2 = null,jp3 = null;	//定义面板


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tools window = new Tools();
					window.jtbp.setVisible(true);
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tools() {
		//创建组件
		jtbp = new JTabbedPane();
		jtbp.add("MD5加密",new MD5JPanel());//创建三个面板
		jtbp.add("随机密码",new RandomPwdJPanel());
		IPJPanel panel = new IPJPanel();
		jtbp.add("IP查询",panel);
		//设置布局管理器
		//添加组件
		getContentPane().add(jtbp);
		//设置界面属性
		//设置窗体实行
		this.setTitle("自定义小工具");	//设置界面标题
		this.setSize(650, 400);		//设置界面像素
		this.setLocation(300, 200);	//设置界面初始位置
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//设置虚拟机和界面一同关闭
		this.setVisible(true);	
	}
}
