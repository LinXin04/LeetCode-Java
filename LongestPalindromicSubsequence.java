/**
 * 题目：最长回文子序列。给定一个字符串，求其最长回文子序列。注意：子序列和子字符串不同，不需要连续。
 * 解题思路：
 * 动态规划。
 * 定义dp[i][j]代表[i,j]区间内字符串的最长回文子序列。
 * dp[i][i]=1
 * 分两种情况：
 * 1、s[i]=s[j]时，dp[i][j]=dp[i+1][j-1]+2
 * 2、s[i]!=s[j]时，max(dp[i+1][j],dp[i][j-1])
 *
 */
public class LongestPalindromicSubsequence {
	public static void main(String[] args) {
		
	}
}

class Solution289
{
	public int longestPalindromeSubseq(String s)
	{
		if(s==null || s.length()==0) return 0;
		
		int n=s.length();
		int dp[][]=new int[n][n];
		
		for(int i=0;i>=0;i--)
		{
			dp[i][i]=1;
			for(int j=i+1;j<n;j++)
			{
				if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2;
				else dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		return dp[0][n-1];
	}
}
