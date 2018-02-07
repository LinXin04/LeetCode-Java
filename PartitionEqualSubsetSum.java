/**
 * 题目：相同子集和分割。
 * 给定一个非空数组，判断数组是否可以被分成两个子数组，这两个子数组的和相等。
 * 解题思路：
 * 如果我们可以找到两个子数组相等的情况，那么每个子数组的和应该是和的一半target。
 * 定义dp[i]表示数字i是否是原数组的任意个子集合的和，那么我们最后返回dp[target]即可。
 * dp[i]=dp[i] || dp[i-nums[j]]
 */
public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
	
	}
}
class Solution284
{
	public boolean canPartition(int[] nums)
	{
		if(nums==null || nums.length==0) return true;
		
		int n=nums.length;
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=nums[i];
		
		//不存在这样的子数组
		if(sum%2!=0) return false;
		int target=sum/2;
		
		boolean[] dp=new boolean[target+1];
		dp[0]=true;
		
		for(int i=0;i<n;i++)
		{
			for(int j=target;j>=nums[i];j--)
				dp[j]=dp[j] || dp[j-nums[i]];
		}
		return dp[target];
	}
}