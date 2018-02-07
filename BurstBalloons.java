/**
 * 题目：
 * 打气球的游戏，每个气球都对应着一个数字，我们每次打爆一个气球，得到的金币数是被打爆的气球的数字和其两边的气球上的数字相乘，如果旁边没有气球了，则按1算，以此类推，求能得到的最多金币数。
 * 解题思路：
 * 使用动态规划。
 * dp[i][j]表示打爆区间[i,j]中的所有气球能得到的最多金币。
 * 边界情况，我们可以在数组的两边各填充一个1.
 * dp[i][j] = max(dp[i][j], nums[i - 1]*nums[k]*nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])                 ( i ≤ k ≤ j )
 */
import java.util.Vector;
public class BurstBalloons {
	public static void main(String[] args) {

	}
}
class Solution273 {
    public int maxCoins(int[] nums) {
    	if(nums==null || nums.length==0) return 0;
        //数组的前后各填充一个1
        int []temp=new int[nums.length+2];
        for(int i=0;i<nums.length;i++)
        	temp[i+1]=nums[i];
        temp[0]=1;
        temp[nums.length+1]=1;
       
        
        int n=temp.length;
        int[][] dp=new int[n][n];
        
        for(int len=1;len<n-1;len++)
        {
        	for(int left=1;left<n-len;left++)
        	{
        		int right=left+len-1;
        		for(int k=left;k<=right;k++)
        			dp[left][right]=Math.max(dp[left][right], temp[left-1]*temp[k]*temp[right+1]+dp[left][k-1]+dp[k+1][right]);
        	}
        }
      return dp[1][n-2];  
    }
}
