/**
 * 题目：给定一个非负的整数，判断该整数是否可以写成两个平方和相加的形式（注意：a、b为0也可以）：a^2+b^2=c
 * 
 * 例如：
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * 
 * 解题思路：
 * 从0到sqrt(c)不断遍历。
 */
import java.util.Scanner;
public class SumOfAquareNumbers {
	public static void main(String[] args) {
	System.out.println("请输入：");
	Scanner sc=new Scanner(System.in);
	int c=sc.nextInt();
	
	Solution191 sl=new Solution191();
	System.out.println("结果是："+sl.judgeSquareSum(c));
	}
}
class Solution191
{
	public boolean judgeSquareSum(int c)
	{
		if(c==0) return true;
		for(int i=(int) Math.sqrt(c);i>=0;i--)
		{
			//此时另外一个为0
			if(i*i==c) return true;
			int b=c-i*i, t=(int) Math.sqrt(b);
			if(t*t==b) return true;
		}
		return false;
	}
}