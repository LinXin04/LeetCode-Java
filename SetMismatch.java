/**
 * 题目：给定一个数组，里面的数字是从1-n的连续数。但是其中有一个数字是重复的，并，请返回重复的数字和缺失的数字。
 * 解题思路：
 * 
 *
 */
import java.util.Scanner;
public class SetMismatch {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		
		Solution207 sl=new Solution207();
		int result[]=sl.findErrorNums(nums);
		System.out.println("结果是：");
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+" ");
	}
}

class Solution207
{
	public int[] findErrorNums(int[] nums)
	{
		if(nums==null) return null;
		if(nums.length==0) return nums;
		
		int n=nums.length;
		int[] result=new int[2];
		int sum=0;
		int all=n*(n+1)/2;
		
		//遍历一遍数字
		for(int i:nums)
		{
			sum+=Math.abs(i);
			//i本应该在|i-1|的位置上，这个位置上的数如果<0,说明i重复了
			if(nums[Math.abs(i)-1]<0) result[0]=Math.abs(i);
			else nums[Math.abs(i)-1]*=-1;
		}
	
		result[1]=all-sum+result[0];
		return result;
	}
}