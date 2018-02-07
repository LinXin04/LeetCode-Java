/**
 * 题目：给定若干个由0和1组成的字符串数组，现在限定使用m个0和n个1，每个0和1至多使用1次，问最多能组成多少个给定的字符串。
 * 解题思路：
 * 动态规划。
 * 有点类似于0-1背包问题。
 * dp[i][j]表示有i个0和j个1时最多能组成的字符串的个数
 * dp[i][j]=max(dp[i][j],dp[i-zeroes][j-ones]+1):zeroes、ones分别代表当前的字符串的0和1的个数
 *
 */
public class OnesAndZeroes {
	public static void main(String[] args) {
	
	}
}

class Solution288 {
	   public int findMaxForm(String[] strs, int m, int n) {
	       if(strs==null || strs.length==0) return 0;
	       
	       int dp[][]=new int[m+1][n+1];
	       
	       for(String str:strs)
	       {
	    	   int zeroes=0,ones=0;
	    	   for(char ch:str.toCharArray())
	    	   {
	    		   if(ch=='0') ++zeroes;
	    		   else ++ones;
	    	   }
	    	   
	    	   for(int i=m;i>=zeroes;i--)
	    	   {
	    		   for(int j=n;j>=ones;j--)
	    			   dp[i][j]=Math.max(dp[i][j], dp[i-zeroes][j-ones]+1);
	    	   }  
	       }
	     return dp[m][n];  
	  }
}
