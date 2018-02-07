/**
 * 题目：给定两个数组，求他们相交的元素
 * 例如：
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * 解题思路：将一个数组nums1变为集合的形式，结果集也是集合的形式。
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class IntersectionOfTwoArrays {
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

class Solution197
{
	public int[] intersection(int[] nums1,int[] nums2)
	{
		if(nums1==null || nums2==null) return null;
	
		Set<Integer> set1=new HashSet<Integer>();
		Set<Integer> temp=new HashSet<Integer>();
		
		for(int i=0;i<nums1.length;i++)
			set1.add(nums1[i]);
		
		for(int j=0;j<nums2.length;j++)
		{
			if(set1.contains(nums2[j]))
				temp.add(nums2[j]);
		}
		
		int []result=new int[temp.size()];
		int i=0;
		for(int num:temp)
			result[i++]=num;
		
		return result;
	}
}