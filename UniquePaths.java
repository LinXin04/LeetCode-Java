/**
 * 题目：给定一个m*n的方格图纸，一个robot在图纸的左上角，他要到达图纸的右下角，他每次只能向下或者向右移动一步，问一共多少种路线。
 * 解题思路：
 * 使用动态规划。
 * 当前点Point[i][j]=Point[i][j-1]+point[i-1][j];（每个点都可能来自2种不同的可能）
 * 我们在这之前将Point的所有点设为1.
 * O(N^2)
 *
 */
import java.util.Scanner;
public class UniquePaths {

	public static void main(String[] args) {
		System.out.println("请输入行数m：");
		Scanner sc=new Scanner(System.in);
		int m=Integer.parseInt(sc.nextLine());
		
		System.out.println("请输入列数：");
		int n=Integer.parseInt(sc.nextLine());
		
		Solution62 sl=new Solution62();
		int result=sl.uniquePaths(m, n);
		System.out.println("结果是："+result);

	}

}
class Solution62
{
	public int uniquePaths(int m,int n)
	{
		if(m<=0 || n<=0) return 0;
		int result=0;
		
		//先将所有的点赋值为1
		int nums[][]=new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
				nums[i][j]=1;
		}
		
		//依次计算nums[i][j]=nums[i][j-1]+nums[i-1][j]
		for(int i=1;i<m;i++)
		{
			for(int j=1;j<n;j++)
				nums[i][j]=nums[i][j-1]+nums[i-1][j];
		}
		result=nums[m-1][n-1];
		return result;
	}
}