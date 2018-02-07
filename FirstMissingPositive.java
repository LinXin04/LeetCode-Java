/**
 * 题目：给定一个未排序的数组，寻找第一个丢失的正整数。线性时间+不能使用额外的空间
 * 例如：
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 题目解析：
 * 交换数组元素，使得数组中第i位存放数值(i+1)。最后遍历数组，寻找第一个不符合此要求的元素，返回其下标。整个过程需要遍历两次数组，复杂度为O(n)。
 * 这里使用了一种特殊的排序方法，使得数组中的第i位存放i+1的数字。
 */
import java.util.Scanner;
public class FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] st=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution66 sl=new Solution66();
		int result=sl.firstMissingPositive(nums);
		System.out.println("结果是："+result);
	}
}

class Solution66
{
	public int firstMissingPositive(int[] nums)
	{
		int result=1;
		if(nums==null || nums.length<=0) return result;
		int Length=nums.length;
		
		//对数组进行排序，使得每个元素i+1都在i位置上
		for(int i=0;i<Length;i++)
		{
			if(nums[i]>0 && nums[i]<=Length && nums[nums[i]-1]!=nums[i])
			{
				int temp=nums[nums[i]-1];
				nums[nums[i]-1]=nums[i];
				nums[i]=temp;
				i--;
			}
		}
		//遍历一遍，寻找不符合的元素
		for(int i=0;i<Length;i++)
		{
			if(nums[i]!=i+1)
			{
				result=i+1;	
				return result;
			}
		}
		//如果没找到的话
		return Length+1;
	}
}