/**
 * 题目：猜数字大小02。
 * 给定一个数字n,我首先在1-n之间选择一个数字，然后由你去猜这个数字是几，如果你猜错了，我会提示你你的答案比真实答案高了还是低了，直到猜中。
 * 在每次猜错时，你都需支付一定的费用，这个费用就是你猜错的数字的大小。问如果能保证赢，至少要支付多少钱。
 * 解题思路：
 * 定义dp[i][j]:区间[i,j]上的猜中一个数字至少花费的钱数。
 * local_min=k+max(dp[i][k-1],dp[k+1][j])  (i<k<j)
 * global_min=min(global_min,local_min)
 * dp[i][j]=j==i+1?j:global_min
 *
 */
public class GuessNumberHigherOrLower02 {
	public static void main(String[] args) {
	}
}

class Solution278
{
	public int getMoneyAmount(int n)
	{
		if(n<=1) return 0;
		
		int dp[][]=new int[n+1][n+1];
		
		for(int i=2;i<=n;i++)
		{
			for(int j=i-1;j>0;j--)
			{
				int global_min=Integer.MAX_VALUE;
				for(int k=j+1;k<i;k++)
				{
					//将[j,i]从中间折断，分别看[j,k-1]和[k+1,i]
					int local_min=k+Math.max(dp[j][k-1],dp[k+1][i]);
					global_min=Math.min(global_min, local_min);
				}
				//注意这里如果i=j+1的话，要返回最小的j，因为猜j的话花费较小。
				dp[j][i]=i==j+1?j:global_min;
		}		
	}
		return dp[1][n];
   }
}