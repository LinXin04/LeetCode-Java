/**
 * 题目：检查完美的平方数。给定一个正整数n，如果该数字是一个完美的平方数则返回True。
 * 例如：
 * Input: 16   Returns: True
 * Input: 14   Returns: False
 * 解题思路：
 * 从1搜索到sqrt(n),如果存在则返回true
 */
import java.util.Scanner;
public class ValidPerfectSquare {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int num=sc.nextInt();
		Solution176 sl=new Solution176();
		System.out.println("结果是:"+sl.isPerfectSquare(num));
	}
}

class Solution176
{
	public boolean isPerfectSquare(int num)
	{
		//注意要用i<num/i是为了防止越界
		for(int i=1;i<=num/i;i++)
		{
			if(i*i==num) return true;
		}
		return false;
	}
}