/**
 * 题目：给定一个数组和一个整数k，当且仅当存在两个不同的下标i和j，满足nums[i]=nums[j]，且|i-j|<=k时返回True，否则返回false
 * 解题思路：
 * 依然是用HashMap存储每一个nums[i]以及他们的下标。
 * 如果这个元素之前不在，则存入map，如果之前就有，则判断该元素与现在元素之间的下标绝对值是否小于等于k,若是，则返回true,否则更新num[i]在map中的下标值为当前的i
 * 
 */
import java.util.HashMap;
import java.util.Scanner;
public class ContainsDuplicate02 {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		System.out.println("请输入数字k：");
		int k=sc.nextInt();

		System.out.println("结果是：");
		Solution53 sl=new Solution53();
		boolean result=sl.containsNearbyDuplicate(nums,k);
		System.out.println("结果是："+result);

	}

}

class Solution53
{
	public boolean containsNearbyDuplicate(int[] nums,int k)
	{
		if(nums==null || nums.length==0 || nums.length==1) return false;
		int Length=nums.length;
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<Length;i++)
		{
			//如果不存在该元素，则将其放入
			if(!map.containsKey(nums[i]))
			{
				map.put(nums[i], i);
			}else
			{
				//判断下标绝对值是否小于等于k，若是责返回true，否则更新当前的坐标为num[i]在map中的value
				int start=map.get(nums[i]);
				if(Math.abs(i-start)<=k)
					return true;
				else
					map.put(nums[i], i);
			}
		}
		return false;
	}
}