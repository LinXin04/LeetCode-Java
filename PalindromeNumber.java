/**
 * 题目：给定一个整数，在不产生额外空间的前提下，判断该整数是不是回文整数
 * 解题思路：每一步判断一下整数的第一位和最后一位是否相等，若不相等则返回false；删除这两位后继续判断
 *
 */
import java.util.Scanner;
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println("请输入一个整数：");
		Scanner sc=new Scanner(System.in);
		int nums=sc.nextInt();
		
		Solution30 sl=new Solution30();
		boolean result=sl.isPalindrome(nums);
		System.out.println("结果是："+result);

	}
}

class Solution30
{
	public boolean isPalindrome(int x)
	{
		//所有的负数都不是
		if(x<0) return false;
		//单位正数都是
		if(0<=x && x<=9) return true;
		
		//首先计算出x一共有多少位
		int index=1;
		while(x/10>=index)
			index*=10;
		
		while(x>0)
		{
			//判断前后的数字是否相等
			if(x/index!=x%10) return false;
			//将x的首尾去掉
			x=(x%index)/10;
			index=index/100;
		}
		return true;
	}
}