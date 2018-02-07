/**
 * 题目：寻找顶端元素。给定一个相邻元素不相等的数组，找出其中的一个局部最大值，返回对应下标。一个数组可能存在很多局部最大值，在这种情况下返回任何一个峰值。
 * 解题思路：
 * 使用二分查找。如果中间元素的值大于后边的邻居元素，则在左边的元素里面有一个峰值；否则，在右边的元素里面有一个峰值。
 */
import java.io.*;
public class FindPeakElement {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入一个数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String []st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution73 sl=new Solution73();
		int result=sl.findPeakElement(nums);
		System.out.println("结果是："+result);
	}
}

class Solution73
{
	public int findPeakElement(int[] nums)
	{
		int result=-1;
		if(nums==null || nums.length==0) return result;
		//定义左边的和右边的
		int left=0;
		int right=nums.length-1;
		while(left<=right)
		{
			if(left==right) return left;
			int mid=(left+right)/2;
			if(nums[mid]>nums[mid+1])
				right=mid;
			else
				left=mid+1;
		}
		return nums.length;
	}
}