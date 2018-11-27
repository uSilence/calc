package com.company;

import javax.swing.*;

/**
 * @author highsad
 */
public class Grouplayout {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("测试grouplayout");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//创建内容面板容器
		JPanel panel = new JPanel();
		//创建分组布局，并关联容器
		GroupLayout layout = new GroupLayout(panel);
		//设置容器的布局
		panel.setLayout(layout);

		//添加组件
		JButton btn1 = new JButton("btn1");
		JButton btn2 = new JButton("btn2");
		JButton btn3 = new JButton("btn3");
		JButton btn4 = new JButton("btn4");
		JButton btn5 = new JButton("btn5");

		//自动创建组件之间的间隙
		//layout.setAutoCreateGaps(true);
		//自动创建容器与触碰到边框的组件之间的间隙
		//layout.setAutoCreateContainerGaps(true);

		// 水平并行（上下） btn01 和 btn02
		GroupLayout.ParallelGroup hParalGroup01 = layout.createParallelGroup()
				.addComponent(btn1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(btn2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		// 水平并行（上下）btn03 和 btn04
		GroupLayout.ParallelGroup hParalGroup02 = layout.createParallelGroup()
				.addComponent(btn3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(btn4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		// 水平串行（左右）hParalGroup01 和 hParalGroup02
		GroupLayout.SequentialGroup hSeqGroup = layout.createSequentialGroup().addGroup(hParalGroup01).addGroup(hParalGroup02);
		// 水平并行（上下）hSeqGroup 和 btn05
		GroupLayout.ParallelGroup hParalGroup = layout.createParallelGroup().addGroup(hSeqGroup).addComponent(btn5, GroupLayout.Alignment.CENTER);
		layout.setHorizontalGroup(hParalGroup);  // 指定布局的 水平组（水平坐标）

		// 垂直并行（左右）btn01 和 btn03
		GroupLayout.ParallelGroup vParalGroup01 = layout.createParallelGroup()
				.addComponent(btn1, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(btn3, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		// 垂直并行（左右）btn02 和 btn04
		GroupLayout.ParallelGroup vParalGroup02 = layout.createParallelGroup()
				.addComponent(btn2, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addComponent(btn4, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		// 垂直串行（上下）vParalGroup01, vParalGroup02 和 btn05
		GroupLayout.SequentialGroup vSeqGroup = layout.createSequentialGroup().addGroup(vParalGroup01).addGroup(vParalGroup02).addComponent(btn5);
		layout.setVerticalGroup(vSeqGroup);    // 指定布局的 垂直组（垂直坐标）

		frame.setContentPane(panel);
		frame.setLocationRelativeTo(null);
		frame.setSize(400, 200);
		frame.setVisible(true);
	}
}
