/**
 * 题目：爬梯子问题。
 * 给定一个整数代表梯子的高度，每次只能爬1层或者2层，问一共有多少种爬法。
 * 解题思路：
 * 动态规划。类似于斐波那契数列。
 * dp[i]=dp[i-1]+dp[i-2]
 *
 */
import java.util.Scanner;
public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println("请输入整数n:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		Solution262 sl=new Solution262();
		System.out.println("结果是："+sl.climStairs(n));
	}
}
class Solution262
{
	public int climStairs(int n)
	{
		int []dp=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++)
			dp[i]=dp[i-1]+dp[i-2];
		return dp[n];
	}
}