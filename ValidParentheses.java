/**
 * 题目：有效的括号。
 * 给定一个字符串，它只包含“(,),{,},[,]”，试判断是否里面所有的括号都是有效的。
 * 解题思路：利用栈将左括号都存起来，然后遇到右括号时再pop进行匹配
 *
 */
import java.util.Scanner;
import java.util.Stack;
public class ValidParentheses {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution103 sl=new Solution103();
		boolean result=sl.isValid(s);
		System.out.println("结果是："+result);
	}
}
class Solution103
{
	public boolean isValid(String s)
	{
		if(s.length()==0 || s==null) return true;
		int Length=s.length();
		Stack<Character> stack=new Stack<Character>();
		
		for(int i=0;i<Length;i++)
		{
			char curChar=s.charAt(i);
			if(curChar=='('||curChar=='['||curChar=='{')
				stack.push(curChar);
			else
			{
				if(!stack.isEmpty() && ((curChar==')' && stack.peek()=='(')||(curChar==']' && stack.peek()=='[')||(curChar=='}'  && stack.peek()=='{')))
					stack.pop();
				else
					return false;
			}
		}
		
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
}