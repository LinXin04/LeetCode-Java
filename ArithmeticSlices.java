/**
 * 题目：算数切片（就是等差序列）。给定一个数列，求它的算数切片的个数 
 * 例如：
 * A = [1, 2, 3, 4]
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 解题思路：
 * 使用动态规划的思想。假设dp[i]代表到位置i的算数切片的个数，则有如下规律dp[i]=dp[i-1]+1
 *
 */
import java.util.Scanner;
public class ArithmeticSlices {

	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		
		int A[]=new int[st.length];
		for(int i=0;i<A.length;i++)
			A[i]=Integer.parseInt(st[i]);
		
		Solution187 sl=new Solution187();
		System.out.println("结果是："+sl.numberOfArithmeticSlices(A));
	}
}

class Solution187
{
	public int numberOfArithmeticSlices(int[] A)
	{
		if(A.length==0) return 0;
		
		int result=0,Length=A.length;
		int dp[]=new int[Length];
		
		for(int i=2;i<Length;i++)
		{
			if(A[i]-A[i-1]== A[i-1]-A[i-2])
				dp[i]=dp[i-1]+1;
			
			result+=dp[i];
		}
		return result;
	}
}