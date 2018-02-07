/**
 * 题目：摆动排序。给定一个数组，求其摆动排序的序列。 nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 例如：
 * given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * 解题思路：
 * O(N)的解法。
 * 根据题目要求的nums[0] <= nums[1] >= nums[2] <= nums[3]....，我们可以总结出如下规律：
 * 当i为奇数时，nums[i] >= nums[i - 1]
 * 当i为偶数时，nums[i] <= nums[i - 1]
 * 我们对每一个数字根据其奇偶性，如果不符合条件就和前面的数字交换位置
 *
 */
import java.util.Scanner;
public class WiggleSort {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution200 sl=new Solution200();
		sl.wiggleSort(nums);
		System.out.println("结果是：");
		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i]+" ");
	}
}
class Solution200
{
	public void wiggleSort(int nums[])
	{
		if(nums==null || nums.length<=1) return;
		for(int i=1;i<nums.length;i++)
		{
			if((i%2==0 && nums[i]>nums[i-1]) || (i%2==1 && nums[i]<nums[i-1]))
			{
				int temp=nums[i];
				nums[i]=nums[i-1];
				nums[i-1]=temp;
			}
		}
	}
}