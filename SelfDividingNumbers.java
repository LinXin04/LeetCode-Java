/**
 * 题目：给定两个整数，代表一个范围，求这个范围中的所有的self-dividing数字。
 * 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * 例如：
 * Input: 
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 解题思路：
 * 直接对每一个数字拆分进行验证
 */
import java.util.ArrayList;
import java.util.Scanner;
public class SelfDividingNumbers {

	public static void main(String[] args) {
		System.out.println("请输入left:");
		Scanner sc=new Scanner(System.in);
		int left=sc.nextInt();
		System.out.println("请输入right：");
		int right=sc.nextInt();

		Solution252 sl=new Solution252();
		ArrayList<Integer> result=sl.selfDividingNumbers(left, right);
		System.out.println("结果是：");
		for(int i=0;i<result.size();i++)
			System.out.print(result.get(i)+" ");
	}
}
class Solution252
{
	public ArrayList<Integer> selfDividingNumbers(int left,int right)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(left>right) return result;
		for(int i=left;i<=right;i++)
		{
			if(check(i)) result.add(i);
		}
		return result;
	}
	
	public boolean check(int num)
	{
		String s=String.valueOf(num);
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='0') return false;
			else
				if(num%(s.charAt(i)-'0')!=0) return false;
		}
		return true;
	}
}