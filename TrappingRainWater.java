/**
 * 题目：水槽。给定一个数组，代表水槽的高度，求这些水槽最多可以积蓄多少水。
 * 解题思路：定义两个指针，分别指向水槽的开始和结束，首先判断两边谁最小，从最小的那边开始遍历；
 * 如果当前水槽的高度<min值，那么代表此水槽可以积水，将其加入到结果集中。
 *
 */
import java.io.*;
public class TrappingRainWater {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution67 sl=new Solution67();
		int result=sl.trap(nums);
		System.out.println("结果是："+result);
	}
}
class Solution67
{
	public int trap(int[] height)
	{
		int result=0;
		if(height==null || height.length<=1) return result;
		
		int left=0;
		int right=height.length-1;
		
		while(left<right)
		{
			int min=Math.min(height[left], height[right]);
			if(height[left]==min)
			{
				//从第二个凹槽开始判断
				left++;
				while(left<right && height[left]<min)
				{
					result+=min-height[left];
					left++;
				}
				
			}else
			{
				//从倒数第二个凹槽开始判断
				right--;
				while(left<right && height[right]<min)
				{
					result+=min-height[right];
					right--;
				}
			}
		}
		return result;
	}
}