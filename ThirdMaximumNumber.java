/**
 * 题目：第三大数：给定一个非空数组，返回它的第三大元素（这里的第三大指的是严格意义上的第三大，即是严格的小于，不是小于等于），如果没有则返回最大的元素
 * 例如：
 * Input: [3, 2, 1]  Output: 1
 * Input: [1, 2] Output: 2
 * Input: [2, 2, 3, 1] Output: 1
 * 解题思路：
 * 我们用三个变量first, second, third来分别保存第一大，第二大，和第三大的数，
 * 然后我们遍历数组，如果遍历到的数字大于当前第一大的数first，那么三个变量各自错位赋值，
 * 如果当前数字大于second，小于first，那么就更新second和third，
 * 如果当前数字大于third，小于second，那就只更新third
 * 
 */
import java.util.Scanner;

public class ThirdMaximumNumber {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution56 sl=new Solution56();
		int result=sl.thirdMax(nums);
		System.out.println("结果是："+result);
	}
}

class Solution56
{
	public int thirdMax(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;
		
		//初始化第一、第二、第三大元素.注意要初始化为long型，否则的话当数组中真的存在Integer.MIN_VALUE时，就不好判断最后一步
		long first=Long.MIN_VALUE;
		long second=Long.MIN_VALUE;
		long third=Long.MIN_VALUE;
		
		for(int i=0;i<Length;i++)
		{
			if(nums[i]>first)
			{
				third=second;
				second=first;
				first=nums[i];
			}else if(nums[i]>second && nums[i]<first)
			{
				third=second;
				second=nums[i];
			}else if(nums[i]>third && nums[i]<second && nums[i]<first)
			{
				third=nums[i];
			}
		}
		if(third==second || third==Long.MIN_VALUE) return (int)first;
		else  return (int)third;
	}
}