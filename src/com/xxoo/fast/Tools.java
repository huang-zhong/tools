package com.xxoo.fast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.xxoo.fast.frame.RandowmPwdFrame;

public class Tools {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tools window = new Tools();
					window.frame.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.GREEN);
		frame.setTitle("\u4E2A\u4EBA\u5DE5\u5177\u6C47\u603B");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\huangzhong\\Downloads\\70d5639b5f29744464df35aafc3c1fb4.png"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel randomPwdPanel = new JPanel();
		frame.getContentPane().add(randomPwdPanel, BorderLayout.NORTH);
		
		JButton button = new JButton("\u968F\u673A\u5BC6\u7801\u751F\u6210\u5668");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				close();
				new RandowmPwdFrame().showRandomPwdFrame();
			}
		});
		randomPwdPanel.add(button);
		
		JButton btnNewButton = new JButton("New button");
		randomPwdPanel.add(btnNewButton);
	}

	
	public void close() {
		if(frame != null && frame.isShowing()) {
			frame.dispose();
		}
	}
}
