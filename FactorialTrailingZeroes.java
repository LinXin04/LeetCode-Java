/**
 * 题目：计算n!的后缀中0的个数。
 * 解题思路：
 * 后缀中的0是由2*5得来的，所以找2、5有多少个就可以了，2比5的个数多，所以只需要找5的个数。
 * 于是n/5就得到了5的个数。还有一点要注意的就是25这种，5和5相乘的结果，所以，还要看n/5里面有多少个5，也就相当于看n里面有多少个25。
 *
 */
import java.util.Scanner;
public class FactorialTrailingZeroes {

	public static void main(String[] args) {
		System.out.println("请输入n：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution162 sl=new Solution162();
		System.out.println("结果是："+sl.trailingZeroes(n));
	}

}
class Solution162
{
	public int trailingZeroes(int n)
	{
		if(n<=0) return 0;
		int result=0;
		
		while(n/5!=0)
		{
			n=n/5;
			result+=n;
		}
		return result;
	}
}