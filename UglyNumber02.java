/**
 * 题目：求第n个丑数的值。
 * 例如：
 * 前十个丑数分别是：1, 2, 3, 4, 5, 6, 8, 9, 10, 12。
 * 解题思路：
 * 1、从1开始求到第n个丑数，这样做会超时
 * 2、经过观察我们发现丑数有以下规律：
 * 每一个丑数都是一个旧的丑数乘以2,3,5得来的。而要求的丑数就是从已经生成的序列中取出来的，我们每次都从三个序列中取出当前最小的那个加入序列。
 * (1) (1x2),  2x2, (2x2), 3x2, (3x2), (4x2), 5x2...
 * (2) 1x3,  (1x3), 2x3, 2x3, (2x3), 3x3, (3x3)...
 * (3) 1x5,  1x5, 1x5, (1x5), 2x5, 2x5, 2x5...
 * 
 */
import java.util.*;
public class UglyNumber02 {

	public static void main(String[] args) {
		System.out.println("请输入一个数字：");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Solution148 sl=new Solution148();
		System.out.println("结果是："+sl.nthUglyNumber(n));
	}
}
class Solution148
{
	public int nthUglyNumber(int n)
	{
		//首先定义一个ArrayList,存储每一步的结果,即所有的丑数
		ArrayList<Integer> result=new ArrayList<Integer>();
		//首先把1加入
		result.add(1);
		//定义2,3,5的位置
		int N2=0,N3=0,N5=0;
		
		while(result.size()<=n)
		{
			//定义每一轮的数字
			int M2=result.get(N2)*2;
			int M3=result.get(N3)*3;
			int M5=result.get(N5)*5;
			
			//选出最小的
			int Ugly=Math.min(M2,Math.min(M3, M5));
			if(Ugly==M2) N2++;
			if(Ugly==M3) N3++;
			if(Ugly==M5) N5++;
			
			//将本轮新选出的丑数加入result
			result.add(Ugly);
		}
		return result.get(n-1);
	}
}