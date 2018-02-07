/**
 * 题目：给定一个数组，求给定一个区间上的数字之和。
 * 解题思路：
 * 如果我们使用普通的检索方法肯定会超时，使用动态规划。
 * dp[i]表示0-i的加和
 * [i,j]的和就是dp[j]-dp[i-1]
 *
 */
public class RangeSumQuery {
	public static void main(String[] args) {
		
	}
}

class NumArray
{
	int dp[];
	public NumArray(int[] nums)
	{
		if(nums==null || nums.length==0) return;
		int n=nums.length;
		dp=new int[n+1];
		dp[0]=nums[0];
		
		for(int i=1;i<n;i++)
			dp[i]=dp[i-1]+nums[i];
	}
	public int sumRange(int i,int j)
	{
		if(i>j) return 0;
		return i==0?dp[j]:dp[j]-dp[i-1];
	}
	
}