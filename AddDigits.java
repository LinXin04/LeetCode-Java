/**
 * 题目：给定一个数字，将其每一位进行加和，一直到得到一个一位数字，返回该数字。
 * 例如：
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * 要求时间复杂度为O(1)
 * 解题思路：
 * 我们实验几个数发现：
 * 输入：1,2,3,4,5,6,7,8,9, 10,11,12,13,14,15,16,17,18, 19,20
 * 结果：1,2,3,4,5,6,7,8,9, 1,2,3,4,5,6,7,8,9, 1,2
 *
 */
import java.util.Scanner;
public class AddDigits {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int num=sc.nextInt();
		Solution168 sl=new Solution168();
		System.out.println("结果是："+sl.addDigits(num));
	}
}
class Solution168
{
	public int addDigits(int num)
	{
		return (num-1)%9+1;
	}
}