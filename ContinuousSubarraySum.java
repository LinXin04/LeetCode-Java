/**
 * 题目：给定一个数组，和一个整数k,求是否存在连续的子数组(长度至少为2)之和等于k，或者是k的整数倍。
 * 例如：
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * 解题思路：直接遍历一边求解
 */
import java.util.Scanner;
public class ContinuousSubarraySum {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<nums.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入整数：");
		int k=sc.nextInt();
		
		Solution253 sl=new Solution253();
		System.out.println("结果是："+sl.checkSubarraySum(nums, k));
	}
}
class Solution253
{
	public boolean checkSubarraySum(int[] nums,int k)
	{
		if(nums==null || nums.length==0) return false;
		
		for(int i=0;i<nums.length;i++)
		{
			int sum=nums[i];
			for(int j=i+1;j<nums.length;j++)
			{
				sum+=nums[j];
				if(sum==k) return true;
				else
					if(k!=0 && sum%k==0) return true;
			}		
		}
		return false;
	}
}