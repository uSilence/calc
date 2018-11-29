/*
package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.regex.Pattern;

*/
/**
 * @author LiYong
 *//*

public class CalcCode {
}

package com.company;

		import javax.swing.*;
		import java.awt.*;
		import java.awt.event.ActionEvent;
		import java.awt.event.ActionListener;
		import java.util.Stack;
		import java.util.regex.Pattern;

public class Calc extends JFrame {

/*
/指定组件与网格之间的距离
	private static Insets insets = new Insets(0, 0, 0, 0);

	//给出一个算术表达式（中缀表达式），得到计算结果
	private static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	//中缀表达式转成后缀表达式
	private static String infixToSuffix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		String suffix = "";
		int length = infix.length();
		for (int i = 0; i < length; i++) {
			Character temp;
			char c = infix.charAt(i);
			switch (c) {
				// 忽略空格
				case ' ':
					break;
				// 碰到'('，push到栈
				case '(':
					stack.push(c);
					break;
				// 碰到'+''-'，将栈中所有运算符弹出，送到输出队列中
				case '+':
				case '-':
					while (stack.size() != 0) {
						temp = stack.pop();
						if (temp == '(') {
							stack.push('(');
							break;
						}
						suffix += " " + temp;
					}
					stack.push(c);
					suffix += " ";
					break;
				// 碰到'*''/'，将栈中所有乘除运算符弹出，送到输出队列中
				case '*':
				case '/':
					while (stack.size() != 0) {
						temp = stack.pop();
						if (temp == '(' || temp == '+' || temp == '-') {
							stack.push(temp);
							break;
						} else {
							suffix += " " + temp;
						}
					}
					stack.push(c);
					suffix += " ";
					break;
				// 碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
				case ')':
					while (stack.size() != 0) {
						temp = stack.pop();
						if (temp == '(')
							break;
						else
							suffix += " " + temp;
					}
					break;
				//如果是数字，直接送至输出序列
				default:
					suffix += c;
			}
		}

		//如果栈不为空，把剩余的运算符依次弹出，送至输出序列。
		while (stack.size() != 0) {
			suffix += " " + stack.pop();
		}
		return suffix;
	}

	//通过后缀表达式求出算术结果
	private static double suffixToArithmetic(String postfix) {

		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); //使用正则表达式 匹配数字
		String strings[] = postfix.split(" ");  //将字符串转化为字符串数组
*//*
 */
/*		for (int i = 0; i < strings.length; i++) {
			strings[i].trim();  //去掉字符串首尾的空格
		}*//*
 */
