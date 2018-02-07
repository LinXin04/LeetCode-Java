/**
 * 题目：外卡匹配。给定两个字符串s和p，问p是否能由s匹配得到。
 * 其中，'?'可以代表任意一个字符，'*'可以代表任意长度的字符串。
 * 例如：
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 解题思路：
 * 使用动态规划的思想。
 * 定义dp[i][j]代表s的i位，与p[j]位的匹配情况。1为匹配成功，0为匹配失败
 */
import java.util.Arrays;
import java.util.Scanner;
public class WildcardMatching {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字符串p:");
		String p=sc.nextLine();
		
		Solution215 sl=new Solution215();
		System.out.println("结果是："+sl.isMatch(s, p));
	}
}
class Solution215
{
	public boolean isMatch(String s, String p)
	{
		if(s==null) return p==null;
		
		int m=s.length(),n=p.length();
		boolean dp[][]=new boolean[m+1][n+1];
		for(int i=0;i<=m;i++)
			for(int j=0;j<=n;j++)
				dp[i][j]=false;
		
		dp[0][0]=true;
		
		for(int k=1;k<=n;k++)
		{
			if(p.charAt(k-1)=='*')
				dp[0][k]=dp[0][k-1];
		}
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(p.charAt(j-1)=='*')
					//'*'可以代表一个序列或者空格
					dp[i][j]=dp[i-1][j] || dp[i][j-1];
				else
					dp[i][j]=(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') && dp[i-1][j-1];
			}
		}
		return dp[m][n];
	}
}