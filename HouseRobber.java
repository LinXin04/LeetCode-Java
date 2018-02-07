/**
 * 题目：打家劫舍。你是一个打劫的人，给定一个数组代表每间房子的财产金额，相邻两间房子不允许连续打劫，求你能打到的最大金额。
 * 解题思路：
 * 动态规划。
 * dp[i]=max(dp[i-2]+nums[i],dp[i-1])
 *
 */
import java.util.Scanner;
public class HouseRobber {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String []st=s.split(" ");
		int []nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution263 sl=new Solution263();
		System.out.println("结果是："+sl.rob(nums));
	}
}
class Solution263
{
	public int rob(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int len=nums.length;
		
		int []dp=new int[len+1];
		dp[0]=0;
		dp[1]=nums[0];
		for(int i=2;i<=len;i++)
			dp[i]=Math.max(dp[i-2]+nums[i-1], dp[i-1]);
		return dp[len];
	}
}