/*
		Stack<Double> stack = new Stack<Double>();

		for (int i = 0; i < strings.length; i++) {

			if (strings[i].equals(""))
				continue;

			//如果是数字，则进栈
			if ((pattern.matcher(strings[i])).matches()) {

				stack.push(Double.parseDouble(strings[i]));
			} else {
				//如果是运算符，弹出运算数，计算结果。
				double y = stack.pop();
				double x = stack.pop();
				stack.push(caculate(x, y, strings[i])); //将运算结果重新压入栈。
			}
		}
		return stack.pop(); //弹出栈顶元素就是运算最终结果。

	}

	private static double caculate(double x, double y, String simble) {
		if (simble.trim().equals("+"))
			return x + y;
		if (simble.trim().equals("-"))
			return x - y;
		if (simble.trim().equals("*"))
			return x * y;
		if (simble.trim().equals("/"))
			return x / y;
		return 0;
	}

	//添加组件函数
	private static void addComponents(Container container, Component component, int gridx, int gridy, int gridwidth,
	                                  int gridheight, int anchor, int fill) {
		//组件布局方案(weightx、weighty为组件大小的增量值，为0时组件不随窗口变化而变化
		GridBagConstraints panel2 = new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0,
				anchor, fill, insets, 0, 0);
		//添加组件及其约束条件
		container.add(component, panel2);
	}

	private JTextArea textArea = new JTextArea();
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	private JButton button11;
	private JButton button12;
	private JButton button13;
	private JButton button14;
	private JButton button15;
	private JButton button16;
	private JButton button17;
	private JButton button18;
	private JButton button19;
	private JButton button20;

	private JFrame frame = new JFrame("这是一个计算器");
	private static JPanel panel = new JPanel();
	private static GroupLayout groupLayout = new GroupLayout(panel);
	private static GridBagLayout gridBagLayout = new GridBagLayout();

	// 设置Button样式
	private static JButton setButton(String name){
		JButton button = new JButton();
		button.setText(name);
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		return button;
	}

	// 初始化变量：初始化Button、textArea
	private void newButton(){
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		textArea.setLineWrap(true); // 自动换行
		textArea.setMinimumSize(new Dimension(20, 10)); // 设置最小窗口值，使其可以自由缩放

		button1 = Calc.setButton("7");
		button2 = Calc.setButton("8");
		button3 = Calc.setButton("9");
		button4 = Calc.setButton("/");
		button5 = Calc.setButton("4");
		button6 = Calc.setButton("5");
		button7 = Calc.setButton("6");
		button8 = Calc.setButton("*");
		button9 = Calc.setButton("1");
		button10 = Calc.setButton("2");
		button11 = Calc.setButton("3");
		button12 = Calc.setButton("-");
		button13 = Calc.setButton("0");
		button14 = Calc.setButton(".");
		button15 = Calc.setButton("=");
		button16 = Calc.setButton("+");
		button17 = Calc.setButton("←");
		button18 = Calc.setButton("(");
		button19 = Calc.setButton(")");
		button20 = Calc.setButton("C");
	}

	// 初始化变量状态：清空textArea
	private void eliminateTextArea(){
		textArea.setText("");
	}

	// 初始化布局
	private void choiceLayout(LayoutManager manager){
		//JFrame frame = new JFrame("这是计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//JPanel panel = new JPanel();

		//frame.setLayout(manager);
		panel.setLayout(manager);

		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);

		frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	// 按键响应
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String originWord = textArea.getText(); // 文本框中原本已经输入进去的内容
			String newWord = ((JButton) e.getSource()).getText(); // 点击按钮产生的新内容
			String input = originWord + newWord;
			textArea.setText(input);

			//特殊按钮
			//←键：删除键
			for (int i = 0; i < originWord.length(); i++) {
				if (newWord.equals("←")) { // 按下删除键时，文本内容减少最后一位
					textArea.setText(originWord.substring(0, originWord.length() - 1));
				}
			}
			// 为空时，不能再进行删除操作
			if (input.equals("←")) { // 为空时，点击←键时input内容即为←
				textArea.setText("null..can't delete...");
			}

			//C键：重置键
			if (newWord.equals("C")) {
				textArea.setText("");
			}

			try {
				if (newWord.equals("=")) { // 输入等号时开始计算
					textArea.setText(input + Calc.stringToArithmetic(originWord));
				}
			} catch (Exception e1) {
				textArea.setText("your input is illegal..."); // 非法输入提示信息
			}
		}
	}

	// 初始化事件：为每个button添加监听事件
	private void addListener(JButton button){
		ButtonListener bl = new ButtonListener();
		button.addActionListener(bl);
	}

	// 实现计算器界面
	private void drawCalc1(){
		//显示框
		addComponents(frame, textArea, 0, 0, 4, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第1行
		addComponents(frame, button1, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button2, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button3, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button4, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第2行
		addComponents(frame, button5, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button6, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button7, 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button8, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第3行
		addComponents(frame, button9, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button10, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button11, 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button12, 3, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第4行
		addComponents(frame, button13, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button14, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button15, 2, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button16, 3, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第5行
		addComponents(frame, button17, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button18, 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button19, 2, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button20, 3, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	}

	private void drawCalc2(){
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

*//*
 */
/*		frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 400);
		frame.setVisible(true);*//*
 */
