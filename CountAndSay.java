/**
 * 题目：计数与发言。给定一个整数n，求出第n个数字
 * 例如：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * 解题思路：
 * 定义一个计数器，在每次读数的时候，判断这个数与之后的数是否相同，相同则加1
 */
import java.util.Scanner;
public class CountAndSay {

	public static void main(String[] args) {
		System.out.println("请输入数字n:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		Solution208 sl=new Solution208();
		System.out.println("结果是："+sl.countAndSay(n));
	}
}
class Solution208
{
	public String countAndSay(int n)
	{
		if(n<=0) return "";
		if(n==1) return "1";
		
		String result="1";
		
		//循环直到n
		while((--n)!=0)
		{
			String cur="";
			for(int i=0;i<result.length();i++)
			{
				//用来记录重复的数字
				int count=1;
				while((i+1)<result.length() && result.charAt(i)==result.charAt(i+1))
				{
					count++;
					i++;
				}
				cur+=String.valueOf(count)+result.charAt(i);
			}
			result=cur;
		}
		return result;
	}
}