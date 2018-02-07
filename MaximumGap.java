/**
 * 题目：寻找最大的间距。给定一个未排序的数组，寻找排好序之后两个元素之间的最大间距。
 * 要求时间复杂度为O(N)
 * 例如：
 * 给定：[5,9,8,3,15]
 * 排序后为：[3,5,8,9,15]，相邻元素之差最大的是15-9=6，返回6。
 * 解题思路：
 * 题目要求是要线性的时间和空间，那么只能用桶排序或者基排序。
 * 这里我用桶排序Bucket Sort来做，首先找出数组的最大值和最小值，然后要确定每个桶的容量，即为(最大值 - 最小值) / 个数 + 1，在确定桶的个数，即为(最大值 - 最小值) / 桶的容量 + 1，然后需要在每个桶中找出局部最大值和最小值。
 * 而最大间距的两个数不会在同一个桶中，而是后一个有效桶的最小值和前一个有效桶的最大值之间的间距。
 */
import java.util.Arrays;
import java.util.Scanner;
public class MaximumGap {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		
		Solution194 sl=new Solution194();
		System.out.println("结果是："+sl.maximumGap(nums));
	}
}
class Solution194
{
	public int maximumGap(int[] nums)
	{
		if(nums==null || nums.length<2) return 0;
		int n=nums.length;
		
		//1、首先找出数组的最大值和最小值
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			max=Math.max(max, nums[i]);
			min=Math.min(min, nums[i]);
		}
		
		//2、计算桶的 容量和桶的个数
		int bucket_size=(max-min)/n+1;
		int bucket_nums=(max-min)/bucket_size+1;
		
		//3、定义存储每个桶中最大值和最小值的数组
		int[] bMax=new int[bucket_nums];
		int[] bMin=new int[bucket_nums];
		Arrays.fill(bMax, Integer.MIN_VALUE);
		Arrays.fill(bMin, Integer.MAX_VALUE);
		
		//4、确定将数字放入几号桶中,并更新每个桶中的最大值和最小值
		for(int i=0;i<n;i++)
		{
			int index=(nums[i]-min)/bucket_size;
			bMax[index]=Math.max(bMax[index], nums[i]);
			bMin[index]=Math.min(bMin[index], nums[i]);
		}
		
		//5、求最大距离
		int result=Integer.MIN_VALUE;
		//前一个桶的最大值
		int pre=bMax[0];
		for(int i=1;i<bucket_nums-1;i++)
		{
			//如果是空桶则跳过
			if(bMax[i]==Integer.MIN_VALUE && bMin[i]==Integer.MAX_VALUE) continue;
			//结果是后一个桶的最小值-前一个桶的最大值
			result=Math.max(result, bMin[i]-pre);
			pre=bMax[i];
		}
		result=Math.max(result, bMin[bucket_nums-1]-pre);
		return result;
	}
}