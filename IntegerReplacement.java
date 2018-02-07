/**
 * 题目：给定一个整数n，如果n是偶数，则用n/2替换；如果n是奇数，则用n+1或者n-1替换。问至少经过几次数字n可以变成1
 * 例如：
 * Input:
 * 8
 * Output:
 * 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 * 解题思路：
 * 递归算法。需要注意的是：由于有n+1，所以为了防止越界需要对n进行处理
 *
 */
import java.util.Scanner;
public class IntegerReplacement {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int n=sc.nextInt();
		
		Solution181 sl=new Solution181();
		System.out.println("结果是："+sl.integerReplacement(n));
	}
}
class Solution181
{
	public int integerReplacement(int n)
	{
		if(n==1) return 0;
		
		//如果n是偶数
		if(n%2==0) return 1+integerReplacement(n/2);
		//如果是奇数
		else 
		{
			long t=n;
			return 2+Math.min(integerReplacement((int) ((t+1)/2)),integerReplacement((int)(t-1)/2));
		}
	}
}