/**
 * 题目：给定一个长度为n的数组，每次可以对其中的n-1个数字进行加1或者减1，问最少需要多少次这样的操作才能让数组中所有的数字相等。
 * 例如：
 * Input:
 * [1,2,3]
 * Output:
 * 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * 解题思路：
 * 1、对数组进行排序。那么最后我们肯定是希望所有的数字变成其中位数（奇数：最中间的数字；偶数：最中间的两个数字中的一个）
 * 2、两端 的两个数字变成中间数字需要的步数正是他们的差值
 */
import java.util.Arrays;
import java.util.Scanner;
public class MinimumMovesToEqualArrayElements02 {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution189 sl=new Solution189();
		System.out.println("结果是："+sl.minMoves2(nums));
	}
}

class Solution189
{
	public int minMoves2(int[] nums)
	{
		if(nums.length==0) return 0;
		int result=0,i=0,j=nums.length-1;
		
		//先排序
		Arrays.sort(nums);
		
		while(i<j)
		{
			result+=nums[j--]-nums[i++];
		}
		
		return result;
	}
}