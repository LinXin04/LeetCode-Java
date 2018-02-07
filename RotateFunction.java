/**
 * 题目：旋转函数。给定一个数组A，将其在k位置上进行旋转，计算最大的F(k).
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * 例子：
 * A = [4, 3, 2, 6]

 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26

 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 解题思路：
 * 找规律。
 * 先把具体的数字抽象为A,B,C,D，那么我们可以得到：
 * F(0) = 0A + 1B + 2C +3D
 * F(1) = 0D + 1A + 2B +3C
 * F(2) = 0C + 1D + 2A +3B
 * F(3) = 0B + 1C + 2D +3A
 * 那么，我们通过仔细观察，我们可以得出下面的规律：
 * F(1) = F(0) + sum - 4D
 * F(2) = F(1) + sum - 4C
 * F(3) = F(2) + sum - 4B
 * 那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]
 *
 */
import java.util.Scanner;
public class RotateFunction {
	public static void main(String[] args) {
		System.out.println("请输入数组：");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String st[]=s.split(" ");
		int []A=new int[st.length];
		for(int i=0;i<A.length;i++)
			A[i]=Integer.parseInt(st[i]);
		
		Solution180 sl=new Solution180();
		System.out.println("结果是："+sl.maxRotateFunction(A));
	}
}
class Solution180
{
	public int maxRotateFunction(int[] A)
	{
		if(A.length==0) return 0;
		int n=A.length;
		
		int sum=0;
		int F=0;
		
		//先计算sum和F(0)
		for(int i=0;i<n;i++)
		{
			sum+=A[i];
			F+=i*A[i];
		}
		
		int result=F;
		for(int i=1;i<n;i++)
		{
			F=F+sum-n*A[n-i];
			result=Math.max(result, F);
		}
		
		return result;
	}
}