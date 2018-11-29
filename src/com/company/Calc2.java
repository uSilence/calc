package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * @author highsad
 */
public class Calc2 {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);

		layout.setAutoCreateContainerGaps(true);
		layout.setAutoCreateGaps(true);

		//添加组件
		JTextField textField = new JTextField("0");
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setEditable(false);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		//JTextArea textArea = new JTextArea();
		//textArea.setFont(new Font("宋体", Font.PLAIN, 20));
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
		JButton button17 = new JButton("0");
		JButton button18 = new JButton(".");
		JButton button19 = new JButton("=");
		JButton button20 = new JButton("+");

		//第1列:各组件上下排列
		GroupLayout.ParallelGroup hParallelGroup1 = layout.createParallelGroup().
				addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第2列
		GroupLayout.ParallelGroup hParallelGroup2 = layout.createParallelGroup().
				addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button10, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button18, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第3列
		GroupLayout.ParallelGroup hParallelGroup3 = layout.createParallelGroup().
				addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button7, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button11, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button19, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//第4列
		GroupLayout.ParallelGroup hParallelGroup4 = layout.createParallelGroup().
				addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button8, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button12, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button20, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		//水平串行：以上各列左右布局
		GroupLayout.SequentialGroup hSequentialGroup = layout.createSequentialGroup().
				addGroup(hParallelGroup1).addGroup(hParallelGroup2).addGroup(hParallelGroup3).addGroup(hParallelGroup4);
		//各组件上下排列
		GroupLayout.ParallelGroup hParallelGroup = layout.createParallelGroup().
				addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE).addGroup(hSequentialGroup);
		//指定布局的水平坐标
		layout.setHorizontalGroup(hParallelGroup);

		//第1行：各组件左右排列
		GroupLayout.ParallelGroup vParallelGroup1 = layout.createParallelGroup().
				addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup2 = layout.createParallelGroup().
				addComponent(button5, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button6, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button7, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button8, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup3 = layout.createParallelGroup().
				addComponent(button9, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button10, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button11, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button12, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup4 = layout.createParallelGroup().
				addComponent(button13, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button14, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button15, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button16, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		GroupLayout.ParallelGroup vParallelGroup5 = layout.createParallelGroup().
				addComponent(button17, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button18, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button19, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(button20, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);

		GroupLayout.SequentialGroup vSequentialGroup = layout.createSequentialGroup().
				addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addGroup(vParallelGroup1).addGroup(vParallelGroup2).addGroup(vParallelGroup3).addGroup(vParallelGroup4).addGroup(vParallelGroup5);
		layout.setVerticalGroup(vSequentialGroup);

		frame.setContentPane(panel);
		frame.setSize(400, 400);
		frame.setLocation(300, 300);
		frame.setVisible(true);
	}
}
