/**
 * 题目：最长回文串。回文串：正读反读都一样的字符串，比如 "bob", "level", "noon" 等等。
 * 例如：
 * Input: "babad"
 * Output: "bab"
 * 解题思路：
 * 1、动态规划。时间O(N^2),空间O(N^2)
 * dp[i][j]表示从i到j是否是回文串，是的话为1，不是的话为0.
 * 则当i=j时，dp[i][j]=1
 * 当j=i+1时，判断s[i]与s[j]是否相等，若相等则dp[i][j]=1
 * 当j>i+1时，判断s[i]与s[j]是否相等，以及dp[i+1][j-1]是否是回文串，若同时满足，则为1.
 * 2、Manacher方法
 */
import java.util.Scanner;
public class LongestPalindromicSubstring {
	public static void main(String[] args) {
	System.out.println("请输入字符串：");
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	
	Solution203 sl=new Solution203();
	System.out.println("结果是："+sl.longestPalindrome02(s));

	}
}
class Solution203
{
	public String longestPalindrome(String s)
	{
		if(s==null) return null;
		
		int len=s.length();
		int dp[][]=new int[len][len];
		
		//最终结果的左边界和右边界，以及长度
		int left=0,right=0,result=0;
		
		for(int i=0;i<len;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(s.charAt(j)==s.charAt(i) && (i-j==1 || dp[j+1][i-1]==1))
					dp[j][i]=1;
				if(dp[j][i]==1 && result<i-j+1)
				{
					result=i-j+1;
					left=j;
					right=i;
				}
			}
			dp[i][i]=1;
		}
		return s.substring(left, right+1);
	}
	
	//经典的manacher马拉车方法解决最长子串问题
	public String longestPalindrome02(String s)
	{
		if(s==null) return null;
		int len=s.length();
		
		//首先先对字符串做处理
		String t="$#";
		for(int i=0;i<len;i++)
		{
			t+=s.charAt(i);
			t+="#";
		}
		
		//定义p[i]表示以第i个字符为中心，向右最大回文子串的长度
		int p[]=new int[t.length()];
		//定义id为0-i-1中最长回文子串的中心位置，mx表示该回文串能延伸到的位置
		int id=0,mx=0;
		int resultMx=0, resultId=0;
		
		for(int i=0;i<t.length();i++)
		{
			if(mx>i)
				p[i]=Math.min(p[2*id-i], mx-i);
			else
				p[i]=1;
			
			//遍历超出mx的部分
			while(i+p[i]<t.length() && i-p[i]>=0 && t.charAt(i+p[i])==t.charAt(i-p[i])) 
				p[i]++;

			//更新当前的id和mx
			if(mx<i+p[i])
			{
				mx=i+p[i];
				id=i;
			}
			
			//更新结果集
			if(resultMx<p[i])
			{
				resultMx=p[i];
				resultId=i;
			}
		}
		return s.substring((resultId-resultMx)/2, (resultId+resultMx)/2-1);
	}
}