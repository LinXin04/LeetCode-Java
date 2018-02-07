/**
 * 题目：给定一个非负数n，求比n小的质数的个数。
 * 解题思路：
 * 埃拉托斯特尼筛法:
 * 从2开始到根号n,先找到第一个质数2，然后将其所有的倍数全部标记出来；
 * 然后再找下一个质数3，...一次类推直到找到根号n.
 * 用一个
 */
import java.util.*;
public class CountPrimes {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入整数：");
		int n=sc.nextInt();
		Solution164 sl=new Solution164();
		System.out.println("结果是："+sl.countPrimes(n));
	}

}
class Solution164
{
	public int countPrimes(int n)
	{
		if(n<=1) return 0;
		
		//定义一个vector来装所有的数,初始都为True，小于n的一共n个数
		Vector<Boolean> vec=new Vector<Boolean>(n);
		//第1、2例外是false
		vec.add(0, false);
		vec.add(1, false);
		
		for(int i=2;i<n;i++)
			vec.add(i,true);
	
		int result=0;
		int limit=(int) Math.sqrt(n-1);
		
		//从2开始，一次标注所有以2为倍数的数。
		for(int i=2;i<=limit;i++)
		{
			int fac=2;
			if(vec.get(i))
			{
				for(int j=i*2;j<n;j=i*fac)
				{
					vec.set(j, false);
					fac++;
				}
			}
		}
		
		//将vec中所有的false取出
		for(int i=0;i<n;i++)
		{
			if(vec.get(i)) result++;
		}
		
		return result;
	}	
}