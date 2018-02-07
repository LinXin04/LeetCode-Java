/**
 * 题目：判断一个数是不是丑数。丑数定义为：一个数，其质因数只包括2,3,5的数。
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * 注意：1也是质因数。
 * 解题思路：
 * 让num不断除以2,3,5，如果剩余的数字是1，那么该数字就是丑数，否则就不是。
 *
 */
import java.util.Scanner;
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println("请输入一个数字：");
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		Solution147 sl=new Solution147();
		System.out.println("结果是："+sl.isUgly(num));
	}
}
class Solution147
{
	public boolean isUgly(int num)
	{
		if(num==1) return true;
		while(num>1)
		{
			if(num%2==0) num/=2;
			else if(num%3==0) num/=3;
			else if(num%5==0) num/=5;
			else return false;
		}
		return num==1;
	}
}