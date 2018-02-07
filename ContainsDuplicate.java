import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目：给定一个数组，如果里面有重复的元素，则返回True，否则返回false
 * 解题思路：用一个HashMap存储每个元素出现的次数，如果存在个数大于1的，则返回True，否则返回false
 *
 */
public class ContainsDuplicate {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);

		System.out.println("结果是：");
		Solution52 sl=new Solution52();
		boolean result=sl.containsDuplicate(nums);
		System.out.println("结果是："+result);
		
	}

}
class Solution52
{
	public boolean containsDuplicate(int[] nums)
	{
		if(nums==null || nums.length==0) return false;
		int Length=nums.length;
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<Length;i++)
		{
			if(!map.containsKey(nums[i]))
			{
				map.put(nums[i], 1);
			}else
			{
				return true;
			}
		}
		return false;
	}
}