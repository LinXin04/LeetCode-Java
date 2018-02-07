import java.util.HashMap;

/**
 * 题目：Arithmetic序列。给定一个数组，判断该数组中有多少Arithmetic子序列。
 * Arithmetic子序列定义为：长度大于2的，并且每相邻两个元素之间拥有相同的差值。
 * 解题思路：
 * 动态规划。
 * 定义一个一维数组dp,dp中的元素为哈希表，这个哈希表是等差数列的差值和其长度之间的映射。
 * 遍历数组中的所有数字nums[i](0<=i<n)，对于当前遍历到的数字，从头开始遍历到当前数字nums[j](0<=j<i)，计算两个数字之间的差值diff.
 * 如果diff越界，则不做任何处理；若diff没有越界，则将dp[i]中的diff的差值映射+1；然后看dp[j]中是否有diff的映射，若有，则构成等差数列，将dp[j][d]加入结果集中，更新dp[i][d].
 *
 */
public class ArthmeticSlices02_Subsequence {
	public static void main(String[] args) {
	
	}
}
class Solution286 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length<=2) return 0;
        
        int result=0;
        HashMap<Integer,Integer>[] maps=new HashMap[A.length];
        
        for(int i=0;i<A.length;i++)
        {
        	maps[i]=new HashMap<Integer,Integer>();
        	for(int j=0;j<i;j++)
        	{
        		long diff=(long)A[i]-(long)A[j];
        		//判断是否越界
        		if(diff>Integer.MAX_VALUE || diff<Integer.MIN_VALUE) continue;
        		int d=(int) diff;
        		
        		// getOrDefault():从map对象里获取数据，如果没有数据则返回一个默认的值
        		int count=maps[j].getOrDefault(d, 0);
        		maps[i].put(d, maps[i].getOrDefault(d, 0)+count+1);
        		result+=count;
        	}
        }
        return result;
    }
}