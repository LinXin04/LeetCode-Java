/**
 * 题目：给定一个整数n，代表n个灯泡. 第一次，打开所有的灯泡；第二次，切换2及2的倍数的灯泡；第三次，切换3及3的倍数的灯泡。。。。
 * 如何下去，直至n轮结束。判断此时有多少个灯泡是亮着的。
 * 例如：
 * Given n = 3. 
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off]. 
 * So you should return 1, because there is only one bulb is on.
 * 
 * 解题思路：
 * 最后开的灯的个数具有的规律是：根号n
 */
import java.util.Scanner;
public class BulbSwitcher {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入：");
		int n=sc.nextInt();
		Solution172 sl=new Solution172();
		System.out.println("结果是："+sl.bulbSwitch(n));
	}
}
class Solution172
{
	public int bulbSwitch(int n)
	{
		if(n<=0) return 0;
		else return (int)Math.sqrt(n);
	}
}