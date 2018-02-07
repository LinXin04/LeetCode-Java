/**
 * 题目：验证括号字符串。给定一个字符串，问该字符串是否是有效的括号字符串。
 * 有效的字符串规则：
 * (1)每一个‘(’,都有一个相应的‘)’
 * (2)每一个‘)’,都有一个相应的‘(’
 * (3)'('必须在‘)’前面
 * (4)*可以代表一个‘(’或者一个‘)’,或者一个空字符
 * 解题思路：
 * count表示左边括号出现的次数。
 * 我们使用递归的方法，当遇到‘(’时，count++; 当遇到‘)’时,count--; 当遇到‘*’时，递归调用当把‘*’当做‘(’,或者‘)’,或者‘’时的情况。
 */
import java.util.Scanner;
public class ValidParenthesisString {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution242 sl=new Solution242();
		System.out.println("结果是："+sl.checkValidString(s));
	}
}
class Solution242
{
	public boolean checkValidString(String s)
	{
		if(s==null || s.length()==0) return true;
		return check(s,0,0);
	}
	public boolean check(String s, int start, int count)
	{
		if(count<0) return false;
		
		for(int i=start;i<s.length();i++)
		{
			char ch=s.charAt(i);
			if(ch=='(') 
				count++;
			else if(ch==')')
			{
				if(count<=0) return false;
				count--;
			}
			else
			{
				return check(s,i+1,count+1) || check(s,i+1,count-1) || check(s,i+1,count);
			}	
		}
		return count==0;
	}
}