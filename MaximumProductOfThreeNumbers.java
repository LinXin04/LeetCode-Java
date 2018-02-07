/**
 * 题目：给定一个数组，求该数组中任意三个数字的最大乘积。
 * 例如：
 * Input: [1,2,3]
 * Output: 6
 * Input: [1,2,3,4]
 * Output: 24
 * 解题思路：
 * 要注意的是：数组中既有正数也有负数
 * 我们首先对数组进行排序，则最大的乘积只有两种可能：
 * nums[0]*nums[1]*nums[n-1]
 * nums[n-1]*nums[n-2]*nums[n-3]
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);

		Solution202 sl=new Solution202();
		System.out.println("结果是："+sl.maximumProduct(nums));
	}
}
class Solution202
{
	public int maximumProduct(int[] nums)
	{
		if(nums==null || nums.length<3) return 0;
		int n=nums.length;
		
		Arrays.sort(nums);
		return Math.max(nums[0]*nums[1]*nums[n-1], nums[n-1]*nums[n-2]*nums[n-3]);
	}
}
