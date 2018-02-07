/**
 * 题目：给定一个无限长的整数序列1,2,3，4,5,6,7,8,9,10,11.....，求第n个数字是多少。
 * 例如：
 * Input:
 * 11
 * Output:
 * 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * 解题思路：
 * 这个问题总共分三步：
 * 1、求出数字n落在几位数的范围内
 * 2、求出数字n落在数字几上
 * 3、求出数字n具体落在该数字的第几位上
 * 一位有9个数字，二位数有90个数字，三位数有900个数，依次类推．
 * 因此可以每次增加一位数字，看n是否还在这个范围内．
 * 例如给定n = 150，首先一位有9个数字，所以位数可以+1，这样n-9 = 141. 
 * 然后2位的数字有2*90= 180，大于141，所以目标数字肯定是2位的．
 * 求具体落在哪个数字. 可以用10+(141-1)/2 = 80求出．
 * 求具体落在哪一位上. 可以用(141-1)%2＝0求出为第0位，即8．
 */
import java.util.Scanner;
public class NthDigit {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int n=sc.nextInt();
		
		Solution182 sl=new Solution182();
		System.out.println("结果是："+sl.findNthDigit(n));
	}
}
class Solution182
{
	public int findNthDigit(int n)
	{
		if(n<=0) return 0;
		
		//定义digit表示几位数字，ith表示（10,100,1000....）,base表示（9,90,900...）
		long digit=1,ith=1,base=9;
		
		while(n>digit*base)
		{
			n-=base*(digit++);
			ith+=base;
			base*=10;
		}
		
		return String.valueOf(ith+(n-1)/digit).charAt((int) ((n-1)%digit))-'0';
	}
}