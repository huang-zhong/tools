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
	//�������	
	JTabbedPane jtbp; //����ѡ�
	JPanel MD5jp = null,jp2 = null,jp3 = null;	//�������


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
		//�������
		jtbp = new JTabbedPane();
		jtbp.add("MD5����",new MD5JPanel());//�����������
		jtbp.add("�������",new RandomPwdJPanel());
		IPJPanel panel = new IPJPanel();
		jtbp.add("IP��ѯ",panel);
		//���ò��ֹ�����
		//������
		getContentPane().add(jtbp);
		//���ý�������
		//���ô���ʵ��
		this.setTitle("�Զ���С����");	//���ý������
		this.setSize(650, 400);		//���ý�������
		this.setLocation(300, 200);	//���ý����ʼλ��
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//����������ͽ���һͬ�ر�
		this.setVisible(true);	
	}
}
