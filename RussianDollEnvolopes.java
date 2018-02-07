/**
 * 题目：俄罗斯套娃信件。给定一个二维数组，每一行[w,h]代表一封信的[长、宽],如果我们像俄罗斯套娃那样套起来（外面的长和宽同时小于里面的长和宽），问一共可以套几封。
 * 解题思路：
 * 定义dp[i]为到第i个信封为止，最多可以有多少个信封。
 * 1、首先我们将数组中的所有信件进行排序：先按照宽由小到大的规则，再按照高由小到大的规则。
 * 2、然后我们依次判断每一个信封，找比它小的所有的信封中满足嵌套规则的信封。
 * 更新dp[i]=max(dp[j]+1,dp[i])
 * 更新result=max(result,dp[i])
 */
import java.util.Comparator;
import java.util.Arrays;

public class RussianDollEnvolopes {
	public static void main(String[] args) {
	}
}

class Solution276
{
	public int maxEnvelopes(int[][] envelopes)
	{
		if(envelopes==null || envelopes.length==0 || envelopes[0]==null || envelopes[0].length==0) return 0;
		int n=envelopes.length;

		int result=0;
		int []dp=new int[n];
		Arrays.fill(dp, 1);
		
		Arrays.sort(envelopes,new Comparator<int[]>()
		{
			public int compare(int[] arr1,int[] arr2)
			{
				if(arr1[0]==arr2[0])
					//1-2：从小到大；2-1：从大到小
					return arr1[1]-arr2[1];
				else
					return arr1[0]-arr2[0];
			}
		});
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1])
					dp[i]=Math.max(dp[i], dp[j]+1);
			}
			result=Math.max(result, dp[i]);
		}
		return result;
	}
}