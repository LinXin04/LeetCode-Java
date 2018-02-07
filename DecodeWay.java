/**
 * 题目：给定一串数字，求反编译成字母一共多少种。
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 例如：
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 解题思路：
 * 动态规划。
 * dp[i]表示前i个数字的反编码种类数。
 * 如果s[i-1]!='0',dp[i]=dp[i-1];否则dp[i]=dp[i-2]
 * 如果s[i-2]!='0'并且1<=s(i-2,i-1)<=26,那么dp[i]=dp[i]+dp[i-2]
 * 斐波那契数列
 *
 */
import java.util.Scanner;
public class DecodeWay {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution219 sl=new Solution219();
		System.out.println("结果是："+sl.numDecodings(s));
	}
}
class Solution219
{
	public int numDecodings(String s)
	{
		if(s==null || s.length()==0 || s.charAt(0)=='0') return 0;
		
		int len=s.length();
		int dp[]=new int[len+1];
		
		dp[0]=1;
		dp[1]=1;
		
		for(int i=2;i<=len;i++)
		{
			if(s.charAt(i-1)!='0')
				dp[i]=dp[i-1];
			if(s.charAt(i-2)!='0' && Integer.valueOf(s.substring(i-2, i))>=1 
					&& Integer.valueOf(s.substring(i-2, i))<=26)
			{
				dp[i]+=dp[i-2];
			}
		}
		return dp[len];
	}
}