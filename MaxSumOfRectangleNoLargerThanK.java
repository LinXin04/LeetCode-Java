/**
 * 题目：最大矩形和不超过k。给定一个矩阵matrix和一个整数k,求元素加和不超过k的最大子矩形。
 * 解题思路：
 * 我们使用暴力搜索的算法。
 * 定义sum[i][j]为矩形(0,0)-(i,j)的和；然后我们遍历这个矩形中的所有的子矩形，计算它与k的大小，并更新结果。
 */
public class MaxSumOfRectangleNoLargerThanK {
	public static void main(String[] args) {
	}
}

class Solution277
{
	public int maxSumSubmatrix(int[][]matrix, int k)
	{
		if(matrix==null || matrix.length==0 ) return 0;
		
		int m=matrix.length;
		int n=matrix[0].length;
		
		int sum[][]=new int[m][n];
		sum[0][0]=matrix[0][0];
		int result=Integer.MIN_VALUE;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				int t=matrix[i][j];
				if(i>0) t+=sum[i-1][j];
				if(j>0) t+=sum[i][j-1];
				if(i>0 && j>0) t-=sum[i-1][j-1];
				sum[i][j]=t;
				
				for(int l=0;l<=i;l++)
				{
					for(int r=0;r<=j;r++)
					{
						int d=sum[i][j];
						if(l>0) d-=sum[l-1][j];
						if(r>0) d-=sum[i][r-1];
						if(l>0 && r>0) d+=sum[l-1][r-1];
						if(d<=k) result=Math.max(result, d);
					}
				}
			}
		}
		return result;
	}
}