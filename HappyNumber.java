/**
 * 题目：开心数：如果一个数是开心数，每一位的平方加和最终等于1.
 * 例如：
 * 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 解题思路：
 * 根据经验可知，非开心数有一个特点：循环数字中一定会有一个4.
 * 因此，我们一直平方，知道最后n==1或者4的时候跳出
 */
import java.util.Scanner;
public class HappyNumber {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("请输入数字：");
	int n=sc.nextInt();
	Solution163 sl=new Solution163();
	System.out.println("结果是："+sl.isHappy(n));
	}

}
class Solution163
{
	public boolean isHappy(int n)
	{
		if(n==0) return false;
		
		//每一次计算平方
		while(n!=1 && n!=4)
		{
			int t=0;
			while(n!=0)
			{
				//每次加上一位数的平方
				t+=(n%10)*(n%10);
				n=n/10;
			}
			n=t;
		}
		return n==1;
	}
}