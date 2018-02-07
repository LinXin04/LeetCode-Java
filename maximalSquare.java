/**
 * 题目：给定一个矩阵，里面只包含0和1，求由1围成的正方形的最大面积
 * 例如：
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 * 解题思路：
 * 动态规划。
 * dp[i][j]:代表以i,j为正方形右下角的最大正方形的边长。
 * dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
 */
import java.util.ArrayList;
import java.util.Scanner;
public class maximalSquare {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Character>> temp=new ArrayList<ArrayList<Character>>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String st[]=s.split(" ");
			ArrayList<Character> t=new ArrayList<Character>();
			for(int i=0;i<st.length;i++)
				t.add(st[i].charAt(0));
			temp.add(t);
		}
		
		char[][] matrix=new char[temp.size()][temp.get(0).size()];
		for(int i=0;i<temp.size();i++)
		{
			for(int j=0;j<temp.get(i).size();j++)
				matrix[i][j]=temp.get(i).get(j);
		}
		
		Solution269 sl=new Solution269();
		System.out.println("结果是："+sl.maximalSquare(matrix));
	}
}
class Solution269
{
	public int maximalSquare(char[][] matrix)
	{
		if(matrix==null || matrix.length==0) return 0;
		int m=matrix.length;
		int n=matrix[0].length;
		int dp[][]=new int[m][n];
		int max=0;
		
		//第一列
		for(int i=0;i<m;i++)
		{
			dp[i][0]=matrix[i][0]-'0';
			max=Math.max(max, dp[i][0]);
		}
		//第一行
		for(int i=0;i<n;i++)
		{
			dp[0][i]=matrix[0][i]-'0';
			max=Math.max(max, dp[0][i]);
		}
		
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
			{
				dp[i][j]=matrix[i][j]=='1'?Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1]))+1:0;
				max=Math.max(max, dp[i][j]);
			}
		}
		return max*max;
	}
}