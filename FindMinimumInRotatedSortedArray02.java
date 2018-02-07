/**
 * 题目：给定一个数组，该数组按照升序排列，含有重复元素。在某个位置旋转了，求最小元素。
 * 解题思路：
 * 原来我们是依靠中间和边缘元素的大小关系，来判断哪一半是不受rotate影响，仍然有序的。
 * 而现在因为重复的出现，如果我们遇到中间和边缘相等的情况，我们就无法判断哪边有序，因为哪边都有可能有序。
 * 解决的办法只能是对边缘移动一步，直到边缘和中间不在相等或者相遇，这就导致了会有不能切去一半的可能。
 * 时间复杂度为O(N)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMinimumInRotatedSortedArray02 {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution76 sl=new Solution76();
		int result=sl.findMin(nums);
		System.out.println("结果是："+result);
	}
}
class Solution76
{
	public int findMin(int[] nums)
	{
		if(nums==null || nums.length==0) return Integer.MAX_VALUE;
		
		int left=0;
		int right=nums.length-1;
		int min=nums[0];
		
		while(left<right-1)
		{
			int mid=(left+right)/2;
			//依次判断中间的元素与左边的元素的大小
			if(nums[left]<nums[mid])
			{
				//记录左边的最小元素
				min=Math.min(nums[left], min);
				left=mid;	
			}else if(nums[left]>nums[mid])
			{
				//记录右边的最小元素
				min=Math.min(nums[right], min);
				right=mid;
			}else
			{
				left++;
			}
		}
		min=Math.min(nums[left], min);
		min=Math.min(nums[right], min);
		return min;
	}
}