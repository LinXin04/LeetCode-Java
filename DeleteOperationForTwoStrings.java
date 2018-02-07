/**
 * 题目：给两个单词，每次只能增删一个字符，从一个单词变到另一个需要多少步。可以对两个字符串进行操作
 * 例如：
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * 解题思路：
 * 实际上就是求两个字符串的相同部分，再用两个字符串的长度减去公共部分的长度，加和即为需要改变的次数。
 * 即为求解最长公共子序列的问题.
 * 定义一个dp[n1+1][n2+1]代表word1的前i个字符和word2的前j个字符组成的两个单词的最长公共子序列。
 * dp[i][j]=dp[i-1][j-1]+1,如果word1[i-1]=word2[i-2];
 * 否则dp[i][j]=max(dp[i-1][j],dp[i][j-1])
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class DeleteOperationForTwoStrings {
	public static void main(String[] args) {
		System.out.println("请输入word1:");
		Scanner sc=new Scanner(System.in);
		
		String word1=sc.nextLine();
		System.out.println("请输入word2:");
		String word2=sc.nextLine();
		
		Solution249 sl=new Solution249();
		System.out.println("结果是："+sl.minDistance(word1, word2));
	}
}
class Solution249
{
	public int minDistance(String word1,String word2)
	{
		if(word1==null && word2==null) return 0;
		if(word1.length()==0 && word2.length()==0) return 0;
		
		int m=word1.length();
		int n=word2.length();
		
		int [][]dp=new int[m+1][n+1];
		
		for(int i=0;i<=m;i++)
		{
			for(int j=0;j<=n;j++)
			{
				if(i==0 || j==0) dp[i][j]=0;
				else if(word1.charAt(i-1)==word2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return n+m-2*dp[m][n];
	}
}