/**
 * 题目：区间和计数。
 * 给定一个数组，一个上限和下限，求有多少个不同的区间使得每个区间的和都在给定的上下限之间。
 * 例如：
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 * Return 3.
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
 * 解题思路：
 * 归并排序。在混合的过程中给[start,mid)与(mid,end]进行排序了。
 * 将数组分成左右两个子数组。整个结果等于左边的结果+右边的结果+合并的结果。
 * 合并的过程中，遍历左边，对于每一个i，我们在右半边找出m和n,使得：
 * m是第一个满足sums[m]-sums[i]>=lower的第一个下标
 * n是第一个满足sums[n]-sums[j]>upper的第一个下标
 * 此外，我们需要定义一个寄存器cache来存储所有满足sums[t]<sums[i]的数字来完成混合排序。
 * sums[]可能会有整型溢出，要用long型
 */
import java.util.Scanner;
public class CountOfRangeSum {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int nums[]=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
		System.out.println("请输入下界：");
		int lower=sc.nextInt();
		System.out.println("请输入上界：");
		int upper=sc.nextInt();
		
		Solution261 sl=new Solution261();
		System.out.println("结果是："+sl.countRangeSum(nums, lower, upper));
	}
}

class Solution261
{
	public int countRangeSum(int[] nums,int lower,int upper)
	{
		if(nums==null || nums.length==0) return 0;
		int len=nums.length;
		
		//定义存储从nums[0]到nums[i]的和的数组
		long[] sums=new long[len+1];
		for(int i=0;i<len;i++)
			sums[i+1]=sums[i]+nums[i];
		return merge(sums,0,len+1,lower,upper);
	}
	
	public int merge(long[] sums,int start,int end,int lower,int upper)
	{
		if(end-start<=1) return 0;
		int mid=(start+end)/2;
		int count=merge(sums,start,mid,lower,upper)+merge(sums,mid,end,lower,upper);
		
		int m=mid,n=mid,t=mid;
		long[] cache=new long[end-start];
		
		for(int i=start,r=0;i<mid;i++,r++)
		{
			while(m<end && sums[m]-sums[i]<lower) m++;
			while(n<end && sums[n]-sums[i]<=upper) n++;
			//将右边所有的比当前nums[i]小的元素赋值到cache中
			while(t<end && sums[t]<sums[i]) cache[r++]=sums[t++];
			
			cache[r]=sums[i];
			count+=n-m;
		}
		//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		//从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
		System.arraycopy(cache, 0, sums, start, t-start);
		return count;
	}
}