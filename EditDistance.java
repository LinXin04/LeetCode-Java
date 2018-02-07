/**
 * 题目：编辑距离。
 * 求从一个字符串转变到另一个字符串需要的变换步骤，共有三种变换方式，插入一个字符，删除一个字符，和替换一个字符。
 * 解题思路：
 * 动态规划
 * dp[i][j]表示字符串s的前i个字符转换成字符串p的前j个字符所需要的步骤。
 * 首先给第一行和第一列赋值。
 * dp[i][j]=dp[i-1][j-1],当s[i-1]=p[j-1]时
 * dp[i][j]=min(dp[i-1][j-1],dp[i][j-1],dp[i-1][j])+1
 */
import java.util.Scanner;
public class EditDistance {
	public static void main(String[] args) {
		System.out.println("请输入Word1：");
		Scanner sc=new Scanner(System.in);
		String word1=sc.nextLine();
		
		System.out.println("请输入Word2：");
		String word2=sc.nextLine();
		
		Solution218 sl=new Solution218();
		System.out.println("结果是："+sl.minDistance(word1, word2));
	}
}
class Solution218
{
	public int minDistance(String word1,String word2)
	{
		if((word1==null && word2==null) || (word1.length()==0 && word2.length()==0))
			return 0;
		int m=word1.length();
		int n=word2.length();
		
		int dp[][]=new int[m+1][n+1];
		
		//定义第一行和第一列
		for(int i=0;i<=n;i++) dp[0][i]=i;
		for(int j=0;j<=m;j++) dp[j][0]=j;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(word1.charAt(i-1)==word2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1];
				else
					dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
			}
		}
		return dp[m][n];
	}
}