/**
 * 题目：正则表达式匹配。给定两个字符串s和p,问p是否可以匹配s.
 * 其中，"."可以代表任意的字符；"*"可以代表与前面相同的字符。
 * 例如：
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 解题思路：
 * 1、如果两个同时为空，则返回true,否则返回false
 * 2、如果p的长度为1，则s的长度为1，并且s[0]=p[0]或者p[0]='.',返回True
 * 3、如果p的长度>1,且p[1]!='*'，则s不为空，并且s[0]=p[0]或者p[0]='.',返回isMatch(s[1],p[1])
 * 4、如果p的长度>1,且p[1]=='*'，则s不为空，并且s[0]=p[0]或者p[0]='.',如果isMatch(s,p[2]),返回true。
 * s.substring(1)
 * 5、当p的第二个字符是星号时，非【S不空且(p.charAt(0) == s.charAt(0) 或者 p.charAt(0)==‘ . ’)】，截去p的前两个元素（某字符+星号）并进入下一层递归。
 *
 */
import java.util.Scanner;
public class RegularExpressionMatching {
	public static void main(String[] args) {	
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		System.out.println("请输入字符串p:");
		String p=sc.nextLine();
		
		Solution204 sl=new Solution204();
		System.out.println("结果是："+sl.isMatch(s, p));
	}
}
class Solution204
{
	public boolean isMatch(String s,String p)
	{
		//1、如果两个同时为空，则返回true,否则返回false
		if(p.isEmpty()) return s.isEmpty();
		
		//2、如果p的长度是1
		if(p.length()==1)
			return (s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'));
		
		//3、如果p的长度大于1.并且p[1]!=*
		if(p.charAt(1)!='*')
		{
			if(s.isEmpty()) return false;
			return  (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.') && isMatch(s.substring(1),p.substring(1));
		}
		
		//4、如果p的长度大于1，并且p[1]=*
		while(!s.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'))
		{
			if(isMatch(s,p.substring(2))) return true;
			s=s.substring(1);
		}
		
		//5、p[1]=*，并且不满足(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')这个条件时
		return isMatch(s,p.substring(2));
	}
}
