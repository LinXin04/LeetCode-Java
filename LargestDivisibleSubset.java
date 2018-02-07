/**
 * 题目：最大可整除子集合。给定一个集合，其中的所有元素都是互不相同的正整数，求它的最大可整除子集合（在这个子集合中，任意的一对元素(s,m)都满足(s%m=0或者m%s=0)
 * 例如：
 * nums: [1,2,3]
 * Result: [1,2] (of course, [1,3] will also be ok)
 * 解题思路：
 * 1、将数组按照升序进行排序。这样我们只需考虑后面的数字能否整除前面的数字。
 * 2、定义一个数组dp,dp[i]代表到数字nums[i]位置最大可整除的子集合的长度。
 * 3、定义一个数组pa,保存上一个能整除的数字的位置。
 * 4、mx表示最大子集合的长度；mx_idx表示起始数字的位置
 * 5、从后开始遍历数组
 * 6、如果nums[j]%nums[i]==0,且dp[i]<dp[j]+1,更新dp[i]和pa[i];如果dp[i]大于mx,更新mx和mx_idx。
 * 
 */
import java.util.Scanner;
import java.util.Vector;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
public class LargestDivisibleSubset {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数组：");
		String st=sc.nextLine();
		String []s=st.split(" ");
		int nums[]=new int[s.length];
		for(int i=0;i<s.length;i++)
			nums[i]=Integer.parseInt(s[i]);
		
		Solution178 sl=new Solution178();
		ArrayList<Integer> result=sl.largestDivisibleSubset(nums);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
}
class Solution178
{
	public ArrayList<Integer> largestDivisibleSubset(int[] nums)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(nums.length==0) return result;
		
		//用Arrays对数组进行排序
		Arrays.sort(nums);
		//定义两个数组
		int dp[]=new int[nums.length];
		int pa[]=new int[nums.length];
		
		int mx=0,mx_idx=0;
		
		for(int i=nums.length-1;i>=0;i--)
		{
			for(int j=i;j<nums.length;j++)
			{
				if(nums[j]%nums[i]==0 && dp[i]<dp[j]+1)
				{
					dp[i]=dp[j]+1;
					pa[i]=j;
					if(mx<dp[i])
					{
						mx=dp[i];
						mx_idx=i;
					}
				}
			}
		}
		
		for(int i=0;i<mx;i++)
		{
			result.add(nums[mx_idx]);
			mx_idx=pa[mx_idx];
		}
		return result;
	}
}