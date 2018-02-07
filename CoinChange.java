/**
 * 题目：硬币找零。给定一个数组，代表可用的硬币的面值，和一个钱数，问我们最小可以用多少个硬币来找零。
 * 如果不可以找零，则返回-1.
 * 解题思路：
 * 动态规划。
 * 定义dp[i]为钱数为i时，至少需要多少个硬币。
 * dp[i]=min(dp[i],dp[i-coins[j]]+1)
 *
 */
import java.util.Scanner;
public class CoinChange {
	public static void main(String[] args) {

	}
}
class Solution274
{
	public int coinChange(int[] coins,int amount)
	{
		if(coins==null || coins.length==0 || amount<=0) return 0;
		
		int dp[]=new int[amount+1];
		//设置最大值
		for(int i=1;i<dp.length;i++)
			dp[i]=amount+1;
		dp[0]=0;
		
		for(int i=1;i<=amount;i++)
		{
			for(int j=0;j<coins.length;j++)
			{
				if(coins[j]<=i)
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
			}
		}
		return dp[amount]>amount?-1:dp[amount];
	}
}