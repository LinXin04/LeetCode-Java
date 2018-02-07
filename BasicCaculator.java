/**
 * 题目：基础计算：给定一个字符串，里面可能包含空格、括号()、+、-、非负整数，求其计算的数值。
 * 例如：
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * 解题思路：
 * 首先，对于读入的字符，如果是数字的话，我们就要利用一个循环将整个（多位）数字读入，计算该数字与前面数字的运算结果；
 * 如果读到“+”或者读到“-”，更新符号；
 * 如果读到“(”,将之前的结果，以及符号压栈，保留下来；
 * 如果读到“)”,将现在的结果与栈里面的结果进行相加
 */
import java.util.Scanner;
import java.util.Stack;
public class BasicCaculator {

	public static void main(String[] args) {
		System.out.println("请输入一个字符串：");
		 Scanner sc=new Scanner(System.in);
		 String s=sc.nextLine();

		 Solution107 sl=new Solution107();
		 int result=sl.caculate(s);
		 System.out.println("结果是："+result);

	}

}
class Solution107
{
	public int caculate(String s)
	{
		if(s==null) return 0;
		int result=0;
		int sign=1;
		Stack<Integer> stack=new Stack<Integer>();
		
		int Length=s.length();
		for(int i=0;i<Length;i++)
		{
			//读入的字符
			char curChar=s.charAt(i);
			//如果是数字
			if(Character.isDigit(curChar))
			{
				int digit=curChar-'0';
				//读入整个数字
				while(i+1<Length && Character.isDigit(s.charAt(i+1)))
					digit=digit*10+s.charAt(++i)-'0';
				//将前面的符号加入
				result+=digit*sign;
			}else if(curChar=='+')
			{
				sign=1;
			}else if(curChar=='-')
			{
				sign=-1;
			}else if(curChar=='(')
			{
				stack.push(result);
				result=0;
				stack.push(sign);
				sign=1;
			}else if(curChar==')')
			{
				result=stack.pop()*result+stack.pop();
				sign=1;
			}
		}
		return result;
	}
}