/**
 * 题目：给定一个没有重复元素的有序数组，返回它的连续区间。
 * 例如：
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * 解题思路：
 * 那么我只需遍历一遍数组即可.
 * 每次检查下一个数是不是递增的，如果是，则继续往下遍历;
 * 如果不是了，我们还要判断此时是一个数还是一个序列，一个数直接存入结果，序列的话要存入首尾数字和箭头“->"。
 * 我们需要两个变量i和j，其中i是连续序列起始数字的位置，j是连续数列的长度，当j为1时，说明只有一个数字，若大于1，则是一个连续序列，
 */
import java.util.ArrayList;
import java.util.Scanner;
public class SummaryRanges {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution78 sl=new Solution78();
		ArrayList<String> result=sl.summaryRanges(nums);
		System.out.print("[");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.print("]");
	}
}

class Solution78
{
	public ArrayList<String> summaryRanges(int[] nums)
	{
		ArrayList<String> result=new ArrayList<String>();
		if(nums==null || nums.length==0) return result;
		
		//开始指针和长度
		int start=0;
		while(start<nums.length)
		{
			int len=1;
			//如果后面的一个元素是连续的
			while(start+len<nums.length && nums[start+len]==nums[start]+len)
				len++;
			//后面的元素是不连续的，要分别判断是不是只有一个元素的情况
			if(len==1)
			{
				result.add(String.valueOf(nums[start]));
			}else
			{
				result.add(String.valueOf(nums[start])+"->"+String.valueOf(nums[start]+len-1));
			}
			
			start=start+len;
		}
		return result;
	}
}