/**
 * 题目：给定一个数组，由n个元素组成，其中元素都为（0,1,2,3,...n）,寻找在这个里面丢失的元素并返回。
 * 例如：
 * Given nums = [0, 1, 3] return 2.
 * 解题思路：
 * 1.先将数组进行排序，然后进行二分查找。
 * 首先定义mid,如果查找的nums[mid]!=mid的话，说明丢失的元素在mid以及mid的左边。
 * O(NlogN)
 * 2.大小为n的数组里的所有数都是0 - n之间的数，作为等差数列，如果没有缺失的时候它的和是能O(1)计算出来的.
 * 所以我们遍历一遍，用期望数组和减去实际数组和，就是缺失的整数。
 * O(N)
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class MissingNumber {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("结果是：");
		Solution54 sl=new Solution54();
		int result=sl.missingNumber(nums);
		System.out.println("结果是："+result);
	}
}
class Solution54
{
	public int missingNumber(int[] nums)
	{
		int result;
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;
		
		//未缺失的数组实际上有n+1个元素
		int ideaSum=(Length+1)*(0+Length)/2;
		int realSum=0;
		for(int i=0;i<Length;i++)
			realSum+=nums[i];
		result=ideaSum-realSum;
		return result;
		
//		Arrays.sort(nums);
//		int start=0;
//		int end=Length-1;
//		while(start<=end)
//		{
//			int mid=(start+end)/2;
//			if(nums[mid]!=mid)
//				end=mid-1;
//			else
//				start=mid+1;
//		}
//		if(nums[start]==start)
//			return start+1;
//		else
//			return start;
	}
}