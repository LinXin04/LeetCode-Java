/**
 * 题目：给定一个二维数组和一个目标值，求该目标值是否在该数组中。该数组有两个特点：
 * 1、每一行从左到右都是递增的
 * 2、每一列从上到下都是递增的
 * 解题思路：
 * 我们可以看出，在数组最左下角的点是有规律的，它左边的元素都大于它，上边的元素都小于它
 *
 */
import java.util.Scanner;
import java.util.ArrayList;
public class SearchA2DMatrix02 {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		ArrayList<ArrayList<Integer>> num=new ArrayList<ArrayList<Integer>>();
		while(true)
		{
			String s=sc.nextLine();
			if(s.equals("")) break;
			String[] st=s.split(" ");
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for(int i=0;i<st.length;i++)
				temp.add(Integer.parseInt(st[i]));
			num.add(temp);
		}
		
		int[][] matrix=new int[num.size()][num.get(0).size()];
		for(int i=0;i<num.size();i++)
		{
			for(int j=0;j<num.get(i).size();j++)
				matrix[i][j]=num.get(i).get(j);
		}
		Scanner sc1=new Scanner(System.in);
		System.out.println("请输入整数target：");
		int target=sc1.nextInt();
		
		Solution257 sl=new Solution257();
		System.out.println("结果是："+sl.searchMatrix(matrix, target));
	}
}
class Solution257
{
	public boolean searchMatrix(int[][] matrix,int target)
	{
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
		int row=matrix.length;
		int column=matrix[0].length;
		int x=row-1;
		int y=0;
		
		while(true)
		{
			if(target<matrix[x][y]) x--;
			else if(target>matrix[x][y]) y++;
			else return true;
			if(x<0 || y>column-1) break;
		}
		return false;
	}
}