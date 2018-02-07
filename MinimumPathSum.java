/**
 * 题目：给定一个二维数组，里面的元素都是非负数，寻找一条从数组左上方到右下方的最短路径（数组元素加和为最小）。只允许向下或者向右走
 * 解题思路：
 * 动态规划：递推式是res[i][j]=min(res[i-1][j], res[i][j-1])+grid[i][j]
 */
import java.io.*;
import java.util.ArrayList;
public class MinimumPathSum {

	public static void main(String[] args) throws IOException {
		System.out.println("请输入一个二维数组：");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader buf=new BufferedReader(isr);
		ArrayList<ArrayList<Integer>> temp=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			String s=buf.readLine();
			if(s.equals("")) break;
			String st[]=s.split(" ");
			ArrayList<Integer> t=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				t.add(Integer.parseInt(st[i]));
			temp.add(t);
		}
		int [][]grid=new int[temp.size()][temp.get(0).size()];
		for(int i=0;i<temp.size();i++)
		{
			for(int j=0;j<temp.get(0).size();j++)
				grid[i][j]=temp.get(i).get(j);
		}
		
		Solution68 sl=new Solution68();
		int result=sl.minPathSum(grid);
		System.out.println("结果是："+result);
	}
}
class Solution68
{
	public int minPathSum(int[][] grid)
	{
		
		if(grid==null || grid.length==0 || grid[0].length==0) return 0; 
		int Row=grid.length;
		int Column=grid[0].length;
		int [][]result=new int[Row][Column];
		
		result[0][0]=grid[0][0];
		//先将第一行和第一列的result赋值
		for(int i=1;i<Column;i++)
			result[0][i]=result[0][i-1]+grid[0][i];
		for(int j=1;j<Row;j++)
			result[j][0]=result[j-1][0]+grid[j][0];
		
		//进入循环
		for(int i=1;i<Row;i++)
		{
			for(int j=1;j<Column;j++)
			{
				result[i][j]=Math.min(result[i-1][j],result[i][j-1])+grid[i][j];
			}
		}
		return result[Row-1][Column-1];
	}
}