/**
 * 题目：不同的子序列。给定字符串s和子字符串t，要求只允许用删除的方式由s得到t，问一共有几种变换方式。
 * 例如：
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 解题思路：
 * 看到求字符串子序列或者匹配的问题，就使用动态规划求解。
 * dp[i][j]:表示字符串t的前i个字符与s的前j个字符产生的解的个数。
 * dp[i][0]=0
 * dp[0][j]=1
 * dp[i][j]=dp[i][j-1]+(t[i-1]==s[j-1]?dp[i-1][j-1]:0)
 *
 */
import java.util.Scanner;
public class DistinctSubsequences {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println("请输入字符串t:");
		String t=sc.nextLine();
		
		Solution227 sl=new Solution227();
		System.out.println("结果是："+sl.numDistinct(s, t));
	}
}
class Solution227
{
	public int numDistinct(String s,String t)
	{
		if(s==null) return t==null?1:0;
		int len1=t.length();
		int len2=s.length();
		
		if(len1>len2) return 0;
		
		int dp[][]=new int[len1+1][len2+1];
		for(int i=1;i<=len1;i++) dp[i][0]=0;
		for(int i=0;i<=len2;i++) dp[0][i]=1;
		
		for(int i=1;i<=len1;i++)
			for(int j=1;j<=len2;j++)
				dp[i][j]=dp[i][j-1]+(t.charAt(i-1)==s.charAt(j-1)?dp[i-1][j-1]:0);
		
		return dp[len1][len2];
	}
}