/**
 * 题目：打家劫舍02.假设房子的首尾是相连的，因此，在这种情况下，要么首部的房子与尾部的房子都不打劫，要么只打劫其中的一个。
 * 解题思路：
 * 动态规划，我们把第一家和最后一家分别去掉，求两种情况的最大值，即为所求。
 */
import java.util.Scanner;
public class HouseRobber02 {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		int []nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution264 sl=new Solution264();
		System.out.println("结果是："+sl.rob(nums));
	}

}
class Solution264 
{
	public int rob(int []nums)
	{
		if(nums==null || nums.length==0) return 0;
		int n=nums.length;
		if(n==1) return nums[0];
		
		return Math.max(helper(nums,0,n-2), helper(nums,1,n-1));
	}
	public int helper(int []nums,int start,int end)
	{
		if(end-start<1) return nums[start];
		
		int len=end-start+1;
		int[] dp=new int[len+1];
		dp[0]=0;
		dp[1]=nums[start];
		
		for(int i=2;i<=len;i++)
			dp[i]=Math.max(dp[i-2]+nums[start+i-1], dp[i-1]);
		return dp[len];
	}
}