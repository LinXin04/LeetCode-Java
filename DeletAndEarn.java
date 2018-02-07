import java.util.Stack;

/**
 * 题目：删除和收益。给定一个数组，删除一个数，那么这个数组中比它大1和小1的数都会被删除，与此同时你可以得到这个数对应的分值，问最最多可以得到几分。
 * 解题思路：
 * 1、将所有的数装入相应的桶中value，即相同的数在一个桶中。
 * 2、skip_i：如果你保留i桶，那么0-i号桶的最优解；take_i：如果你删除i桶，那么0-i号桶的最优解
 * 3、take_i=skip_i+value[i]; skip_i=Math.max(skip,take);
 *
 */
public class DeletAndEarn {
	public static void main(String[] args) {
	}
}

class Solution292
{
	public int deleteAndEarn(int[] nums)
	{
		if(nums==null || nums.length==0) return 0;
		int n=10001;
		int []values=new int[n];
		//装桶
		for(int num:nums)
			values[num]+=num;
		
		int take=0,skip=0;
		for(int i=0;i<n;i++)
		{
			int take_i=skip+values[i];
			int skip_i=Math.max(skip, take);
			take=take_i;
			skip=skip_i;
		}
		String s="";
		return Math.max(take, skip);
	}
	
}