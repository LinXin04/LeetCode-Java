import java.util.Arrays;

/**
 * 题目：给定一个非负整数的数组和一个整数m，你可以将数组分割为m个非空的子数组，求最小化m个子数组中的最大和。
 * 解题思路：
 * 动态规划。
 * 定义dp[i][j]为：前i个数被分割成j个子数组的最小的最大子数组和。
 * dp[0][0]=0;
 * j的范围应该是[1,nums.length].
 * dp[i][j]=min(dp[i][j],max(dp[k][i-1],sum[i]-sum[k]))
 *
 */
public class SplitArrayLargestSum {
	public static void main(String[] args) {
	}
}
class Solution283
{
	public int splitArray(int[] nums,int m)
	{
		if(nums==null || nums.length==0) return 0;
		int n=nums.length;
		if(m>n) return -1;
		
		int sums[]=new int[n+1];
		for(int i=1;i<=n;i++)
			sums[i]=sums[i-1]+nums[i-1];
		
		if(m==1) return sums[n];
		
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		
		dp[0][0]=0;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				for(int k=j-1;k<i;k++)
					dp[i][j]=Math.min(dp[i][j], Math.max(dp[k][j-1], sums[i]-sums[k]));			
			}
		}
		return dp[n][m];
	}
}