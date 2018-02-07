/**
 * 题目：完全平方数。给定一个正整数，求它至少由几个完全平方数加和构成。
 * 例如：
 * given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 * 解题思路：
 * 这个运用了一个“四平方和定理”：
 * 1、任何一个正整数都可以表示为至多4个整数的平方和。(所以返回的结果有1,2,3,4)
 * 2、任何一个正整数如果因数有4的话，除以4后不影响结果。
 * 3、任何一个正整数除以8余数为7的话，一定只能分解为4个完全平方数。
 * 就此为止，计算复杂度已经大大降低。我们再看，将一个数能否拆为2个平方数之和，如果成功了结果则是1或者2。
 * 否则的话，就是返回3.
 *
 */
import java.util.Scanner;
public class PerfectSquares {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入：");
		int n=sc.nextInt();
		Solution169 sl=new Solution169();
		System.out.println("结果是："+sl.numSquares(n));	
	}
}
class Solution169
{
	public int numSquares(int n)
	{
		if(n==1) return 1;
		//首先按照“四平方和定理”处理数据
		while(n%4==0) n=n/4;
		if(n%8==7) return 4;
		
		//试着将该数字分成两个平方和
		for(int i=0;i*i<=n;i++)
		{
			int j=(int) Math.sqrt(n-i*i);
			if(i*i+j*j==n)
			{
				//判断是不是有0
				if(i==0 || j==0) return 1;
				else return 2;
			}
		}
		return 3;
	}
}
