/**
 * 题目：给定一个数组，里面含有2n个元素，两两相互组合得到n个组合，即(a1,b1),(a2,b2),(a3,b3).....(an,bn).求得一个min(ai,bi)的加和最大的结果。
 * 例如：
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * 解题思路：
 * 现将数组进行排序。
 * 最大的和=（a0,a2,...a[2n-2]）
 */
import java.util.Arrays;
import java.util.Scanner;
public class ArrayPartition01 {

	public static void main(String[] args) {
		System.out.println("请输入一个数组：");
		Scanner sc=new Scanner(System.in);
		String st=sc.nextLine();
		String s[]=st.split(" ");
		int nums[]=new int[s.length];
		for(int i=0;i<s.length;i++)
			nums[i]=Integer.parseInt(s[i]);
		
		Solution65 sl=new Solution65();
		int result=sl.arrayPairSum(nums);
		System.out.println("结果是："+result);
	}

}
class Solution65
{
	public int arrayPairSum(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int Length=nums.length;
		
		//先排序
		Arrays.sort(nums);
		int maxSum=0;
		for(int i=0;i<nums.length;i++)
		{
			if(i%2==0)
				maxSum+=nums[i];
		}
		return maxSum;
	}
}