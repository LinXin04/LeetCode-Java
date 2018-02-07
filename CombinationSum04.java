/**
 * 题目：组合和。给定一个数组nums,里面没有重复元素；以及一个目标数target，求用nums里面的数加和得到target的组合情况一共有多少种。
 * 解题思路：
 * 动态规划。
 * 定义dp[i]为目标数target为i时，不同组合的个数。
 * 然后我们遍历nums,对于nums中的每一个数a,如果a<=target,那么：dp[i]=dp[i]+dp[i-a]
 *
 */
public class CombinationSum04 {
	public static void main(String[] args) {
		
	}
}

class Solution280
{
	public int combinationSum4(int []nums,int target)
	{
		if(nums==null || nums.length<=0) return 0;
		
		int dp[]=new int[target+1];
		dp[0]=1;
		for(int i=1;i<=target;i++)
		{
			for(int a:nums)
			{
				if(a<=i) dp[i]+=dp[i-a];
			}
		}
		return dp[target];
	}
}