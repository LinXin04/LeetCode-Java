/**
 * 题目：给定一个非负整数n,计算在0-10^n(包括0，不包括10^n)之间，拥有各位数字都不同的数字的个数。
 * 例如：
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 * 解题思路：
 * [0,9]中有10个；
 * [10-99]中有81个；
 * 总结：k表示位数的话，结果应该是f(k)=9*9*8*...*(9-k+2)个。
 *
 */
import java.util.Scanner;
public class CountNumbersWithUniqueDigits {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int n=sc.nextInt();
		
		Solution175 sl=new Solution175();
		System.out.println("结果是："+sl.countNumbersWithUniqueDigits(n));
	}
}

class Solution175
{
	public int countNumbersWithUniqueDigits(int n)
	{
		if(n==0) return 1;
		int result=0;
		for(int i=1;i<=n;i++)
			result+=count(i);
		return result;
	}
	//按照给定的位数k来求每小段的满足要求的个数
	public int count(int k)
	{
		if(k==1) return 10;
		int result=9;
		
		for(int i=9;i>=11-k;i--)
			result*=i;
		
		return result;
	}
}