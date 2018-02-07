/**
 * 题目：给定一个数组，该数组中有n个元素，每个元素的范围都是1-n,其中，有的元素出现一次，有的元素重复出现两次。请找出所有1-n中该数组中没有出现的元素。不允许额外的空间
 * 例如：
 * Input:[4,3,2,7,8,2,3,1]   Output:[5,6]
 * 解题思路：
 * 1.扫描整个数组，计算出数组中的元素nums[i]应该在的位置val，将val位置的元素标为负数，代表这个数字已出现在数组中
 * 2.遍历整个数组，如果某个数字为负数，则代表该位置val+1在数组中出现过，否则表示没有出现过
 */
import java.util.ArrayList;
import java.util.Scanner;
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution57 sl=new Solution57();
		ArrayList<Integer> result=sl.findDisappearedNumbers(nums);
		System.out.println("结果是：");
		System.out.print("[ ");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.print("]");
	}
}

class Solution57
{
	public ArrayList<Integer> findDisappearedNumbers(int[] nums)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(nums==null || nums.length==0 ||nums.length==1) return result;
		int Length=nums.length;
		
		for(int i=0;i<Length;i++)
		{
			//该元素应该在的下标
			int index=Math.abs(nums[i])-1;
			//如果大于0，则标为负数
			if(nums[index]>0)
				nums[index]=-nums[index];
		}
		
		for(int i=0;i<Length;i++)
		{
			if(nums[i]>0)
				result.add(i+1);
		}
		return result;
	}
}