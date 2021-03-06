package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.regex.Pattern;

public class Calc extends JFrame {
	private static final String GROUP_LAYOUT = "GROUP_LAYOUT";
	private static final String GRID_BAG_LAYOUT = "GRID_BAG_LAYOUT";

	// 构造方法：默认使用GroupLayout布局方式实现计算器
	private Calc() {

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		newButton();
		choiceLayout(GROUP_LAYOUT);
		addListeners();
		eliminateTextField();

		groupLayout.setAutoCreateContainerGaps(true);
		groupLayout.setAutoCreateGaps(true);
		frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 400);

	}

	//指定组件与网格之间的距离
	private static Insets insets = new Insets(0, 0, 0, 0);

	//给出一个算术表达式（中缀表达式），得到计算结果
	private static double stringToArithmetic(String string) {
		return suffixToArithmetic(infixToSuffix(string));
	}

	//中缀表达式转成后缀表达式
	private static String infixToSuffix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder suffixSb = new StringBuilder(); // 循环中的中间变量，最终转换为suffix字符串
		String suffix; // 最终需要的后缀表达式
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
						//suffix += " " + temp;
						suffixSb.append(" ").append(temp);
					}
					stack.push(c);
					//suffix += " ";
					suffixSb.append(" ");
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
							//suffix += " " + temp;
							suffixSb.append(" ").append(temp);
						}
					}
					stack.push(c);
					//suffix += " ";
					suffixSb.append(" ");
					break;
				// 碰到右括号，将靠近栈顶的第一个左括号上面的运算符全部依次弹出，送至输出队列后，再丢弃左括号
				case ')':
					while (stack.size() != 0) {
						temp = stack.pop();
						if (temp == '(')
							break;
						else
							//suffix += " " + temp;
							suffixSb.append(" ").append(temp);
					}
					break;
				//如果是数字，直接送至输出序列
				default:
					//suffix += c;
					suffixSb.append(c);
			}
		}

		//如果栈不为空，把剩余的运算符依次弹出，送至输出序列。
		while (stack.size() != 0) {
			//suffix += " " + stack.pop();
			suffixSb.append(" ").append(stack.pop());
		}
		suffix = suffixSb.toString();
		return suffix;
	}

	//通过后缀表达式求出算术结果
	private static double suffixToArithmetic(String postfix) {

		Pattern pattern = Pattern.compile("\\d+|(\\d+\\.\\d+)"); //使用正则表达式匹配数字
		String strings[] = postfix.split(" ");  //将字符串转化为字符串数组
/*		for (int i = 0; i < strings.length; i++) {
			strings[i].trim();  //去掉字符串首尾的空格
		}*/
		Stack<Double> stack = new Stack<Double>();

		for (String i : strings) {

			if (i.equals(""))
				continue;

			//如果是数字，则进栈
			if ((pattern.matcher(i)).matches()) {
				stack.push(Double.parseDouble(i));
			} else {
				//如果是运算符，弹出运算数，计算结果。
				double y = stack.pop();
				double x = stack.pop();
				stack.push(caculate(x, y, i)); //将运算结果重新压入栈。
			}
		}
		return stack.pop(); //弹出栈顶元素就是运算最终结果。

	}

	private static double caculate(double x, double y, String simble) {
		if (simble.equals("+")) {
			return x + y;
		}
		if (simble.equals("-")) {
			return x - y;
		}
		if (simble.equals("*")) {
			return x * y;
		}
		if (simble.equals("/")) {
			return x / y;
		}
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

	private JTextField textField = new JTextField();
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
	private JButton button21; // 添加自定义运算符按钮

	private JFrame frame = new JFrame("这是一个计算器");
	private JPanel panel = new JPanel();
	private GroupLayout groupLayout = new GroupLayout(panel);
	private GridBagLayout gridBagLayout = new GridBagLayout();

	// 设置Button样式
	private static JButton setButton(String name) {
		JButton button = new JButton();
		button.setText(name);
		button.setFont(new Font("宋体", Font.PLAIN, 20));
		return button;
	}

	// 初始化变量：初始化Button、textField
	private void newButton() {
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		//textField.setLineWrap(true); // 自动换行
		textField.setMinimumSize(new Dimension(20, 10)); // 设置最小窗口值，使其可以自由缩放

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
		button21 = Calc.setButton("addOperator");
	}

	// 初始化变量状态：清空textField
	private void eliminateTextField() {
		textField.setText("0");
		textField.setEditable(false); // 设置为只读状态：只能通过点击Button输入
		textField.setHorizontalAlignment(JTextField.RIGHT); // 靠右显示
	}

	// 初始化布局
	private void choiceLayout(String manager) {
		if (manager.equals(GRID_BAG_LAYOUT)) {
			gridBagLayoutDrawCalc();
		} else if (manager.equals(GROUP_LAYOUT)) {
			groupLayoutDrawCalc();
		}
	}

	// 添加自定义Button方法
	private void addButton(int function) {
		if (function == 1) {

		}
	}

	// 计算器界面显示
	private void showCalc() {
		frame.setVisible(true);
	}

	// 文本框中内容显示
	// 按键响应
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//boolean doCalc = false;
			String oldWord = textField.getText(); // 文本框中原本已经输入进去的内容
			String newWord = ((JButton) e.getSource()).getText(); // 点击按钮产生的新内容
			String input = oldWord + newWord;

			textField.setText(input);

			// 刚生成计算器时、进行了清除操作后，默认显示一个0，当有输入时，需要覆盖它（若输入的值为0-1之间的小数，则不需要覆盖）
			if (oldWord.equals("0") && !newWord.equals("") && !newWord.equals(".")) {
				textField.setText(newWord);
			}

			// 输入等号时输出结果
			try {
				if (newWord.equals("=")) {
					String result = String.valueOf(Calc.stringToArithmetic(oldWord)); // 计算结果为double，转换成String
					textField.setText(result);
					//doCalc = true;
				}
			} catch (Exception e1) {
				textField.setText("your input is illegal..."); // 非法输入提示信息
			}

			// 进行一次运算之后，再输入操作数，需要覆盖原来的内容（若输入操作符，则不需要覆盖）
			// BUG
/*			String pattern = "^(-?\\d+)(\\.\\d+)?$"; // 浮点数
			boolean isMatch = Pattern.matches(pattern, oldWord);
			String pattern2 = "^[0-9]*$"; // 数字
			boolean isMatch2 = Pattern.matches(pattern2, newWord);
			if((isMatch && isMatch2 && !oldWord.equals("0")) || oldWord.contains("illegal") || oldWord.contains("null") || oldWord.contains("function")){
				textField.setText(newWord);
			}*/


			// 特殊按钮
			// ←键：删除键
			for (int i = 0; i < oldWord.length(); i++) {
				if (newWord.equals("←")) { // 按下删除键时，文本内容减少最后一位
					textField.setText(oldWord.substring(0, oldWord.length() - 1));

				}
			}
			// 为空时，不能再进行删除操作
			if (input.equals("←")) { // 为空时，点击←键时input内容即为←
				textField.setText("null..can't delete...");
			}
			// C键：Clear清除
			if (newWord.equals("C")) {
				textField.setText("0");
			}
			// addOperator键
			if (newWord.equals("addOperator")) {
				textField.setFont(new Font("宋体", Font.PLAIN, 13));
				textField.setText("input which function you want to add: 1、1/x; 2、%.");
				// 输入1
				if (oldWord.equals("input which function you want to add: 1、1/x; 2、%.1")) {
					//textField.setText("function1");

				}
				// 输入2
			}

		}
	}

	private ButtonListener bl = new ButtonListener();

	private void addListener(JButton button) {
		button.addActionListener(bl);
	}

	// 初始化事件：为每个button添加监听事件
	private void addListeners() {
		addListener(button1);
		addListener(button2);
		addListener(button3);
		addListener(button4);
		addListener(button5);
		addListener(button6);
		addListener(button7);
		addListener(button8);
		addListener(button9);
		addListener(button10);
		addListener(button11);
		addListener(button12);
		addListener(button13);
		addListener(button14);
		addListener(button15);
		addListener(button16);
		addListener(button17);
		addListener(button18);
		addListener(button19);
		addListener(button20);
		addListener(button21);
	}

	// 实现计算器界面
	private void gridBagLayoutDrawCalc() {
		panel.setLayout(gridBagLayout);
		//显示框
		addComponents(frame, textField, 0, 0, 4, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH);

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

		// 第6行：添加自定义运算符按钮
		addComponents(frame, button21, 0, 7, 4, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
	}

	private void groupLayoutDrawCalc() {
		panel.setLayout(groupLayout);
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
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addGroup(hSequentialGroup)
				.addComponent(button21, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
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
				.addComponent(textField, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
				.addGroup(vParallelGroup1).addGroup(vParallelGroup2).addGroup(vParallelGroup3).addGroup(vParallelGroup4).addGroup(vParallelGroup5)
				.addComponent(button21, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE);
		groupLayout.setVerticalGroup(vSequentialGroup);

		/*frame.setContentPane(panel);
		frame.setLocation(600, 300);// 显示位置
		frame.setSize(400, 400);
		frame.setVisible(true);*/
	}

	public static void main(String[] args) {

		Calc calc = new Calc();
		//calc.choiceLayout(Calc.GRID_BAG_LAYOUT);
		calc.showCalc();
	}
}
