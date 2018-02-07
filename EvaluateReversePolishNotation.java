/**
 * 题目：计算逆波兰表达式的值（即后缀表达式）
 * 解题思路：
 * 使用一个栈存储操作数，如果遇到操作符，则将栈中的栈顶的两个元素取出进行运算，再将结果压栈。
 *
 */
import java.util.Scanner;
import java.util.Stack;
public class EvaluateReversePolishNotation {

	public static void main(String[] args) {
		System.out.println("请输入一个字符串：");
		 Scanner sc=new Scanner(System.in);
		 String s=sc.nextLine();
		 String[] tokens=s.split(" ");
		 
		 Solution105 sl=new Solution105();
		 int result=sl.evalRPN(tokens);
		 System.out.println("结果是："+result);
	}
}
class Solution105
{
	public int evalRPN(String[] tokens)
	{
		if(tokens==null) return 0;
		if(tokens.length==1) return Integer.parseInt(tokens[0]);
		int result=0;
		
		Stack<String> stack=new Stack<String>();
		int Length=tokens.length;
		
		for(int i=0;i<Length;i++)
		{
			if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
				stack.push(tokens[i]);
			else
			{
				//遇到操作符，将前两个数字弹出来进行运算
				int a=Integer.parseInt(stack.pop());
				int b=Integer.parseInt(stack.pop());
				char operator=tokens[i].charAt(0);
				switch (operator)
				{
					case '+': 
						result=b+a;
						stack.push(String.valueOf(result));
						break;
					case '-':
						result=b-a;
						stack.push(String.valueOf(result));
						break;
					case '*':
						result=b*a;
						stack.push(String.valueOf(result));
						break;
					case '/':
						result=b/a;
						stack.push(String.valueOf(result));
						break;
					default:
						break;
				}		
			}
		}
		return result;
	}
}