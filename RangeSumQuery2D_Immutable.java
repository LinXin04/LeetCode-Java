/**
 * 题目：给定一个二维数组matrix[][]，以及两个坐标点(row1,col1)(row2,col2)，求由两个坐标点围成的矩形区域中的元素之和。
 * 解题思路：
 * 利用动态规划的思想。
 * 定义dp[i][j]为区间(0,0)-(i,j)这个矩形区域中的所有元素之和。
 * dp[n+1][n+1]
 * dp[i][j]=dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1]+matrix[i-1][j-1]
 * 
 * result=dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1]
 */
public class RangeSumQuery2D_Immutable {

}
class NumMatrix
{
	public NumMatrix(int[][] matrix)
	{
		if(matrix==null || matrix.length==0)  return;
		
		int m=matrix.length;
		int n=matrix[0].length;
		dp=new int[m+1][n+1];
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i-1][j-1];
			}
		}
	}
	public int sumRegion(int row1,int col1,int row2,int col2)
	{
		return dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1];
	}
	private int [][]dp;
}
