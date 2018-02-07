/**
 * 题目：目标和。给定一个非负的整数数组，a1,a2,a3,...,an,以及一个目标值s.
 * 现在你有两个符号“+”和“-”，对于每一个整数分配一个符号，找出有多少种符号分配方式使得整数的和等于目标s.
 * 解题思路：
 * 深度优先搜索。
 * 我们从第一个数字，调用递归函数，在递归函数中，分别对目标值进行加上当前数字调用递归，和减去当前数字调用递归，这样会涵盖所有情况。
 */
public class TargetSum {
	public static void main(String[] args) {
	
	}
}

class Solution285
{
	private int result=0;
	public int findTargetSumWays(int[] nums,int S)
	{
		if(nums==null || nums.length==0) return 0;
		helper(nums,S,0,0);
		return result;	
	}
	public void helper(int[] nums,int S,int index,int sum)
	{
		if(index==nums.length)
		{
			if(sum==S)
				result++;
			return;
		}
		
		//否则的话，结果为当前的nums[index]赋为+的情况，与赋为-的情况。
		helper(nums,S,index+1,sum+nums[index]);
		helper(nums,S,index+1,sum-nums[index]);
	}
}