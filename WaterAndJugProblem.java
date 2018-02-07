/**
 * 题目：水和桶的问题。给定两个桶，容量分别为 x和y；还有一个容量为z的桶，求用前面两个桶能不能装满这个桶。
 * 解题思路：
 * 上述问题可以写成：z=mx+ny. m,n大于0表示装水，小于0表示倒水。那么我们就是需要判断存不存在这样的m和n.
 * 根据裴蜀定理：mx+ny的解为d=gcd(x,y),即x与y的最大公约数。所以只要z%d==0,上边的问题就有解。
 * 我们只需要看看z是不是x和y的最大公约数的倍数就行了。此外还要满足一个条件（x+y>=z,因为x和y不能称出比它们的和还多的水）
 *
 */
import java.util.Scanner;
public class WaterAndJugProblem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		
		Solution177 sl=new Solution177();
		System.out.println("结果是："+sl.canMeasureWater(x, y, z));
	}
}
class Solution177
{
	public boolean canMeasureWater(int x,int y,int z)
	{
		if(z==0) return true;
		else if(x+y>=z && (z% gcd(x,y))==0) return true;
		else return false;
	}
	
	//求两个数的最大公约数
	public int gcd(int x,int y)
	{
		if(y==0) return x;
		else return gcd(y,x%y);
	}
}