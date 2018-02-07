/**
 * 问题：最大连续子序列乘积
 * 解题思路：
 * 动态规划。
 * 与最大连续子序列和不同，这里由于乘法与加法不同，乘法中可能现在看起来非常小的一个负数，后面跟着一个负数就会得到一个很大的乘积。
 */
import java.io.*;
public class MaximumProductSubarray {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution74 sl=new Solution74();
		int result=sl.maxProduct(nums);
		System.out.println("结果是："+result);

	}

}

class Solution74
{
	public int maxProduct(int[] nums)
	{
		
		if(nums==null || nums.length==0) return Integer.MIN_VALUE;
		
		//定义当前最大值
		int curr_max=nums[0];
		//定义当前最小值
		int curr_min=nums[0];
		//定义全局最大值
		int global_max=nums[0];
		
		for(int i=1;i<nums.length;i++)
		{
			int max_copy=curr_max;
			curr_max=Math.max(Math.max(curr_max*nums[i], nums[i]), curr_min*nums[i]);
			curr_min=Math.min(Math.min(max_copy*nums[i], nums[i]), curr_min*nums[i]);
			global_max=Math.max(curr_max, global_max);
		}
		return global_max;
	}
}