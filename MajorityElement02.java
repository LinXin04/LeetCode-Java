/**
 * 题目：给定一个数组（不是有序的数组），寻找数组中元素个数大于n/3的元素
 * 阶梯思路：
 * 首先需要知道的是：任意一个数组出现次数大于n/3的众数最多有两个。
 * 1.声明两个数：nums1和nums2. 两个计数器count1和count2. 
 * 2.遍历整个数组，如果该元素与nums1或者nums2相同，则count1和count2都加1
 * 3.如果count1和count2为0，将遍历到的该元素赋给nums1和nums2
 * 4.否则，count1和count2减1
 * 5.重新扫描一遍，记录nums1和nums2的出现次数，判断是否大于n/3
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class MajorityElement02 {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<nums.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution93 sl=new Solution93();
		ArrayList<Integer> result=sl.majorityElement(nums);
		System.out.println("结果是：");
		System.out.print("[ ");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.print("]");
		
	}
}
class Solution93
{
	public ArrayList<Integer> majorityElement(int[] nums)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(nums==null || nums.length==0) return result;
		int Length=nums.length;
		
		int nums1=0;
		int nums2=0;
		int count1=0;
		int count2=0;
		
		for(int i=0;i<Length;i++)
		{
			if(nums1==nums[i])
				count1++;
			else if(nums2==nums[i])
				count2++;
			else if(count1==0)
			{
				nums1=nums[i];
				count1++;
			}
			else if(count2==0)
			{
				nums2=nums[i];
				count2++;
			}
			else
			{
				count1--;
				count2--;
			}
		}
		
		count1=0;
		count2=0;
		for(int i=0;i<Length;i++)
		{
			if(nums[i]==nums1) count1++;
			//注意：这里一定要用else if，这是为了防止重复
			else if(nums[i]==nums2) count2++;
		}
		if(count1>Length/3) result.add(nums1);
		if(count2>Length/3) result.add(nums2);
		return result;
	}
}