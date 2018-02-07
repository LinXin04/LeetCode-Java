/**
 * 题目：给定两个整数n和k，求[1,2,...,n]的第k个序列。
 * 例如：
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 解题思路：这是一道数学类的题目：
 * 通过观察我们发现，这些序列存在以下规律：
 * k--
 * 1、第一个数字：
 * a1=k/(n-1)!
 * k1=k
 * 2、第二个数字：
 * a2=k1/(n-2)!
 * k2=k1%(n-2)!
 * ....
 * 3、第n个数字
 * an=kn-1/0!
 * kn=kn-1%0!
 * 
 */
import java.util.*;
public class PermutationSequence {

	public static void main(String[] args) {
		System.out.println("请输入整数n:");
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		System.out.println("请输入整数k:");
		int k=sc.nextInt();
		
		Solution158 sl=new Solution158();
		System.out.println("结果是："+sl.getPermutation(n, k));
	}

}
class Solution158
{
	public String getPermutation(int n,int k)
	{
		String result="";
		if(n<=0 || k<=0) return result;
		
		ArrayList<String> nums=new ArrayList<String>();
		for(int i=1;i<=9;i++)
			nums.add(String.valueOf(i));

		k--;
		//计算阶乘
		int Fac[]=new int[n];
		Fac[0]=1;
		for(int j=1;j<n;j++) Fac[j]=Fac[j-1]*j;
		
		//每次循环计算一个a1，一个k1
		for(int i=n;i>0;i--)
		{
			int a=k/Fac[i-1];
			k=k%Fac[i-1];
			result+=nums.get(a);
			nums.remove(a);
		}
		return result;
	}
}