/**
 * 题目：给了我们n个硬币，让我们按一定规律排列，第一行放1个，第二行放2个，以此类推，问我们有多少行能放满。
 * 例如：
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 * 解题思路：
 * 我们可以发现，这道题就是不断地对n进行-1，-2，-3，-4，-5.....
 *
 */
import java.util.Scanner;
public class ArrangingCoins {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入n:");
		int n=sc.nextInt();
		
		Solution184 sl=new Solution184();
		System.out.println("结果是："+sl.arrangeCoins(n));
	}
}
class Solution184
{
	public int arrangeCoins(int n)
	{
		if(n==0) return 0;
		int result=0;
		
		for(int i=1;i<=n;i++)
		{
			if(n>=i) 
			{
				n-=i;
				result++;
			}
		}
		return result;
	}
}