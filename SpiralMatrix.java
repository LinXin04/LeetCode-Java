/**
 * 题目：给定一个m*n的数组，以螺旋的方式返回所有的元素
 * 例如：
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 解题思想：
 * 1.首先我们要从给定的mxn的矩阵中算出按螺旋顺序有几个环，注意最终间的环可以是一个数字，也可以是一行或者一列。环数的计算公式是 min(m, n)/2;
 * 2.接着我们按照先向右、向下、向左、向上的规则依次将元素加入到结果集中
 * 3.最后是最中间的一行或者是一列、或者是一个数字
 */
import java.util.ArrayList;
import java.util.Scanner;
public class SpiralMatrix {

	public static void main(String[] args) {
		System.out.println("请输入数组：");
		ArrayList<ArrayList<Integer>> nums=new ArrayList<ArrayList<Integer>>();
		Scanner sc=new Scanner(System.in);
		while(true)
		{
		String s=sc.nextLine();
		if(s.equals("")) break;
		ArrayList<Integer> emp=new ArrayList<Integer>();
		String st[]=s.split(" ");
		for(int i=0;i<st.length;i++)
			emp.add(Integer.parseInt(st[i]));
		nums.add(emp);
		}
		
		int [][]matrix=new int[nums.size()][nums.get(0).size()];
		for(int i=0;i<nums.size();i++)
		{
			for(int j=0;j<nums.get(0).size();j++)
				matrix[i][j]=nums.get(i).get(j);
		}
		Solution38 sl=new Solution38();
		ArrayList<Integer> result=sl.spiralOrder(matrix);
		
		System.out.println("结果是");
		System.out.print("[ ");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
		System.out.println("]");
		
	}

}
class Solution38
{
	public ArrayList<Integer> spiralOrder(int [][]matrix)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(matrix==null||matrix.length==0||matrix[0].length==0) return result;
		
		//定义行数
		int Row=matrix.length;
		//定义列数
		int Column=matrix[0].length;
		
		//计算螺旋有几环
		int Num=(Math.min(Row, Column))/2;
		//对于每一环，依次遍历
		for(int ring=0;ring<Num;ring++)
		{
			//向右走
			for(int i=ring;i<Column-ring-1;i++)
				result.add(matrix[ring][i]);
			//向下走
			for(int i=ring;i<Row-ring-1;i++)
				result.add(matrix[i][Column-1-ring]);
			//向左走
			for(int i=Column-ring-1;i>ring;i--)
				result.add(matrix[Row-1-ring][i]);
			//向上走
			for(int i=Row-ring-1;i>ring;i--)
				result.add(matrix[i][ring]);
		}
		//3.最后是最中间的一行或者是一列、或者是一个数字
		if((Math.min(Row, Column))%2==1)
		{
			//如果最后剩下一行的话
			if(Row<Column)
			{
				for(int i=Num;i<Column-Num;i++)
					result.add(matrix[Num][i]);
			}
			//如果最后剩下一列的话
			else
			{
				for(int i=Num;i<Row-Num;i++)
					result.add(matrix[i][Num]);
			}
		}
		return result;
	}
}