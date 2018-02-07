/**
 * 题目：爬楼梯的最小代价。
 * 给定一个数组代表楼梯第i层的代价，初始时可以从cost[0]爬起，也可以从cost[1]开始爬起。一旦你支付费用，便可以爬一步或者两步。求爬完楼梯的最小代价
 * 解题思路：
 * 动态规划。
 * dp[i]:代表爬到第i层的最小代价。
 * dp[i]=cost[i]+min(dp[i-1],dp[i-2])
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		

	}

}

class Solution287
{
	public int minCostClimbingStairs(int[] cost)
	{
		if(cost==null || cost.length==0) return 0;
		int n=cost.length;
		int[] dp=new int[n];
		
		dp[0]=cost[0];
		dp[1]=cost[1];
		
		for(int i=2;i<n;i++)
			dp[i]=cost[i]+Math.min(dp[i-1], dp[i-2]);
		
		return Math.min(dp[n-1],dp[n-2]);
	}
}
