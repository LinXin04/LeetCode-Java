/**
 * 题目：交叉字符串。给定字符串s1,s2,s3，判断字符串s3是否由字符串s1与s2交叉得到。
 * 例如：
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",

 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 解题思路：
 * 凡是字符串匹配匹配或者子序列问题，就用动态规划。
 * 假设dp[i][j]是s1的前i个字符与s2的前j的字符是否匹配s3的前(i+j)个字符。
 * dp[0][0]:代表s1,s2都是空，返回true
 * dp[i][0]:当dp[i-1][0]为True，并且s1[i-1]==s3[i-1]时，为true;
 * dp[0][i]:当dp[0][i-1]为True，并且s2[i-1]==s3[i-1]时，为true;
 * dp[i][j]=(dp[i-1][j] && s1[i-1]==s3[i+j-1]) || (dp[i][j-1] && s2[j-1]==s3[i+j-1])
 */
import java.util.Arrays;
import java.util.Scanner;
public class InterleavingString {
	public static void main(String[] args) {
	System.out.println("请输入String1：");
	Scanner sc=new Scanner(System.in);
	String s1=sc.nextLine();
	System.out.println("请输入String2：");
	String s2=sc.nextLine();
	System.out.println("请输入String3：");
	String s3=sc.nextLine();
	
	Solution226 sl=new Solution226();
	System.out.println("结果是："+sl.isInterleave(s1, s2, s3));
	}
}
class Solution226
{
	public boolean isInterleave(String s1,String s2,String s3)
	{
		if(s1==null && s2==null) return s3==null;
		int len1=s1.length();
		int len2=s2.length();
		int len3=s3.length();
		if(len3!=len1+len2) return false;
		
		boolean[][] dp=new boolean[len1+1][len2+1];
		for(int k=0;k<=len1;k++)
			Arrays.fill(dp[k], false);

		dp[0][0]=true;
		
		for(int i=1;i<=len1;i++)
			dp[i][0]=dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
		for(int j=1;j<=len2;j++)
			dp[0][j]=dp[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
		
		for(int i=1;i<=len1;i++)
			for(int j=1;j<=len2;j++)
				dp[i][j]= (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1)) || (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
		
		return dp[len1][len2];	
	}
}