/**
 * 题目：给定一个n*n的矩阵，将其旋转90度。
 * 例如：
 * Given input matrix = 
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],

 * rotate the input matrix in-place such that it becomes:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 解题思路：
 * 首先将矩阵按照对角线为对称轴，取它的转置矩阵，然后将转置矩阵沿着中轴线进行反转即可得到最终的结果。
 * 1  2  3　　　 　  1  4  7　　　　　  7  4  1
 * 4  5  6　　--> 2  5  8　　 -->  8  5  2　　
 * 7  8  9 　　　3  6  9　　　　      9  6  3
 */
import java.util.ArrayList;
import java.util.Scanner;

public class RotateImage {

	public static void main(String[] args) {
		System.out.println("请输入图片数组：");
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
		int [][] matrix=new int[arr.size()][arr.get(0).size()];
		for(int i=0;i<arr.size();i++)
		{
			for(int j=0;j<arr.get(i).size();j++)
				matrix[i][j]=arr.get(i).get(j);
		}
		
		
		Solution64 sl=new Solution64();
		sl.rotate(matrix);
		
		System.out.println("[");
		for(int i=0;i<matrix.length;i++)
		{
			System.out.print("[ ");
			for(int j=0;j<matrix[i].length;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println("]");
		}
		System.out.println("]");
	}

}

class Solution64
{
	public void rotate(int[][] matrix)
	{
		if(matrix==null || matrix.length==0 || matrix[0].length==0) return;
		//n*n的
		int n=matrix.length;
		
		//先对矩阵进行转置
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				//注意：：：这里不能使用再定义一个temp(int a,int b)函数，改变的效果传不进来！！！
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}
		}
		//再对矩阵进行reverse
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n/2;j++)
			{
				int temp=matrix[i][j];
				matrix[i][j]=matrix[i][n-1-j];
				matrix[i][n-1-j]=temp;
			}
		}
	}
}