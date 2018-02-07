/**
 * 题目：在上面一题的基础上，允许返回重复的数字。
 * 例如：
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 * 解题思路：
 * 将nums1的内容存入一个HashMap，遍历nums2,如果遇到一个相同的，则存入结果集中，同时相应的HashMap-1.
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class IntersectionOfTwoArrays02 {

	public static void main(String[] args) {
		System.out.println("请输入数组1：");
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String st1[]=s1.split(" ");
		int nums1[]=new int[st1.length];
		for(int i=0;i<st1.length;i++)
			nums1[i]=Integer.parseInt(st1[i]);
		
		System.out.println("请输入数组2: ");
		String s2=sc.nextLine();
		String st2[]=s2.split(" ");
		int nums2[]=new int[st2.length];
		for(int i=0;i<st2.length;i++)
			nums2[i]=Integer.parseInt(st2[i]);
		
		Solution197 sl=new Solution197();
		int result[]=sl.intersection(nums1, nums2);
		System.out.println("结果是：");
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}

}
class Solution198
{
	public int[] insersect(int[] nums1,int[] nums2)
	{
		if(nums1==null || nums2==null) return null;
		
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		ArrayList<Integer> result=new ArrayList<Integer>();
		
		//将nums1加入map
		for(int i=0;i<nums1.length;i++)
		{
			if(map.containsKey(nums1[i])) 
				map.put(nums1[i], map.get(nums1[i])+1);
			else
				map.put(nums1[i], 1);
		}
		
		//遍历nums2
		for(int i=0;i<nums2.length;i++)
		{
			if(map.containsKey(nums2[i]) && map.get(nums2[i])!=0)
			{
				result.add(nums2[i]);
				map.put(nums2[i], map.get(nums2[i])-1);
			}
		}
		
		int temp[]=new int[result.size()];
		for(int i=0;i<result.size();i++)
			temp[i]=result.get(i);
		return temp;
	}
}
