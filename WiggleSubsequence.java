/**
 * 题目：摆动子序列。如果一个序列满足num1<num2>num3<num4>num5或者num1>num2<num3>num4<num5，也就是说，连续两个值之间的差是正负交替的，这种序列称为摆动序列。
 * 此题是给定一个数组，求该数组的最长摆动子序列的长度。
 * 解题思路：
 * 贪心算法。
 * 维护两个变量p和q,如果nums[i]>nums[i-1],p=q+1;否则nums[i]<nums[i-1],q=p+1;
 * 返回的结果是min(nums.length,max(p,q))
 *
 */
public class WiggleSubsequence {
	public static void main(String[] args) {
		
	}
}

class Solution279
{
	public int wiggleMaxLength(int []nums)
	{
		if(nums==null ||nums.length==0) return 0;
		int p=1,q=1,n=nums.length;
		
		for(int i=1;i<n;i++)
		{
			if(nums[i]>nums[i-1]) p=q+1;
			else if(nums[i]<nums[i-1]) q=p+1;
		}
		return Math.min(n, Math.max(p,q));
	}
}