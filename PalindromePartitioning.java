/**
 * 题目：给定一个字符串，将其切割成若干子字符串，保证每个子字符串都是回文串，求最小的切割次数。
 * 解题思路：
 * 动态规划。
 * dp[i]:表示从i到len为止，需要的最小切割次数。
 * dp[i]=min(dp[i],dp[j+1]+1)
 * 
 * 同时需要p[i][j]来存储i到j是不是回文串
 *
 */
import java.util.Scanner;
public class PalindromePartitioning {
	public static void main(String[] args) {
		System.out.println("请输入字符串s:");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		
		Solution265 sl=new Solution265();
		System.out.println("结果是："+sl.minCut(s));
	}
}
class Solution265
{
	public int minCut(String s)
	{
		if(s==null || s.length()==0) return 0;
		int n=s.length();
		int dp[]=new int[n+1];
		boolean [][]p=new boolean[n][n];
		
		//初始化dp:从i-n-1最多切割次数是n-i-1;
		for(int i=0;i<=n;i++)
			dp[i]=n-i-1;
		
		//初始化p[i][j]
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				p[i][j]=false;
		
		for(int i=n-1;i>=0;i--)
		{
			for(int j=i;j<n;j++)
			{
				if(s.charAt(i)==s.charAt(j) && (j-i<=1 || p[i+1][j-1]))
				{
					p[i][j]=true;
					//从i到j是回文串了，下一刀应该在j+1处
					dp[i]=Math.min(dp[i], dp[j+1]+1);
				}
			}
		}
		return dp[0];
	}
}