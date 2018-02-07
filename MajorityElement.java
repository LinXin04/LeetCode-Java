/**
 * 题目：给定一个非空数组，返回它里面出现次数最多的元素。这个元素出现的次数大于（n/2）次
 * 解题思路：
 * 重复元素的个数大于（n/2）这是一个非常重要的信息。
 * 我们遍历一遍数组，如果当前元素的个数为0，则设为1;否则如果当前的元素与已有的元素相等，则个数加1;否则个数-1.当个数=0时，说明这个元素重复的次数不大于（n/2）
 */
import java.util.Scanner;
public class MajorityElement {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution50 sl=new Solution50();
		System.out.println("结果是："+sl.majorityElement(nums));

	}

}
class Solution50
{
	public int majorityElement(int[]nums)
	{
		if(nums==null || nums.length==0) return 0;
		
		int major=0;
		int count=0;
		//遍历所有的元素
		for(int i=0;i<nums.length;i++)
		{
			if(count==0)
			{
				count++;
				major=nums[i];
			}else if(major==nums[i])
			{
				count++;
			}else
			{
				count--;
			}
		}
		return major;
	}
}