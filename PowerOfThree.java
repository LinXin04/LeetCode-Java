/**
 * 题目：给定一个整数，判断该整数是不是3的n次方。
 * 解题思路：
 * 返回除以3，最后如果余数为1，则是；否则不是。
 */
import java.util.Scanner;
public class PowerOfThree {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入：");
		int n=sc.nextInt();
		Solution171 sl=new Solution171();
		System.out.println("结果是："+sl.isPowerOfThree(n));
	}
}
class Solution171
{
	public boolean isPowerOfThree(int n)
	{
		if(n==0) return false;
		while(n!=0 && n%3==0)
			n/=3;
		return n==1;
	}
}