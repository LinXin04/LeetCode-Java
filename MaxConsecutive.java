/**
 * 题目：给定一个二值数组（数组中只有0和1），计算最长的连续1的长度。
 * 例如：
 * Input: [1,1,0,1,1,1]  Output: 3
 * 解题思路：
 * 我们可以遍历一遍数组，用一个计数器count来统计1的个数，
 * 方法是如果当前数字为0，那么count重置为0;
 * 如果不是0，count自增1，然后每次更新结果res即可
 */
import java.util.Scanner;
public class MaxConsecutive {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int[] nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution59 sl=new Solution59();
		int result=sl.findMaxConsecutiveOnes(nums);
		System.out.println("结果是："+result);
	}
}
class Solution59
{
	public int findMaxConsecutiveOnes(int[] nums)
	{
		int result=0;
		if(nums==null || nums.length<=0) return result;
		int Length=nums.length;
		
		int count=0;
		for(int i=0;i<Length;i++)
		{
			if(nums[i]==1) count++;
			else if(nums[i]==0) count=0;
			result=Math.max(result, count);
		}
		return result;
	}
}