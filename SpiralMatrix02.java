/**
 * 题目：给定一个整数n,创建一个矩阵，使得里面的元素按照螺旋式排列，数字大小1~n^2
 * 例如：Given n = 3,
 * You should return the following matrix:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * 解题思路：类似于上面的Spiral Matrix,分层，然后按照上右下左的顺序放入数组中。每个元素只访问一次，时间复杂度是O(n^2)
 */
import java.util.Scanner;
public class SpiralMatrix02 {

	public static void main(String[] args) {
		System.out.println("请输入一个整数n:");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		
		Solution39 sl=new Solution39();
		int result[][]=sl.generateMatrix(num);
		System.out.println("结果是：");
		for(int i=0;i<result.length;i++)
		{
			System.out.print("[ ");
			for(int j=0;j<result[i].length;j++)
				System.out.print(result[i][j]+" ");
			System.out.println("]");
		}

	}

}
class Solution39
{
	public int[][] generateMatrix(int n)
	{
		if(n<0) return null;
		int [][]result=new int[n][n];
		
		//求的螺旋的环数
		int Num=n/2;
		//每一个位置上的数字
		int index=1;
		//对于每一环，分别赋值
		for(int ring=0;ring<Num;ring++)
		{
			//向右走
			for(int i=ring;i<n-ring-1;i++)
				result[ring][i]=index++;
			//向下走
			for(int i=ring;i<n-ring-1;i++)
				result[i][n-ring-1]=index++;
			//向左走
			for(int i=n-ring-1;i>ring;i--)
				result[n-ring-1][i]=index++;
			//向上走
			for(int i=n-ring-1;i>ring;i--)
				result[i][ring]=index++;
		}
		//最后会剩余一个数
		if(n%2==1)
		{
			result[Num][Num]=index;
		}
		return result;
	}
}