/*
	}
*//*

	// 使用GridBagLayout布局实现计算器
	private void gridBagLayoutCalc(){
		JFrame frame = new JFrame("这是一个计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 关闭窗口时结束任务
		GridBagLayout gridBagLayout = new GridBagLayout();
		frame.setLayout(gridBagLayout);

		//final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true); // 自动换行
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton button1 = Calc.setButton("7");
		JButton button2 = Calc.setButton("8");
		JButton button3 = Calc.setButton("9");
		JButton button4 = Calc.setButton("/");
		JButton button5 = Calc.setButton("4");
		JButton button6 = Calc.setButton("5");
		JButton button7 = Calc.setButton("6");
		JButton button8 = Calc.setButton("*");
		JButton button9 = Calc.setButton("1");
		JButton button10 = Calc.setButton("2");
		JButton button11 = Calc.setButton("3");
		JButton button12 = Calc.setButton("-");
		JButton button13 = Calc.setButton("0");
		JButton button14 = Calc.setButton(".");
		JButton button15 = Calc.setButton("=");
		JButton button16 = Calc.setButton("+");
		JButton button17 = Calc.setButton("←");
		JButton button18 = Calc.setButton("(");
		JButton button19 = Calc.setButton(")");
		JButton button20 = Calc.setButton("C");

		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String originWord = textArea.getText(); // 文本框中原本已经输入进去的内容
				String newWord = ((JButton) e.getSource()).getText(); // 点击按钮产生的新内容
				String input = originWord + newWord;
				textArea.setText(input);

				//特殊按钮
				//←键：删除键
				for (int i = 0; i < originWord.length(); i++) {
					if (newWord.equals("←")) { // 按下删除键时，文本内容减少最后一位
						textArea.setText(originWord.substring(0, originWord.length() - 1));
					}
				}
				// 为空时，不能再进行删除操作
				if (input.equals("←")) { // 为空时，点击←键时input内容即为←
					textArea.setText("null..can't delete...");
				}

				//C键：重置键
				if (newWord.equals("C")) {
					textArea.setText("");
				}

				try {
					if (newWord.equals("=")) { // 输入等号时开始计算
						textArea.setText(input + Calc.stringToArithmetic(originWord));
					}
				} catch (Exception e1) {
					textArea.setText("your input is illegal..."); // 非法输入提示信息
				}


			}
		}

		ButtonListener bl = new ButtonListener();
		button1.addActionListener(bl);
		button2.addActionListener(bl);
		button3.addActionListener(bl);
		button4.addActionListener(bl);
		button5.addActionListener(bl);
		button6.addActionListener(bl);
		button7.addActionListener(bl);
		button8.addActionListener(bl);
		button9.addActionListener(bl);
		button10.addActionListener(bl);
		button11.addActionListener(bl);
		button12.addActionListener(bl);
		button13.addActionListener(bl);
		button14.addActionListener(bl);
		button15.addActionListener(bl);
		button16.addActionListener(bl);
		button17.addActionListener(bl);
		button18.addActionListener(bl);
		button19.addActionListener(bl);
		button20.addActionListener(bl);

		//显示框
		addComponents(frame, textArea, 0, 0, 4, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第1行
		addComponents(frame, button1, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button2, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button3, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button4, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第2行
		addComponents(frame, button5, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button6, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button7, 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button8, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第3行
		addComponents(frame, button9, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button10, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button11, 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button12, 3, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第4行
		addComponents(frame, button13, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button14, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button15, 2, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button16, 3, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		//第5行
		addComponents(frame, button17, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button18, 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button19, 2, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
		addComponents(frame, button20, 3, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 500);
		frame.setVisible(true);

	}

	// 使用GroupLayout布局实现计算器
	private void groupLayoutCalc() {
		JFrame frame = new JFrame("这是一个计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(panel);

		panel.setLayout(groupLayout);
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);

		final JTextArea textArea = new JTextArea();
		//textArea.setLineWrap(true); // 自动换行
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton button1 = Calc.setButton("7");
		JButton button2 = Calc.setButton("8");
		JButton button3 = Calc.setButton("9");
		JButton button4 = Calc.setButton("/");
		JButton button5 = Calc.setButton("4");
		JButton button6 = Calc.setButton("5");
		JButton button7 = Calc.setButton("6");
		JButton button8 = Calc.setButton("*");
		JButton button9 = Calc.setButton("1");
		JButton button10 = Calc.setButton("2");
		JButton button11 = Calc.setButton("3");
		JButton button12 = Calc.setButton("-");
		JButton button13 = Calc.setButton("0");
		JButton button14 = Calc.setButton(".");
		JButton button15 = Calc.setButton("=");
		JButton button16 = Calc.setButton("+");
		JButton button17 = Calc.setButton("←");
		JButton button18 = Calc.setButton("(");
		JButton button19 = Calc.setButton(")");
		JButton button20 = Calc.setButton("C");

		//按键响应方法
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String originWord = textArea.getText(); // 文本框中原本已经输入进去的内容
				String newWord = ((JButton) e.getSource()).getText(); // 点击按钮产生的新内容
				String input = originWord + newWord;
				textArea.setText(input);

				//特殊按钮
				//←键：删除键
				for (int i = 0; i < originWord.length(); i++) {
					if (newWord.equals("←")) { // 按下删除键时，文本内容减少最后一位
						textArea.setText(originWord.substring(0, originWord.length() - 1));
					}
				}
				// 为空时，不能再进行删除操作
				if (input.equals("←")) { // 为空时，点击←键时input内容即为←
					textArea.setText("null..can't delete...");
				}

				//C键：重置键
				if (newWord.equals("C")) {
					textArea.setText("");
				}

				try {
					if (newWord.equals("=")) { // 输入等号时开始计算
						textArea.setText(input + Calc.stringToArithmetic(originWord));
					}
				} catch (Exception e1) {
					textArea.setText("your input is illegal..."); // 非法输入提示信息
				}


			}
		}

		ButtonListener bl = new ButtonListener();
		button1.addActionListener(bl);
		button2.addActionListener(bl);
		button3.addActionListener(bl);
		button4.addActionListener(bl);
		button5.addActionListener(bl);
		button6.addActionListener(bl);
		button7.addActionListener(bl);
		button8.addActionListener(bl);
		button9.addActionListener(bl);
		button10.addActionListener(bl);
		button11.addActionListener(bl);
		button12.addActionListener(bl);
		button13.addActionListener(bl);
		button14.addActionListener(bl);
		button15.addActionListener(bl);
		button16.addActionListener(bl);
		button17.addActionListener(bl);
		button18.addActionListener(bl);
		button19.addActionListener(bl);
		button20.addActionListener(bl);

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

*/
/*		frame.setContentPane(panel);

		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 500);
		frame.setVisible(true);*//*

	}


	public static void main(String[] args) {

		Calc calc = new Calc();
		//calc.show();
		*/
