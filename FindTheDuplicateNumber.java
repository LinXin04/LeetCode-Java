/**
 * 题目:给定一个含有n+1个整数的数组，其中每个元素的取值都是1-n,证明至少有一个重复的元素存在，并返回该元素。
 * 要求：复杂度小于O(N^2),不分配多余的空间，不允许修改数组中的元素
 * 解题思路：
 * 二分搜索法
 * 首先我们找到中间的数mid,注意不是nums[mid]，统计小于mid的数一共多少，如果该数大于mid，则说明重复的元素小于mid，否则大于mid
 *
 */
import java.util.Scanner;
public class FindTheDuplicateNumber {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
		{
			nums[i]=Integer.parseInt(st[i]);
		}
		Solution91 sl=new Solution91();
		int result=sl.findDuplicate(nums);
		System.out.println("结果是："+result);
	}

}
class Solution91
{
	public int findDuplicate(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;
		
		//定义两头的元素
		int min=0;
		int max=Length-1;
		while(min<=max)
		{
			int mid=(min+max)/2;
			//遍历整个数组，寻找比mid小的元素的个数
			int amount=0;
			for(int i=0;i<Length;i++)
			{
				if(mid>=nums[i]) amount++;
			}
			
			//如果amount>mid,则在前半部分查找
			if(amount>mid)
				max=mid-1;
			else
				min=mid+1;
		}
		return min;
	}
}