/**
 * 题目：给定一个除数，一个被除数，不使用除法、乘法以及模运算，求得两个整数相除得到的商。如果商越界了则返回Integer.MAX_VALUE
 * 解题思想:
 * 使用移位的思想：
 * 1.越界的话只有两种情况：一是除数为0；一种是被除数是-2147483648，除数是-1，这种情况下越界
 * 2.在被除数大于等于除数的情况下，除数左移一位相当于乘以2，我们先让除数左移直到大于被除数之前得到一个最大的基，则结果增加加2^k（k为左移的次数）。然后接下来我们尝试减去这个基，判断剩下的是否>=除数。
 *
 */
import java.util.Scanner;
public class DivideTwoInteger {

	public static void main(String[] args) {
		System.out.println("请输入除数：");
		Scanner sc=new Scanner(System.in);
		int dividend=sc.nextInt();
		System.out.println("请输入被除数：");
		int divisor=sc.nextInt();
		
		Solution41 sl=new Solution41();
		int result=sl.divide(dividend, divisor);
		System.out.println("结果是："+result);
	}

}
class Solution41
{
	public int divide(int dividend,int divisor)
	{
		//1.判断越界：越界的话只有两种情况：一是除数为0；一种是被除数是-2147483648，除数是-1，这种情况下越界
		if(divisor==0||dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		int result=0;
		if(divisor==1) return dividend;
		//先将符号的问题解决.注意：这里的m,n以及dividend和divisor必须用long。否则，当dividend为MIN_VALUE时就越界了
		long m=Math.abs((long)dividend);
		long n=Math.abs((long)divisor);
		int sign=(((dividend<0) && (divisor<0)) || ((dividend>0) && (divisor>0)))? 1:-1;
		
		while(m>=n)
		{
			long t=n;
			//最大的基
			long k=1;
			while(m>=(t<<1))
			{
				t=t<<1;
				k=k<<1;
			}
			result+=k;
			m-=t;
		}
		return sign==1?result:(-result);
	}
}