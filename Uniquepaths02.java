/**
 * 题目：上上题的基础上，允许有障碍物的存在，给定一个数组为图纸，如果某一个元素为1，则代表该处有障碍物，否则为0
 * 解题思路：
 * 对上题稍微改正，同样使用动态规划。
 * 先将第一行和第一列的result值表示出来，然后再判断下面的。
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Uniquepaths02 {

	public static void main(String[] args) {
		System.out.println("请输入障碍数组：");
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String[] st=s.split(" ");
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				temp.add(Integer.parseInt(st[i]));
			arr.add(temp);
		}
		int [][] obstacleGrid=new int[arr.size()][arr.get(0).size()];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<arr.get(i).size();j++)
				obstacleGrid[i][j]=arr.get(i).get(j);
		}
		Solution63 sl=new Solution63();
		int result=sl.uniquePathsWithObstacles(obstacleGrid);
		System.out.println("结果是："+result);
	}
}

class Solution63
{
	public int uniquePathsWithObstacles(int[][] obstacleGrid)
	{
		if(obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
		int Row=obstacleGrid.length;
		int Column=obstacleGrid[0].length;
		int result[][]=new int[Row][Column];
		
		//result第一列置为1或者0
		for(int i=0;i<Row;i++)
		{
			if(obstacleGrid[i][0]==0) result[i][0]=1;
			else 
			{
				result[i][0]=0;
				break;
			}
		}
		//result第一行置为1或者0
		//注意这里必须加break，因为只要出现一个1，就代表这一行后面的路径都不合法
		for(int j=0;j<Column;j++)
		{
			if(obstacleGrid[0][j]==0) result[0][j]=1;
			else 
			{
				result[0][j]=0;
				break;
			}
		}
		
		for(int i=1;i<Row;i++)
		{
			for(int j=1;j<Column;j++)
			{
				if(obstacleGrid[i][j]==1)
					result[i][j]=0;
				else
					result[i][j]=result[i][j-1]+result[i-1][j];
			}	
		}
		return result[Row-1][Column-1];
	}
}