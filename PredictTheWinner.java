/**
 * 题目：预测胜利者。
 * 给定一个正整数数组，选手1从数组的头部或者尾部选择一个数，选手2从剩下部分的头部或尾部选择一个数，循环往复，直到该数组中的数都被取完。判断选手1取的数的和值是否大于选手2。
 * 解题思路：
 * 两个人依次拿，如果player1赢了，则player1拿的分数>player2拿的分数。
 * 我们把player1拿的分数视为“+”，把player2拿的分数视为“-”，如果最后的结果大于等于0，则player1赢。
 * 使用递归的思想来做。
 * helper(nums,start,end):表示对于数组nums,从start和end中拿的结果。
 *
 */
public class PredictTheWinner {
	public static void main(String[] args) {
		
	}
}

class Solution291
{
	public boolean PredictTheWinner(int[] nums)
	{
		if(nums==null || nums.length==0) return true;
		return helper(nums,0,nums.length-1)>=0;
	}
	public int helper(int[] nums,int start,int end)
	{
		if(start==end) return nums[start];
		//player1拿第一个的结果与player1拿最后一个的结果
		return Math.max(nums[start]-helper(nums,start+1,end), nums[end]-helper(nums,start,end-1));
	}
}