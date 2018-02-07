/**
 * 题目：最长的有效的括号长度。
 * 例如：
 * input： (()
 * ()
 * output：2
 *
 * input： )()())
 * ()()
 * output：4
 * 解题思路：
 * 借助一个栈。定义start为有效字符串开始的位置。
 * 遍历字符串s，若遇到左括号“(”，则将当前下标压入栈；如果遇到右括号“)”,如果当前栈是空的，则start=i+1,如果不为空，取出栈顶元素，若此时栈为空，则更新res=i-start+1;若不为空，则更新res=i-m.top()
 */
import java.util.Scanner;
import java.util.Stack;
public class LongestValidParentheses {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution212 sl=new Solution212();
		System.out.println("结果是："+sl.longestValidParentheses(s));
	}
}
class Solution212
{
	public int longestValidParentheses(String s)
	{
		if(s==null || s.length()<=1) return 0;
		Stack<Integer> m=new Stack<Integer>();
		int start=0;
		int result=0;
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(') m.push(i);
			else
			{
				if(m.isEmpty())  start=i+1;
				else
				{
					m.pop();
					if(m.isEmpty()) result=Math.max(result, i-start+1);
					else result=Math.max(result, i-m.peek());
				}
			}
		}
		return result;
	}
}
