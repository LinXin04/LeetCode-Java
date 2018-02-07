/**
 * 题目：完美的数。如果一个数可以等于它的所有因数(除了它自己)加起来的和，那么这个数就是完美的数。
 * 例如：
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * 解题思路：
 * 初始化sum=1,i从2开始到sqrt(n),如果num%i==0,则sum=sum+i+num/i;但是如果i*i=num，则sum=sum+i+0.
 */
import java.util.Scanner;
public class PerfectNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字num：");
		int num=sc.nextInt();
		
		Solution186 sl=new Solution186();
		System.out.println("结果是："+sl.checkPerfectNumber(num));
	}
}

class Solution186
{
	public boolean checkPerfectNumber(int num)
	{
		if(num==1) return false;
	
		int sq=(int) Math.sqrt(num);
		int sum=1;
		
		for(int i=2;i<=sq;i++)
		{
			if(num%i==0) sum+=i+(i*i==num?0:num/i);
		}
		
		return sum==num;
	}
}