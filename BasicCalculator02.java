/**
 * 题目：基础计算器。给定一个字符串，求解该字符串的计算结果。
 * 该表达式只包括+、-、*、/、若干个空格。
 * 例如：
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * 解题思路：
 * 本题的主要关键点在于处理优先级。
 * 我们使用一个栈来保存数字（带正负号），如果遇到乘、除则从栈顶取出一个数字与当前数字做运算，然后将结果压入栈中。
 * 最后将所有栈中的数字相加就会得到最后的结果。
 */
import java.util.Scanner;
import java.util.Stack;
public class BasicCalculator02 {

	public static void main(String[] args) {
		System.out.println("请输入字符串S：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution234 sl=new Solution234();
		System.out.println("结果是："+sl.calculate(s));
	}
}
class Solution234
{
	public int calculate(String s)
	{
		if(s==null || s.length()<=0) return 0;
		
		int result=0;
		int temp=0;
		char sign='+';
		
		Stack<Integer> nums=new Stack<Integer>();
		
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			//首先将遇到的字符串数字转成整数
			if(ch>='0')
				temp=temp*10+ch-'0';
			
			//然后当遇到符号时，做如下操作
			if((ch<'0' && ch!=' ') || i==s.length()-1)
			{
				if(sign=='+') nums.push(temp);
				if(sign=='-') nums.push(-temp);
				if(sign=='*' || sign=='/')
				{
					int n=sign=='*'?nums.pop()*temp:nums.pop()/temp;
					nums.push(n);
				}
				sign=ch;
				temp=0;
			}
		}
		while(!nums.isEmpty())
			result+=nums.pop();
		return result;
	}
}
