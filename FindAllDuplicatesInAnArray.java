/**
 * 题目：给定一个数组，该数组中有n个元素，每个元素的范围都是1-n,其中，有的元素出现一次，有的元素重复出现两次。请找出所有1-n中该数组所有出现过两次的元素。不允许额外的空间
 * 例子：
 * Input:[4,3,2,7,8,2,3,1]  Output:[2,3]
 * 解题思路：
 * 扫描整个数组，计算出数组中的元素nums[i]应该在的位置val。
 * 如果该位置的数为正数，则将val位置的元素标为负数，代表这个数字已出现在数组中一次。
 * 如果该位置的数为负数，则代表该元素出现了第二次了，符合要求，加入result中。
 * 
 */
import java.util.ArrayList;
import java.util.Scanner;

public class FindAllDuplicatesInAnArray {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution58 sl=new Solution58();
		ArrayList<Integer> result=sl.findDuplicates(nums);
		System.out.println("结果是：");
		System.out.print("[ ");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.print("]");
	}
}

class Solution58
{
	public ArrayList<Integer> findDuplicates(int[] nums)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(nums==null || nums.length==0 || nums.length==1) return result;
		int Length=nums.length;
		
		for(int i=0;i<Length;i++)
		{
			int index=Math.abs(nums[i])-1;
			if(nums[index]>0)
				nums[index]=-nums[index];
			else if(nums[index]<0)
				result.add(index+1);
		}
		return result;
	}
}