/*calc.choiceLayout(groupLayout);

		calc.newButton();
		calc.addListener(calc.button1);
		calc.addListener(calc.button2);
		calc.addListener(calc.button3);
		calc.addListener(calc.button4);
		calc.addListener(calc.button5);
		calc.addListener(calc.button6);
		calc.addListener(calc.button7);
		calc.addListener(calc.button8);
		calc.addListener(calc.button9);
		calc.addListener(calc.button10);
		calc.addListener(calc.button11);
		calc.addListener(calc.button12);
		calc.addListener(calc.button13);
		calc.addListener(calc.button14);
		calc.addListener(calc.button15);
		calc.addListener(calc.button16);
		calc.addListener(calc.button17);
		calc.addListener(calc.button18);
		calc.addListener(calc.button19);
		calc.addListener(calc.button20);*//*


		//calc.gridBagLayoutCalc();
		//calc.groupLayoutCalc();

		*/
/*JFrame frame = new JFrame("这是一个计算器");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//GridBagLayout gridBagLayout = new GridBagLayout();

		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(panel);

		// 设置布局方式
		//frame.setLayout(gridBagLayout); // 方式一：GridBagLayout
		panel.setLayout(groupLayout); // 方式二：GroupLayout
		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);

		//创建内容面板容器
		//JPanel panel = new JPanel();
		//创建布局
		//GridBagLayout layout = new GridBagLayout();
		//GroupLayout layout = new GroupLayout(panel);
		//设置容器的布局
		//panel.setLayout(layout);

		final JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true); // 自动换行
		textArea.setFont(new Font("宋体", Font.PLAIN, 20));
		JButton button1 = Calc.setButton("7");
		JButton button2 = Calc.setButton("8");
		JButton button3 = Calc.setButton("9");
		JButton button4 = Calc.setButton("/");
		JButton button5 = Calc.setButton("4");
		JButton button6 = Calc.setButton("5");
		JButton button7 = Calc.setButton("6");
		JButton button8 = Calc.setButton("*");
		JButton button9 = Calc.setButton("1");
		JButton button10 = Calc.setButton("2");
		JButton button11 = Calc.setButton("3");
		JButton button12 = Calc.setButton("-");
		JButton button13 = Calc.setButton("0");
		JButton button14 = Calc.setButton(".");
		JButton button15 = Calc.setButton("=");
		JButton button16 = Calc.setButton("+");
		JButton button17 = Calc.setButton("←");
		JButton button18 = Calc.setButton("(");
		JButton button19 = Calc.setButton(")");
		JButton button20 = Calc.setButton("C");

		//按键响应方法
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				String originWord = textArea.getText(); // 文本框中原本已经输入进去的内容
				String newWord = ((JButton) e.getSource()).getText(); // 点击按钮产生的新内容
				String input = originWord + newWord;
				textArea.setText(input);

				//特殊按钮
				//←键：删除键
				for (int i = 0; i < originWord.length(); i++) {
					if (newWord.equals("←")) { // 按下删除键时，文本内容减少最后一位
						textArea.setText(originWord.substring(0, originWord.length() - 1));
					}
				}
				// 为空时，不能再进行删除操作
				if (input.equals("←")) { // 为空时，点击←键时input内容即为←
					textArea.setText("null..can't delete...");
				}

				//C键：重置键
				if (newWord.equals("C")) {
					textArea.setText("");
				}

				try {
					if (newWord.equals("=")) { // 输入等号时开始计算
						textArea.setText(input + Calc.stringToArithmetic(originWord));
					}
				} catch (Exception e1) {
					textArea.setText("your input is illegal..."); // 非法输入提示信息
				}


			}
		}

		ButtonListener bl = new ButtonListener();
		button1.addActionListener(bl);
		button2.addActionListener(bl);
		button3.addActionListener(bl);
		button4.addActionListener(bl);
		button5.addActionListener(bl);
		button6.addActionListener(bl);
		button7.addActionListener(bl);
		button8.addActionListener(bl);
		button9.addActionListener(bl);
		button10.addActionListener(bl);
		button11.addActionListener(bl);
		button12.addActionListener(bl);
		button13.addActionListener(bl);
		button14.addActionListener(bl);
		button15.addActionListener(bl);
		button16.addActionListener(bl);
		button17.addActionListener(bl);
		button18.addActionListener(bl);
		button19.addActionListener(bl);
		button20.addActionListener(bl);

		String grid = frame.getLayout().toString();
		String group = panel.getLayout().toString();

		// 判断前面使用了哪种布局方式
	//	if (grid.equals("java.awt.BorderLayout[hgap=0,vgap=0]") && !group.contains("HORIZONTAL")) { // GridBagLayout布局方式
			//显示框
			*//*
 */
/*addComponents(frame, textArea, 0, 0, 4, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

			//第1行
			addComponents(frame, button1, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button2, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button3, 2, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button4, 3, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

			//第2行
			addComponents(frame, button5, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button6, 1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button7, 2, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button8, 3, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

			//第3行
			addComponents(frame, button9, 0, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button10, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button11, 2, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button12, 3, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

			//第4行
			addComponents(frame, button13, 0, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button14, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button15, 2, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button16, 3, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

			//第5行
			addComponents(frame, button17, 0, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button18, 1, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button19, 2, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
			addComponents(frame, button20, 3, 6, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);*//*
 */
/*
		//} else if (group.contains("HORIZONTAL")) { // GroupLayout布局方式
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

			//frame.setContentPane(panel);
		//}

		frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 500);
		frame.setVisible(true);*//*

	}




}

*/
