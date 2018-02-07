/**
 * 题目：最短的子串和：给定一个正整数数组和一个目标值s，求出最短的满足加和》=s的序列长度。如果不存在，返回0
 * 例如：
 * given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint
 * 解题思路：
 * 定义两个指针start和end，如果得到的sum<s,则end++;如果得到的sum>=s，则更新result，并且start++，一直到end=len-1.
 *
 */
import java.util.Scanner;
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println("请输入一个正整数s:");
		Scanner sc=new Scanner(System.in);
		int s=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入一个数组nums");
		String s1=sc.nextLine();
		String st[]=s1.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<nums.length;i++)
		{
			nums[i]=Integer.parseInt(st[i]);
		}

		Solution61 sl=new Solution61();
		System.out.print("结果是：");
		int result=sl.minSubArrayLen(s, nums);
		System.out.print(result);
	}

}
class Solution61
{
	public int minSubArrayLen(int s,int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;
		int result=Length+1;
		
		int start=0;
		int end=0;
		int Sum=0;
		
		while(start<Length && end<Length)
		{
			//如果Sum<s,end右移
			while(Sum<s && end<Length)
				Sum+=nums[end++];
			//如果Sum>=s,start右移
			while(Sum>=s && start<=end)
			{
				result=Math.min(result, end-start);
				Sum-=nums[start++];
			}		
		}
		//如果最后没有找到则返回0
		return result==Length+1?0:result;
	}
}