/**
 * 题目：给定一个长度为n的数组，每次可以对n-1个数字同时加1，问最少需要多少次这样的操作才能让数组中所有的数字相等。
 * 例如：
 * Input:
 * [1,2,3]
 * Output:
 * 3
 * Explanation:
 * Only three moves are needed (remember each move increments two elements):
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 解题思路：
 * 正常思路：
 * 每次找到最大的数字，然后对除去该数字之外的其他数字加1，知道所有的数字相等。但是这种复杂度过高。
 * 转换思路：
 * 每次给n-1个数字加1，效果等同于给那个未被选中的数字减1，直到所有的数字都减小到最小值为止。
 * 这样的话，我们只需先找到最小值，然后累加每个数与最小值之间的差值即可。
 *
 */
import java.util.Scanner;
public class MinimumMovesToEqualArrayElements {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution188 sl=new Solution188();
		System.out.println("结果是："+sl.minMoves(nums));
	}
}

class Solution188
{
	public int minMoves(int[] nums)
	{
		if(nums.length==0) return 0;
		int len=nums.length;
		
		int min=Integer.MAX_VALUE;
		int sum=0;
		
		//找到最小的值
		for(int i=0;i<len;i++)
			min=Math.min(nums[i], min);
		
		//计算结果
		for(int i=0;i<len;i++)
			sum+=nums[i]-min;
		
		return sum;
	}
}