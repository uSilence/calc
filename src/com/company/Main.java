package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

	// 定义Button样式
/*	private static JButton setButton(String name){
		JButton button = new JButton();
		button.setText(name);
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		return button;
	}*/


	public static void main(String[] args) {

		final JFrame frame = new JFrame("这是一个计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(panel);

		// 设置布局方式
		GridBagLayout gridBagLayout = new GridBagLayout();
		//frame.setLayout(gridBagLayout); // 方式一：GridBagLayout
		panel.setLayout(groupLayout); // 方式二：GroupLayout
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);

		JTextArea textArea = new JTextArea();
		//textArea.setLineWrap(true); // 自动换行
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton button1 = new JButton("7");
		JButton button2 = new JButton("8");
		JButton button3 = new JButton("9");
		JButton button4 = new JButton("/");
		JButton button5 = new JButton("4");
		JButton button6 = new JButton("5");
		JButton button7 = new JButton("6");
		JButton button8 = new JButton("*");
		JButton button9 = new JButton("1");
		JButton button10 = new JButton("2");
		JButton button11 = new JButton("3");
		JButton button12 = new JButton("-");
		JButton button13 = new JButton("0");
		JButton button14 = new JButton(".");
		JButton button15 = new JButton("=");
		JButton button16 = new JButton("+");
		JButton button17 = new JButton("+");
		JButton button18 = new JButton("+");
		JButton button19 = new JButton("+");
		JButton button20 = new JButton("+");

		//第1列:各组件上下排列
		GroupLayout.ParallelGroup hParallelGroup1 = groupLayout.createParallelGroup()
				.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第2列
		GroupLayout.ParallelGroup hParallelGroup2 = groupLayout.createParallelGroup()
				.addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button10, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button18, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第3列
		GroupLayout.ParallelGroup hParallelGroup3 = groupLayout.createParallelGroup()
				.addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button7, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button11, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button19, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第4列
		GroupLayout.ParallelGroup hParallelGroup4 = groupLayout.createParallelGroup()
				.addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button8, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button12, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button20, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//水平串行：以上各列左右布局
		GroupLayout.SequentialGroup hSequentialGroup = groupLayout.createSequentialGroup()
				.addGroup(hParallelGroup1).addGroup(hParallelGroup2).addGroup(hParallelGroup3).addGroup(hParallelGroup4);
		//各组件上下排列
		GroupLayout.ParallelGroup hParallelGroup = groupLayout.createParallelGroup()
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE).addGroup(hSequentialGroup);
		//指定布局的水平坐标
		groupLayout.setHorizontalGroup(hParallelGroup);

		//第1行：各组件左右排列
		GroupLayout.ParallelGroup vParallelGroup1 = groupLayout.createParallelGroup()
				.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup2 = groupLayout.createParallelGroup()
				.addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button7, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button8, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup3 = groupLayout.createParallelGroup()
				.addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button10, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button11, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button12, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup4 = groupLayout.createParallelGroup()
				.addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup5 = groupLayout.createParallelGroup()
				.addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button18, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button19, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button20, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);

		GroupLayout.SequentialGroup vSequentialGroup = groupLayout.createSequentialGroup()
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addGroup(vParallelGroup1).addGroup(vParallelGroup2).addGroup(vParallelGroup3).addGroup(vParallelGroup4).addGroup(vParallelGroup5);
		groupLayout.setVerticalGroup(vSequentialGroup);

		frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}
