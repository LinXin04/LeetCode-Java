/**
 * 题目：给定一个整数，判断他是不是2的次方。
 * 解题思路：
 * 1     2       4         8         16 　　....
 * 1     10      100       1000      10000　....
 * 由上面可知，2的次方都是首位为1的数，我们只需将n与(n-1)按位与即为0可得到结果
 */
import java.util.*;
public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println("请输入数字n:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution166 sl=new Solution166();
		System.out.println("结果是："+sl.isPowerOfTwo(n));
	}
}
class Solution166
{
	public boolean isPowerOfTwo(int n){
	if(n>0 && (n & (n-1))==0) return true;
	else return false;
}
}