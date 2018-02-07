/**
 * 题目：给定一个数组，求最长递增子序列。
 * 例如：
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * 解题思路：
 * O(N^2):使用两个指针i,j，遍历i:0-n;j:0-i;类似于暴力搜索
 * dp[i]:表示以nums[i]结尾的最长递增子序列
 * 
 * 还有一种O(NlogN)的方法：
 * 定义dp[i]为长度为i的升序序列中末尾最小的序列的末尾元素。
 * 先建立一个数组ends，把首元素放进去，然后比较之后的元素，如果遍历到的新元素比ends数组中的首元素小的话，替换首元素为此新元素，如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。如果遍历到的新元素比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，以此类推直至遍历完整个nums数组，此时ends数组的长度就是我们要求的LIS的长度
 * 注意这样求得的结果不一定是最长的递增子序列，只是长度相等而已。
 */
import java.util.Arrays;
import java.util.Scanner;
public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");

		int []nums=new int[st.length];
		for(int i=0;i<st.length;i++)
			nums[i]=Integer.parseInt(st[i]);
	}
}
class Solution271
{
//	暴力
//	public int lengthOfLIS(int[] nums)
//	{
//		if(nums==null || nums.length<=0) return 0;
//		int dp[]=new int[nums.length];
//		Arrays.fill(dp, 1);
//		int result=0;
//		
//		for(int i=0;i<nums.length;i++)
//		{
//			for(int j=0;j<i;j++)
//			{
//				if(nums[i]>nums[j])
//					dp[i]=Math.max(dp[i], dp[j]+1);
//			}
//			result=Math.max(result, dp[i]);
//		}
//		return result;
//	}
//二分查找
	public int lengthOfLIS(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int result=0;
		int n=nums.length;
		int dp[]=new int[n];
		
		//首先将首元素加入
		dp[0]=nums[0];
		//一次遍历后面的元素
		for(int i=1;i<n;i++)
		{
			//如果比最小的小
			if(nums[i]<dp[0])
				dp[0]=nums[i];
			else if(nums[i]>dp[result])
				dp[++result]=nums[i];
			else
			{
				int left=0,right=result;
				while(left<=right)
				{
					int mid=(left+right)/2;
					if(dp[mid]<nums[i]) left=mid+1;
					else right=mid-1;
				}
				dp[right]=nums[i];
			}		
		}
		return result+1;
	}
}