package com.company;

/**
 * @author highsad
 */

public class Rand {

	/*static boolean contion(){
		boolean result = Math.random() < 0.5;
		System.out.println(result + ".");
		return result;
	}*/

	public static void main(String[] args) {

/*		String a = "+";
		char b = a.charAt(0);
		System.out.println(b);*/

		//加法

		String a = "11+315=";
		String b = a.substring(0, a.length() - 1);
		System.out.println(b);
		//String[] expression = a.split("\\=");


		//boolean flag = a.contains("-");
		//int doCount = Arrays.binarySearch(b, "2");
		//System.out.println(flag);
		/*String[] num = expression[0].split("\\+");
		int num1 = Integer.parseInt(num[0]);
		int num2 = Integer.parseInt(num[1]);
		int result = num1 + num2;
		System.out.println(num[0] + "+" +num[1] + "=" );
		System.out.println(result);
*/



		/*while (contion()) {
			System.out.println("inside while");
		}
		System.out.println("outside while");*/
	}
}
