/**
 * 题目：给定一个数组，该数组按照升序排列，且无重复元素。在某个位置旋转了，求最小元素。
 * 例如：
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 返回0
 * 解题思路：
 * 二分查找。
 * 首先判断该数组是否旋转了：比较最后一个元素与第一个元素的大小，若最后的元素大于第一个元素，说明没有旋转，直接返回最小的。
 * 否则：判断中间位置的数是否大于第一个数，如果是，则在右边寻找；否则，在右边寻找。
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		String s=buf.readLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution75 sl=new Solution75();
		int result=sl.findMin(nums);
		System.out.println("结果是："+result);

	}

}
class Solution75
{
	public int findMin(int[] nums)
	{
		if(nums==null || nums.length==0) return Integer.MAX_VALUE;
		int Length=nums.length;
		int left=0;
		int right=Length-1;
		
		//首先判断是否旋转
		if(nums[left]<=nums[right])
		{
			return nums[left];
		}else
		{
			while(left!=right-1)
			{
				int mid=(left+right)/2;
				if(nums[mid]>nums[left])
				{
					left=mid;
				}else
				{
					right=mid;
				}
			}
			return Math.min(nums[left], nums[right]);
		}
	}
}