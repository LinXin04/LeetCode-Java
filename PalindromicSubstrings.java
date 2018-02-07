/**
 * 题目：回文子串的数量。给定一个字符串，求该字符串中回文子串的个数。可以重复
 * 例如：
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * 解题思路：
 * 动态规划。
 * dp[i][j]:第i个字符到第j个字符中包含的回文子串的数量
 * dp[i][j]=1+dp[i+1][j-1],s[i]==s[j]
 * dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
 * 或者递归：
 * 回文字符串有奇数个字符时，当前i位置字母作为回文字符串的中心；有偶数个字符的时候当前i和i+1位置字母作为回文字符串的中心。
 */
import java.util.Scanner;
public class PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println("请输入字符串：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution250 sl=new Solution250();
		System.out.println("结果是："+sl.countSubstring(s));
	}
}
class Solution250
{
	int count=0;
	public int countSubstring(String s)
	{
//		if(s==null || s.length()<=0) return 0;
//		int n=s.length();
//		int dp[][]=new int[n][n];
//		
//		for(int j=0;j<n;j++)
//		{
//			dp[j][j]=1;
//			for(int i=j-1;i>=0;i--)
//			{
//				dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
//				if(s.charAt(i)==s.charAt(j)) dp[i][j]+=1+dp[i+1][j-1];	
//			}
//		}
//		return dp[0][n-1];
		if(s==null || s.length()<=0) return 0;
		int n=s.length();

		for(int i=0;i<n;i++)
		{
			check(s,i,i);
			check(s,i,i+1);
		}
		return count;
	}
	public void check(String s,int i,int j)
	{
		while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
		{
			count++;
			i--;
			j++;
		}
	}
}
